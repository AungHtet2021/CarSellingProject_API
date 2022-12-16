package com.carSelling.CarSelling.service;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carSelling.CarSelling.entity.Discount;
import com.carSelling.CarSelling.repository.DiscountRepository;

@Service
public class DiscountServiceImpl implements DiscountService{

	@Autowired
	DiscountRepository discountRepository;

	@Override
	public List<Discount> getAll() {
		return discountRepository.findAll();
	}
	
	@Override
	public Discount get(int id) {
		return discountRepository.findById(id).orElse(null);
	}

	@Override
	public Discount create(Discount discount) {
		discount.setCreatedAt(LocalDateTime.now());
		return discountRepository.save(discount);
	}
	

}
