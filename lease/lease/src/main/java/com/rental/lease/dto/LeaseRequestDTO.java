package com.rental.lease.dto;

import lombok.*;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaseRequestDTO {
    public LeaseRequestDTO() {
		
	}
	public LeaseRequestDTO(Long tenantId, Long propertyId, String duration, Double rentAmount) {

		this.tenantId = tenantId;
		this.propertyId = propertyId;
		this.duration=duration;
		this.rentAmount = rentAmount;
	}
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
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
}