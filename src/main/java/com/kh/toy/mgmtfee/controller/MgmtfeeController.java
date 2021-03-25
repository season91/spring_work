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

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	// 페이징처리
	@GetMapping("admin/mgmtfee")
	public void adminMgmtfee(@RequestParam(defaultValue = "1") int page, Model model) {
		String apartmentIdx = "100000";
		// 관리자의 아파트정보 기준으로 관리비 리스트 가져오기
		// 페이징 처리 해주기
		System.out.println(page);
		model.addAllAttributes(mgmtfeeService.selectMgmtfeeList(page, apartmentIdx));
	};
	
	// 아영 : 업로드된 엑셀파일 읽기. 비동기통신
	@PostMapping(value="admin/mgmtfee/uploadimpl")
	@ResponseBody
	public String mgmtUpload(@RequestParam MultipartFile file, Model model) {
		Map<String, Object> commandMap = mgmtfeeService.mgmtfeeRead(file);
		// 업로드할때 관리자의 아파트번호의 아파트세대에게 관리비를 보내야한다.
		
		String apartmentIdx = "100000";
		List<Mgmtfee> mgmtfeeList = mgmtfeeService.insertMgmtfee(commandMap, apartmentIdx);
		System.out.println(mgmtfeeList.size());
		
		// 성공 실패 분기나누기
		if(mgmtfeeList == null || mgmtfeeList.size() == 0 || mgmtfeeList.get(0).getPeriodPayment().equals("")) {
			System.out.println("실패유");
			return "fail";
		}
		return "success";

	}
	
	// 아영 : 관리비 엑셀 양식 다운로드 받기
	@GetMapping("admin/mgmtfeeformdownload")
	public ResponseEntity<FileSystemResource> mgmtFormDownload() {
		// 엑셀양식 다운로드하게
		
		// 만드려면 필요한것 : 아파트번호
		// 아파트번호는 로그인한 관리자 세션을 통해 가져온다.
		// 관리인 정보 기준으로 아파트 번호 받아와 세대정보 보내준다.
		String apartmentIdx = "100000";
		Map<String, Object> generationList = mgmtfeeService.selectGenerationList(apartmentIdx);

		FileUtil fileUtil = new FileUtil();
		// mgmtfeeFormExcel 엑셀 양식 호출.
		System.out.println("양식만들기시작");
		File file = fileUtil.mfmtgeeFormExcel(generationList);
		
		// 내보내기
		HttpHeaders headers= new HttpHeaders();
		headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName(), Charset.forName("UTF-8"))
				.build());
		FileSystemResource resource = new FileSystemResource(file);
		
		return ResponseEntity.ok().headers(headers).body(resource);
	}
	
	// 수정,삭제하기
	@GetMapping("admin/mgmtfeemodify")
	public void mgmtfeeModify() {
		
	}
	
	@GetMapping("admin/mgmtfeemodifyimpl")
	public void mgmtfeeModifyImpl() {
		
	}
}