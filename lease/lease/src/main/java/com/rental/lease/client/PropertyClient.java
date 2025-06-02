package com.rental.lease.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "property", url = "http://localhost:8084/api/properties")
public interface PropertyClient {
    @GetMapping("/exists/{id}")
    boolean checkIfPropertyExists(@PathVariable Long id);
}