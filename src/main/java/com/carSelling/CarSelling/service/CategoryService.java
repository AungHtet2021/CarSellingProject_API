package com.carSelling.CarSelling.service;

import java.util.List;

import com.carSelling.CarSelling.entity.Category;

public interface CategoryService {

	public Category create(Category category);

	public Category getCategory(int id);

	public List<Category> getCategorys();

	public Category deleteCategory(int id);

	public Category updateCategory(Category category);

}
