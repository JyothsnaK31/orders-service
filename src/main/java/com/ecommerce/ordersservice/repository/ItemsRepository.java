package com.ecommerce.ordersservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ordersservice.model.Items;

public interface ItemsRepository extends JpaRepository<Items, Long>{

}
