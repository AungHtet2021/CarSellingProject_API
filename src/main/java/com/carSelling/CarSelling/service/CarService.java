package com.carSelling.CarSelling.service;
import java.util.List;

import com.carSelling.CarSelling.entity.Car;

public interface CarService {
	
	public List<Car> getAll();
	public Car get(int id);
	public Car create(Car car);
	public Car update(int id, Car car);
	public boolean delete(int id);


//	public List<CarDetails> join();

}
