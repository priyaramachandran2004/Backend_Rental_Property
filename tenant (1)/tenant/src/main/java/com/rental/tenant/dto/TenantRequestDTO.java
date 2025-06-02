package com.rental.tenant.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenantRequestDTO {
    
	
	public TenantRequestDTO() {
		
	}
public TenantRequestDTO(String name, String email, String phone, String rentalHistory,String password) {
		
		this.name = name;
		this.email = email;
		this.phone=phone;
		this.password=password;
		this.rentalHistory = rentalHistory;
	}
	private String name;
    private String email;
    private String phone;
    private String rentalHistory;
    private String password;
    public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRentalHistory() {
		return rentalHistory;
	}
	public void setRentalHistory(String rentalHistory) {
		this.rentalHistory = rentalHistory;
	}
}