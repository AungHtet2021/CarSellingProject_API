package com.carSelling.CarSelling.entity;
import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class OrderHistoryId implements java.io.Serializable{
	
	@Column(nullable = false)
	private int orderId;
	
	@Column(nullable = false)
	private int carId;
	
	@Column(nullable = false)
	private int  userId;
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public OrderHistoryId() {
	}

	public OrderHistoryId(int orderId, int carId, int userId) {
		this.orderId = orderId;
		this.carId = carId;
		this.userId = userId;
	}	  
}
