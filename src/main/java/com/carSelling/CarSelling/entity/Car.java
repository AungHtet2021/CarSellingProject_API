package com.carSelling.CarSelling.entity;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@AllArgsConstructor
@NoArgsConstructor
@ToString
// Default Constructor, All Args Constructor, Getters Setters, ToString

public class Car implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 50, nullable = false, unique = true)
	@NotBlank(message = "Required")
	private String name;

	@Column(nullable = false)
	@NotBlank(message = "Required")
	private int status;

	@Column(nullable = false)
	@NotBlank(message = "Required")
	private int quantity;

	@Column(nullable = false)
	@NotBlank(message = "Required")
	private int price;

	@Column(nullable = false)
	@NotBlank(message = "Required")
	private int waitingTime;

	@Column(columnDefinition = "boolean", nullable = false)
	@ColumnDefault("false")
	private Boolean isPublic;
	
	private String description;
	
	@Column(length = 200)
	@NotBlank(message = "Required")
	private String imagePath;

	@Column(nullable = false)
	@ColumnDefault("CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

}
