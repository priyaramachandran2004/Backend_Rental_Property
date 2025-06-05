package com.rental.property.service;

import com.rental.property.client.OwnerClient;
import com.rental.property.dto.PropertyRequestDTO;
import com.rental.property.dto.PropertyResponseDTO;
import com.rental.property.exception.PropertyNotFoundException;

import com.rental.property.model.Property;
import com.rental.property.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository repository;

    @Autowired
    private OwnerClient ownerClient;
  
    @Override
    public PropertyResponseDTO addProperty(PropertyRequestDTO dto) {
        // ✅ Check if the owner exists before saving the property
        if (!ownerClient.checkIfOwnerExists(dto.getOwnerId())) {
            throw new PropertyNotFoundException("Owner not found with id: " + dto.getOwnerId());
        }

        // ✅ Convert DTO to Entity before saving
        Property property = new Property();
        property.setOwnerId(dto.getOwnerId());
        property.setAddress(dto.getAddress());
        property.setRentAmount(dto.getRentAmount());
        property.setAvailabilityStatus(dto.getAvailabilityStatus());
        property.setDescription(dto.getDescription());
        property.setName(dto.getName());

        Property saved = repository.save(property); // Save entity in the database
        return convertToResponseDTO(saved); // Convert Entity to DTO
    }

    @Override
    public PropertyResponseDTO updateProperty(Long id, PropertyRequestDTO dto) {
        if (!ownerClient.checkIfOwnerExists(dto.getOwnerId())) {
            throw new PropertyNotFoundException("Owner not found with id: " + dto.getOwnerId());
        }
        
        Property property = repository.findById(id)
                .orElseThrow(() -> new PropertyNotFoundException("Property not found with ID: " + id));

        // ✅ Update existing property
        property.setAddress(dto.getAddress());
        property.setRentAmount(dto.getRentAmount());
        property.setAvailabilityStatus(dto.getAvailabilityStatus());
        property.setDescription(dto.getDescription());
        property.setName(dto.getName());

        return convertToResponseDTO(repository.save(property));
    }

    @Override
    public void deleteProperty(Long id) {
        if (!repository.existsById(id)) {
            throw new PropertyNotFoundException("Property not found with ID: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<PropertyResponseDTO> getAllProperties() {
        return repository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyResponseDTO> getPropertiesByOwner(Long ownerId) {
        if (!ownerClient.checkIfOwnerExists(ownerId)) {
            throw new PropertyNotFoundException("Owner not found with ID: " + ownerId);
        }
        
        return repository.findByOwnerId(ownerId)
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PropertyResponseDTO getPropertyById(Long id) {
        // ✅ Implement method to return property by ID
        Property property = repository.findById(id)
                .orElseThrow(() -> new PropertyNotFoundException("Property not found with ID: " + id));
        
        return convertToResponseDTO(property);
    }

    private PropertyResponseDTO convertToResponseDTO(Property property) {
        return new PropertyResponseDTO(
                property.getPropertyId(),
                property.getOwnerId(),
                property.getAddress(),
                property.getRentAmount(),
                property.getAvailabilityStatus(),
                property.getDescription(),
                property.getName()
        );
    }
    
    @Override
    public boolean existsById(Long propertyId) {
        return repository.existsById(propertyId);
    }
}
