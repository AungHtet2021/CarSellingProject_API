package com.carSelling.CarSelling.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.carSelling.CarSelling.entity.Category;
import com.carSelling.CarSelling.entity.Car;
import com.carSelling.CarSelling.entity.Admin;
import com.carSelling.CarSelling.entity.Brand;
import com.carSelling.CarSelling.entity.Discount;
import com.carSelling.CarSelling.service.CategoryService;
import com.carSelling.CarSelling.service.AdminService;
import com.carSelling.CarSelling.service.BrandService;
import com.carSelling.CarSelling.service.CategoryService;

import com.carSelling.CarSelling.service.DiscountService;
import com.carSelling.CarSelling.service.StorageService;
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	StorageService  storageService;

	@PostMapping("/create")
	public ResponseEntity<?> createAdmin(@Valid @RequestBody Admin Admin) {
		if (Admin.getName() == null) {
			return ResponseEntity.badRequest().body("Name is empty");
		}
		if (Admin.getId() == 0) {
			return ResponseEntity.badRequest().body("Admin ID is invalid");
		}
		if (Admin.getPassword() == null) {
			return ResponseEntity.badRequest().body("password is empty");
		}
		
		if (Admin.getGmail() == null) {
			return ResponseEntity.badRequest().body("gmail is empty");
		}
		
		return ResponseEntity.ok(adminService.create(Admin));
	}
//	@GetMapping(value="/get/admin/{id}")
//	public ResponseEntity <Admin> getAdmin(@PathVariable("id") int id){
//		Admin Admin=adminService.getAdmin(id);
//		return new ResponseEntity<Admin>(Admin,HttpStatus.OK);
//	}
//	
	@GetMapping(value="/get/admins")
	public ResponseEntity<List<Admin>> getAdmins(){
		List<Admin> admins=adminService.getAdmins();
		return new ResponseEntity<List<Admin>>(admins,HttpStatus.OK);
	}
	
	@PostMapping("/file/create")
	public ResponseEntity<String> createFile(
			@RequestParam("file") MultipartFile file,
			@RequestParam("fileType") String fileType
	) {
		String filePath = storageService.create(file, fileType);
		if (filePath == null) {
			return ResponseEntity.internalServerError().build();
		}
		return ResponseEntity.ok(filePath);
	}

	@PutMapping("/file/update")
	public ResponseEntity<String> updateFile(
			@RequestParam("file") MultipartFile file,
			@RequestParam("fileType") String fileType,
			@RequestParam("filePath") String filePath
	) {
		String newFilePath = storageService.update(file, fileType, filePath);
		if (newFilePath == null) {
			return ResponseEntity.internalServerError().build();
		}
		return ResponseEntity.ok(newFilePath);
	}

//	@PutMapping("/admin/update/{id}")
//	public ResponseEntity<Admin> updateAdmin(
//			@PathVariable int id, @Valid @RequestBody Admin Admin
//	) {
//		Admin updatedAdmin = adminService.update(id, Admin);
//		if (updatedAdmin == null) {
//			return ResponseEntity.notFound().build();
//		}
//		return ResponseEntity.ok().body(updatedAdmin);
//	}

//	@DeleteMapping(value = "/admin/delete/{id}")
//	public ResponseEntity<?> deleteAdmin(@PathVariable int id) {
//		Admin Admin = adminService.get(id);
//		if (Admin == null) {
//			return ResponseEntity.notFound().build();
//		}
//		return ResponseEntity.ok().build();
//	}

	@GetMapping("/Admin/name/{name}")
	public ResponseEntity<Boolean> findAdminByName(
			@PathVariable("name") String name
	) {
		Admin Admin = adminService.getByName(name);
		if (Admin == null) {
			return ResponseEntity.ok().body(false);
		}
		return ResponseEntity.ok().body(true);
	}

}

