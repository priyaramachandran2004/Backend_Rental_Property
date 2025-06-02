package com.rental.owner.service;

import com.rental.owner.dto.OwnerDTO;
import com.rental.owner.exception.OwnerNotFoundException;
import com.rental.owner.model.Owner;
import com.rental.owner.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public  class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;
    
    private OwnerDTO mapToDTO(Owner owner) {
        return new OwnerDTO(owner.getOwnerId(), owner.getName(), owner.getEmail(), owner.getPhone());
    }

    private Owner mapToEntity(OwnerDTO dto) {
        return new Owner(dto.getOwnerId(), dto.getName(), dto.getEmail(), dto.getPhone());
    }

    @Override
    public OwnerDTO addOwner(OwnerDTO ownerDTO) {
        Owner saved = ownerRepository.save(mapToEntity(ownerDTO));
        return mapToDTO(saved);
    }

    @Override
    public OwnerDTO getOwnerById(Long id) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new OwnerNotFoundException("Owner not found with ID: " + id));
        return mapToDTO(owner);
    }

    @Override
    public List<OwnerDTO> getAllOwners() {
        return ownerRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public OwnerDTO updateOwner(Long id, OwnerDTO ownerDTO) {
        Owner existing = ownerRepository.findById(id)
                .orElseThrow(() -> new OwnerNotFoundException("Owner not found with ID: " + id));

        existing.setName(ownerDTO.getName());
        existing.setEmail(ownerDTO.getEmail());
        existing.setPhone(ownerDTO.getPhone());
       

        return mapToDTO(ownerRepository.save(existing));
    }

    @Override
    public void deleteOwner(Long id) {
        if (!ownerRepository.existsById(id)) {
            throw new OwnerNotFoundException("Owner not found with ID: " + id);
        }
        ownerRepository.deleteById(id);
    }
    @Override
    public boolean existsById(Long id) {
        return ownerRepository.existsById(id);
    }
}