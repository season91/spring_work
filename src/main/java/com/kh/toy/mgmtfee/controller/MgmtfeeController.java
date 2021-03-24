package com.kh.toy.mgmtfee.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.toy.mgmtfee.model.service.MgmtfeeService;
import com.kh.toy.mgmtfee.model.vo.Mgmtfee;


@Controller
public class MgmtfeeController {


	private final MgmtfeeService mgmtfeeService;
	
	public MgmtfeeController(MgmtfeeService mgmtfeeService) {
		this.mgmtfeeService = mgmtfeeService;
	}
	

	@PostMapping(value="work/mgmtfeeuploadimpl",headers = ("content-type=multipart/*"))
	public String mgmtUpload(@RequestParam MultipartFile file, Model model) {
		System.out.println("여기오나??");
		System.out.println(file);
		
		List<Mgmtfee> dataList = new ArrayList<>();
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		
		System.out.println("파일타입이 뭔가?"+extension);
		
		// XSSFWorkbook은 엑셀파일 전체 내용을 담고 있는 객체
		// XSSFWorkbook : workbook에서 작성 write()
		// XSSFSheet : sheet 에서 row 생성 createRow()
		// XSSFRow : row에서 cell 생성 createCell()
		// XSSFCell : cell에서 값 입력 setCellValue()
		// 워크북, 시트,  행, 셀 생성
		
		// 1. 엑셀 업로드한 파일 확장자 확인
		Workbook workbook = null;
		try {
			if(extension.equals("xlsx")) {
				System.out.println("xlsx 이다.");
				// excel 2007 이상버전
				workbook = new XSSFWorkbook(file.getInputStream());
			}else if(extension.equals("xls")) {
				// excel 구버전
				workbook = new HSSFWorkbook(file.getInputStream());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 2. 시트 확인
		Sheet workSheet = workbook.getSheetAt(0);
		
		// 3. 행 읽기, 시트의 행수만큼
		for (int i = 0; i < workSheet.getPhysicalNumberOfRows(); i++) {
			Row row = workSheet.getRow(i);
			//System.out.println(row);
			// 4. 셀 읽기, 행의 셀 수만큼
			int cells = row.getPhysicalNumberOfCells();
			for (int j = 0; j < cells; j++) {
				Cell cell = row.getCell(j);
				String value = "";
				// 셀타입에 따라 읽는다.
				//System.out.println(cell.getCellType());
				switch (cell.getCellType()) {
				case FORMULA:
					value = cell.getCellFormula();
					break;
				case NUMERIC:
					value = cell.getNumericCellValue() + "";
					break;
				case STRING:
					value = cell.getStringCellValue() + "";
					break;
				case BLANK:
					value = cell.getBooleanCellValue() + "";
					break;
				case ERROR:
					value = cell.getErrorCellValue() + "";
					break;
				}
				System.out.println(i+"번행 : " + j +"번 열 값은 " + value);
			}
			
		}

		return "work/uploadtest";
		
	}
	
	@GetMapping("work/mgmtfeeformdownload")
	public ResponseEntity<FileSystemResource> mgmtFormDownload() {
		// 엑셀양식 다운로드하게
		//HttpHeaders headers = new HttpHeaders();
		//headers.setContentDisposition(ContentDisposition.builder("attachment").filename(filename, Charset.forName("UTF-8")));
		System.out.println("양식만들기시작");
		
		//xlsx로 다운로드
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		XSSFRow row = null;
		XSSFCell cell = null;
		
		int rowNo = 0;
		
		// 엑셀 생성
		workbook = new XSSFWorkbook();
		// 시트 이름 지정
		sheet = workbook.createSheet("세대관리비");
		
		// 행지정
		row = sheet.createRow(rowNo++);
		
		// 셀지정
		cell = row.createCell(0);
		cell.setCellValue("호수");
		cell = row.createCell(1);
		cell.setCellValue("일반관리비");
		
		// 두번째 셀
		cell = row.createCell(1);
		cell.setCellValue("103호");
		
		// 내보내기
		String localFile = "C:\\CODE\\세대관리비양식.xlsx";
		File file = new File(localFile);
		FileOutputStream fos = null;
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

		HttpHeaders headers= new HttpHeaders();
		headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName(), Charset.forName("UTF-8"))
				.build());
		FileSystemResource resource = new FileSystemResource(file);
		
		return ResponseEntity.ok().headers(headers).body(resource);
	}
}
