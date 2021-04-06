package com.kh.toy.admin.index.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IndexManagementRepository {
	
	@Select("select sum(period_payment) from tb_mgmtfee where is_del = 0 group by due_date")
	List<String> selectMgmtfeeMonthFee();

}
