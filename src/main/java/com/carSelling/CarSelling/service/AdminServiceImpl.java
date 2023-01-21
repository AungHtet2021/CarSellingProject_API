package com.carSelling.CarSelling.service;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.carSelling.CarSelling.entity.Admin;
import com.carSelling.CarSelling.entity.Car;
import com.carSelling.CarSelling.repository.AdminRepository;



@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Admin checkLoginAdmin(String gmail, String password) {
		Admin admin=adminRepository.findByGmail(gmail);
		if(admin==null) {
			return null;
		}
		if(!passwordEncoder.matches(password, admin.getPassword())) {
			return null;
		}
		return admin;
	}
	
	@Override
	public List<Admin> getAll() {
		return adminRepository.findAll();
	}
	
	public Admin create(Admin Admin) {
		Admin.setPassword(passwordEncoder.encode(Admin.getPassword()));
		Admin.setCreatedAt(LocalDateTime.now());
		return adminRepository.save(Admin);
	}
	
	public Admin update(int id, Admin Admin) {
		Admin toUpdateAdmin = this.get(id);
		if (toUpdateAdmin == null) {
			return null;
		}
		toUpdateAdmin.setName(Admin.getName());
		toUpdateAdmin.setId(Admin.getId());
		toUpdateAdmin.setPassword(Admin.getPassword());
		toUpdateAdmin.setAdminRole(Admin.getAdminRole());
		toUpdateAdmin.setGmail(Admin.getGmail());
		toUpdateAdmin.setImagePath(Admin.getImagePath());
		toUpdateAdmin.setCreatedAt(LocalDateTime.now());
		adminRepository.save(toUpdateAdmin);
		return toUpdateAdmin;
	}
	
	@Override
	public List<Admin> getAdmins() {
		List Admin=adminRepository.findAll();
	 return  Admin;
	}

	@Override
	public Admin getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		Admin admin=this.get(id);
		if(admin == null) {
			return false;
		}
		adminRepository.deleteById(id);
		return true;
	}

	@Override
	public Admin getAdmin(int id) {	
		Admin admin=adminRepository.findById(id).orElse(null);
		return admin;
	}

	@Override
	public Admin get(int id) {
		return adminRepository.findById(id).orElse(null);
	}
	
}
