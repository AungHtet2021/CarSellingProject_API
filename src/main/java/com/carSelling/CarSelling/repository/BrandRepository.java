package com.carSelling.CarSelling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.carSelling.CarSelling.entity.Brand;
@EnableJpaRepositories
public interface BrandRepository extends JpaRepository <Brand , Integer>{

}
