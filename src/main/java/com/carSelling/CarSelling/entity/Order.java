//package com.carSelling.CarSelling.entity;
//import java.time.LocalDateTime;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.validation.constraints.NotBlank;
//
//import org.hibernate.annotations.ColumnDefault;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//
//@Entity
//
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//
//public class Order implements java.io.Serializable{
//	private static final long serialVersionUID = 1L;
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int id;
//
//	@Column(nullable = false)
//	private int carId;
//	
//	@Column(nullable = false)
//	private int userId;
//	
//	@Column(nullable = false)
//	private String total;
//	
//	@Column(nullable = false)
//	private String carQuantity;
//	
//	@Column(nullable = false)
//	@ColumnDefault("CURRENT_TIMESTAMP")
//	private LocalDateTime createdAt;
//}