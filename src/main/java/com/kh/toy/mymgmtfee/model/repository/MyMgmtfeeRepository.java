package com.kh.toy.mymgmtfee.model.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.toy.mgmtfee.model.vo.Mgmtfee;

@Mapper
public interface MyMgmtfeeRepository {
	
	@Select("select * from tb_mgmtfee where generation_idx = #{generationIdx}")
	Mgmtfee selectMgmtfee(String generationIdx);
	
	@Select("select count(*) from tb_mgmtfee where generation_idx = #{generationIdx}")
	int selectContentCnt(String generationIdx);

	List<Mgmtfee> selectMyMgmtfeeList(Map<String, Object> generationMap);
	
	@Select("select * from tb_mgmtfee where mgmtfee_idx =  #{mgmtfeeIdx}")
	Mgmtfee selectMyMgmtfee(String mgmtfeeIdx);
	
	@Select("select extract(year from mgmt_start_date) year, extract(month from mgmt_start_date) month from tb_mgmtfee where mgmtfee_idx=#{mgmtfeeIdx}")
	Map<String,Object> selectMyMgmtfeeDate(String mgmtfeeIdx);
}
