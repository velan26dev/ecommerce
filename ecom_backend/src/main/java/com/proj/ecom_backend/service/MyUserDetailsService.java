package com.proj.ecom_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.proj.ecom_backend.dto.UserPrincipal;
import com.proj.ecom_backend.entity.User;
import com.proj.ecom_backend.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByEmail(username).orElse(null);
		
		if(user == null)
			throw new UsernameNotFoundException("User not found");
		
		return new UserPrincipal(user);
	}

}