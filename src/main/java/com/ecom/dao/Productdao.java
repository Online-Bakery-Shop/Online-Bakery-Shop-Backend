package com.ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.entity.Product;

public interface Productdao extends JpaRepository<Product,Long> {

}
