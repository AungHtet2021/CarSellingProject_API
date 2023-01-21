package com.carSelling.CarSelling.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.carSelling.CarSelling.entity.CarDetail;
import com.carSelling.CarSelling.entity.OrderDailyReport;
import com.carSelling.CarSelling.entity.OrderHistory;
import com.carSelling.CarSelling.entity.OrderHistoryId;
import com.carSelling.CarSelling.entity.User;
import com.carSelling.CarSelling.entity.UserOrderDetail;
import com.carSelling.CarSelling.entity.UserOrderId;

@Repository
@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<OrderHistory, OrderHistoryId> {

	@Query(nativeQuery = true, value = "select max(order_id) from order_history")
	Integer getMaxOrderId();

	@Query(nativeQuery = true, value = "select distinct order_id from order_history history where history.user_id = :userId")
	List<UserOrderId> getOrderIdList(int userId);

	@Query(nativeQuery = true, value = "select o.order_id,o.car_id  ,o.user_id,o.car_quantity,o.total,o.created_at,c.name ,c.image_path ,u.name as UserName,u.image_path as UserImage,u.gmail as UserGmail from order_history o left join car c on o.car_id =c.id left join user u on o.user_id=u.id")
	List<OrderDailyReport> getOrders();

	@Query(nativeQuery = true, value = "select c.name,userOrder.order_id, userOrder.car_quantity,userOrder.total from order_history userOrder left join car c on c.id = userOrder.car_id where userOrder.order_id = :orderId")
	List<UserOrderDetail> userOrderDetailList(int orderId);

	@Query(nativeQuery = true, value = "select * from order_history where created_at between :from and :to")
	List<OrderHistory> getToDayOrder(String from, String to);
	
	@Query(nativeQuery =true ,value="select * from order_history where created_at between :from and :to")
	List<OrderHistory> getToDaySellingAmount(String from, String to);

	@Transactional
	void deleteById_OrderId(int orderId);

}
