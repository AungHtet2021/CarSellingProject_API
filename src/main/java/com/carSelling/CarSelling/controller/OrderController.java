package com.carSelling.CarSelling.controller;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.carSelling.CarSelling.entity.Car;
import com.carSelling.CarSelling.entity.CarData;
import com.carSelling.CarSelling.entity.OrderDailyReport;
import com.carSelling.CarSelling.entity.OrderHistory;
import com.carSelling.CarSelling.service.JoinQueryService;
import com.carSelling.CarSelling.service.OrderService;


@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	@Autowired
	JoinQueryService joinQueryService;
	
	@PostMapping(value="/create",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createOrder(@RequestBody ArrayList<OrderHistory> orderHistory){
		int maxId =joinQueryService.getMaxOrderId();
		for (OrderHistory order : orderHistory) {
			OrderHistory newOrder=orderService.create(order,maxId + 1);
		}
		return ResponseEntity.ok().body("Order Success");

	}
	
	@GetMapping("/getOrder/{id}")
	public List getUserOrder(
			@PathVariable("id") int userId
	) {
		List idList =joinQueryService.getOrderIdList(userId);
		
		return idList;
	}
	
	
//	@GetMapping(value="/get/brands")
//	public ResponseEntity<List<Brand>> getBrands(){
//		List<Brand> brands=brandService.getBrands();
//		return new ResponseEntity<List<Brand>>(brands,HttpStatus.OK);
//	}
	
//	@GetMapping("/CarDetailsList")
//	public ResponseEntity<List<CarData>> getCarDetailLists() {
//		return new ResponseEntity<List<CarData>>(joinQueryService.getCarDetailLists(), HttpStatus.OK);
//
//	}
	
	@GetMapping("/get/orders")
	public ResponseEntity <List<OrderDailyReport>> getOrders(){
//		List orders=joinQueryService.getOrders();
		return new ResponseEntity<List<OrderDailyReport>>(joinQueryService.getOrders(),HttpStatus.OK);
	}
	
}
