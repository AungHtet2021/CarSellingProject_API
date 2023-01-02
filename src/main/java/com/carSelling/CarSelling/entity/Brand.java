package com.carSelling.CarSelling.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

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

public class Brand implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 50, nullable = false, unique = true)
	@NotBlank(message = "Required")
	private String brandName;
	
	@Column(length=30, nullable = false)
	@NotBlank(message = "Required ")
	private String produceCountry;

	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getBrandName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setBrandName(Object brandName2) {
		// TODO Auto-generated method stub
		
	}

	public Object getProduceCountry() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setProduceCountry(Object produceCountry2) {
		// TODO Auto-generated method stub
		
	}
}








