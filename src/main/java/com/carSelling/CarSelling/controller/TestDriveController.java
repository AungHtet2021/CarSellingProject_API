package com.carSelling.CarSelling.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;


import com.carSelling.CarSelling.entity.TestDrive;
import com.carSelling.CarSelling.service.TestDriveService;

@RestController
@RequestMapping("/testDrive")
public class TestDriveController {
	
	
	@Autowired
	TestDriveService testDriveService;
	
	@PostMapping(value="/create",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TestDrive> createTestDrive(@RequestBody TestDrive testDrive){
		TestDrive drive=testDriveService.create(testDrive);
		return new ResponseEntity<TestDrive>(drive,HttpStatus.OK);
	}
	
	@GetMapping(value="/get/testDrive/{id}")
	public ResponseEntity <TestDrive> getTestDrive(@PathVariable("id") int id){
		TestDrive drive=testDriveService.getTestDrive(id);
		return new ResponseEntity<TestDrive>(drive,HttpStatus.OK);
	}
	
	@GetMapping(value="/get/testDrives")
	public ResponseEntity<List<TestDrive>> getTestDrives(){
		List<TestDrive> drive=testDriveService.getTestDrives();
		return new ResponseEntity<List<TestDrive>>(drive,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<TestDrive> deleteTestDrive(@PathVariable("id") int id){
		testDriveService.deleteTestDrive(id);
		return new ResponseEntity<TestDrive>(HttpStatus.OK);
	}
	
	@PutMapping(value="/update/{id}")
	public ResponseEntity<TestDrive> updateTestDrive(@RequestBody TestDrive testDrive){
		TestDrive updateDrive=testDriveService.updateTestDrive(testDrive);
		return new ResponseEntity<TestDrive>(updateDrive,HttpStatus.OK);
	}
	
}
