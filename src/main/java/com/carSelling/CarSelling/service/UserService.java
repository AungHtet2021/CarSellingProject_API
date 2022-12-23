package com.carSelling.CarSelling.service;

import javax.validation.Valid;

import com.carSelling.CarSelling.entity.User;

public interface UserService {

	public User create(User user);

	public User checkLoginUser(String gmail, String password);

}
