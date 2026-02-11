package com.proj.ecom_backend.controller;

import java.security.Principal;
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
	
	@PostMapping("/{productId}/{quantity}")
	public void addToCart(@PathVariable Long productId,@PathVariable int quantity,Principal principal) {
		String userEmail = principal.getName();
		cartServ.addToCart(userEmail, productId, quantity);
	}
	
	@DeleteMapping("/{productId}")
	public void removeFromCart(@PathVariable Long productId,Principal principal) {
		String userEmail = principal.getName();
		cartServ.removeFromCart(userEmail, productId);
	}
	
	@GetMapping()
	public List<CartItem> getCartItems(Principal principal){
		String userEmail = principal.getName();
		return cartServ.getCartItems(userEmail);
	}
}