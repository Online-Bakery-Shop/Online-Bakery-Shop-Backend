package com.ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
