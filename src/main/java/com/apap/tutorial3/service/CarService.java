package com.apap.tutorial3.service;

import java.util.List;

import com.apap.tutorial3.model.CarModel;

/**
 * CarService
 * @author Amira Taliya
 *
 */
public interface CarService {
	void addCar (CarModel car);
	
	List<CarModel> getCarList();
	
	CarModel getCarDetail(String id);
}
