package com.kh.toy.mgmtfee;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import com.kh.toy.mgmtfee.model.repository.MgmtfeeRepository;
import com.kh.toy.mgmtfee.model.vo.Generation;
import com.kh.toy.mgmtfee.model.vo.Mgmtfee;

import common.util.paging.Paging;


@WebAppConfiguration 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class MgmtfeeRepositoryTest {

	   @Autowired
	   MgmtfeeRepository mgmtfeeRepository;// dao 주입 받아서 테스트한다.
	
	   @Test
	   public void selectMemberById() {
		   String apartmentIdx = "100000";
		   List<String> test = mgmtfeeRepository.selectBuildingByApartmentIdx(apartmentIdx);
		   List<String> test2 = mgmtfeeRepository.selectNumByApartmentIdx(apartmentIdx);
		   for (int i = 0; i < test.size(); i++) {
			System.out.println(test.get(i)+"동");
			System.out.println(test2.get(i)+"호");
		   }
	   }
	   
	   @Test
	   public void selectGenerationIdx() {
		   String building = "101";
		   String num = "101";
		   String apartmentIdx = "100000";
		   Generation inpu = new Generation();
		   inpu.setBuilding(building);;
		   inpu.setNum(num);
		   inpu.setApartmentIdx(apartmentIdx);
		   Generation test = mgmtfeeRepository.selectGenerationIdx(inpu);
		   System.out.println(test);
	   }
	   
	   @Test
	   public void procudureUpdatePeriodPayment() {
		   String fee = "22222";
		   String mgmtfeeIdx = "100971";
		   Mgmtfee mgmtfee = new Mgmtfee();
		   mgmtfee.setMgmtfeeIdx(mgmtfeeIdx);
		   mgmtfee.setElvtrMnfee(fee);
		   mgmtfee.setGenElctr(fee);
		   mgmtfee.setCleanFee(fee);
		   mgmtfee.setComonElctr(fee);
		   mgmtfee.setGenWater(fee);
		   mgmtfee.setSewer(fee);
		   mgmtfee.setExpenses(fee);
		   mgmtfee.setGenReduction(fee);
		   mgmtfee.setGnrlMgmtFee(fee);
		   mgmtfee.setExpenses(fee);
		   //업데이트문
		   mgmtfeeRepository.updateMgmtfee(mgmtfee);
		   
		   //프로시저부른다.
		   mgmtfeeRepository.procudureUpdatePeriodPayment(mgmtfeeIdx);
		   
		   System.out.println(mgmtfeeRepository.selectMgmtfeeByMgmtfeeIdx(mgmtfeeIdx));
		   
	   }
	   
	   @Test
	   public void procedureMgmtOverDue() {
//		   List<Mgmtfee> list = mgmtfeeRepository.selectMgmtfeeListByAll();
//		   for (int i = 0; i < list.size(); i++) {
//			 System.out.println(list.get(i));
//		}
		   String mgmtfeeIdx = "100980";
		   mgmtfeeRepository.procedureMgmtOverDue(mgmtfeeIdx);
	   }

	   @Test
	   public void selectContentCntTest() {
		   //String[] searchType = {"apartmentIdx"};
		   Map<String, Object> commandMap = new HashedMap<String, Object>();
		   commandMap.put("searchType", "apartmentIdx");
		   commandMap.put("apartmentIdx", "100000");
		   
		   Paging paging = Paging.builder()
					.currentPage(1)
					.blockCnt(5)
					.cntPerPage(10)
					.type("mgmtfee")
					.total(mgmtfeeRepository.selectContentCntTest(commandMap))
					.build();

		   commandMap.put("paging", paging);
		   
		  // System.out.println(paging.toString());
		   
		   
		   System.out.println(mgmtfeeRepository.selectMgmtfeeListTest(commandMap));
	   }
	   
}
