package com.carSelling.CarSelling.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.carSelling.CarSelling.entity.Admin;
import com.carSelling.CarSelling.entity.Car;
import com.carSelling.CarSelling.entity.DateFilter;
import com.carSelling.CarSelling.entity.LoginRequest;
import com.carSelling.CarSelling.entity.TrendCar;
import com.carSelling.CarSelling.entity.User;
import com.carSelling.CarSelling.entity.UserOrderDetail;
import com.carSelling.CarSelling.service.JoinQueryService;
import com.carSelling.CarSelling.service.StorageService;
import com.carSelling.CarSelling.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
		
	@Autowired
	UserService userService;
	
	@Autowired
	StorageService storageService;
	
	@Autowired
	JoinQueryService joinQueryService;

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
		User createdUser =userService.create(user);
		if(createdUser==null) {
			return ResponseEntity.badRequest().body("Already Exist Gmail");
		}
		return ResponseEntity.ok().body(createdUser);
	}
	
	@GetMapping(value="/get/user/{id}")
	public ResponseEntity <User> getUser(@PathVariable("id") int id){
		User user=userService.getUser(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

	@PutMapping("user/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,@Valid @RequestBody User user){
		User updatedUser=userService.update(id,user);
		if(updatedUser == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id) {
		User user = userService.get(id);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		String imagePath=user.getImagePath();
		boolean isDeleted=userService.delete(id);
		if(!isDeleted) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}
		return ResponseEntity.ok().build();
	}
	@GetMapping(value="/get/users")
	public ResponseEntity<List<User>> getUsers(){
		List<User>users=userService.getUsers();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@GetMapping(value="/getToDayRegistration/{id}")
	public ResponseEntity<List<User>> getToDayRegistration(@PathVariable("id") String date){
		return new ResponseEntity<List<User>>(joinQueryService.getToDayRegistration(date +" 00:00:00",date + " 23:59:59"),HttpStatus.OK);	
	}
	
	@PostMapping("/file/create")
	public String createFile(
			@RequestParam("file") MultipartFile file,
			@RequestParam("fileType") String fileType)
	{
		String fileName=storageService.create(file, fileType);
		return fileName;
	}
	
	@GetMapping("/media/{fileType}/{fileName}")
	public ResponseEntity<?> getPoster(
			@PathVariable("fileType") String fileType,
			@PathVariable("fileName") String fileName
	) throws IOException {
		MediaType contentType = MediaType.IMAGE_PNG;
		switch (fileType) {
			case "mp4" :
				contentType = MediaType.APPLICATION_OCTET_STREAM;
				break;
			case "jpg" :
				contentType = MediaType.IMAGE_JPEG;
				break;
			case "png" :
				contentType = MediaType.IMAGE_PNG;
				break;
			default :
				return ResponseEntity.badRequest()
						.body("Unsupported File Type");
		}
		byte[] fileBytes = storageService.load(fileName);
		if (fileBytes == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().contentType(contentType).body(fileBytes);
	}
	
}
