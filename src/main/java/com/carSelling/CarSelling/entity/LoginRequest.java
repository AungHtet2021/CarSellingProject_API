package com.carSelling.CarSelling.entity;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data

public class LoginRequest {
	
	
	@NotBlank(message="Required")
	private String gmail;
	
	@NotBlank(message="Required")
	private String password;
}
