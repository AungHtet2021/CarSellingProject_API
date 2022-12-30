package com.carSelling.CarSelling.service;
import java.util.List;

import com.carSelling.CarSelling.entity.Car;
import com.carSelling.CarSelling.entity.CarDetails;

public interface CarService {
	
	public List<Car> getAll();
	public Car get(int id);
	public Car create(Car car);
	public Car update(int id, Car car);
	public boolean delete(int id);
<<<<<<< HEAD

=======
//	public List<CarDetails> join();
>>>>>>> 3dc2a04b67164bfe3bad20f08b5d4bc8234cb0ef
}
