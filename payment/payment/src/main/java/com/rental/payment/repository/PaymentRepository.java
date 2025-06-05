package com.rental.payment.repository;

import com.rental.payment.model.Payment;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

	List<Payment> findByLeaseId(Long leaseId);
}