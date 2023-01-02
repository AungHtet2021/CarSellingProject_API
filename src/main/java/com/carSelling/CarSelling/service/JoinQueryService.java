package com.carSelling.CarSelling.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carSelling.CarSelling.entity.CarData;
import com.carSelling.CarSelling.entity.TrendCar;
import com.carSelling.CarSelling.repository.CarRepository;

@Service
public class JoinQueryService {

	@Autowired
	private CarRepository carRepository;


	public List<CarData> getCarDetailLists() {
	List<CarData> list = carRepository.carDetailList();
	return list;
	}

	public List<TrendCar> getTrendCarLists() {
		List<TrendCar> lists = carRepository.trendCarList();
		return lists;
	}
	
	public List<TrendCar> getDiscountCarLists() {
		List<TrendCar> lists = carRepository.discountCarList();
		return lists;
	}

	public List<TrendCar> getBrandCarLists() {
		// TODO Auto-generated method stub
		List<TrendCar>lists=carRepository.BrandCarList();
		return lists;

	}

	public List<TrendCar> getUsedCarLists() {
		// TODO Auto-generated method stub
		List<TrendCar>lists=carRepository.UsedCarList();
		return lists;
	}

}