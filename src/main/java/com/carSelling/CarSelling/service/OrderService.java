package com.carSelling.CarSelling.service;
import java.util.List;

import com.carSelling.CarSelling.entity.OrderHistory;

public interface OrderService {

	public OrderHistory create(OrderHistory order,int maxId);
	
}
