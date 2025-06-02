package com.rental.tenant.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tenant {
	 public Tenant() {
     }
    
	public Tenant(Long tenantId, String name, String email, String phone, String rentalHistory,String password) {
		
		this.tenantId = tenantId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password=password;
		this.rentalHistory = rentalHistory;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tenantId;


    private String name;
    private String email;
    private String phone;
    private String password;
     private String rentalHistory;
    
     
    public String getRentalHistory() {
		return rentalHistory;
	}

	public void setRentalHistory(String rentalHistory) {
		this.rentalHistory = rentalHistory;
	}

   

    // Getters and Setters
    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
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