package com.apap.tutorial3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tutorial3.model.CarModel;
import com.apap.tutorial3.service.CarService;

@Controller
public class CarController {
	@Autowired
	private CarService mobilService;
	
	@RequestMapping("/car/add")
	public String add (@RequestParam(value = "id", required = true) String id,
					@RequestParam(value = "brand", required = true) String brand,
					@RequestParam(value = "type", required = true) String type,
					@RequestParam(value = "price", required = true) Long price,
					@RequestParam(value = "amount", required = true) Integer amount) {
		CarModel car = new CarModel(id, brand, type, price, amount);
		mobilService.addCar(car);
		return "add";
	}
	
	@RequestMapping("/car/view")
	public String view(@RequestParam("id") String id, Model model) {
		CarModel archieve = mobilService.getCarDetail(id);
		model.addAttribute("car", archieve);
		return "view-car";
	}
	
	@RequestMapping("/car/viewall")
	public String viewall(Model model) {
		List<CarModel> archieve = mobilService.getCarList();
		model.addAttribute("ListCar", archieve);
		return "viewall-car";
	}
	
	@RequestMapping(value="/car/view/{id}", method=RequestMethod.GET)
	public String viewvar(@PathVariable String id, Model model) {
		List<CarModel> archieve = mobilService.getCarList();
		for (CarModel car : archieve) {
			if(car.getId().equals(id)) {
				model.addAttribute("car", car);
				return  "view-car";
			}
		}
		return "error";
	}
	
	@RequestMapping(value="/car/update/{id}/amount/{amount}", method=RequestMethod.GET)
	public String changeAmount(@PathVariable String id, @PathVariable Integer amount, Model model) {
		List<CarModel> archieve = mobilService.getCarList();
		for (CarModel car : archieve) {
			if(car.getId().equals(id)) {
				car.setAmount(amount);
				return "changeAmount";
			}
		}
		return "error";
	}
	
	@RequestMapping(value="/car/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable String id, Model model) {
		List<CarModel> archieve = mobilService.getCarList();
		Integer counter = 0;
		for (CarModel car : archieve) {
			counter++;
			if(car.getId().equals(id)){
				archieve.remove(counter-1);
				return "delete";
			}
		}
		return "error";
	}
}
