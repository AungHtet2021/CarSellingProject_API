package com.carSelling.CarSelling.entity;

public interface OrderDailyReport {
	
//	int getId();
	 int getOrder_id();
	 int getUser_id();
	 int getCar_id();
	 String getUserName();
	 String getUserImage();
	 String getUserGmail();
	 String getName();
	 String getImage_path();
	 String getCar_quantity();
	 String getTotal();
	 String getCreated_at();
}
