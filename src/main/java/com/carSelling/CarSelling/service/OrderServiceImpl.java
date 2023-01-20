package com.carSelling.CarSelling.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.carSelling.CarSelling.entity.Admin;
import com.carSelling.CarSelling.entity.Category;
import com.carSelling.CarSelling.entity.OrderHistory;
import com.carSelling.CarSelling.entity.OrderHistoryId;
import com.carSelling.CarSelling.entity.User;
import com.carSelling.CarSelling.repository.CarRepository;
import com.carSelling.CarSelling.repository.OrderRepository;
import com.carSelling.CarSelling.repository.UserRepository;

@Service

public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Override
	public OrderHistory create(OrderHistory order, int maxId) {
		OrderHistoryId id = new OrderHistoryId(maxId, order.getId().getCarId() , order.getId().getUserId());
//		order.setOrderId(maxId);
//		order.setCarId(order.getId());
//		order.setUserId(order.getUserId());
		order.setId(id);
		order.setCarQuantity(order.getCarQuantity());
		order.setTotal(order.getTotal());
		order.setCreatedAt(LocalDateTime.now());
		return orderRepository.save(order);
	}

	@Override
	public OrderHistory deleteOrder(int orderId) {
		orderRepository.deleteById_OrderId(orderId);
		return null;
	}

//	@Override
//	public List<OrderHistory> getOrders() {
//		// TODO Auto-generated method stub
//		return orderRepository.findAll();
//	}
}
