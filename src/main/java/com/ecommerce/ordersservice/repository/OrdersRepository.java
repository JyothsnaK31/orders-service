package com.ecommerce.ordersservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.ordersservice.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

 
}