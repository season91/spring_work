package com.kh.toy.bdmin.management.model.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kh.toy.generation.model.vo.Admin;
import com.kh.toy.generation.model.vo.Apartment;

@Mapper
public interface ManagementRepository {
	//[매니저 권한 관리]
	// 1. 매니저 권한 부여
	@Insert("insert into tb_manager(manager_idx, apartment_idx, id, password, name) values(sc_manager_idx.nextval, #{apartmentIdx}, #{id}, #{password}, #{name})")
	int insertAdmin(Admin admin);
	
	// 중복아이디인지 확인
	@Select("select count(*) from tb_manager where id=#{id}")
	int selectIdCheck(Admin admin);

	// 2. 매니저 권한 회수
	@Update("update tb_manager set is_del = 1 where manager_idx = #{managerIdx} and is_del = 0")
	int updateAdminIsDel(String managerIdx);
	
	// 기본페이징
	int selectAdminCnt(Map<String, Object> searchMap);
	
	List<Admin> selectAdminList(Map<String, Object> searchMap);
	
	//아파트 이름 정보가져오기
	@Select("select apartment_name from tb_apartment where apartment_idx = #{apartmentIdx}")
	String selectApartmentNameByApartmentIdx(String apartmentIdx);
	
	// 매니저 상세정보
	@Select("select * from tb_manager where manager_idx = #{managerIdx}")
	Admin selectAdminByManagerIdx(String managerIdx);
	
	// 아파트정보 리스트 가져오기
	@Select("select * from tb_apartment")
	List<Apartment> selectApartmentList();
	
	// 매니저 이름으로 검색
	

}
