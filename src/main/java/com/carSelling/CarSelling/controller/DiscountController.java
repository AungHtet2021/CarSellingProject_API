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
	
	@GetMapping("/discountList")
	public Object getDiscounts() {
		List<Discount> discountRules = discountService.getAll();
		if(discountRules.size() > 0) {
			return discountRules;
		} else {
			return "There is no discount rule";
		}

	}
	
	@GetMapping("/{discount_id}")
	public ResponseEntity<Discount> getDiscount(
			@PathVariable("discount_id") int discountId
	) {
		Discount discount = discountService.get(discountId);
		if (discount == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(discount);
	}

	
	@PostMapping("/create")
	public Discount createDiscount(@Valid @RequestBody Discount discount) {
		return discountService.create(discount);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Discount> updateDiscount(
			@PathVariable int id, @Valid @RequestBody Discount discount
	) {
		Discount updatedDiscount = discountService.update(id, discount);
		if (updatedDiscount == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(updatedDiscount);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteDiscount(@PathVariable int id) {
		Discount discount = discountService.get(id);
		if (discount == null) {
			return ResponseEntity.notFound().build();
		}
		boolean isDeleted = discountService.delete(id);
		if (!isDeleted) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}
		return ResponseEntity.ok().build();
	}
	


}
