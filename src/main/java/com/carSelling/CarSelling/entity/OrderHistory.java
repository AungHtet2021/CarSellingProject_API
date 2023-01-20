package com.carSelling.CarSelling.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@IdClass(OrderHistoryId.class)
public class OrderHistory implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderHistoryId id;
//	@Id
//	private int orderId;
//	
//	@Id
//	private int carId;
//	
//	@Id
//	private int  userId;

	@Column(nullable = false)
	private int total;

	@Column(nullable = false)
	private int carQuantity;

	@Column(nullable = false)
	@ColumnDefault("CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;

}
