package com.carSelling.CarSelling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.carSelling.CarSelling.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	public User findByGmail(String gmail);
	public User findByName(String name);

	@Query(nativeQuery = true, value ="select * from user where created_at between :from and :to")
	   List<User> getToDayRegistration(String from,String to);
	
}
