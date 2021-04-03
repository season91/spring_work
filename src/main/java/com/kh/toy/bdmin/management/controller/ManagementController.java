package com.kh.toy.bdmin.management.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.toy.bdmin.management.model.service.ManagementService;
import com.kh.toy.generation.model.vo.Admin;

@Controller
public class ManagementController {
	
	private final ManagementService managementService;
	
	public ManagementController(ManagementService managementService) {
		this.managementService = managementService;
	}
	
	// 페이징
	@GetMapping("/bdmin/management/adminauthority")
	public void adminAuthority(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "basic") String standard, @RequestParam(defaultValue = "basic") String keyword, Model model) {		//관리자 권한 페이징
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("searchType", standard);
		searchMap.put("keyword", keyword);
		
		model.addAllAttributes(managementService.selectAdminList(page, searchMap));
		
	}
	
	// 관리자 신규등록
	@GetMapping("/bdmin/management/adminadd")
	public String adminAdd(Admin admin, @RequestParam String apartmentInfo,Model model) {
		
		String[] apartmentIndx = apartmentInfo.split("/");
		// [0]은 아파트이름이고 [1]아파트 idx이다.
		admin.setApartmentIdx(apartmentIndx[1]);
		System.out.println(admin);
		
		managementService.insertAdmin(admin);
		model.addAttribute("alertMsg", "권한부여가 되었습니다.");
		model.addAttribute("url", "/bdmin/management/adminauthority");
		return "common/result";
	}
	
	// 비동기통신
	@GetMapping("/bdmin/management/admindelete")
	public void adminDelete(@RequestParam String managerIdx) {
		managementService.updateAdminIsDel(managerIdx);
	}
	
	@GetMapping("/bdmin/management/admindetail")
	public void adminDetail(@RequestParam String managerIdx, Model model) {
		model.addAttribute(managementService.selectAdminByManagerIdx(managerIdx));
		
	}
	
}
