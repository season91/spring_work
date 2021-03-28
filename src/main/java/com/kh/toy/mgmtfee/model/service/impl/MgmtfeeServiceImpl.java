package com.kh.toy.mgmtfee.model.service.impl;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.Document;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.toy.mgmtfee.model.repository.MgmtfeeRepository;
import com.kh.toy.mgmtfee.model.service.MgmtfeeService;
import com.kh.toy.mgmtfee.model.vo.Generation;
import com.kh.toy.mgmtfee.model.vo.Mgmtfee;
import com.kh.toy.mgmtfee.model.vo.MgmtfeeOverdue;

import common.code.ErrorCode;
import common.exception.ToAlertException;
import common.util.paging.Paging;

@Service
public class MgmtfeeServiceImpl implements MgmtfeeService{

	private final MgmtfeeRepository mgmtfeeRepository;

	public MgmtfeeServiceImpl(MgmtfeeRepository mgmtfeeRepository) {
		this.mgmtfeeRepository = mgmtfeeRepository;
	}
	
	@Override
	public Map<String, Object> mgmtfeeRead(MultipartFile file) {
		// 전달받은 MultipartFile file의 타입을 확인한다. xlxs인지 xls인지
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		System.out.println(extension);
		// 1. 업로드된 엑셀파일의 확장자 확인
		Workbook workbook = null;
		if(!extension.equals("xlsx")) {
			System.out.println("예외발동한다.");
			throw new ToAlertException(ErrorCode.SM01);
		}
		
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
		Map<String,Object> commandMap = new HashedMap<String, Object>();
		
		for (int i = 1; i < workSheet.getPhysicalNumberOfRows(); i++) {
			Row row = workSheet.getRow(i);
			
			//System.out.println(row);
			// 4. 셀 읽기, 행의 셀 수만큼
			List<Object> list = new ArrayList<Object>();
			int cells = row.getPhysicalNumberOfCells();
			if(cells > 2) {
				for (int j = 0; j < cells; j++) {
					
					Cell cell = row.getCell(j);
					String value = "";
					// 셀타입에 따라 읽는다.
					// System.out.println(cell.getCellType());
					switch (cell.getCellType()) {
					case FORMULA:
						value = cell.getCellFormula();
						break;
					case NUMERIC:
						value = (int) cell.getNumericCellValue()+"";
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
					list.add(value);
				}
			} else { 
				throw new ToAlertException(ErrorCode.API01);
			}
			
			commandMap.put(i+"행", list);
		}
		
		return commandMap;
	}

	@Override
	public List<Mgmtfee> insertMgmtfee(Map<String, Object> commandMap,String apartmentIdx) {
		List<Mgmtfee> mgmtfeeList = new ArrayList<>();
		Mgmtfee mgmtfee = new Mgmtfee();
		for (String	key : commandMap.keySet()) {
			//System.out.println(commandMap.get(key));
			List<String> list = (List<String>) commandMap.get(key);
			//System.out.println("동호수:" + list.get(0)+"d"+list.get(1)+"h");
			//System.out.println("일반관리비:"+list.get(2));
			
			// 아파트번호와 동호수로 세대관리번호 조회해온다.
			String building = list.get(0);
			String num = list.get(1);
			
			System.out.println(building+"동");
			Generation generationInfo = new Generation();
			generationInfo.setApartmentIdx(apartmentIdx);;
			generationInfo.setBuilding(building);
			generationInfo.setNum(num);
			
			Generation generation = mgmtfeeRepository.selectGenerationIdx(generationInfo);

			mgmtfee.setApartmentIdx(apartmentIdx);
			mgmtfee.setGenerationIdx(generation.getGenerationIdx());
			mgmtfee.setGnrlMgmtFee(list.get(2));
			mgmtfee.setCleanFee(list.get(3));
			mgmtfee.setElvtrMnfee(list.get(4));
			mgmtfee.setGenElctr(list.get(5));
			mgmtfee.setComonElctr(list.get(6));
			mgmtfee.setGenWater(list.get(7));
			mgmtfee.setSewer(list.get(8));
			mgmtfee.setExpenses(list.get(9));
			mgmtfee.setGenReduction(list.get(10));
			mgmtfee.setPeriodPayment(list.get(11));
			mgmtfee.setDueDate(Date.valueOf(list.get(12)));
			mgmtfee.setMgmtStartDate(Date.valueOf(list.get(13)));
			mgmtfee.setMgmtEndDate(Date.valueOf(list.get(14)));
			mgmtfee.setMgmtWriteDate(Date.valueOf(list.get(15)));
			

			System.out.println(mgmtfee.toString());

			
			mgmtfeeRepository.insertMgmtfee(mgmtfee);
			mgmtfeeList.add(mgmtfee);
		}
		
		
		return mgmtfeeList;
	}

	// 세대정보 엑셀다운을 위한 리스트 동,호수 리스트받아오기.
	@Override
	public Map<String, Object> selectGenerationList(String apartmentIdx) {
		List<String> builging = mgmtfeeRepository.selectBuildingByApartmentIdx(apartmentIdx);
		List<String> num = mgmtfeeRepository.selectNumByApartmentIdx(apartmentIdx);
		
		Map<String, Object> commandMap = new HashMap<>();
		commandMap.put("building", builging);
		commandMap.put("num", num);
		
		return commandMap;
	}
	

	@Override
	public Map<String, Object> selectMgmtfeeList(int currentPage, Map<String, Object> searchMap) {
		//페이징처리
		Paging paging = Paging.builder()
				.currentPage(currentPage)
				.blockCnt(5)
				.cntPerPage(10)
				.type("mgmtfee")
				.total(mgmtfeeRepository.selectContentCntTest(searchMap))
				.build();
		System.out.println(paging.toString());
		// paing 세대조건 정보 넣을 맵
		searchMap.put("paging", paging);

		// 페이징정보 포함해서 페이징에 뿌려줄 리스트 받아온다.
		List<Mgmtfee> mgmtfeeList = mgmtfeeRepository.selectMgmtfeeListTest(searchMap);
		searchMap.put("mgmtfeeList", mgmtfeeList);
		System.out.println("mgmtfeeList"+mgmtfeeList);
		
		// 관리비번호 기준  세대정보 가져오자.
		List<Generation> generationList = new ArrayList<>();
		for (int i = 0; i < mgmtfeeList.size(); i++) {
			String generationIdx = mgmtfeeList.get(i).getGenerationIdx();
			generationList.add(mgmtfeeRepository.selectGenerationByGenerationIdx(generationIdx));
		}
		
		searchMap.put("generationList", generationList);
		System.out.println("searchMap"+searchMap);
		return searchMap;
	}
	
	@Override
	public Mgmtfee selectMgmtfeeByMgmtfeeIdx(String mgmtfeeIdx) {
		
		return mgmtfeeRepository.selectMgmtfeeByMgmtfeeIdx(mgmtfeeIdx);
	}

	@Override
	public Generation selectGenerationByGenerationIdx(String generationIdx) {
		
		return mgmtfeeRepository.selectGenerationByGenerationIdx(generationIdx);
	}

	@Override
	public Mgmtfee updateMgmtfee(Mgmtfee mgmtfee) {
		// TODO Auto-generated method stub
		String mgmtfeeIdx = mgmtfee.getMgmtfeeIdx();
		int res = mgmtfeeRepository.updateMgmtfee(mgmtfee);
		//납부금액 업데이트

		if(res > 0) {
			mgmtfeeRepository.procudureUpdatePeriodPayment(mgmtfeeIdx);
		} else {
			throw new ToAlertException(ErrorCode.UMGMT01);
		} 
		
		return mgmtfeeRepository.selectMgmtfeeByMgmtfeeIdx(mgmtfeeIdx);
	}

	@Override
	@Scheduled(cron = "0 0 18 * * *")
	public void procedureMgmtOverDue() {
		// 연체료 계산하는 배치 메서드, 매일 18시 00분에 돈다.
		System.out.println("배치시작");
		// 납기일이 지난  전체 미납 관리비 가져온다.
		List<Mgmtfee> mgmtfeeList = mgmtfeeRepository.selectMgmtfeeListByAll();
		
		for (int i = 0; i < mgmtfeeList.size(); i++) {
			String mgmtfeeIdx = mgmtfeeList.get(i).getMgmtfeeIdx();
			// 관리비번호 프로시저로 보낸다.
			System.out.println(mgmtfeeIdx+"배치수행");
			mgmtfeeRepository.procedureMgmtOverDue(mgmtfeeIdx);
		}
		
	}

	@Override
	public int updateMgmtfeeIsDel(String mgmtfeeIdx) {
		// TODO Auto-generated method stub
		return mgmtfeeRepository.updateMgmtfeeIsDel(mgmtfeeIdx);

	}

	@Override
	public MgmtfeeOverdue selectMgmtfeeOverdue(String mgmtfeeIdx) {
		// TODO Auto-generated method stub
		return mgmtfeeRepository.selectMgmtfeeOverdue(mgmtfeeIdx);
	}

	@Override
	public int updateMgmtfeeOverdue(MgmtfeeOverdue mgmtfeeOverdue) {
		// TODO Auto-generated method stub
		return mgmtfeeRepository.updateMgmtfeeOverdue(mgmtfeeOverdue);
	}

	@Override
	public Generation selectGenerationByBuildingAndNum(Generation generation) {
		// TODO Auto-generated method stub
		return mgmtfeeRepository.selectGenerationByBuildingAndNum(generation);
	}



}
