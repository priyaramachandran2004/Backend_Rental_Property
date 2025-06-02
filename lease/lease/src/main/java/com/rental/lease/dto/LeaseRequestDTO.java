package com.rental.lease.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaseRequestDTO {
    public LeaseRequestDTO() {
		
	}
	public LeaseRequestDTO(Long tenantId, Long propertyId, LocalDate startDate, LocalDate endDate, Double rentAmount) {
		
		this.tenantId = tenantId;
		this.propertyId = propertyId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rentAmount = rentAmount;
	}
	private Long tenantId;
    private Long propertyId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double rentAmount;
	public Long getTenantId() {
		return tenantId;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	public Long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Double getRentAmount() {
		return rentAmount;
	}
	public void setRentAmount(Double rentAmount) {
		this.rentAmount = rentAmount;
	}
}