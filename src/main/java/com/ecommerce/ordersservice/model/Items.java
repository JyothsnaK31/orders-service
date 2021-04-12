package com.ecommerce.ordersservice.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Items")

public class Items {

	@Id
	private long itemNo;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "item_price")
	private BigDecimal price; 
	
	//@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	@OneToMany(targetEntity = OrderItems.class,cascade = CascadeType.ALL, mappedBy = "item")
    private List<OrderItems> orderItems;

	public Items() {
		super();
	}

	public long getItemNo() {
		return itemNo;
	}

	public void setItemNo(long itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/*
	 * public List<OrderItems> getOrderItems() { return orderItems; }
	 * 
	 * public void setOrderItems(List<OrderItems> orderItems) { this.orderItems =
	 * orderItems; }
	 */

	public Items(long itemNo, String itemName, BigDecimal price, List<OrderItems> orderItems) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.price = price;
		this.orderItems = orderItems;
	}

	
}
