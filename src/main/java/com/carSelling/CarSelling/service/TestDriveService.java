package com.carSelling.CarSelling.service;

import java.util.List;

import com.carSelling.CarSelling.entity.TestDrive;

public interface TestDriveService {

	public TestDrive create(TestDrive testDrive);

	public TestDrive getTestDrive(int id);

	public List<TestDrive> getTestDrives();

	public TestDrive deleteTestDrive(int id);

	public TestDrive updateTestDrive(TestDrive testDrive);

}
