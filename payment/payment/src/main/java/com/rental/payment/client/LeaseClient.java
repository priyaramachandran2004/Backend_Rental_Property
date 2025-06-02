package com.rental.payment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "lease", url = "http://localhost:8085/api/leases")
public interface LeaseClient {

    @GetMapping("/exists/{leaseId}")
    boolean checkIfLeaseExists(@PathVariable Long leaseId);
}