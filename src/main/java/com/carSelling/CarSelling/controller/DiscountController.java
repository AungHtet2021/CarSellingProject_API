package com.carSelling.CarSelling.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.carSelling.CarSelling.entity.Discount;
import com.carSelling.CarSelling.service.DiscountService;

@RestController
@RequestMapping("/discount")
public class DiscountController {

	@Autowired
	DiscountService discountService;
	
	@PostMapping("/create")
	public Discount createMovie(@Valid @RequestBody Discount discount) {
		return discountService.create(discount);
	}
	
	@GetMapping("/discountList")
	public Object getMovies() {
		List<Discount> discountRules = discountService.getAll();
		if(discountRules.size() > 0) {
			return discountRules;
		} else {
			return "There is no discount rule";
		}

	}
	
	@GetMapping("/discount/{discount_id}")
	public ResponseEntity<Discount> getDiscount(
			@PathVariable("discount_id") int discountId
	) {
		Discount discount = discountService.get(discountId);
		if (discount == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(discount);
	}


}
