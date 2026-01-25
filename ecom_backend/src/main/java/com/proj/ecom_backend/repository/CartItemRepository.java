package com.proj.ecom_backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proj.ecom_backend.entity.Cart;
import com.proj.ecom_backend.entity.CartItem;
import com.proj.ecom_backend.entity.Product;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>{

	Optional<CartItem> findByCartAndProduct(Cart cart, Product product);
	
	List<CartItem> findByCart(Cart cart);
}