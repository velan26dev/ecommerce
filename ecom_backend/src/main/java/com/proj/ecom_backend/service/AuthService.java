package com.proj.ecom_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.proj.ecom_backend.dto.JwtResponse;
import com.proj.ecom_backend.dto.Login;
import com.proj.ecom_backend.entity.User;
import com.proj.ecom_backend.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private JWTService jwtService;

	@Autowired
	private AuthenticationManager authManager;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	public User register(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	public JwtResponse login(Login login) {
		String token = null;
		
		Authentication authentication = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
		
		if (authentication.isAuthenticated())
			token = jwtService.generateToken(login.getEmail());

		return new JwtResponse(token);

	}

}