package com.ecom.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.entity.Product;
import com.ecom.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/use")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		
		return this.productService.getProduct();
		
	}
	
	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable String productId) {
		
		return this.productService.getProduct(Long.parseLong(productId));
	}
	
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) { 
		
		return this.productService.addProduct(product);
	}
	
	
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product product) {
		
		return this.productService.updateProduct(product);
	}
	
	
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String productId)
	{
		try {
			this.productService.deleteProduct(Long.parseLong(productId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e){
			return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
