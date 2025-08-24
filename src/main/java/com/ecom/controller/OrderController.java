package com.ecom.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.entity.Order;
import com.ecom.service.OrderService;


@CrossOrigin
@RestController
public class OrderController {
	@Autowired
	private OrderService service;
	
	@PostMapping("/addorder")
	public Order addOrder(@RequestBody Order order) {
		return this.service.saveOrder(order);
		
	}
	@PostMapping("/addorders")
	public List<Order> addOrders(@RequestBody List<Order> orders){
		return this.service.saveOrders(orders);
		
	}
	@GetMapping("/order/{id}")
	public Order findOrderById(@PathVariable int id) {
		return service.getOrderById(id);
	}
	@GetMapping("/orders")
	public List<Order> findOrders(){
		return service.getOrders();
		
	}
	
}