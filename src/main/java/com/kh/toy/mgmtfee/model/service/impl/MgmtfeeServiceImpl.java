package com.kh.toy.mgmtfee.model.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.toy.mgmtfee.model.service.MgmtfeeService;
import com.kh.toy.mgmtfee.model.vo.Mgmtfee;

@Service
public class MgmtfeeServiceImpl implements MgmtfeeService{

	@Override
	public List<Mgmtfee> mgmtfeeUpload(MultipartFile file) {
		List<Mgmtfee> mgmtfeeList = new ArrayList<>();
		
		OPCPackage opc;
		try {
			opc = OPCPackage.open(file.getInputStream());
			XSSFWorkbook workBook = new XSSFWorkbook(opc);
			
			// 첫번째 시트 불러오기
			XSSFSheet sheet = workBook.getSheetAt(0);
			for (int i = 1; i < sheet.getLastRowNum()+1; i++) {
				XSSFRow  row = sheet.getRow(i);
				// 행 미존재시 스킵
				if(row == null) {
					continue;
				}
				// 행의 두번째 열
				XSSFCell cell = row.getCell(1);
				Mgmtfee mgmtfee = Mgmtfee.builder()
						.gnrlMgmtFee(cell.getStringCellValue())
						.cleanFee(cell.getStringCellValue())
						.elvtrMnfee(cell.getStringCellValue())
						.genElctr(cell.getStringCellValue())
						.build();
				
				mgmtfeeList.add(mgmtfee);
				
			}
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("리스트"+mgmtfeeList);
		return mgmtfeeList;
	}

	

}
