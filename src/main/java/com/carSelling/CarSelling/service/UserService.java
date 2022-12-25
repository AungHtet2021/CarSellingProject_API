package com.carSelling.CarSelling.service;

import java.util.List;

import javax.validation.Valid;

import com.carSelling.CarSelling.entity.User;

public interface UserService {

	public User create(User user);

	public User checkLoginUser(String gmail, String password);

	public List<User> getUsers();

}
