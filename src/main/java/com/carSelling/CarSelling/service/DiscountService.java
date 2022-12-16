package com.carSelling.CarSelling.service;
import java.util.List;

import com.carSelling.CarSelling.entity.Discount;

public interface DiscountService {

	public List<Discount> getAll();
	public Discount get(int id);
	public Discount create(Discount discount);
	
}
