package com.kh.toy.mgmtfee.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.kh.toy.mgmtfee.model.vo.Mgmtfee;

public interface MgmtfeeService {
	
	Map<String, Object> mgmtfeeRead(MultipartFile file);
	
	List<Mgmtfee> insertMgmtfee(Map<String,Object> commandMap, String apartmentIdx);
	
	Map<String, Object> selectGenerationList(String apartmentIdx);

	Map<String, Object> selectMgmtfeeList(int currentPage, String apartmentIdx);
	
}
