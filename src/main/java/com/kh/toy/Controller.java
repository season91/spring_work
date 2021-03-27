package com.kh.toy;

import org.springframework.web.bind.annotation.GetMapping;



@org.springframework.stereotype.Controller
public class Controller {
	
	@GetMapping("generation")
	public String index() {
		return "generation/index";
	}
	
	@GetMapping("admin")
	public String admin() {
		return "admin/index";
	}
	
	@GetMapping("myapt/parking")
	public void parking() {};
	
	@GetMapping("mypage/mgmtfee")
	public void mgmtfee() {};
	
	@GetMapping("mypage/mgmtfeedetail")
	public void mgmtfeedetail() {};
	
	@GetMapping("mypage/myvehicle")
	public void myvehicle() {};
	
	@GetMapping("work/mgmtfee")
	public void adminMgmtfee() {};
	
	@GetMapping("work/mgmtfeeupload")
	public void adminMgmtfeeUpload() {};
	
	@GetMapping("work/vehicle")
	public void adminVehicle() {};
	
	@GetMapping("work/uploadtest")
	public void testUpload() {};
	
}
