package com.carSelling.CarSelling.repository;
import java.util.List;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.carSelling.CarSelling.entity.Admin;
@EnableJpaRepositories
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	public Admin findByGmail(String gmail);
	public Admin findByName(String name);

}

