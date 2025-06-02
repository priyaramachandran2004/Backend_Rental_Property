package com.rental.owner.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerDTO {
    private Long ownerId;
    private String name;
    private String email;
    private String phone;
    private String password;
    public OwnerDTO() {}
    
	public OwnerDTO(Long ownerId, String name, String email, String phone,String password) {
		this.ownerId = ownerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password=password;
	}
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}