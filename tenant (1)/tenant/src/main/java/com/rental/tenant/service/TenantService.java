package com.rental.tenant.service;

import com.rental.tenant.dto.TenantRequestDTO;
import com.rental.tenant.dto.TenantResponseDTO;
import com.rental.tenant.model.Tenant;

import java.util.List;
import java.util.Optional;

public interface TenantService {
    TenantResponseDTO registerTenant(TenantRequestDTO dto);
    TenantResponseDTO getTenantById(Long id);
    List<TenantResponseDTO> getAllTenants();
    TenantResponseDTO updateTenant(Long id, TenantRequestDTO dto);
    void deleteTenant(Long id);
	boolean existsById(Long tenantId);
	TenantResponseDTO getTenantByEmail(String email);
}