package com.apap.tutorial3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apap.tutorial3.model.CarModel;

/**
 * CarInMemoryService
 * @author Amira Taliya
 *
 */

@Service
public class CarInMemoryService implements CarService {
	private List<CarModel> archievCar;
	
	public CarInMemoryService() {
		archievCar = new ArrayList<>();
	}
	
	@Override
	public void addCar(CarModel car) {
		archievCar.add(car);
	}
	
	@Override
	public List<CarModel> getCarList() {
		return archievCar;
	}

	@Override
	public CarModel getCarDetail(String id) {
		CarModel carCar = new CarModel();
		for (CarModel car: archievCar) {
			if (car.getId() == id) {
				carCar = car;
			}
		}
		return carCar;
	}
}
