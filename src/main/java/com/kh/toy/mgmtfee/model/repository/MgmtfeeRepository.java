package com.kh.toy.mgmtfee.model.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kh.toy.mgmtfee.model.vo.Generation;
import com.kh.toy.mgmtfee.model.vo.Mgmtfee;
import com.kh.toy.mgmtfee.model.vo.MgmtfeeOverdue;

import common.util.paging.Paging;

@Mapper
public interface MgmtfeeRepository {


	@Select("select * from TB_GENERATION where building = #{building} and num = #{num} and apartment_idx = #{apartmentIdx}")
	Generation selectGenerationIdx(Generation generationInfo);
	
	// 관리비 DB에 넣기
	int insertMgmtfee(Mgmtfee mgmtfee);
	
	// 아파트번호로 세대정보 받아오기
	@Select("select building from tb_generation where apartment_idx = #{apartmentIdx} order by building asc")
	List<String> selectBuildingByApartmentIdx(String apartmentIdx);
	
	@Select("select num from tb_generation where apartment_idx = #{apartmentIdx} order by building, num  asc")
	List<String> selectNumByApartmentIdx(String apartmentIdx);
	
	//페이징을 위한 개수 확인
	@Select("select count(*) from tb_mgmtfee where apartment_idx = #{apartmentIdx}")
	int selectContentCnt(String apartmentIdx);
	
	// 페이징 화면 구현을 위한 list
	List<Mgmtfee> selectMgmtfeeList(Map<String,Object> generationMap);
	
	// 페이징에 세대정보 넣어야해서 세대번호기준 세대정보 가져온다. 관리비 상세조회에서 쓸 세대정보 조회
	@Select("select * from tb_generation where generation_idx = #{generationIdx}")
	Generation selectGenerationByGenerationIdx(String generationIdx);
	
	//관리비 수정을 위한 관리비조회
	@Select("select * from tb_mgmtfee where mgmtfee_idx = #{mgmtfeeIdx}")
	Mgmtfee selectMgmtfeeByMgmtfeeIdx(String mgmtfeeIdx);
	
	//관리비 수정
	int updateMgmtfee(Mgmtfee mgmtfee);
	
	//수정된 관리비 납부금액 업데이트
	void procudureUpdatePeriodPayment(String mgmtfeeIdx);
	
	// 납기일이 지난 전체 미납 관리비 내역 조회
	@Select("select * from tb_mgmtfee where is_payment = 0 and TRUNC(DUE_DATE) < TRUNC(SYSDATE)")
	List<Mgmtfee> selectMgmtfeeListByAll();
	
	void procedureMgmtOverDue(String mgmtfeeIdx);

	
}
