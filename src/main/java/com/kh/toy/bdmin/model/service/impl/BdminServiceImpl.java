package com.kh.toy.bdmin.model.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kh.toy.bdmin.model.repository.BdminRepository;
import com.kh.toy.bdmin.model.service.BdminService;
import com.kh.toy.bdmin.model.vo.ApartApplication;
import com.kh.toy.bdmin.model.vo.Bdmin;
import com.kh.toy.generation.model.vo.Apartment;

import common.util.paging.Paging;

@Service
public class BdminServiceImpl implements BdminService{

	private final BdminRepository bdminRepository;
	
	public BdminServiceImpl(BdminRepository bdminRepository) {
		this.bdminRepository = bdminRepository;
	}

	@Override
	public Bdmin selectBdminForAuth(Bdmin bdmin) {
		Bdmin bdminInfo = bdminRepository.selectBdminForAuth(bdmin);
		if(bdminInfo == null || !bdmin.getPassword().equals(bdminInfo.getPassword())) {
			return null;
		}
		return bdminInfo;
	}

	
	public Map<String, Object> searchMap(String standard, String keyword){
		Map<String, Object> searchMap = new HashMap<String, Object>();
		
		switch(standard) {
		case "basic":
			searchMap.put("searchType", "basic");
			break;
		case "apartmentName":
			// 쿼리검색용
			searchMap.put("searchType", "apartmentName");
			
			// view용
			searchMap.put("keyword", keyword);
			searchMap.put("link", "/name");
			break;
		
		}
		
		return searchMap;
	}

	@Override
	public Map<String, Object> selectApartList(int currentPage, String standard, String keyword) {
		Map<String, Object> searchMap = searchMap(standard, keyword);
		// 페이징처리
		Paging paging = Paging.builder()
				.currentPage(currentPage)
				.blockCnt(5)
				.cntPerPage(10)
				.type("apartment")
				.total(bdminRepository.selectApartCnt(searchMap))
				.build();
		System.out.println(paging.toString());
		searchMap.put("paging", paging);
		List<Apartment> apartList = bdminRepository.selectApartList(searchMap);
		searchMap.put("apartList", apartList);
		
		// TODO Auto-generated method stub
		return searchMap;
	}

	@Override
	public int insertApartApplication(ApartApplication apartApplication) {
		// TODO Auto-generated method stub
		return bdminRepository.insertApartApplication(apartApplication);
	}

	@Override
	public Map<String, Object> selectApartApplicationList(int page, String standard, String keyword) {
		Map<String, Object> searchMap = searchMap(standard, keyword);
		// 페이징처리
		Paging paging = Paging.builder()
				.currentPage(page)
				.blockCnt(5)
				.cntPerPage(10)
				.type("apartment")
				.total(bdminRepository.selectApartApplicationCnt(searchMap))
				.build();
		System.out.println(paging.toString());
		searchMap.put("paging", paging);
		List<Apartment> apartApplicationList = bdminRepository.selectApartApplicationList(searchMap);
		searchMap.put("apartApplicationList", apartApplicationList);
		
		// TODO Auto-generated method stub
		return searchMap;
	}

	@Override
	public Apartment selectApartment(String apartmentIdx) {
		// TODO Auto-generated method stub
		return bdminRepository.selectApartment(apartmentIdx);
	}

	@Override
	public int updateApartment(Apartment apartment) {
		// TODO Auto-generated method stub
		return bdminRepository.updateApartment(apartment);
	}

	@Override
	public ApartApplication selectApartApplication(String applicationIdx) {
		// TODO Auto-generated method stub
		return bdminRepository.selectApartApplication(applicationIdx);
	}

	@Override
	public int updateApartApplicationIsProcess(ApartApplication apartApplication) {
		// TODO Auto-generated method stub
		return bdminRepository.updateApartApplicationIsProcess(apartApplication);
	}

	
}
