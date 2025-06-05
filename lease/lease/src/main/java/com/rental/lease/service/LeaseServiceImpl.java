package com.rental.lease.service;

import com.rental.lease.client.PropertyClient;
import com.rental.lease.client.TenantClient;
import com.rental.lease.dto.LeaseRequestDTO;
import com.rental.lease.dto.LeaseResponseDTO;
import com.rental.lease.exception.ResourceNotFoundException;
import com.rental.lease.model.Lease;
import com.rental.lease.repository.LeaseRepository;


import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeaseServiceImpl implements LeaseService {
	@Autowired
    private  LeaseRepository repository;
	@Autowired
    private  TenantClient tenantClient;
	@Autowired
    private  PropertyClient propertyClient;

    @Override
    public LeaseResponseDTO createLease(LeaseRequestDTO dto) {
        if (!tenantClient.checkIfTenantExists(dto.getTenantId())) {
            throw new ResourceNotFoundException("Tenant not found with id: " + dto.getTenantId());
        }

        if (!propertyClient.checkIfPropertyExists(dto.getPropertyId())) {
            throw new ResourceNotFoundException("Property not found with id: " + dto.getPropertyId());
        }

        Lease lease = new Lease();
        lease.setTenantId(dto.getTenantId());
        lease.setPropertyId(dto.getPropertyId());
        lease.setDuration(dto.getDuration());
        lease.setRentAmount(dto.getRentAmount());

        Lease saved = repository.save(lease);
        return convertToResponse(saved);
    }

    @Override
    public LeaseResponseDTO updateLease(Long id, LeaseRequestDTO dto) {
    	 if (!tenantClient.checkIfTenantExists(dto.getTenantId())) {
             throw new ResourceNotFoundException("Tenant not found with id: " + dto.getTenantId());
         }

         if (!propertyClient.checkIfPropertyExists(dto.getPropertyId())) {
             throw new ResourceNotFoundException("Property not found with id: " + dto.getPropertyId());
         }
        Lease lease = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lease not found with ID: " + id));

        lease.setDuration(dto.getDuration());
        lease.setRentAmount(dto.getRentAmount());

        Lease updated = repository.save(lease);
        return convertToResponse(updated);
    }

    @Override
    public void deleteLease(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Lease not found with ID: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<LeaseResponseDTO> getAllLeases() {
        return repository.findAll().stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    @Override
    public List<LeaseResponseDTO> getLeasesByTenant(Long tenantId) {
        return repository.findByTenantId(tenantId).stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    @Override
    public List<LeaseResponseDTO> getLeasesByProperty(Long propertyId) {
        return repository.findByPropertyId(propertyId).stream().map(this::convertToResponse).collect(Collectors.toList());
    }
    @Override
    public boolean checkIfLeaseExists(Long leaseId) {
        return repository.existsById(leaseId);
    }
    private LeaseResponseDTO convertToResponse(Lease lease) {
        LeaseResponseDTO response = new LeaseResponseDTO();
        response.setLeaseId(lease.getLeaseId());
        response.setTenantId(lease.getTenantId());
        response.setPropertyId(lease.getPropertyId());
        response.setDuration(lease.getDuration());
        response.setRentAmount(lease.getRentAmount());
        return response;
    }
    public LeaseResponseDTO getLeaseById(Long id) {
        Lease lease = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lease not found with ID: " + id));

        return convertToResponse(lease);
    }
	
}
