package com.proj.ecom_backend.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.proj.ecom_backend.entity.Product;
import com.proj.ecom_backend.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private FileUploadService fileUploadService;

	public Product addProduct(Product prod, MultipartFile image) throws IOException {
		String imageName = fileUploadService.saveImage(image);
		prod.setImageUrl("http://localhost:8080/images/" + imageName);
		return productRepo.save(prod);
	}

	public Product getProductById(Long id) {
		return productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	}

	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	public List<Product> getProductByName(String name) {
		return productRepo.findByNameLike("%" + name + "%");
	}

	public String updateProduct(Long id, Product newProd) {
		Product exProd = productRepo.findById(id).orElse(null);
		if (exProd != null) {
			exProd.setName(newProd.getName());
			exProd.setDescription(newProd.getDescription());
			exProd.setPrice(newProd.getPrice());
			exProd.setRating(newProd.getRating());
			exProd.setStock(newProd.getStock());
			exProd.setCategory(newProd.getCategory());

			productRepo.save(exProd);
			return "Product updated";
		}
		return "Product not found";
	}

	public String deleteProduct(Long id) {
		if (productRepo.existsById(id)) {
			productRepo.deleteById(id);
			return "Product deleted";
		}
		return "Product not found";
	}
}