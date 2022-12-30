package com.carSelling.CarSelling.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.carSelling.CarSelling.entity.Admin;
import com.carSelling.CarSelling.entity.User;
@EnableJpaRepositories
public interface UserService {

	public User create(User user);

	public User checkLoginUser(String gmail, String password);

	public List<User> getUsers();

	public  User get(int id);
	public  User update(int id, User user);

	public boolean delete(int id);

	public User getUser(int id); 

}
