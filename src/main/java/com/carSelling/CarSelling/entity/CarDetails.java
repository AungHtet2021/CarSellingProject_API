package com.carSelling.CarSelling.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor


public class CarDetails {

	private Integer id;
	private String description;
	private Boolean isPublic;
	private Integer price;
	private Integer quantity;
	private Integer status;
	private Integer waitingTime;
	private String imagePath;
	private String name;
	private String categoryName;
	private String video;

	public CarDetails(Integer id, String description, Boolean isPublic, Integer price,
			Integer quantity, Integer status, Integer waitingTime, String imagePath,
			String name, String categoryName, String video
			) {
		this.id = id;
		this.description = description;
		this.isPublic = isPublic;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
		this.waitingTime = waitingTime;
		this.imagePath = imagePath;
		this.name = name;
		this.categoryName = categoryName;
		this.video = video;
	}
	
	
	@Override
	public String toString() {
		return "CarDetails [id=" + id + ", description=" + description + ", isPublic=" + isPublic + ", price=" + price
				+ ", quantity=" + quantity + ", status=" + status + ", waitingTime=" + waitingTime + ", imagePath="
				+ imagePath + ", name=" + name + ", categoryName=" + categoryName + ", video=" + video + "]";
	}
	
	
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public Boolean getIsPublic() {
//		return isPublic;
//	}
//	public void setIsPublic(Boolean isPublic) {
//		this.isPublic = isPublic;
//	}
//	public String getPrice() {
//		return price;
//	}
//	public void setPrice(String price) {
//		this.price = price;
//	}
//	public String getQuantity() {
//		return quantity;
//	}
//	public void setQuantity(String quantity) {
//		this.quantity = quantity;
//	}
//	public Integer getStatus() {
//		return status;
//	}
//	public void setStatus(Integer status) {
//		this.status = status;
//	}
//	public String getWaitingTime() {
//		return waitingTime;
//	}
//	public void setWaitingTime(String waitingTime) {
//		this.waitingTime = waitingTime;
//	}
//	public String getImagePath() {
//		return imagePath;
//	}
//	public void setImagePath(String imagePath) {
//		this.imagePath = imagePath;
//	}
//	
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getCategoryName() {
//		return categoryName;
//	}
//	public void setCategoryName(String categoryName) {
//		this.categoryName = categoryName;
//	}
//	public String getVideo() {
//		return video;
//	}
//	public void setVideo(String video) {
//		this.video = video;
//	}

	
//	public CarDetails() {
//	}
	
}
