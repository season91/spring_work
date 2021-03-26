package com.kh.toy.mymgmtfee.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.toy.mgmtfee.model.vo.Mgmtfee;
import com.kh.toy.mymgmtfee.model.service.MyMgmtfeeService;

@Controller
public class MyMgmtfeeController {
	
	private final MyMgmtfeeService myMgmtfeeService;
	
	public MyMgmtfeeController(MyMgmtfeeService myMgmtfeeService) {
		this.myMgmtfeeService = myMgmtfeeService;
	}
	
	@GetMapping("mypage/mymgmtfee")
	public void myMgmtfee(@RequestParam(defaultValue = "1") int page, Model model) {
		String generationIdx = "100304";
		System.out.println("page"+page);
		model.addAllAttributes(myMgmtfeeService.selectMyMgmtfeeList(page, generationIdx));
	

	}
	
	@GetMapping("mypage/mymgmtfeedetail")
	public void MyMgmtfeeDetail(@RequestParam String mgmtfeeidx, Model model) {
		System.out.println("넘어오나?"+mgmtfeeidx);
		Mgmtfee mgmtfee = myMgmtfeeService.selectMyMgmtfeeByMgmtfeeIdx(mgmtfeeidx);
		Map<String,Object> mgmtdate = myMgmtfeeService.selectMyMgmtfeeDate(mgmtfeeidx);

		model.addAttribute(mgmtfee);
		model.addAttribute("mgmtdate",mgmtdate);
		System.out.println(mgmtdate.get("YEAR"));
		System.out.println(mgmtdate.get("MONTH"));
		
	}

}
