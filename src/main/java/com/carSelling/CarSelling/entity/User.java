package com.carSelling.CarSelling.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.factory.annotation.Required;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User implements java.io.Serializable{
	
	private static final long serialVerisonUID=1L;
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(length=30,nullable=false)
	@NotBlank(message="Required")
	private String name;
	
	@Column(length=50,nullable=false,unique=true)
	@NotBlank(message="Required")
	private String gmail;
	
	@Column(length=50,nullable=false,unique=true)
	@NotBlank(message="Required")
	private String password;
	
	@Column(length=200,nullable=false,unique=true)
	@NotBlank(message="Requied")
	private String imagePath;
	
	@Column(nullable=false)
	private LocalDate DateOFBirth;
	
	@Column(length=20,nullable=false,unique=true)
	@NotBlank(message="Required")
	private int phone;
	
	@Column(nullable = false)
	@ColumnDefault("CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;
	
}
