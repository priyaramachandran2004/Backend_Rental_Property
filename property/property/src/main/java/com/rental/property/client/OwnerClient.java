package com.rental.property.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "owner", url = "http://localhost:8082") // replace port if needed
public interface OwnerClient {

    @GetMapping("/api/owners/{id}/exists")
    boolean checkIfOwnerExists(@PathVariable("id") Long id);
}