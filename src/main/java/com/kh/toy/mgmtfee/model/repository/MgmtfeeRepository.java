package com.kh.toy.mgmtfee.model.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
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
	
	// [엑셀] 
	// 1. 관리비 DB에 넣기
	int insertMgmtfee(Mgmtfee mgmtfee);
	
	// 1-1. 세대번호 가져오기. 아파트번호로 세대정보(동,호) 받아오기
	@Select("select building from tb_generation where apartment_idx = #{apartmentIdx} and is_del = 0 order by building asc")
	List<String> selectBuildingByApartmentIdx(String apartmentIdx);

	@Select("select num from tb_generation where apartment_idx = #{apartmentIdx} and is_del = 0 order by building, num  asc")
	List<String> selectNumByApartmentIdx(String apartmentIdx);
	
	// [관리비페이지-조건X]
	// 1. 페이징을 위한 개수 확인
	@Select("select count(*) from tb_mgmtfee where apartment_idx = #{apartmentIdx} and is_del = 0")
	int selectContentCnt(String apartmentIdx);
	
	// 2. 페이징 화면 구현을 위한 list
	List<Mgmtfee> selectMgmtfeeList(Map<String,Object> generationMap);
	
	// text
	List<Mgmtfee> selectMgmtfeeListTest(Map<String,Object> commandMap);
	
	int selectContentCntTest(Map<String,Object> commandMap);
	
	// 3. 페이징에 세대정보 넣어야해서 세대번호기준 세대정보 가져온다. 관리비 상세조회에서 쓸 세대정보 조회
	@Select("select * from tb_generation where generation_idx = #{generationIdx} and is_del = 0")
	Generation selectGenerationByGenerationIdx(String generationIdx);
	
	// [관리비페이지-관리비번호검색]
	// 1. 페이징을 위한 개수 확인. 삭제된것도 조회 가능하다.
	@Select("select count(*) from tb_mgmtfee where mgmtfee_idx = #{mgmtfeeIdx}")
	int selectContextCntByMgmtfeeIdx(String mgmtfeeIdx);
	
	// 2. 페이징 화면 구현을 위한 list. 아마 거의1개이긴 할것임. 삭제된것도 조회 가능하다.
	List<Mgmtfee> selectMgmtfeeListByMgmtfeeIdx(Map<String,Object> mgmtfeeMap);
	
	//관리비 수정을 위한 관리비조회
	@Select("select * from tb_mgmtfee where mgmtfee_idx = #{mgmtfeeIdx} and is_del = 0")
	Mgmtfee selectMgmtfeeByMgmtfeeIdx(String mgmtfeeIdx);
	
	//관리비 상세를 위한 연체금액 확인
	@Select("select * from tb_mgmtfee_overdue where mgmtfee_idx = #{mgmtfeeIdx}")
	MgmtfeeOverdue selectMgmtfeeOverdue(String mgmtfeeIdx);
	
	//관리비 수정
	int updateMgmtfee(Mgmtfee mgmtfee);
	
	//연체료 수정
	@Update("update tb_mgmtfee_overdue set overdue_fee = #{overdueFee} where mgmtfee_idx = #{mgmtfeeIdx}")
	int updateMgmtfeeOverdue(MgmtfeeOverdue mgmtfeeOverdue);
	
	//수정된 관리비 납기내 납부금액 업데이트
	void procudureUpdatePeriodPayment(String mgmtfeeIdx);
	
	// 납기일이 지난 전체 미납 관리비 내역 조회
	@Select("select * from tb_mgmtfee where is_payment = 0 and TRUNC(DUE_DATE) < TRUNC(SYSDATE)")
	List<Mgmtfee> selectMgmtfeeListByAll();
	
	void procedureMgmtOverDue(String mgmtfeeIdx);

	// 관리비 삭제처리
	@Update("update tb_mgmtfee set is_del = 1 where mgmtfee_idx = #{mgmtfeeIdx}")
	int updateMgmtfeeIsDel(String mgmtfeeIdx);
	
	
	// 결제완료시 관리비, 연체료 결제여부 1로 업데이트한다.
}
