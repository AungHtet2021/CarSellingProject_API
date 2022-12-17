package com.carSelling.CarSelling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.carSelling.CarSelling.entity.Brand;
import com.carSelling.CarSelling.entity.Category;
@EnableJpaRepositories
public interface CategoryRepository extends JpaRepository <Category, Integer>{

}
