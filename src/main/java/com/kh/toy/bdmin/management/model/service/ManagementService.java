package com.kh.toy.bdmin.management.model.service;

import java.util.List;
import java.util.Map;

import com.kh.toy.generation.model.vo.Admin;

public interface ManagementService {
	
	// 기본페이징
	Map<String, Object> selectAdminList(int page, Map<String, Object> searchMap);
	
	int insertAdmin(Admin admin);
	
	// 상세정보
	Admin selectAdminByManagerIdx(String managerIdx);
	
	// 매니저 권한회수
	int updateAdminIsDel(String managerIdx);

}
