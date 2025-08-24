package com.ecom.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.dao.OrderRepository;
import com.ecom.entity.Order;

@Service
public class OrderServiceImp implements OrderService{
	@Autowired
	private OrderRepository repo;

	@Override
	public Order saveOrder(Order order) {
		 repo.save(order);
		 return order;
		
	}

	@Override
	public List<Order> saveOrders(List<Order> orders) {
		
		return repo.saveAll(orders);
	}

	@Override
	public List<Order> getOrders() {
		
		return repo.findAll();
	}

	@Override
	public Order getOrderById(int id) {
		
		return repo.findById(id).get();
	}

}