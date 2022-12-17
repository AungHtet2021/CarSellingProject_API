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


import com.carSelling.CarSelling.entity.Category;
import com.carSelling.CarSelling.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping(value="/create",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> createCategory(@RequestBody Category category){
		Category newCategory=categoryService.create(category);
		return new ResponseEntity<Category>(newCategory,HttpStatus.OK);
	}
	
	@GetMapping(value="/get/category/{id}")
	public ResponseEntity <Category> getCategory(@PathVariable("id") int id){
		Category category=categoryService.getCategory(id);
		return new ResponseEntity<Category>(category,HttpStatus.OK);
	}
	
	@GetMapping(value="/get/categorys")
	public ResponseEntity<List<Category>> getCategorys(){
		List<Category> categorys=categoryService.getCategorys();
		return new ResponseEntity<List<Category>>(categorys,HttpStatus.OK);
	}

	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Category> deleteCategory(@PathVariable("id") int id){
		categoryService.deleteCategory(id);
		return new ResponseEntity<Category>(HttpStatus.OK);
	}
	
	@PutMapping(value="/update/{id}")
	public ResponseEntity<Category> putCategory(@RequestBody Category category){
		Category updateCategory=categoryService.updateCategory(category);
		return new ResponseEntity<Category>(updateCategory,HttpStatus.OK);
	}
}
