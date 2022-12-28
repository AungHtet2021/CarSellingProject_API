package com.carSelling.CarSelling.service;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

import com.carSelling.CarSelling.entity.Admin;

import com.carSelling.CarSelling.repository.AdminRepository;



@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository AdminRepository;
	
	@Override
	public List<Admin> getAll() {
		return AdminRepository.findAll();
	}
	
//	@Autowired
//	public Admin get(int id) {
//		return ( AdminRepository.findById(id)).orElse(null);
//	}

//	@Override
//	public Admin getAdmin(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public Admin create(Admin Admin) {
		Admin.setCreatedAt(LocalDateTime.now());
		return AdminRepository.save(Admin);
	}
	
//	public Admin update(int id, Admin Admin) {
//		Admin toUpdateAdmin = this.get(id);
//		if (toUpdateAdmin == null) {
//			return null;
//		}
//		toUpdateAdmin.setName(Admin.getName());
//		toUpdateAdmin.setId(Admin.getId());
//		toUpdateAdmin.setPassword(Admin.getPassword());
//		toUpdateAdmin.setGmail(Admin.getGmail());
//		toUpdateAdmin.setUpdatedAt(LocalDateTime.now());
//		AdminRepository.save(toUpdateAdmin);
//		return toUpdateAdmin;
//	}
	
	
//	public boolean delete(int id) {
//		Admin Admin = this.get(id);
//		if (Admin == null) {
//			return false;
//		}
//		AdminRepository.deleteById(id);
//		return true;
//	}



	@Override
	public List<Admin> getAdmins() {
		// TODO Auto-generated method stub
	 return AdminRepository.findAll();
	}

	@Override
	public Admin getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}


	
}
