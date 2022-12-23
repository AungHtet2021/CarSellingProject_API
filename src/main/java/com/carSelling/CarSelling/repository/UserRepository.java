package com.carSelling.CarSelling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carSelling.CarSelling.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	public User findByGmail(String gmail);
	public User findByName(String name);

}
