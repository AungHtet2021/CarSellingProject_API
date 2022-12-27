package com.carSelling.CarSelling.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.carSelling.CarSelling.entity.Car;
import com.carSelling.CarSelling.entity.LoginRequest;
import com.carSelling.CarSelling.entity.User;
import com.carSelling.CarSelling.service.StorageService;
import com.carSelling.CarSelling.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
		
	@Autowired
	UserService userService;
	
	@Autowired
	StorageService storageService;
	
	
//	@PostMapping("/login")
//	public ResponseEntity<User> login(
//			@Valid @RequestBody LoginRequest lognReq
//	) {
//		User user = userService
//				.checkLoginUser(lognReq.getGmail(), lognReq.getPassword());
//		if (user == null) {
//			return ResponseEntity.badRequest().build();
//		}
//		return ResponseEntity.ok().body(user);
//	}
	@PostMapping("/login")
	public ResponseEntity<User> login(@Valid @RequestBody LoginRequest loginRequest){
		User user=userService.checkLoginUser(loginRequest.getGmail(),loginRequest.getPassword());
		if(user==null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping(value="/register",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> register(@Valid @RequestBody User user){
//		System.out.println(user);
		User createdUser =userService.create(user);
		if(createdUser==null) {
			return ResponseEntity.badRequest().body("Already Exist Gmail");
		}
		return ResponseEntity.ok().body(createdUser);
		
//		return new ResponseEntity<User>(createdUser,HttpStatus.OK);
	}
	
//	@GetMapping(value="/get/brands")
//	public ResponseEntity<List<Brand>> getBrands(){
//		List<Brand> brands=brandService.getBrands();
//		return new ResponseEntity<List<Brand>>(brands,HttpStatus.OK);
//	}
	
	@GetMapping(value="/get/users")
	public ResponseEntity<List<User>> getUsers(){
		List<User>users=userService.getUsers();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
//	@PostMapping("/file/create")
//	public String createFile(
//			@RequestParam("file") MultipartFile file,
//			@RequestParam("fileType") String fileType
//	) {
//		String fileName = storageService.create(file, fileType);
//		return fileName;
//	}
	
	@PostMapping("/file/create")
	public String createFile(
			@RequestParam("file") MultipartFile file,
			@RequestParam("fileType") String fileType)
	{
		String fileName=storageService.create(file, fileType);
		return fileName;
	}
	
}
