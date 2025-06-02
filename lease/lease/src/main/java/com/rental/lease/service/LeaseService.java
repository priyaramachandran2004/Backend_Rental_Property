package com.rental.lease.service;

import com.rental.lease.dto.LeaseRequestDTO;
import com.rental.lease.dto.LeaseResponseDTO;

import java.util.List;

public interface LeaseService {
    LeaseResponseDTO createLease(LeaseRequestDTO dto);
    LeaseResponseDTO updateLease(Long id, LeaseRequestDTO dto);
    void deleteLease(Long id);
    List<LeaseResponseDTO> getAllLeases();
    List<LeaseResponseDTO> getLeasesByTenant(Long tenantId);
    List<LeaseResponseDTO> getLeasesByProperty(Long propertyId);
	boolean checkIfLeaseExists(Long leaseId);
}