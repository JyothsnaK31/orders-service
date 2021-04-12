package com.ecommerce.ordersservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ordersservice.model.OrderItems;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {

}
