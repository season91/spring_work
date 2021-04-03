package com.kh.toy.bdmin.model.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kh.toy.bdmin.model.vo.ApartApplication;
import com.kh.toy.bdmin.model.vo.Bdmin;
import com.kh.toy.generation.model.vo.Apartment;
import com.kh.toy.mgmtfee.model.vo.Generation;

import common.util.paging.Paging;

@Mapper
public interface BdminRepository {
	
	// [로그인]
	@Select("select * from tb_bdmin where id = #{id} and is_del = 0")
	Bdmin selectBdminForAuth(Bdmin bdmin);
	
	// [아파트 목록]
	// 1. 페이징 위한 개수 확인
	int selectApartCnt(Map<String, Object> searchMap);
	
	// 2. 페이징 화면 구현을 위한 list
	List<Apartment> selectApartList(Map<String, Object> searchMap);
	
	// 3. 아파트 상세
	@Select("select * from tb_apartment where apartment_idx = #{apartmentIdx}")
	Apartment selectApartment(String apartmentIdx);

	// 4. 아파트 수정
	@Update("update tb_apartment set apartment_name = #{apartmentName}, apartment_address = #{apartmentAddress}, apartment_parking = #{apartmentParking} where apartment_idx = #{apartmentIdx}")
	int updateApartment(Apartment apartment);

	
	// [서비스신청문의 목록]
	// 1. 페이징 위한 개수 확인
	int selectApartApplicationCnt(Map<String, Object> searchMap);
	
	// 2. 페이징 화면 구현을 위한 list
	List<Apartment> selectApartApplicationList(Map<String, Object> searchMap);
	
	// 3. 서비스 신청서 상세
	@Select("select * from tb_apart_application where application_idx = #{applicationIdx}")
	ApartApplication selectApartApplication(String applicationIdx);
	
	// 4. 서비스 신청서 승인, 반려
	@Update("update tb_apart_application set is_process = #{isProcess} where application_idx = #{applicationIdx} and is_process = 0")
	int updateApartApplicationIsProcess(ApartApplication apartApplication);

	
	// [서비스 신청서]
	@Insert("insert into tb_apart_application values(SC_APART_APPLICATION_IDX.nextval, #{aApartmentName}, #{aApartmentAddress}, #{aGenerationCnt},#{aParking}, #{aName}, #{aTell}, #{aEmail}, 0)")
	int insertApartApplication(ApartApplication apartApplication);
}
