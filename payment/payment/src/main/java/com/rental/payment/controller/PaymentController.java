package com.rental.payment.controller;

import com.rental.payment.dto.PaymentRequestDTO;
import com.rental.payment.dto.PaymentResponseDTO;
import com.rental.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
   @Autowired
    private  PaymentService paymentService;

    @PostMapping
    public PaymentResponseDTO create(@RequestBody PaymentRequestDTO dto) {
        return paymentService.createPayment(dto);
    }

    @GetMapping("/{id}")
    public PaymentResponseDTO getById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping
    public List<PaymentResponseDTO> getAll() {
        return paymentService.getAllPayments();
    }
}