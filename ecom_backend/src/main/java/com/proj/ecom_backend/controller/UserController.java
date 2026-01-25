package com.proj.ecom_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.ecom_backend.entity.User;
import com.proj.ecom_backend.service.UserService;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userServ;

	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id) {
		return userServ.getUserById(id);
	}

	@GetMapping("/email/{email}")
	public User getUserByEmail(@PathVariable String email) {
		return userServ.getUserByEmail(email);
	}

	@GetMapping
	public List<User> getAllUser() {
		return userServ.getAllUser();
	}

	@PutMapping("/{id}")
	public String updateUser(@PathVariable int id, @RequestBody User newUser) {
		return userServ.updateUser(id, newUser);
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable int id) {
		return userServ.deleteUser(id);
	}
}