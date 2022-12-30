package com.carSelling.CarSelling.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

public class Category implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 50, nullable = false, unique = true)
	@NotBlank(message = "Required")
	private String categoryName;

//	@OneToMany(mappedBy="category", cascade=CascadeType.ALL)
//	private List<Car> cars;
//  
//	 public List<Car> getCars() {
//	        return cars;
//    }
//	 
//    public void setCars(List<Car> cars) {
//	        this.cars = cars;
//	    }

}
