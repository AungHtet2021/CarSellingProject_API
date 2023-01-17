package com.carSelling.CarSelling.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carSelling.CarSelling.entity.CarData;
import com.carSelling.CarSelling.entity.CarDetail;
import com.carSelling.CarSelling.entity.OrderDailyReport;
import com.carSelling.CarSelling.entity.OrderHistory;
import com.carSelling.CarSelling.entity.TrendCar;
import com.carSelling.CarSelling.entity.UserOrderId;
import com.carSelling.CarSelling.repository.CarRepository;
import com.carSelling.CarSelling.repository.OrderRepository;

@Service
public class JoinQueryService {

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	public CarDetail getCarDetail(int carId) {
		CarDetail list = carRepository.CarDetail(carId);
		return list;
		}
	
	public List<CarData> getCarDetailLists() {
	List<CarData> list = carRepository.carDetailList();
	return list;
	}

	public List<TrendCar> getTrendCarLists() {
		List<TrendCar> lists = carRepository.trendCarList();
		return lists;
	}
	
	public List<TrendCar> getTestDriveCarLists() {
		List<TrendCar>lists=carRepository.testDriveCarList();
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
	
	public int getMaxOrderId() {
		// TODO Auto-generated method stub
		int maxId= orderRepository.getMaxOrderId() == null ? 0 : orderRepository.getMaxOrderId();
		return maxId;
	}
	
	public List<UserOrderId> getOrderIdList(int userId) {
		List<UserOrderId>lists=orderRepository.getOrderIdList(userId);
		return lists;
	}

	public List<OrderDailyReport> getOrders() {
		List <OrderDailyReport> orders=orderRepository.getOrders();
		return orders;
	}

}