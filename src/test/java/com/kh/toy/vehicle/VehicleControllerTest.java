package com.kh.toy.vehicle;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.toy.vehicle.model.repository.VehicleRepository;
import com.kh.toy.vehicle.model.service.VehicleService;
import com.kh.toy.vehicle.model.vo.Vehicle;

import common.code.Configcode;
import common.util.qrcode.QRCodeUtil;

@WebAppConfiguration 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class VehicleControllerTest {
	@Autowired
	VehicleService vehicleService;

	
	@Test
	public void insertVehicle() {
		String domain = Configcode.DOMAIN.desc;
		String url = "/work/readvehicle";
		String generationIdx = "100300";
		
		Vehicle vehicle = new Vehicle();
		vehicle.setGenerationIdx(generationIdx);
		vehicle.setVehicleNumber("123마7890");
		
		// 파라미터 인코딩해주기
		try {
			String vehicleNumber = URLEncoder.encode(vehicle.getVehicleNumber(),"UTF-8");
		
		// QR코드생성한다
		QRCodeUtil qr = new QRCodeUtil();
		qr.makeQR(domain+url+"?generationIdx=100298&vehicleNumber="+vehicleNumber, "testtest");
			
		vehicle.setVehicleIMG("/resources/vehicle/");
		
		
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	
	
}
