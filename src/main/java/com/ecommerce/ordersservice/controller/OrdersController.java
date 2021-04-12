package com.ecommerce.ordersservice.controller;


import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ordersservice.dto.OrdersRequest;
import com.ecommerce.ordersservice.exception.ResourceNotFoundException;
import com.ecommerce.ordersservice.model.Items;
import com.ecommerce.ordersservice.model.Orders;
import com.ecommerce.ordersservice.model.PaymentInfo;
import com.ecommerce.ordersservice.model.Payments;
import com.ecommerce.ordersservice.repository.ItemsRepository;
import com.ecommerce.ordersservice.repository.OrderItemsRepository;
import com.ecommerce.ordersservice.repository.OrdersRepository;
import com.ecommerce.ordersservice.repository.PaymentInfoRepository;
import com.ecommerce.ordersservice.repository.PaymentsRepository;

@RestController
@RequestMapping("/api/v1/")
public class OrdersController {

	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private PaymentsRepository paymentsRepository;
	
	@Autowired
	private PaymentInfoRepository paymentInfoRepository;
	
	@Autowired
	private OrderItemsRepository orderItemsRepository;
	
	@Autowired
	private ItemsRepository itemsRepository;
	
	//get orders
	
	@GetMapping("orders")
	public List<Orders> getAllOrders(){
		return this.ordersRepository.findAll();
	}
	
	//get orders by id
	@GetMapping("/orders/{id}")
	public ResponseEntity<Orders> getOrderById(@PathVariable(value = "id") Long orderId)
			throws ResourceNotFoundException {
		Orders order = ordersRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + orderId));
		return ResponseEntity.ok().body(order);
	}
	
	//create order
	@PostMapping("orders")
	public Orders createOrder(@RequestBody OrdersRequest request)
	{
		/*
		 * Long itemNo = request.getItems().getItemNo(); Items item =
		 * itemsRepository.findById(itemNo) .orElseThrow(() -> new
		 * ResourceNotFoundException("Item not found for this id :: " + itemNo));
		 * 
		 * request.getOrderitems().setItem(item);
		 */		
        return this.ordersRepository.save(request.getOrder());

	}
	
	@PostMapping("payments")
	public Payments createPayment(@RequestBody Payments payment)
	{
		return this.paymentsRepository.save(payment);
	}
	
	//delete order
	@DeleteMapping("/orders/{id}")
	public Map<String, Boolean> deleteOrder(@PathVariable(value = "id") Long orderId) throws ResourceNotFoundException{
		Orders order = ordersRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + orderId));
		Long paymentInfoId = order.getPayments().get(0).getPaymentInformation().getPaymentInfoId();
		/*
		 * PaymentInfo paymentinfo = paymentInfoRepository.findById(paymentInfoId)
		 * .orElseThrow(() -> new
		 * ResourceNotFoundException("PaymentInfo not found for this id :: " +
		 * paymentInfoId));
		 */
		this.paymentInfoRepository.deleteById(paymentInfoId);
		
		this.ordersRepository.delete(order);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);

		return response;
	}
}

