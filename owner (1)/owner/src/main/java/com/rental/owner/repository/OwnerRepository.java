package com.rental.owner.repository;

import com.rental.owner.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

	Owner findByEmail(String email);
}