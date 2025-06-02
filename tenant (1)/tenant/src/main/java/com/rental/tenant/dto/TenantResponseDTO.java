package com.rental.tenant.dto;

public class TenantResponseDTO {

    
	public TenantResponseDTO() {
		
	}

	public TenantResponseDTO(Long tenantId, String name, String email, String phone,String rentalHistory,String password) {
		
		this.tenantId = tenantId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password=password;
		this.rentalHistory = rentalHistory;
	}

	private Long tenantId;
    private String name;
    private String email;
    private String phone;
    private String password;
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String rentalHistory;
    public String getRentalHistory() {
		return rentalHistory;
	}

	public void setRentalHistory(String rentalHistory) {
		this.rentalHistory = rentalHistory;
	}

	
    // Getters
    public Long getTenantId() { return tenantId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
 // Setters
    public void setTenantId(Long tenantId) { this.tenantId = tenantId; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }


    
}