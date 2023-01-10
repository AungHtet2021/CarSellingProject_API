package com.carSelling.CarSelling.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.carSelling.CarSelling.entity.Admin;
import com.carSelling.CarSelling.entity.UserOrder;
import com.carSelling.CarSelling.entity.User;
import com.carSelling.CarSelling.repository.CarRepository;
import com.carSelling.CarSelling.repository.OrderRepository;
import com.carSelling.CarSelling.repository.UserRepository;
@Service

public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;

	@Override
	public UserOrder create( UserOrder UserOrder) {
		UserOrder.setOrderId(UserOrder.getOrderId());
		UserOrder.setCarId(UserOrder.getCarId());
		UserOrder.setUserId(UserOrder.getUserId());
		UserOrder.setCarQuantity(UserOrder.getCarQuantity());
		UserOrder.setTotal(UserOrder.getTotal());
		UserOrder.setCreatedAt(LocalDateTime.now());
		return orderRepository.save(UserOrder);
	}
}
