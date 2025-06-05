package com.rental.property.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "properties")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    public Property(Long propertyId, Long ownerId, String address, Double rentAmount, boolean availabilityStatus,
			String description, String name) {
		this.propertyId = propertyId;
		this.ownerId = ownerId;
		this.address = address;
		this.rentAmount = rentAmount;
		this.availabilityStatus = availabilityStatus;
		this.description = description;
		this.name=name;
	}
	public Property() {
		
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propertyId;

    public Long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean getAvailabilityStatus() {
		return availabilityStatus;
	}
	public void setAvailabilityStatus(boolean availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}
	public Double getRentAmount() {
		return rentAmount;
	}
	public void setRentAmount(Double rentAmount) {
		this.rentAmount = rentAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private Long ownerId;
    private String address;
    private Double rentAmount;
    private boolean availabilityStatus; 
    private String description;
    private String name;
    
}