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
import com.carSelling.CarSelling.entity.CarData;
import com.carSelling.CarSelling.entity.TrendCar;
@Repository
@EnableJpaRepositories
public interface CarRepository extends JpaRepository<Car, Integer>{


	 @Query(nativeQuery = true, value ="select c.id,c.description from car c")
	  List<CarData> carDetailList();
	 
	 @Query(nativeQuery = true, value ="select c.id,c.name,c.price,c.quantity,c.image_path, c.description, disc.percentage from car c left join discount disc on c.discount_id = disc.id and c.is_public = true")
	  List<TrendCar> trendCarList();
	 
	 @Query(nativeQuery = true, value ="select c.id,c.name,c.price,c.quantity,c.image_path, c.description, disc.percentage from car c , discount disc where c.discount_id = disc.id and c.discount_id != '0'")
	  List<TrendCar> discountCarList();

	 @Query(nativeQuery = true, value ="select c.id,c.name,c.price,c.quantity,c.image_path, c.description, disc.percentage from car c ,discount disc where c.status  == '2'")
	  List<TrendCar> BrandCarList();

	 @Query(nativeQuery = true, value ="select c.id,c.name,c.price,c.quantity,c.image_path, c.description, disc.percentage from car c ,discount disc where c.status  == '1'")
	  List<TrendCar> UsedCarList();

	

}
