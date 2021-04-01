package com.kh.toy.parking.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.toy.car.model.vo.Car;
import com.kh.toy.parking.model.vo.CarApplication;

@Mapper
public interface ParkingRepository {
	
	// [주차현황 확인]
	// 1. 전체 주차가능 대수 확인
	@Select("select apartment_parking from tb_apartment where apartment_idx = #{apartmentIdx}")
	int selectApartmentParking(String apartmentIdx);
	
	// 2. 현재 주차가능 대수 계산
	// 2-1. 현재 입차한 차량 확인
	@Select("select sum(is_in_car) from tb_car where is_del = 0")
	int selectIsInCarCnt();
	
	
	// [차량 등록 신청]
	// 1. 신청하기
	@Insert("insert into tb_car_application(application_idx, apartment_idx, generation_idx, aplct_car_number) values (sc_application_idx.nextval, #{apartmentIdx}, #{generationIdx}, #{aplctCarNumber})")
	int insertCarApplication(CarApplication carApplication);

	// 2. 페이지에 보여주기 위한 신청한 내역이 있는지 확인.
	@Select("select * from tb_car_application where generation_idx = #{generationIdx} and is_process = 0")
	List<CarApplication> selectCarApplicationByGenerationIdx(String generationIdx);
	
	// 3. 신청전 신청가능상태를 확인하기위해 등록차량이있는지 확인한다.
	@Select("select * from tb_car where generation_idx = #{generationIdx} and car_number = #{aplctCarNumber} and is_del = 0")
	Car selectCarByApplicationInfo(CarApplication carApplication);
	
	// 4. 신청 전 신청한내역이 있는지 확인한다
	@Select("select * from tb_car_application where generation_idx = #{generationIdx} and aplct_car_number =  #{aplctCarNumber} and is_process = 0")
	List<CarApplication> selectCarApplication(CarApplication carApplication);
}
