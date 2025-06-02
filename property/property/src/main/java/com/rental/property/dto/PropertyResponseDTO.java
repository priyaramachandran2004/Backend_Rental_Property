package com.rental.property.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyResponseDTO {
    public PropertyResponseDTO() {
		
	}
	public PropertyResponseDTO(Long propertyId, Long ownerId, String address, Double rentAmount,
			String availabilityStatus, String description) {
				this.propertyId = propertyId;
		this.ownerId = ownerId;
		this.address = address;
		this.rentAmount = rentAmount;
		this.availabilityStatus = availabilityStatus;
		this.description = description;
	}
	private Long propertyId;
    private Long ownerId;
    private String address;
    private Double rentAmount;
    private String availabilityStatus;
    private String description;
   
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public Long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getRentAmount() {
		return rentAmount;
	}
	public void setRentAmount(Double rentAmount) {
		this.rentAmount = rentAmount;
	}
	public String getAvailabilityStatus() {
		return availabilityStatus;
	}
	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}