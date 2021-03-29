package com.kh.toy.vehicle;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.toy.vehicle.model.repository.VehicleRepository;
import com.kh.toy.vehicle.model.vo.Vehicle;

@WebAppConfiguration 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class VehicleRepositoryTest {
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Test
	public void insertVehicle() {
		Vehicle vehicle = new Vehicle();
		vehicle.setGenerationIdx("100297");
		vehicle.setVehicleNumber("123허4568");
		vehicle.setVehicleIMG("/resources/vehicle/");
		System.out.println(vehicleRepository.insertVehicle(vehicle));
	};

	@Test
	public void selectVehicleByVehicleNumberAndGenerationIdx() {
		String vehicleNumber = "123허4565";
		String generationIdx = "100297";
		Map<String, String> commandMap = new HashMap<String, String>();
		commandMap.put("vehicleNumber", vehicleNumber);
		commandMap.put("generationIdx", generationIdx);
		System.out.println(vehicleRepository.selectVehicleByVehicleNumberAndGenerationIdx(commandMap));
		
	}
}
