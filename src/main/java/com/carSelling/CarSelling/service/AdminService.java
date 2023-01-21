package com.carSelling.CarSelling.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.carSelling.CarSelling.entity.Admin;

@EnableJpaRepositories
public interface AdminService {

	public List<Admin> getAll();
	public  Admin get(int id);
	public  Admin create(Admin Admin);
	public  Admin update(int id, Admin Admin); 
	public  boolean delete(int id); 
	public  Admin getByName(String name);
	public Admin getAdmin(int id);
	public List<Admin> getAdmins();
	public Admin checkLoginAdmin(String gmail, String password);
	
}

