package com.carSelling.CarSelling.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.carSelling.CarSelling.entity.UserOrder;
//@Repository
@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<UserOrder, Integer>{

}
