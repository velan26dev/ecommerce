package com.proj.ecom_backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proj.ecom_backend.entity.Cart;
import com.proj.ecom_backend.entity.CartItem;
import com.proj.ecom_backend.entity.Order;
import com.proj.ecom_backend.entity.OrderItem;
import com.proj.ecom_backend.entity.OrderStatus;
import com.proj.ecom_backend.entity.Product;
import com.proj.ecom_backend.entity.User;
import com.proj.ecom_backend.repository.CartItemRepository;
import com.proj.ecom_backend.repository.CartRepository;
import com.proj.ecom_backend.repository.OrderItemRepository;
import com.proj.ecom_backend.repository.OrderRepository;
import com.proj.ecom_backend.repository.ProductRepository;
import com.proj.ecom_backend.repository.UserRepository;

@Service
@Transactional
public class OrderService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private CartItemRepository cartItemRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderItemRepository orderItemRepo;
	
	public Order placeOrder(String userEmail) {
		
		User user = userRepo.findByEmail(userEmail).orElseThrow(()-> new RuntimeException("User not found"));
		
		Cart cart = cartRepo.findByUser(user).orElseThrow(()-> new RuntimeException("Cart not found"));
		
		List<CartItem> cartItems = cartItemRepo.findByCart(cart);
		
		if(cartItems.isEmpty()) {
			throw new RuntimeException("Cart is empty");
		}
		
		Order order = new Order();
		order.setUser(user);
		order.setOrderStatus(OrderStatus.PLACED);
		order.setOrderDate(LocalDateTime.now());
		
		double totalAmount = 0;
		
		order = orderRepo.save(order);
		
		for(CartItem cartItem : cartItems) {
			
			Product product = cartItem.getProduct();
			
			if(product.getStock() < cartItem.getQuantity()) {
				throw new RuntimeException("Insufficient stock for product: " + product.getName());
			}
			
			product.setStock(product.getStock() - cartItem.getQuantity());
			productRepo.save(product);
			
			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);
			orderItem.setProduct(product);
			orderItem.setQuantity(cartItem.getQuantity());
			orderItem.setPrice(cartItem.getPrice());
			
			totalAmount += cartItem.getQuantity() * cartItem.getPrice();
			
			orderItemRepo.save(orderItem);
		}
		
		order.setTotalAmount(totalAmount);
		orderRepo.save(order);
		
		cartItemRepo.deleteAll(cartItems);
		
		return order;
	}
	
}