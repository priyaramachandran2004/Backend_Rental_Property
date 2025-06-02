package com.rental.property.service;

import com.rental.property.dto.PropertyRequestDTO;
import com.rental.property.dto.PropertyResponseDTO;

import java.util.List;

public interface PropertyService {
	
    PropertyResponseDTO addProperty(PropertyRequestDTO dto);
    PropertyResponseDTO updateProperty(Long id, PropertyRequestDTO dto);
    void deleteProperty(Long id);
    List<PropertyResponseDTO> getAllProperties();
    List<PropertyResponseDTO> getPropertiesByOwner(Long ownerId);
    boolean existsById(Long propertyId);
}