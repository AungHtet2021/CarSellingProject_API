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
	
	@Override
	public Discount update(int id, Discount discount) {
		Discount toUpdateDiscount = this.get(id);
		if (toUpdateDiscount == null) {
			return null;
		}
		toUpdateDiscount.setDiscountName(discount.getDiscountName());
		toUpdateDiscount.setPercentage(discount.getPercentage());
		toUpdateDiscount.setFromDate(discount.getFromDate());
		toUpdateDiscount.setToDate(discount.getToDate());
		toUpdateDiscount.setUpdatedAt(LocalDateTime.now());
		discountRepository.save(toUpdateDiscount);
		return toUpdateDiscount;
	}
	
	@Override
	public boolean delete(int id) {
		Discount discount = this.get(id);
		if (discount == null) {
			return false;
		}
		discountRepository.deleteById(id);
		return true;
	}
	

}
