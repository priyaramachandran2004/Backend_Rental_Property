package com.rental.tenant.repository;

import com.rental.tenant.model.Tenant;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
	Tenant findByEmail(String email);
}