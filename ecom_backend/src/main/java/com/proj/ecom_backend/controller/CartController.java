package com.proj.ecom_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.ecom_backend.entity.CartItem;
import com.proj.ecom_backend.service.CartService;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	private CartService cartServ;
	
	@PostMapping("/{userEmail}/{productId}/{quantity}")
	public void addToCart(@PathVariable String userEmail,@PathVariable Long productId,@PathVariable int quantity) {
		cartServ.addToCart(userEmail, productId, quantity);
	}
	
	@DeleteMapping("/{userEmail}/{productId}")
	public void removeFromCart(@PathVariable String userEmail,@PathVariable Long productId) {
		cartServ.removeFromCart(userEmail, productId);
	}
	
	@GetMapping("/{userEmail}")
	public List<CartItem> getCartItems(@PathVariable String userEmail){
		return cartServ.getCartItems(userEmail);
	}
}