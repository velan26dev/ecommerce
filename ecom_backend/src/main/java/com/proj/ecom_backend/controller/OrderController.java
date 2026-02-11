package com.proj.ecom_backend.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.ecom_backend.entity.Order;
import com.proj.ecom_backend.service.OrderService;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private OrderService orderServ;
	
	@PostMapping
	public Order placeOrder(Principal principal) {
		String userEmail = principal.getName();
		return orderServ.placeOrder(userEmail);
	}
}