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
	
	@Column(nullable=false)
	@NotBlank(message="Required")
	private String password;
	
	@Column(length=200,nullable=false)
	@NotBlank(message="Requied")
	private String imagePath;
	
//	@Column(nullable=false)
//	private LocalDate DateOfBirth;
	
	@Column(length=20,nullable=false,unique=true)
	@NotBlank(message="Required")
	private String phone;
	
	@Column(nullable = false)
	@ColumnDefault("CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;


	public String getImagePath() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	
}
