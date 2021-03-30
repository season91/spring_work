package com.kh.toy;

import org.springframework.web.bind.annotation.GetMapping;



@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping("work/mgmtfee")
	public void adminMgmtfee() {};
	
	@GetMapping("work/mgmtfeeupload")
	public void adminMgmtfeeUpload() {};

	@GetMapping("work/uploadtest")
	public void testUpload() {};
	
}
