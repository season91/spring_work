package com.kh.toy.mgmtfee.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.kh.toy.mgmtfee.model.vo.Generation;
import com.kh.toy.mgmtfee.model.vo.Mgmtfee;
import com.kh.toy.mgmtfee.model.vo.MgmtfeeOverdue;

public interface MgmtfeeService {
	
	// [엑셀]
	Map<String, Object> mgmtfeeRead(MultipartFile file);
	
	List<Mgmtfee> insertMgmtfee(Map<String,Object> commandMap, String apartmentIdx);
	
	Map<String, Object> selectGenerationList(String apartmentIdx);

	// [관리자페이지 페이징]
	Map<String, Object> selectMgmtfeeList(int currentPage, String apartmentIdx);

	// [관리자페이지 - 관리비번호검색]
	Map<String, Object> selectMgmtfeeListByMgmtfeeIdx(int currentPage, String mgmtfeeIdx);
	
	Mgmtfee selectMgmtfeeByMgmtfeeIdx(String mgmtfeeIdx);
	
	Generation selectGenerationByGenerationIdx(String generationIdx);
	
	Mgmtfee updateMgmtfee(Mgmtfee mgmtfee);
	
	MgmtfeeOverdue selectMgmtfeeOverdue(String mgmtfeeIdx);
	
	int updateMgmtfeeOverdue(MgmtfeeOverdue mgmtfeeOverdue);
	
	//연체료 계산하는 배치메서드
	void procedureMgmtOverDue();
	
	int updateMgmtfeeIsDel(String mgmtfeeIdx);
}
