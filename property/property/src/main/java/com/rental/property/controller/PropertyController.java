package com.rental.property.controller;

import com.rental.property.dto.PropertyRequestDTO;
import com.rental.property.dto.PropertyResponseDTO;
import com.rental.property.service.PropertyService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
@RequiredArgsConstructor
public class PropertyController {
	 @Autowired
    private  PropertyService propertyService;

    @PostMapping
    public ResponseEntity<PropertyResponseDTO> addProperty(@RequestBody PropertyRequestDTO dto) {
        return ResponseEntity.ok(propertyService.addProperty(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropertyResponseDTO> updateProperty(@PathVariable Long id, @RequestBody PropertyRequestDTO dto) {
        return ResponseEntity.ok(propertyService.updateProperty(id, dto));
    }

    @DeleteMapping("/{id}")
    public String deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
       return "Property deleted successfully";
    }

    @GetMapping
    public ResponseEntity<List<PropertyResponseDTO>> getAllProperties() {
        return ResponseEntity.ok(propertyService.getAllProperties());
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<PropertyResponseDTO>> getPropertiesByOwner(@PathVariable Long ownerId) {
        return ResponseEntity.ok(propertyService.getPropertiesByOwner(ownerId));
    }
    
    @GetMapping("/exists/{propertyId}")
    public boolean checkIfPropertyExists(@PathVariable Long propertyId) {
        return propertyService.existsById(propertyId);
    }
}