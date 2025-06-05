package com.rental.tenant.controller;

import com.rental.tenant.dto.TenantRequestDTO;
import com.rental.tenant.dto.TenantResponseDTO;
import com.rental.tenant.model.Tenant;
import com.rental.tenant.repository.TenantRepository;
import com.rental.tenant.service.TenantService;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController

@CrossOrigin(origins = "http://localhost:5173")

@RequestMapping("/api/tenants")
public class TenantController {

    @Autowired
    private TenantService tenantService;
    @Autowired
    private TenantRepository tenantRepository;

    @PostMapping
    public ResponseEntity<?> registerTenant(@RequestBody TenantRequestDTO dto) {
        if (tenantRepository.findByEmail(dto.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.SC_CONFLICT).body("Tenant already exists!");
        }
        TenantResponseDTO newTenant = tenantService.registerTenant(dto);
        return ResponseEntity.ok(newTenant);
    }

    @GetMapping("/{id}")
    public TenantResponseDTO getTenantById(@PathVariable Long id) {
        return tenantService.getTenantById(id);
    }
    @GetMapping("login/{email}")
    public TenantResponseDTO getTenantByEmail(@PathVariable String email) {
        return tenantService.getTenantByEmail(email);
    }

    @GetMapping
    public List<TenantResponseDTO> getAllTenants() {
        return tenantService.getAllTenants();
    }

    @PutMapping("/{id}")
    public TenantResponseDTO updateTenant(@PathVariable Long id, @RequestBody TenantRequestDTO dto) {
        return tenantService.updateTenant(id, dto);
    }

   
    @DeleteMapping("/{id}")
    public String deleteTenant(@PathVariable Long id) {
    	tenantService.deleteTenant(id);
        return "Tenant deleted successfully";
    }
    
    @GetMapping("/exists/{tenantId}")
    public boolean checkIfTenantExists(@PathVariable Long tenantId) {
        return tenantService.existsById(tenantId);
    }
}