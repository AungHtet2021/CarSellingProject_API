package com.carSelling.CarSelling.service;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	public String create(MultipartFile file, String fileType);
	public String update(MultipartFile file, String fileType, String filePath);
	public byte[] load(String filePath);
	public boolean delete(String filePath);
	public void clearAll();
	
}
