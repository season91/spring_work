package com.kh.toy.admin.index.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IndexManagementRepository {
	
	//관리비 월별 조회
	@Select("select sum(period_payment) from tb_mgmtfee where is_del = 0 group by due_date")
	List<String> selectMgmtfeeMonthFee();

	
	//등록가능한 차량 대수 확인
	@Select("select apartment_parking from tb_apartment")
	int selectApartmentParking();
	
	@Select("select count(*) from tb_car where is_del = 0")
	int selectCar();
	
	//현재 입차 중인 차량대수
	@Select("select count(*) from tb_car where is_in_car = 1")
	int selectInCar();
	
}
