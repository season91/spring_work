package com.kh.toy.parking.model.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kh.toy.parking.model.repository.ParkingRepository;
import com.kh.toy.parking.model.service.ParkingService;
import com.kh.toy.parking.model.vo.CarApplication;

@Service
public class ParkingServiceImpl implements ParkingService{
	
	private final ParkingRepository parkingRepository;
	
	public ParkingServiceImpl(ParkingRepository parkingRepository) {
		this.parkingRepository = parkingRepository;
	}

	@Override
	public Map<String, Object> possibleParking(String apartmentIdx) {
		Map<String, Object> parkingMap = new HashMap<String, Object>();
		// 현재 주차가능대수 조회
		int totalParking = parkingRepository.selectApartmentParking(apartmentIdx);
		parkingMap.put("totalParking", totalParking);
		
		int InCarCnt = parkingRepository.selectIsInCarCnt();
		int possibleParking = totalParking - InCarCnt;
		parkingMap.put("possibleParking", possibleParking);
		
		return parkingMap;
	}

	@Override
	public int insertCarApplication(CarApplication carApplication) {
		// TODO Auto-generated method stub
		return parkingRepository.insertCarApplication(carApplication);
	}

	@Override
	public List<CarApplication> selectCarApplicationByGenerationIdx(String generationIdx) {
		// TODO Auto-generated method stub
		return parkingRepository.selectCarApplicationByGenerationIdx(generationIdx);
	}

}
