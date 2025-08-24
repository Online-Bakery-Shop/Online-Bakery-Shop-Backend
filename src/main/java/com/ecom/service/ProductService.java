package com.ecom.service;

import java.util.List;

import com.ecom.entity.Product;

public interface ProductService {
	
	public List<Product> getProduct();
	
	public Product getProduct(long productId);
	
	public Product addProduct(Product product);
	
	public Product updateProduct(Product product);
	
	public void deleteProduct(long parseLong);
}
