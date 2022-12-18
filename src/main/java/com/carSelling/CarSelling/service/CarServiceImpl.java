package com.carSelling.CarSelling.service;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carSelling.CarSelling.entity.Car;
import com.carSelling.CarSelling.repository.CarRepository;


@Service
public class CarServiceImpl implements CarService{

	@Autowired
	CarRepository carRepository;
	
	@Override
	public Car create(Car car) {
		car.setCreatedAt(LocalDateTime.now());
		return carRepository.save(car);
	}
	
}
