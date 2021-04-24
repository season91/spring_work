package com.kh.toy.admin.index.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.kh.toy.admin.index.model.service.IndexManagementService;
import com.kh.toy.generation.model.vo.Admin;

@Controller
public class AdminIndexController {

	private final IndexManagementService indexManagementService;
	
	public AdminIndexController(IndexManagementService indexManagementService) {
		this.indexManagementService = indexManagementService;
	}
	
	@GetMapping("admin/index")
	public void admin(Model model) {
		List<Integer> list = indexManagementService.selectMgmtfeeMonthFee();
		model.addAttribute("list", list);
	}
	
}
