package com.ecom.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	
	@Id
	private long id;
	
	private String title;
	
	private String descprition;
	
	private double price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescprition() {
		return descprition;
	}

	public void setDescprition(String descprition) {
		this.descprition = descprition;
	}

	public Product(long id, String title, String descprition,double price) {
		super();
		this.id = id;
		this.title = title;
		this.descprition = descprition;
		this.price = price;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", descprition=" + descprition + ", price=" + price + "]";
	}

	
	

}
