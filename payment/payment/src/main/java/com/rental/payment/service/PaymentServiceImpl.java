package com.rental.payment.service;

import com.rental.payment.client.LeaseClient;
import com.rental.payment.dto.PaymentRequestDTO;
import com.rental.payment.dto.PaymentResponseDTO;
import com.rental.payment.exception.PaymentNotFoundException;
import com.rental.payment.model.Payment;
import com.rental.payment.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    
    @Autowired
    private PaymentRepository repository;

    @Autowired
    private LeaseClient leaseClient;

    @Override
    public PaymentResponseDTO createPayment(PaymentRequestDTO dto) {
        if (!leaseClient.checkIfLeaseExists(dto.getLeaseId())) {
            throw new PaymentNotFoundException("Lease not found with ID: " + dto.getLeaseId());
        }

        Payment payment = new Payment(null, dto.getLeaseId(), dto.getAmount(),
                dto.getPaymentDate(), dto.getPaymentMode());

        Payment saved = repository.save(payment);
        return convertToResponse(saved);
    }

    @Override
    public PaymentResponseDTO getPaymentById(Long id) {
        Payment payment = repository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found with ID: " + id));
        return convertToResponse(payment);
    }

    @Override
    public List<PaymentResponseDTO> getAllPayments() {
        return repository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    // ✅ Get Payments by Lease ID Implementation
    @Override
    public List<PaymentResponseDTO> getPaymentsByLeaseId(Long leaseId) {
        if (!leaseClient.checkIfLeaseExists(leaseId)) {
            throw new PaymentNotFoundException("Lease not found with ID: " + leaseId);
        }

        return repository.findByLeaseId(leaseId)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    private PaymentResponseDTO convertToResponse(Payment payment) {
        return new PaymentResponseDTO(
                payment.getPaymentId(),
                payment.getLeaseId(),
                payment.getAmount(),
                payment.getPaymentDate(),
                payment.getPaymentMode()
        );
    }
}
