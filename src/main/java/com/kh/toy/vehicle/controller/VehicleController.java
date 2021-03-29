package com.kh.toy.vehicle.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.toy.mgmtfee.model.vo.Generation;
import com.kh.toy.vehicle.model.service.VehicleService;
import com.kh.toy.vehicle.model.vo.Vehicle;

import common.code.Configcode;
import common.util.qrcode.QRCodeUtil;

@Controller
public class VehicleController {
	
	private final VehicleService vehicleService;
	
	public VehicleController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	// 페이징처리하기
	@GetMapping("admin/vehicle")
	public String vehicle() {
		return "work/vehicle";
	}
	
	@GetMapping("admin/vehicleadd")
	public String vehicleAdd(Generation generationInfo, @RequestParam String vehicleNumber, Model model){
		// 전달받은 아파트번호,동,호수 정보로 Generation 가져온다.
		System.out.println("오나??");
		Generation generation = vehicleService.selectGenerationByBuildingAndNum(generationInfo);
		System.out.println(generation);
		// 전달받은 차량번호를 세대정보와 함께 넣어준다.
		Vehicle vehicle = new Vehicle();
		vehicle.setGenerationIdx(generation.getGenerationIdx());
		vehicle.setVehicleNumber(vehicleNumber);
		vehicle.setVehicleIMG(Configcode.QRCODE_PATH.desc);
		
		String res = vehicleService.insertAndQRWrite(generation, vehicle);
		model.addAttribute("alertMsg", res);
		model.addAttribute("url", "admin/vehicle");

		return "common/result";
		
		
	}
	// 관리자가 등록시 QR코드 생성한다.
	@GetMapping("work/vehicletestimpl")
	public String vehicletest(@RequestParam String url, String generationIdx){
		// 세대 정보 받아서 큐알 생성한다.
		
		String domain = Configcode.DOMAIN.desc;
		try {
			Vehicle vehicle = new Vehicle();
			vehicle.setGenerationIdx(generationIdx);
			vehicle.setVehicleNumber("123허7890");
			String vehicleNumber = URLEncoder.encode(vehicle.getVehicleNumber(),"UTF-8");
			
			// QR코드생성한다
			QRCodeUtil qr = new QRCodeUtil();
			qr.makeQR(domain+url+"?generationIdx=100298&vehicleNumber="+vehicleNumber, "testtest");
	
			// localhost:8888//work/readvehicle?generationIdx=100298&vehicleNumber=123가4567 로 가질거임.
			// 경로는 ck에디터 경로이고, 파일명은 vehicleIdx이다.
			
			// QR코드 경로 토대로 insert한다
			//vehicle.setVehicleIMG("/resources/ckstorage/vehicle");
			//vehicleService.insertVehicle(vehicle);
			
			System.out.println("다만들음");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return "work/vehicletest";
	}
	
	// 관리자는 생성된 QR코드에는 세대관리번호와 차량번호가 들어가있고 이걸 url로 읽는 메서드
	@GetMapping("/work/readvehicle")
	public String readQRCode(@RequestParam String generationIdx, @RequestParam String vehicleNumber) {
		System.out.println("잘넘어오나?"+generationIdx+vehicleNumber);
		
		return "mypage/myvehicle";
	}
	
	// 입주자는 차량 QR코드를 사이트에서 바로 볼수있다
	// QR이미지 불러오기
	@GetMapping("/work/readqrcode")
	public String generationQRCode(Model model) {
		String vehicleIdxck = "100000"; // ck경로 공용용?
		String vehicleIdxre = "100007"; // 작업경로? 무슨차이인지잘모르겠음
		Vehicle vehicle = vehicleService.selectVehcile(vehicleIdxre);
		model.addAttribute(vehicle);
		System.out.println(vehicle);
		return "work/vehicletest";
	}
	
}
