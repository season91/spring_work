package com.kh.toy.bdmin.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.toy.bdmin.model.service.AdminService;
import com.kh.toy.bdmin.model.service.BdminService;
import com.kh.toy.bdmin.model.vo.ApartApplication;
import com.kh.toy.bdmin.model.vo.Bdmin;
import com.kh.toy.generation.model.vo.Admin;
import com.kh.toy.generation.model.vo.Apartment;

@Controller
public class BdminController {
	
	private final BdminService bdminService;
	private final AdminService adminService;
	
	public BdminController(BdminService bdminService,AdminService adminService) {
		this.bdminService = bdminService;
		this.adminService = adminService;
	}
	
	@GetMapping("/admin/chat")
	public void chatTest() {
		
	}
	
	@GetMapping("/myapt/chat")
	public void chatGenerationTest() {
		
	}
	
	
	// 선영
	@GetMapping("/admin/login")
	public String adminlogin() {
		return "admin/login";
	}
	
	// 선영
	@PostMapping("/admin/loginimpl")
	@ResponseBody
	public String loginimpl(@RequestBody Admin adminInfo, HttpSession session) {

		// adminInfo : 받아와서 맵핑 해주는 객체 이름
		// admin : 진짜 admin 정보가 담긴 객체 이름

		Admin admin = adminService.selectAdminForAuth(adminInfo);
		if (admin == null) {
			return "fail";
		}
		session.setAttribute("admin", admin);
		return "sussece";

	}
	
	@GetMapping("/bdmin/login")
	public void login() {
		
	}

	@PostMapping("/bdmin/loginimpl")
	@ResponseBody
	public String loginImpl(@RequestBody Bdmin bdminInfo, HttpSession session) {
		Bdmin bdmin = bdminService.selectBdminForAuth(bdminInfo);
		
		if(bdmin == null) {
			return "fail";
		}

		session.setAttribute("bdmin", bdmin);
		return "success";
	}

	@GetMapping("/bdmin/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("bdmin");
		return "redirect:/admin/index";
	}

	// 현재 서비스 이용 중인 아파트리스트
	@GetMapping("/bdmin/apartment")
	public String apartment(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "basic") String standard, @RequestParam(defaultValue = "basic") String keyword, Model model) {
		Map<String,Object> map = bdminService.selectApartList(page, standard, keyword);
		model.addAllAttributes(map);
		String link = "";
		if(map.get("link") != null) {
			link = (String) map.get("link");
		}
		return "/bdmin/apartment"+link;
	}
	
	@GetMapping("/bdmin/apartment/detail")
	public void apartmentDetail(@RequestParam String apartmentIdx, Model model) {
		System.out.println(apartmentIdx);
		
		model.addAttribute(bdminService.selectApartment(apartmentIdx));
	}
	
	@PostMapping("/bdmin/apartment/modify")
	public String apartmentModify(Apartment apartment, Model model) {
		System.out.println(apartment);
		bdminService.updateApartment(apartment);
		model.addAttribute("alertMsg", "수정이 완료되었습니다");
		model.addAttribute("url", "/bdmin/apartment");
		return "common/result";
	}
	
	
	// 입점문의건 목록
	@GetMapping("/bdmin/apartment/contactlist")
	public void apartmentContactList(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "basic") String standard, @RequestParam(defaultValue = "basic") String keyword, Model model) {
		model.addAllAttributes(bdminService.selectApartApplicationList(page, standard, keyword));
	}
	
	// 입점문의 상세
	@GetMapping("/bdmin/apartment/contactusdetail")
	public void apartmentContactDetail(String applicationIdx, Model model) {
		System.out.println(applicationIdx);
		model.addAttribute(bdminService.selectApartApplication(applicationIdx));
	}
	
	// 입점문의 승인, 반려 업데이트
	@PostMapping("/bdmin/contactus/process")
	public String contactUsProcess(ApartApplication apartApplication, Model model) {
		System.out.println("처리시작?"+apartApplication.getApplicationIdx()+"처리?"+apartApplication.getIsProcess());
		int res = bdminService.updateApartApplicationIsProcess(apartApplication);
		if(res > 0 ) {
			model.addAttribute("alertMsg", "처리가 완료되었습니다.");
			model.addAttribute("url", "/bdmin/apartment/contactlist");
		} else {
			model.addAttribute("alertMsg", "처리가 되지 않았습니다. 개발팀에 문의해주세요.");
			model.addAttribute("url", "/bdmin/apartment/contactlist");
		}

		return "common/result";
	}
	
	@GetMapping("/bdmin/contactus")
	public String contactUs() {
		System.out.println("오나");
		return "/bdmin/contactus";
	}
	
	@PostMapping("/bdmin/contactusimpl")
	public String contactUsImpl(ApartApplication apartApplication, Model model) {
		// 신청서 작성시 신청서 insert한다.
		System.out.println(apartApplication);
		bdminService.insertApartApplication(apartApplication);
		model.addAttribute("alertMsg", "등록신청이 완료되었습니다. 처리까지는 4~5일 소요되며, 승인시 담당자가 연락할 예정입니다.");
		model.addAttribute("url", "/bdmin/contactus");
		return "common/result";
	}
	
}
