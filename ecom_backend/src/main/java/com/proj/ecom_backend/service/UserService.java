package com.proj.ecom_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.ecom_backend.entity.User;
import com.proj.ecom_backend.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User getUserById(int id) {
		return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
	}

	public User getUserByEmail(String email) {
		return userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
	}

	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	public String updateUser(int id, User newUser) {
		User exUser = userRepo.findById(id).orElse(null);
		if (exUser != null) {
			exUser.setName(newUser.getName());
			exUser.setAddress(newUser.getAddress());
			exUser.setPhone(newUser.getPhone());
			exUser.setEmail(newUser.getEmail());
			exUser.setPassword(newUser.getPassword());

			userRepo.save(exUser);
			return "User updated";
		}
		return "User not found";
	}

	public String deleteUser(int id) {
		if (userRepo.existsById(id)) {
			userRepo.deleteById(id);
			return "User deleted";
		}
		return "User not found";
	}
}