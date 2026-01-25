package com.proj.ecom_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.ecom_backend.dto.JwtResponse;
import com.proj.ecom_backend.dto.Login;
import com.proj.ecom_backend.entity.User;
import com.proj.ecom_backend.service.AuthService;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authServ;

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return authServ.register(user);
	}

	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody Login login) {
		JwtResponse response = authServ.login(login);
		return ResponseEntity.ok(response);
	}
}