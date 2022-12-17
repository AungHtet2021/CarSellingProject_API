package com.carSelling.CarSelling.controller;

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


import com.carSelling.CarSelling.entity.Brand;
import com.carSelling.CarSelling.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {
	
	@Autowired
	BrandService brandService;
	
	@PostMapping(value="/create",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Brand> createBrand(@RequestBody Brand brand){
		Brand newBrand=brandService.create(brand);
		return new ResponseEntity<Brand>(newBrand,HttpStatus.OK);
	}
	
	@GetMapping(value="/get/brand/{id}")
	public ResponseEntity <Brand> getBrand(@PathVariable("id") int id){
		Brand brand=brandService.getBrand(id);
		return new ResponseEntity<Brand>(brand,HttpStatus.OK);
	}
	
	@GetMapping(value="/get/brands")
	public ResponseEntity<List<Brand>> getBrands(){
		List<Brand> brands=brandService.getBrands();
		return new ResponseEntity<List<Brand>>(brands,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Brand> deleteBrand(@PathVariable("id") int id){
		brandService.deleteBrand(id);
		return new ResponseEntity<Brand>(HttpStatus.OK);
	}

	@PutMapping(value="/update/{id}")
	public ResponseEntity<Brand> putBrand(@RequestBody Brand brand){
		Brand updateBrand=brandService.updateBrand(brand);
		return new ResponseEntity<Brand>(updateBrand,HttpStatus.OK);
	}
}








