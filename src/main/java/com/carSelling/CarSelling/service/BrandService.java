package com.carSelling.CarSelling.service;

import java.util.List;

import com.carSelling.CarSelling.entity.Brand;

public interface BrandService {
	public Brand create(Brand brand);
	public Brand getBrand(int id);
	public List<Brand> getBrands();
	public Brand deleteBrand(int id);
	public Brand updateBrand(Brand brand);
}
