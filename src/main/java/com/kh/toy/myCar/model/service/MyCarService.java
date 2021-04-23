package com.kh.toy.myCar.model.service;

import java.util.List;

import com.kh.toy.car.model.vo.Car;

public interface MyCarService {

	List<Car>  selectCarByGenerationIdx(String generationIdx);

}
