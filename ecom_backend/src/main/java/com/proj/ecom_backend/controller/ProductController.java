package com.proj.ecom_backend.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.proj.ecom_backend.entity.Product;
import com.proj.ecom_backend.service.ProductService;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productServ;

	@PostMapping
	public Product addProduct(@RequestPart("product") Product prod, @RequestPart("image") MultipartFile image) throws IOException {
		return productServ.addProduct(prod, image);
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productServ.getProductById(id);
	}

	@GetMapping
	public List<Product> getAllProduct() {
		return productServ.getAllProduct();
	}

	@GetMapping("/name/{name}")
	public List<Product> getProductByName(@PathVariable String name) {
		return productServ.getProductByName(name);
	}

	@PutMapping("/{id}")
	public String updateProduct(@PathVariable Long id, @RequestBody Product newProd) {
		return productServ.updateProduct(id, newProd);
	}

	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		return productServ.deleteProduct(id);
	}
}