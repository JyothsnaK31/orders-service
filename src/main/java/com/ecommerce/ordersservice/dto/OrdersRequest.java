package com.ecommerce.ordersservice.dto;

import java.util.List;

import com.ecommerce.ordersservice.model.Items;
import com.ecommerce.ordersservice.model.OrderItems;
import com.ecommerce.ordersservice.model.Orders;
import com.ecommerce.ordersservice.model.Payments;

public class OrdersRequest {
	
	private Orders order;
	
	

	public OrdersRequest() {
		super();
	}

	

	public OrdersRequest(Orders order) {
		super();
		this.order = order;
	}




	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}



		
}
