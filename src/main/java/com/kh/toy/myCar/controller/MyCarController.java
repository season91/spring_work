package com.kh.toy.myCar.controller;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.toy.car.model.vo.Car;
import com.kh.toy.myCar.model.service.MyCarService;

@Controller
public class MyCarController {
	
	private final MyCarService myCarService;
	
	public MyCarController(MyCarService myCarService) {
		this.myCarService = myCarService;
	}

	// 내가등록한 차량 확인
	@GetMapping("/mypage/mycar")
	public void myCar(Model model) {
		String generationIdx = "100305";
		// generationIdx로 등록된 차량 정보 가져온다
		
		List<Car> carList = myCarService.selectCarByGenerationIdx(generationIdx);
		System.out.println(carList);
		model.addAttribute("carList",carList);

	}

	//QR코드 다운받기
	@GetMapping("/mypage/mycarqrdownload")
	public ResponseEntity<FileSystemResource> myQRDownload(String path) {
		String fileName = path.replace("/resources/vehicle/", "");
		String originPath = "C:\\CODE\\06_Spring\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\Spring_abooTest\\resources\\vehicle\\";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDisposition(ContentDisposition.builder("attachment").filename(fileName, Charset.forName("UTF-8"))
				.build());
		
		FileSystemResource resources = new FileSystemResource(originPath+fileName);
		return ResponseEntity.ok().headers(headers).body(resources);
		
	}
}
