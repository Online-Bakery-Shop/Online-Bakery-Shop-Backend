package com.ecom.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecom.dao.Productdao;
import com.ecom.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private Productdao productDao;

	
	
	@Override
	public List<Product> getProduct() {
		
		return productDao.findAll();
	}
	
	

	@Override
	public Product getProduct(long productId) {
		
		return productDao.getOne(productId);   // try to use getById()   // 
	}

	
	
	@Override
	public Product addProduct(Product product) {

		productDao.save(product);
		return product;
		
	}

	
	
	@Override
	public Product updateProduct(Product product) {
		
		productDao.save(product);
		return product;
	}

	
	
	@Override
	public void deleteProduct(long parseLong) {
		
		Product entity = productDao.getOne(parseLong);
		productDao.delete(entity);
	}

}
