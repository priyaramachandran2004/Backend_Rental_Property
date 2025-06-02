package com.rental.tenant.service;

import com.rental.tenant.dto.TenantRequestDTO;
import com.rental.tenant.dto.TenantResponseDTO;
import com.rental.tenant.exception.TenantNotFoundException;
import com.rental.tenant.model.Tenant;
import com.rental.tenant.repository.TenantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    private TenantResponseDTO mapToResponseDTO(Tenant tenant) {
        TenantResponseDTO responseDTO=new TenantResponseDTO();
        responseDTO.setTenantId(tenant.getTenantId());
        responseDTO.setName(tenant.getName());
        responseDTO.setEmail(tenant.getEmail());
        responseDTO.setPhone(tenant.getPhone());
        responseDTO.setPassword(tenant.getPassword());
        responseDTO.setRentalHistory(tenant.getRentalHistory());
        return responseDTO;
    }

    private Tenant mapToEntity(TenantRequestDTO dto) {
        Tenant tenant = new Tenant();
        tenant.setName(dto.getName());
        tenant.setEmail(dto.getEmail());
        tenant.setPhone(dto.getPhone());
        tenant.setPassword(dto.getPassword());
        tenant.setRentalHistory(dto.getRentalHistory());
        return tenant;
    }

    @Override
    public TenantResponseDTO registerTenant(TenantRequestDTO dto) {
        Tenant tenant = tenantRepository.save(mapToEntity(dto));
        return mapToResponseDTO(tenant);
    }

    @Override
    public TenantResponseDTO getTenantById(Long id) {
        Tenant tenant = tenantRepository.findById(id)
                .orElseThrow(() -> new TenantNotFoundException("Tenant not found with id: " + id));
        return mapToResponseDTO(tenant);
    }

    @Override
    public List<TenantResponseDTO> getAllTenants() {
        return tenantRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TenantResponseDTO updateTenant(Long id, TenantRequestDTO dto) {
        Tenant existing = tenantRepository.findById(id)
                .orElseThrow(() -> new TenantNotFoundException("Tenant not found with id: " + id));

        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        existing.setPhone(dto.getPhone());
        existing.setRentalHistory(dto.getRentalHistory());

        Tenant updated = tenantRepository.save(existing);
        return mapToResponseDTO(updated);
    }

    @Override
    public void deleteTenant(Long id) {
        if (!tenantRepository.existsById(id)) {
            throw new TenantNotFoundException("Tenant not found with id: " + id);
        }
        tenantRepository.deleteById(id);
    }
    
    public boolean existsById(Long tenantId) {
        return tenantRepository.existsById(tenantId);
    }

	@Override
	public TenantResponseDTO getTenantByEmail(String email) {
		Tenant tenant = tenantRepository.findByEmail(email);
        return mapToResponseDTO(tenant);
	}
}
