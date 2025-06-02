package com.rental.lease.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "tenant", url = "http://localhost:8083/api/tenants")
public interface TenantClient {
    @GetMapping("/exists/{id}")
    boolean checkIfTenantExists(@PathVariable Long id);
}