package com.kh.toy.mymgmtfee.model.service;

import java.util.List;
import java.util.Map;

import com.kh.toy.mgmtfee.model.vo.Mgmtfee;

public interface MyMgmtfeeService {
	
	Mgmtfee selectMgmtfee(String generationIdx);
	
	Map<String, Object> selectMyMgmtfeeList(int currentPage, String generationIdx);
	
	Mgmtfee selectMyMgmtfee(String mgmtfeeIdx);
	
	Map<String,Object> selectMyMgmtfeeDate(String mgmtfeeIdx);
}
