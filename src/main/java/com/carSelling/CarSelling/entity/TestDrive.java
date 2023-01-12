package com.carSelling.CarSelling.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestDrive implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 50, nullable = false, unique = true)
	@NotBlank(message = "Required")
	private String name;
	
	@Column(length=50,nullable=false,unique=true)
	@NotBlank(message="Required")
	private String gmail;
	
	@Column(length=30,nullable=false,unique=true)
	@NotBlank(message="Required")
	private String gender;
	
	@Column(length=30, nullable = false)
	@NotBlank(message = "Required ")
	private String country;
	
	@Column(length=20,nullable=false,unique=true)
	@NotBlank(message="Required")
	private String phone;
	
	@Column(nullable = false)
	private String requestDate;
			
	@Column(nullable = false)
	private String carId;
	
	@Column(nullable = false)
	@ColumnDefault("CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;
}










