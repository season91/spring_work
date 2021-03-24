package common.util.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.kh.toy.mgmtfee.model.vo.Mgmtfee;

import common.code.Configcode;

public class FileUtil {
	
	public List<FileVo> fileUpload(List<MultipartFile> files) throws IllegalStateException, IOException{
		// file 메타 정보를 가지고 반환될 list 선언
		List<FileVo> fileDatas =  new ArrayList<FileVo>();
		// 파일이 저장될 폴더 경로 생성
		String savePath = getSavePath();
		// 게시판에서 아무것도 안담겨있으면 빈파일로 올라가버린다.
		// 그래서 여기서 분기처리해줘야한다. foreach문 돌리기전에 foreach를 돌릴지 말지 검증
		// 안올려도 1이고 1개올려도 1이다. 1보다크면서 본파일명이 있는경우 포문 돌린다(빈파일은 오리진파일명이 null이다)

		if(files.size() >= 1 && !files.get(0).getOriginalFilename().equals("")) {
			for (MultipartFile multipartFile : files) {
				// 저장될 파일명 생성
				String renameFileName =  UUID.randomUUID().toString();
				
				// 원본 파일명
				String originFileName = multipartFile.getOriginalFilename();
				
				FileVo fileVo = new FileVo();
				fileVo.setOriginFileName(originFileName);
				fileVo.setRenameFileName(renameFileName);
				fileVo.setSavePath(savePath);
				
				fileDatas.add(fileVo);
				
				saveFile(multipartFile, fileVo);

			}
		}

		return fileDatas;
	}
	
	// 저장 경로
	private String getSavePath() {
		Calendar today = Calendar.getInstance();
		return today.get(Calendar.YEAR) + "/" + (today.get(Calendar.MONTH)+1) +"/" + today.get(Calendar.DAY_OF_MONTH) + "/"; 
	}
	
	// 파일 저장
	private void saveFile(MultipartFile multipartFile, FileVo fileVo) throws IllegalStateException, IOException {
		File file = new File(fileVo.getFullPath() + fileVo.getRenameFileName());
		if(!file.exists()) {
			new File(fileVo.getFullPath()).mkdirs();
		}
		System.out.println("경로"+fileVo.getFullPath() + fileVo.getRenameFileName());
		// 왜 던지냐면 빈으로 등록하지도 않았고, 스프링이 동작하는 서비스나 컨트롤러에서 받아 처리해야 트랜잭션처리 및 예외처리가 가능하다. 
		multipartFile.transferTo(file); 
	}

	// 엑셀 폼 내보내기?
	public void formExcel(FileVo fileVo) {
		// XSSFWorkbook은 엑셀파일 전체 내용을 담고 있는 객체
		// XSSFWorkbook : workbook에서 작성 write()
		// XSSFSheet : sheet 에서 row 생성 createRow()
		// XSSFRow : row에서 cell 생성 createCell()
		// XSSFCell : cell에서 값 입력 setCellValue()
		// 워크북, 시트,  행, 셀 생성
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell;
		
		// 엑셀 헤더 정보 구성
		cell = row.createCell(0);
		cell.setCellValue("일반관리비");
		
		cell = row.createCell(1);
		cell.setCellValue("청소비");
		
		cell = row.createCell(2);
		cell.setCellValue("승강기유지비");
		
		cell = row.createCell(3);
		cell.setCellValue("하수도료");
		
		// 리스트 size만큼 row 생성
		
		// 파일 쓰기
		File file = new File(fileVo.getFullPath()+"test.xls");
		FileOutputStream fos = null;
		if(!file.exists()) {
			try {
				fos = new FileOutputStream(file);
				workbook.write(fos);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					workbook.close();
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
	// 파일 삭제
	public void deleteFile(String path, String renameFileName) {
		// 기초 저장경로 + 날짜 저장경로 + 파일이름
		File file = new File(Configcode.UPLOAD_PATH + path + renameFileName);
		file.delete();
	}

	
}
