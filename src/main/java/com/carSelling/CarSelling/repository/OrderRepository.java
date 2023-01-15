package com.carSelling.CarSelling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.carSelling.CarSelling.entity.CarDetail;
import com.carSelling.CarSelling.entity.OrderHistory;
import com.carSelling.CarSelling.entity.UserOrderId;
@Repository
@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<OrderHistory, Integer>{


	@Query(nativeQuery = true, value ="select max(order_id) from order_history")
	   Integer getMaxOrderId();
	
	@Query(nativeQuery = true, value ="select distinct order_id from order_history history where history.user_id = :userId")
	   List<UserOrderId> getOrderIdList(int userId);

}
