package com.kh.toy.mymgmtfee.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.toy.mgmtfee.model.vo.Generation;
import com.kh.toy.mgmtfee.model.vo.Mgmtfee;
import com.kh.toy.mgmtfee.model.vo.MgmtfeeOverdue;
import com.kh.toy.mymgmtfee.model.service.MyMgmtfeeService;

@Controller
public class MyMgmtfeeController {
	
	private final MyMgmtfeeService myMgmtfeeService;
	
	public MyMgmtfeeController(MyMgmtfeeService myMgmtfeeService) {
		this.myMgmtfeeService = myMgmtfeeService;
	}
	
	@GetMapping("mypage/mymgmtfee")
	public void myMgmtfee(@RequestParam(defaultValue = "1") int page, Model model) {
		String generationIdx = "100333";
		// 로그인유저 generation 가져와 세대정보 보여준다.
		// 임시라서 직접넣는다.
		Generation generation = new Generation();
		generation.setApartmentIdx("100000");
		generation.setGenerationIdx(generationIdx);
		generation.setBuilding("109");
		generation.setNum("904");
		model.addAttribute("generation",generation);
		Map<String,Object> map = myMgmtfeeService.selectMyMgmtfeeList(page, generationIdx); 
		System.out.println(map.get("myMgmtfeeList"));
		model.addAllAttributes(map);
	
	}
	
	@GetMapping("mypage/mymgmtfeedetail")
	public void MyMgmtfeeDetail(@RequestParam String mgmtfeeidx, Model model) {
		System.out.println("넘어오나?"+mgmtfeeidx);
		
		// 관리비정보 보내준다.
		Mgmtfee mgmtfee = myMgmtfeeService.selectMyMgmtfeeByMgmtfeeIdx(mgmtfeeidx);
		
		Map<String,Object> mgmtdate = myMgmtfeeService.selectMyMgmtfeeDate(mgmtfeeidx);

		// 연체료정보도 보내준다
		MgmtfeeOverdue mgmtfeeOverdue = myMgmtfeeService.selectMyMgmtfeeOverdue(mgmtfeeidx);
		if (mgmtfeeOverdue != null) {
			model.addAttribute(mgmtfeeOverdue);
			System.out.println("있따"+mgmtfeeOverdue);
		}
		System.out.println(mgmtfeeOverdue);
		model.addAttribute(mgmtfee);
		model.addAttribute("mgmtdate",mgmtdate);
		
		
	}

}
