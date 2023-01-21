package com.carSelling.CarSelling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.carSelling.CarSelling.entity.Brand;
import com.carSelling.CarSelling.repository.BrandRepository;
@Service
public class BrandServiceImpl implements BrandService{
	@Autowired
	BrandRepository brandRepository;

	@Override
	public Brand create(Brand brand) {
		Brand newBrand=brandRepository.save(brand);
		return newBrand;
	}

	@Override
	public Brand getBrand(int id) {
		Brand brand=brandRepository.findById(id).orElse(null);
		return brand;
	}

	
	@Override
	public List<Brand> getBrands() {
		List<Brand> brands=brandRepository.findAll();
		return brands;
	}

	@Override
	public Brand deleteBrand(int id) {
		brandRepository.deleteById(id);
		return null;
	}

	@Override
	public Brand updateBrand(Brand brand) {
		Brand original=brandRepository.findById(brand.getId()).orElse(null);
		if(original!=null) {
			original.setBrandName(brand.getBrandName());
			original.setProduceCountry(brand.getProduceCountry());
			original=brandRepository.save(original);
		}
		return original;
	}

}
