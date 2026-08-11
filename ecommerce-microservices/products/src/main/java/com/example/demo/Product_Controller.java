package com.example.demo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;

@RestController()
public class Product_Controller {
	
	private Product_service Product_service;
	
	public Product_Controller(Product_service Product_service) {
		this.Product_service=Product_service;
	}

	@GetMapping("/getProducts")
	public ResponseEntity<List<Product_Entity>> getAllProducts(){
		return Product_service.getAllProducts();
	}
	
	 @GetMapping("/getProducts/{id}")
	    public ResponseEntity<Product_Entity> getProductById(@PathVariable Long id) {
	        return Product_service.getProductById(id);
	    }
	
	@PostMapping("/addProduct")
	public ResponseEntity<ProductResponse> addProduct( @RequestBody ProductRequest ProductRequest ){
		return Product_service.addProduct(ProductRequest);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id){
		return Product_service.deleteProduct(id);
	}

}
