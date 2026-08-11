package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;

@Service
public class Product_service {
	
	private Product_Repository Repository;

	public Product_service(Product_Repository Repository) {
		this.Repository=Repository;
	}
	
	public ResponseEntity<List<Product_Entity>> getAllProducts(){
		List<Product_Entity> arr= this.Repository.findAll();
		
		return ResponseEntity.ok(arr);
	}

	public ResponseEntity<Product_Entity> getProductById(Long id) {

	    return Repository.findById(id)
	            .map(ResponseEntity::ok)
	            .orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<ProductResponse> addProduct(ProductRequest productRequest) {
	
	    Product_Entity product = new Product_Entity();

	    product.setProductName(productRequest.getProductName());
	    product.setDescription(productRequest.getDescription());
	    product.setPrice(productRequest.getPrice());
	    product.setQuantity(productRequest.getQuantity());
	    product.setCategory(productRequest.getCategory());
	    product.setSku(productRequest.getSku());

	    Product_Entity savedProduct = Repository.save(product);

	    ProductResponse response = new ProductResponse();

	    response.setId(savedProduct.getId());
	    response.setProductName(savedProduct.getProductName());
	    response.setDescription(savedProduct.getDescription());
	    response.setPrice(savedProduct.getPrice());
	    response.setQuantity(savedProduct.getQuantity());
	    response.setCategory(savedProduct.getCategory());

	    return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	public ResponseEntity<String> deleteProduct(Long id) {

	    Optional<Product_Entity> product = Repository.findById(id);

	    if (product.isPresent()) {
	        Repository.deleteById(id);
	        return ResponseEntity.ok("Product deleted successfully.");
	    }

	    return ResponseEntity.notFound().build();
	}
}
