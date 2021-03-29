package com.kh.toy.mymgmtfee.model.service;

import java.util.List;
import java.util.Map;

import com.kh.toy.mgmtfee.model.vo.Mgmtfee;
import com.kh.toy.mgmtfee.model.vo.MgmtfeeOverdue;

public interface MyMgmtfeeService {
	//안쓰는거같은데
	Mgmtfee selectMgmtfeeByGenerationIdx(String generationIdx);
	
	Map<String, Object> selectMyMgmtfeeList(int currentPage, String generationIdx);
	
	Mgmtfee selectMyMgmtfeeByMgmtfeeIdx(String mgmtfeeIdx);
	
	Map<String,Object> selectMyMgmtfeeDate(String mgmtfeeIdx);
	
	MgmtfeeOverdue selectMyMgmtfeeOverdue(String mgmtfeeIdx);
}
