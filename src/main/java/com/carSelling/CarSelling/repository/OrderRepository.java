package com.carSelling.CarSelling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.carSelling.CarSelling.entity.CarDetail;
import com.carSelling.CarSelling.entity.OrderHistory;
@Repository
@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<OrderHistory, Integer>{


	@Query(nativeQuery = true, value ="select max(order_id) from order_history")
	   int getMaxOrderId();

}
