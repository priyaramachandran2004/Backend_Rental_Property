package com.rental.payment.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDTO {
    public PaymentRequestDTO() {
		
	}
	public PaymentRequestDTO(Long leaseId, Double amount, LocalDate paymentDate, String paymentMode) {
		
		this.leaseId = leaseId;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.paymentMode = paymentMode;
	}
	private Long leaseId;
    private Double amount;
    private LocalDate paymentDate;
    private String paymentMode;
	public Long getLeaseId() {
		return leaseId;
	}
	public void setLeaseId(Long leaseId) {
		this.leaseId = leaseId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
}