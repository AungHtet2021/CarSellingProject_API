package com.carSelling.CarSelling.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.carSelling.CarSelling.entity.Car;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.carSelling.CarSelling.entity.Car;
import com.carSelling.CarSelling.entity.CarData;
import com.carSelling.CarSelling.entity.TrendCar;
import com.carSelling.CarSelling.entity.CarDetail;
@Repository
@EnableJpaRepositories
public interface CarRepository extends JpaRepository<Car, Integer>{

	@Query(nativeQuery = true, value ="select c.id,c.name,c.price,c.quantity,c.image_path,c.video,c.description,c.status,cate.category_name,disc.percentage  from car c left join discount disc on c.discount_id = disc.id left join category cate on c.category_id = cate.id where c.id = :carId ")
	  CarDetail CarDetail(@Param("carId") Integer carId);

	 @Query(nativeQuery = true, value ="select c.id,c.description from car c")
	  List<CarData> carDetailList();
	 
	 @Query(nativeQuery = true, value ="select c.id,c.name,c.price,c.quantity,c.image_path, c.description, disc.percentage from car c left join discount disc on c.discount_id = disc.id where c.is_public = '1'")
	  List<TrendCar> trendCarList();
	 
	 @Query(nativeQuery = true, value ="select c.id,c.name,c.price,c.quantity,c.image_path, c.description, disc.percentage from car c , discount disc where c.discount_id = disc.id and c.discount_id != '0'")
	  List<TrendCar> discountCarList();

	 @Query(nativeQuery = true, value ="select c.id,c.name,c.price,c.quantity,c.image_path, c.description , disc.percentage  from car c left join discount disc on c.discount_id = disc.id where c.status='1'")
	  List<TrendCar> BrandCarList();

	 @Query(nativeQuery = true, value ="select c.id,c.name,c.price,c.quantity,c.image_path, c.description , disc.percentage  from car c left join discount disc on c.discount_id = disc.id where c.status='2'")
	  List<TrendCar> UsedCarList();


	

}
