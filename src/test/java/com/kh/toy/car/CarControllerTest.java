package com.kh.toy.car;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.kh.toy.car.model.service.CarService;
import com.kh.toy.car.model.vo.Car;
import com.kh.toy.mgmtfee.model.vo.Generation;

import common.code.Configcode;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*-context.xml" })
public class CarControllerTest {
	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void joinTest() throws Exception {
		mockMvc.perform(get("/member/join")).andDo(print());
	}

	@Test
	public void carApplicationApproval() throws Exception {
		// 등록신청
		List<String> testlist = new ArrayList<String>();
		mockMvc.perform(get("/admin/carapplication/approval").param("applicationidx", "100100").param("applicationidx", "100060"))
		.andDo(print());

	}
}
