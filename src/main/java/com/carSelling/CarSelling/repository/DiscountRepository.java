package com.carSelling.CarSelling.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.carSelling.CarSelling.entity.Discount;


@EnableJpaRepositories
public interface DiscountRepository extends JpaRepository<Discount, Integer>{


}
