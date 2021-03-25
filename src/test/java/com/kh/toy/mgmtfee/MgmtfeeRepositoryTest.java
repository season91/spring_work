package com.kh.toy.mgmtfee;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import com.kh.toy.mgmtfee.model.repository.MgmtfeeRepository;
import com.kh.toy.mgmtfee.model.vo.Generation;
import com.kh.toy.mgmtfee.model.vo.Mgmtfee;


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
	   
	   
}
