package com.kh.toy.vehicle.model.repository;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.toy.mgmtfee.model.vo.Generation;
import com.kh.toy.vehicle.model.vo.Vehicle;

@Mapper
public interface VehicleRepository {

	// test qr확인
	@Select("select * from tb_vehicle where vehicle_idx = #{vehicleIdx}")
	Vehicle selectVehicle(String vehicleIdx);
	
	// [QR코드]
	// 1. DB에 넣어주기
	@Insert("insert into tb_vehicle values (sc_vehicle_idx.nextval, #{generationIdx}, #{vehicleNumber}, #{vehicleIMG}||sc_vehicle_idx.currval||'.jpg', 0)")
	Vehicle insertVehicle(Vehicle vehicle);
	
	// 1-1. 넣기전에 이 세대 2건이상 있는지 확인한다.
	@Select("select count(*) from tb_vehicle where generation_idx = #{generationIdx}")
	int selectVehicleCnt(String generationIdx);
	
	// 2. 차량번호와 세대관리번호로 등록차량조회하기.
	@Select("select * from tb_vehicle where vehicle_number= #{vehicleNumber} and generation_idx = #{generationIdx}")
	Vehicle selectVehicleByVehicleNumberAndGenerationIdx(Map<String, String> commandMap);
	
	// [차량 등록]
	// 1. 차량등록을 위해 입력받은 동,호수정보로 세대정보 가져오기
	@Select("select * from tb_generation where building = #{building} and num = #{num} and is_del = 0")
	Generation selectGenerationByBuildingAndNum(Generation generation);
	
}
