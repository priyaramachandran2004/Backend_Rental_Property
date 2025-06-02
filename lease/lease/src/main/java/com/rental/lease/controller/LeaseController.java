package com.rental.lease.controller;

import com.rental.lease.dto.LeaseRequestDTO;
import com.rental.lease.dto.LeaseResponseDTO;
import com.rental.lease.service.LeaseService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leases")
@RequiredArgsConstructor
public class LeaseController {

	@Autowired
    private  LeaseService service;

    @PostMapping
    public LeaseResponseDTO createLease(@RequestBody LeaseRequestDTO dto) {
        return service.createLease(dto);
    }

    @PutMapping("/{id}")
    public LeaseResponseDTO updateLease(@PathVariable Long id, @RequestBody LeaseRequestDTO dto) {
        return service.updateLease(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteLease(@PathVariable Long id) {
        service.deleteLease(id);
        return "Lease deleted Sucessfully";
    }

    @GetMapping
    public List<LeaseResponseDTO> getAllLeases() {
        return service.getAllLeases();
    }

    @GetMapping("/tenant/{tenantId}")
    public List<LeaseResponseDTO> getLeasesByTenant(@PathVariable Long tenantId) {
        return service.getLeasesByTenant(tenantId);
    }

    @GetMapping("/property/{propertyId}")
    public List<LeaseResponseDTO> getLeasesByProperty(@PathVariable Long propertyId) {
        return service.getLeasesByProperty(propertyId);
    }
    @GetMapping("/exists/{leaseId}")
    public boolean checkIfLeaseExists(@PathVariable Long leaseId) {
        return service.checkIfLeaseExists(leaseId);
    }
}