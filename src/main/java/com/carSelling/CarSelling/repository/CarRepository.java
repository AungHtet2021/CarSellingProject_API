package com.carSelling.CarSelling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import com.carSelling.CarSelling.entity.Car;
import com.carSelling.CarSelling.entity.CarDetails;



//	 @Query("select c.id,c.description,c.is_public,c.price,c.quantity,c.status,c.waiting_time,c.image_path,c.name,cate.category_name from car c, category cate where c.category_id = cate.id")
//	 public List<CarDetails> join();

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carSelling.CarSelling.entity.Car;
import com.carSelling.CarSelling.entity.CarDetails;
@Repository
@EnableJpaRepositories
public interface CarRepository extends JpaRepository<Car, Integer>{

	 @Query(nativeQuery = true, value ="select new com.carSelling.CarSelling.entity.CarDetails(c.id,c.description,c.is_public,c.price,c.quantity,c.status,c.waiting_time,c.image_path,c.name,cate.category_name,c.video)" + "from car c, category cate where c.category_id = cate.id")
	  List<CarDetails> carDetailList();

	
}
