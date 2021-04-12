package com.ecommerce.ordersservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.ordersservice.model.Payments;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Long>{

}
