package com.kh.toy.bdmin.management.model.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kh.toy.bdmin.management.model.repository.ManagementRepository;
import com.kh.toy.bdmin.management.model.service.ManagementService;
import com.kh.toy.generation.model.vo.Admin;
import com.kh.toy.generation.model.vo.Apartment;

import common.code.ErrorCode;
import common.exception.ToAlertException;
import common.util.paging.Paging;

@Service
public class ManagementServiceImpl implements ManagementService{

	private final ManagementRepository managementRepository;
	
	public ManagementServiceImpl(ManagementRepository managementRepository) {
		this.managementRepository = managementRepository;
	}
	@Override
	public Map<String, Object> selectAdminList(int page, Map<String, Object> searchMap) {
		Paging paging = Paging.builder()
				.currentPage(page)
				.blockCnt(5)
				.cntPerPage(10)
				.type("adminauthority")
				.total(managementRepository.selectAdminCnt(searchMap))
				.build();
		System.out.println(paging.toString());
		searchMap.put("paging", paging);

		List<Admin> adminList = managementRepository.selectAdminList(searchMap);
		searchMap.put("adminList", adminList);
		
		// 페이징정보에 뿌려줄 아파트 이름 가져온다.
		List<String> apartmentNameList = new ArrayList<String>();
		for (int i = 0; i < adminList.size(); i++) {
			String apartmentIdx = adminList.get(i).getApartmentIdx();
			apartmentNameList.add(managementRepository.selectApartmentNameByApartmentIdx(apartmentIdx));
		}
		searchMap.put("apartmentNameList", apartmentNameList);
		
		//테스트
		searchMap.put("apartmentList", managementRepository.selectApartmentList());
		System.out.println(searchMap);
		return searchMap;
	}
	@Override
	public int updateAdminIsDel(String managerIdx) {
		// TODO Auto-generated method stub
		return managementRepository.updateAdminIsDel(managerIdx);
	}
	@Override
	public int insertAdmin(Admin admin) {

		// 중복아이디인지 확인
		if(managementRepository.selectIdCheck(admin) > 0) {
			throw new ToAlertException(ErrorCode.IDCHECK01);
		} 
		return managementRepository.insertAdmin(admin);
	}
	@Override
	public Admin selectAdminByManagerIdx(String managerIdx) {
		// TODO Auto-generated method stub
		return managementRepository.selectAdminByManagerIdx(managerIdx);
	}

}
