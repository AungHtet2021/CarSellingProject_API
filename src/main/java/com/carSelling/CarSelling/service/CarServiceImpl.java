package com.carSelling.CarSelling.service;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carSelling.CarSelling.entity.Car;
import com.carSelling.CarSelling.entity.CarDetails;
import com.carSelling.CarSelling.repository.CarRepository;


@Service
public class CarServiceImpl implements CarService{

	@Autowired
	CarRepository carRepository;
	
	@Override
	public List<Car> getAll() {
		return carRepository.findAll();
	}
	
	@Override
	public Car get(int id) {
		return carRepository.findById(id).orElse(null);
	}

	@Override
	public Car create(Car car) {
		car.setCreatedAt(LocalDateTime.now());
		return carRepository.save(car);
	}
	
	@Override
	public Car update(int id, Car car) {
		Car toUpdateCar = this.get(id);
		if (toUpdateCar == null) {
			return null;
		}
		toUpdateCar.setName(car.getName());
		toUpdateCar.setStatus(car.getStatus());
		toUpdateCar.setQuantity(car.getQuantity());
		toUpdateCar.setPrice(car.getPrice());
		toUpdateCar.setWaitingTime(car.getWaitingTime());
		toUpdateCar.setIsPublic(car.getIsPublic());
		toUpdateCar.setDescription(car.getDescription());
		toUpdateCar.setImagePath(car.getImagePath());
		toUpdateCar.setUpdatedAt(LocalDateTime.now());
		carRepository.save(toUpdateCar);
		return toUpdateCar;
	}
		
	@Override
	public boolean delete(int id) {
		Car car = this.get(id);
		if (car == null) {
			return false;
		}
		carRepository.deleteById(id);
		return true;
	}
	
//	@Override
//	public List<CarDetails> join() {
//		return carRepository.join();
//	}
//	
}
