package com.kh.toy.vehicle.model.service.impl;

import org.springframework.stereotype.Service;

import com.kh.toy.mgmtfee.model.vo.Generation;
import com.kh.toy.vehicle.model.repository.VehicleRepository;
import com.kh.toy.vehicle.model.service.VehicleService;
import com.kh.toy.vehicle.model.vo.Vehicle;

import common.code.Configcode;
import common.code.ErrorCode;
import common.exception.ToAlertException;
import common.util.qrcode.QRCodeUtil;

@Service
public class VehicleServiceImpl implements VehicleService{
	
	private final VehicleRepository vehicleRepository;

	public VehicleServiceImpl(VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}

	

	@Override
	public Vehicle selectVehcile(String vehicleIdx) {
		// TODO Auto-generated method stub
		return vehicleRepository.selectVehicle(vehicleIdx);
	}
	
	
	@Override
	public Generation selectGenerationByBuildingAndNum(Generation generation) {
		// TODO Auto-generated method stub
		return vehicleRepository.selectGenerationByBuildingAndNum(generation);
	}

	@Override
	public String insertAndQRWrite(Generation generation, Vehicle vehicle) {
		// QR코드 생성한 후 baseURL 경로에 저장한다.
		// 1. DB에 저장한다 (시퀀스번호때문에 어쩔수없다.)
		int res = vehicleRepository.selectVehicleCnt(generation.getGenerationIdx());
		Vehicle newVehicle = new Vehicle();
		// 2건이상 등록된 세대라면 등록하지 않는다.
		if(res <= 2) {
			newVehicle = vehicleRepository.insertVehicle(vehicle);
		} else {
			throw new ToAlertException(ErrorCode.IQR02);
		}

		// 조회결과가 없다면 QR생성하지 않는다. 예외처리해준다.
		if(newVehicle == null) {
			throw new ToAlertException(ErrorCode.IQR01);
		}
		// 2. QR코드 생성한다.
		// url 링크는 localhost:8888/admin/vehicleread?generationidx=값&vehicleidx=값
		// 파일명은 v시퀀스번호로 한다.
		String domain = Configcode.DOMAIN.desc +"/admin/vehicleread?generationidx="+generation.getGenerationIdx()+"&vehicleidx="+vehicle.getVehicleIdx();
		QRCodeUtil qr = new QRCodeUtil();
		qr.makeQR(domain, "c"+vehicle.getVehicleIdx());
		
		return "등록되었습니다.";
	}

	

}
