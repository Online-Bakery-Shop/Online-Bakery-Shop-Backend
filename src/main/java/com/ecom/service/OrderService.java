package com.ecom.service;

import java.util.List;

import com.ecom.entity.Order;



public interface OrderService {
	
	public Order saveOrder(Order order);
	
	public List<Order> saveOrders(List<Order> orders);
	
	public List<Order> getOrders();
	
	public Order getOrderById(int id);
	
}