package com.carSelling.CarSelling.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carSelling.CarSelling.entity.CarDetails;
import com.carSelling.CarSelling.repository.CarRepository;

@Service
public class JoinQueryService {

	@Autowired
	private CarRepository carRepository;
	

	public List<CarDetails> getCarDetailLists() {
	List<CarDetails> list = carRepository.carDetailList();
	System.out.println(list);
	return list;
}

//	public List<CarDetails> getCarDetailLists() {
//		List<CarDetails> list = carRepository.carDetailList();
//		System.out.println(list);
//		return list;
//	}


}