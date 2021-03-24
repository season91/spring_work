package com.kh.toy.mgmtfee.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
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

import common.util.file.FileUtil;


@Controller
public class MgmtfeeController {


	private final MgmtfeeService mgmtfeeService;
	
	public MgmtfeeController(MgmtfeeService mgmtfeeService) {
		this.mgmtfeeService = mgmtfeeService;
	}
	
	// 업로드된 엑셀파일 읽기.
	@PostMapping(value="work/mgmtfeeuploadimpl",headers = ("content-type=multipart/*"))
	public String mgmtUpload(@RequestParam MultipartFile file, Model model) {
		System.out.println("여기오나??");

		Map<String, Object> commandMap = mgmtfeeService.mgmtfeeRead(file);
		List<Mgmtfee> mgmtfeeList = mgmtfeeService.addMgmtfee(commandMap);
		System.out.println(mgmtfeeList.toString());
		
		return "work/uploadtest";
		
	}
	
	@GetMapping("work/mgmtfeeformdownload")
	public ResponseEntity<FileSystemResource> mgmtFormDownload() {
		// 엑셀양식 다운로드하게
		//HttpHeaders headers = new HttpHeaders();
		//headers.setContentDisposition(ContentDisposition.builder("attachment").filename(filename, Charset.forName("UTF-8")));
		System.out.println("양식만들기시작");
		
		FileUtil fileUtil = new FileUtil();
		// mgmtfeeFormExcel 엑셀 양식 호출.
		File file = fileUtil.mfmtgeeFormExcel();
		
		// 내보내기
		HttpHeaders headers= new HttpHeaders();
		headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName(), Charset.forName("UTF-8"))
				.build());
		FileSystemResource resource = new FileSystemResource(file);
		
		return ResponseEntity.ok().headers(headers).body(resource);
	}
}
