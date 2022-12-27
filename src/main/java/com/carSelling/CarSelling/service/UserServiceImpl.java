package com.carSelling.CarSelling.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.carSelling.CarSelling.entity.User;
import com.carSelling.CarSelling.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Override
	public User create( User user) {
//		User GmailCheckUser=userRepository.findByGmail(user.getGmail());
//		if(GmailCheckUser==null) {
//			return null;
//		}
//		user.setName(user.getName());
//		user.setGmail(user.getGmail());
//		user.setPassword(user.getPassword());
//		user.setImagePath(user.getImagePath());
//		user.setPhone(user.getPhone());
//		user.setCreatedAt(LocalDateTime.now());
//		return userRepository.save(user);
		user.setCreatedAt(LocalDateTime.now());
		return userRepository.save(user);
//		
	
	}
	
//	@Override
//	public User checkLoginUser(String gmail, String password) {
//		User user = userRepo.findByGmail(gmail);
//		if (user == null) {
//			return null;
//		}
//		if (!pwEncoder.matches(password, user.getPassword())) {
//			return null;
//		}
//		return user;
//	}
	@Override
	public User checkLoginUser(String gmail, String password) {
//		User user=userRepository.findByGmail(gmail);
//		if(user==null) {
//			return null;
//		}
//		if(!passwordEncoder.matches(password, user.getPassword())) {
//			return null;
//		}
//		return user;
		return null;
	}

	@Override
	public List<User> getUsers() {
		List users=userRepository.findAll();	
		return users;
	}

}
