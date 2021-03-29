package com.kh.toy.vehicle.model.service;

import com.kh.toy.mgmtfee.model.vo.Generation;
import com.kh.toy.vehicle.model.vo.Vehicle;

public interface VehicleService {
	
	// test 입주자확인용
	Vehicle selectVehcile(String vehicleIdx);
	
	// [차량 등록]
	// 1. 등록을 위한 세대정보 가져오기
	Generation selectGenerationByBuildingAndNum(Generation generation);
	
	// 2. QR코드 생성 & DB 등록한다.
	String insertAndQRWrite(Generation generation,Vehicle vehicle);

}
