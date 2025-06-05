package com.rental.lease.model;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lease {

    public Lease() {
		
	}
	public Lease(Long leaseId, Long tenantId, Long propertyId,String duration,
			Double rentAmount) {
		
		this.leaseId = leaseId;
		this.tenantId = tenantId;
		this.propertyId = propertyId;
		this.duration=duration;
		this.rentAmount = rentAmount;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaseId;

    public Long getLeaseId() {
		return leaseId;
	}
	public void setLeaseId(Long leaseId) {
		this.leaseId = leaseId;
	}
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
	private Long tenantId;
    private Long propertyId;

   private String duration;
    public String getDuration() {
	return duration;
}
public void setDuration(String duration) {
	this.duration = duration;
}
	private Double rentAmount;
}