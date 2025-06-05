package com.rental.lease.dto;

import lombok.*;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaseResponseDTO {
    public LeaseResponseDTO() {
		
	}
	public LeaseResponseDTO(Long leaseId, Long tenantId, Long propertyId, String duration,
			Double rentAmount) {
		
		this.leaseId = leaseId;
		this.tenantId = tenantId;
		this.propertyId = propertyId;
		this.duration=duration;
		this.rentAmount = rentAmount;
	}
	private Long leaseId;
    private Long tenantId;
    private Long propertyId;
    private String duration;
    private Double rentAmount;
    public Long getTenantId() {
		return tenantId;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
    public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public Long getLeaseId() {
		return leaseId;
	}
	public void setLeaseId(Long leaseId) {
		this.leaseId = leaseId;
	}
	public Long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	
	public Double getRentAmount() {
		return rentAmount;
	}
	public void setRentAmount(Double rentAmount) {
		this.rentAmount = rentAmount;
	}
}