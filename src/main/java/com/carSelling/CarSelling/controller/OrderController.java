package com.carSelling.CarSelling.controller;
import java.util.ArrayList;
import java.util.List;

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
import com.carSelling.CarSelling.entity.Order;
import com.carSelling.CarSelling.service.OrderService;


@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping(value="/create",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> createOrder(@RequestBody Order order){
//		System.out.println(order);
//		return null;
		Order newOrder=orderService.create(order);
		return new ResponseEntity<Order>(newOrder,HttpStatus.OK);
	}
	
}
