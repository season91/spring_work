package com.kh.toy.parking.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.toy.car.model.vo.Car;
import com.kh.toy.mgmtfee.model.vo.Generation;
import com.kh.toy.parking.model.service.ParkingService;
import com.kh.toy.parking.model.vo.CarApplication;
import com.kh.toy.parking.validator.CarApplicationValidator;

@Controller
public class ParkingController {
	
	private final ParkingService parkingService;
	private final CarApplicationValidator carApplicationValidator;
	
	public ParkingController(ParkingService parkingService, CarApplicationValidator carApplicationValidator) {
		this.parkingService = parkingService;
		this.carApplicationValidator = carApplicationValidator;
	}
	
	@InitBinder("carApplication")
	public void initBinder(WebDataBinder webDataBinder) {
		//webDataBinder : 컨트롤러 메서드의 파라미터에 데이터 바인드 해주는 역할을 하는 클래스
		webDataBinder.addValidators(carApplicationValidator);
	}

	@GetMapping("/myapt/parking")
	public void parking(Model model) {
		String apartmentIdx = "100000";
		
		// 주차가능대수 조회
		Map<String, Object> parkingMap = parkingService.possibleParking(apartmentIdx);
		model.addAllAttributes(parkingMap);
	}
	
	// 차량신청
	@GetMapping("/myapt/parking/application")
	public String carApplication(Model model){
		String generationIdx= "100296";		
		// 신청한 내역이 있는지 확인 후 보내준다.
		
		List<CarApplication> carApplicationCheck = parkingService.selectCarApplicationByGenerationIdx(generationIdx);
		System.out.println(carApplicationCheck);
		
		if(carApplicationCheck != null && carApplicationCheck.size() > 0) {
			model.addAttribute("carApplicationList",carApplicationCheck);
		}
		
		return "/myapt/carapplication";
	}

	@PostMapping("/myapt/parking/applicationimpl")
	public String carApplicationImpl(@Valid CarApplication carApplication, Errors errors, Model model){
		String generationIdx= "100296";
		carApplication.setApartmentIdx("100000");
		carApplication.setGenerationIdx(generationIdx);
		System.out.println(carApplication);
		// 1.신청 온 차량번호 검증한다
		if(errors.hasErrors()) {
			return "/myapt/carapplication";
		}
		
		// 2. 신청가능 상태를 확인한다. 
		// 이미 등록된차량인지 세대가 2대등록이상 신청인지 확인 후 없으면 신청가능
		// 신청한 이력이 없다면 신청가능
		Car car = parkingService.selectCarByApplicationInfo(carApplication);
		List<CarApplication> carApplicationCheck = parkingService.selectCarApplication(carApplication);
		
		if(car == null && carApplicationCheck.size() == 0) {
			// 등록된 차량도, 신청한 이력도 없다면 신청가능
			// 차량번호와 세대관리번호로 신청 테이블에 넣어준다.
			int res = parkingService.insertCarApplication(carApplication);
			if(res > 0) {
				model.addAttribute("alertMsg", "차량 등록 신청이 되었습니다.");
			} else {
				model.addAttribute("alertMsg", "차량 등록 신청이 실패하였습니다. 관리인에게 문의해주세요.");
			}

		} else {
			model.addAttribute("alertMsg", "이미 신청된 차량 정보입니다.");
		}

		model.addAttribute("url", "/myapt/parking/application");
		return "common/result";
	}

}
