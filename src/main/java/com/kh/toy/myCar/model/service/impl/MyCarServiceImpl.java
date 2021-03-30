package com.kh.toy.myCar.model.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.toy.car.model.vo.Car;
import com.kh.toy.myCar.model.repository.MyCarRepository;
import com.kh.toy.myCar.model.service.MyCarService;

@Service
public class MyCarServiceImpl implements MyCarService{
	
	private final MyCarRepository myCarRepository;
	
	public MyCarServiceImpl( MyCarRepository myCarRepository) {
		this.myCarRepository = myCarRepository;
	}

	@Override
	public List<Car>  selectCarByGenerationIdx(String generationIdx) {
		// TODO Auto-generated method stub
		return myCarRepository.selectCarByGenerationIdx(generationIdx);
	}

}
