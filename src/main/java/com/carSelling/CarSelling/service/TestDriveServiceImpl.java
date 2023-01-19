package com.carSelling.CarSelling.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.carSelling.CarSelling.entity.TestDrive;
import com.carSelling.CarSelling.repository.TestDriveRepository;
@Service
public class TestDriveServiceImpl implements TestDriveService{
	
	@Autowired
	TestDriveRepository testDriveRepository;
	@Override
	public TestDrive create(TestDrive testDrive) {
//		testDrive.setName(testDrive.getName());
//		testDrive.setGmail(testDrive.getGmail());
//		testDrive.setGender(testDrive.getGender());
//		testDrive.setPhone(testDrive.getPhone());
//		testDrive.setCountry(testDrive.getCountry());
//		testDrive.setRequestDate(testDrive.getRequestDate());
		testDrive.setStatus(testDrive.getStatus());
		testDrive.setCreatedAt(LocalDateTime.now());
		testDrive.setCarId(testDrive.getCarId());
		TestDrive drive=testDriveRepository.save(testDrive);
		return drive;
	}
	@Override
	public TestDrive getTestDrive(int id) {
		TestDrive drive=testDriveRepository.findById(id).orElse(null);
		return drive;
		
	}
	@Override
	public List<TestDrive> getTestDrives() {
		List<TestDrive> drive=testDriveRepository.findAll();
		return drive;
	}
	@Override
	public TestDrive deleteTestDrive(int id) {
		testDriveRepository.deleteById(id);
		return null;
	}
	@Override
	public TestDrive updateTestDrive(TestDrive testDrive) {
		TestDrive original=testDriveRepository.findById(testDrive.getId()).orElse(null);
		if(original!=null) {
			original.setCarId(testDrive.getCarId());		
			original.setName(testDrive.getName());
			original.setGmail(testDrive.getGmail());
			original.setGender(testDrive.getGender());
			original.setCountry(testDrive.getCountry());
			original.setStatus(testDrive.getStatus());
			original.setRequestDate(testDrive.getRequestDate());
			original.setCreatedAt(LocalDateTime.now());
			original=testDriveRepository.save(original);
		}
		return original;
	}

}
