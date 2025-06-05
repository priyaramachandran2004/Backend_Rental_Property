package com.rental.owner.service;

import com.rental.owner.dto.OwnerDTO;
import java.util.List;

public interface OwnerService {
    OwnerDTO addOwner(OwnerDTO ownerDTO);
    OwnerDTO getOwnerById(Long id);
    List<OwnerDTO> getAllOwners();
    OwnerDTO updateOwner(Long id, OwnerDTO ownerDTO);
    void deleteOwner(Long id);
	boolean existsById(Long id);
	OwnerDTO getOwnerByEmail(String email);
}