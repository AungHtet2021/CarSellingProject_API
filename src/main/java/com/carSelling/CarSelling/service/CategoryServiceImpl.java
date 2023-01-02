package com.carSelling.CarSelling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carSelling.CarSelling.entity.Category;
import com.carSelling.CarSelling.repository.CategoryRepository;

import lombok.Data;
@Service

public class CategoryServiceImpl implements CategoryService{
 @Autowired
 CategoryRepository categoryRepository;

@Override
public Category create(Category category) {
	Category newCategory=categoryRepository.save(category);
	return newCategory;
}

@Override
public Category getCategory(int id) {
	Category category=categoryRepository.findById(id).orElse(null);
	return category;
}

@Override
public List<Category> getCategorys() {
	List<Category> categorys=categoryRepository.findAll();
	return categorys;
}

@Override
public Category deleteCategory(int id) {
	categoryRepository.deleteById(id);
	return null;
}

@Override
public Category updateCategory(Category category) {
	Category original=categoryRepository.findById(category.getId()).orElse(null);
	if(original!=null) {
		original.setCategoryName(category.getCategoryName());
		original=categoryRepository.save(original);
	}
	return original;
}
 
 
 
 
 
}
