package com.rental.payment.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

  
	public Payment() {
		
	}
	  public Payment(Long paymentId, Long leaseId, Double amount, LocalDate paymentDate, String paymentMode) {
			
			this.paymentId = paymentId;
			this.leaseId = leaseId;
			this.amount = amount;
			this.paymentDate = paymentDate;
			this.paymentMode = paymentMode;
		}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    public Long getPaymentId() {
		return paymentId;
	}
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
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	private Long leaseId;
    private Double amount;
    private LocalDate paymentDate;
    private String paymentMode;
}