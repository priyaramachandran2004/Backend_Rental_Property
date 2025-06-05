package com.rental.payment.service;

import com.rental.payment.dto.PaymentRequestDTO;
import com.rental.payment.dto.PaymentResponseDTO;

import java.util.List;

public interface PaymentService {
    PaymentResponseDTO createPayment(PaymentRequestDTO dto);
    PaymentResponseDTO getPaymentById(Long id);
    List<PaymentResponseDTO> getAllPayments();
	List<PaymentResponseDTO> getPaymentsByLeaseId(Long leaseId);
}