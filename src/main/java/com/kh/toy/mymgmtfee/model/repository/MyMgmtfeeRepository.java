package com.kh.toy.mymgmtfee.model.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.toy.mgmtfee.model.vo.Generation;
import com.kh.toy.mgmtfee.model.vo.Mgmtfee;
import com.kh.toy.mgmtfee.model.vo.MgmtfeeOverdue;

@Mapper
public interface MyMgmtfeeRepository {
	
	@Select("select * from tb_mgmtfee where generation_idx = #{generationIdx}")
	Mgmtfee selectMgmtfeeByGenerationIdx(String generationIdx);
	
	// 2. 페이징처리
	// - total 개수 세는 쿼리
	@Select("select count(*) from tb_mgmtfee where generation_idx = #{generationIdx}")
	int selectContentCnt(String generationIdx);
	
	// - 관리비 리스트 가져오는 쿼리
	List<Mgmtfee> selectMyMgmtfeeList(Map<String, Object> commandMap);
	
	// - 연체료 가져오는 쿼리
	@Select("select * from tb_mgmtfee_overdue where mgmtfee_idx = #{mgmtfeeIdx}")
	MgmtfeeOverdue selectMyMgmtfeeOverdue(String mgmtfeeIdx);
		
	
	@Select("select * from tb_mgmtfee where mgmtfee_idx =  #{mgmtfeeIdx}")
	Mgmtfee selectMyMgmtfeeByMgmtfeeIdx(String mgmtfeeIdx);
	
	@Select("select extract(year from mgmt_start_date) year, extract(month from mgmt_start_date) month from tb_mgmtfee where mgmtfee_idx=#{mgmtfeeIdx}")
	Map<String,Object> selectMyMgmtfeeDate(String mgmtfeeIdx);
	
	
}
