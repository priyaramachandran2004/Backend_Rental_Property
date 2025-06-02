package com.rental.owner.controller;

import com.rental.owner.dto.OwnerDTO;
import com.rental.owner.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;
    
    
    @PostMapping
    public OwnerDTO createOwner(@RequestBody OwnerDTO dto) {
        return ownerService.addOwner(dto);
    }

    @GetMapping("/{id}")
    public OwnerDTO getOwner(@PathVariable Long id) {
        return ownerService.getOwnerById(id);
    }

    @GetMapping
    public List<OwnerDTO> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @PutMapping("/{id}")
    public OwnerDTO updateOwner(@PathVariable Long id, @RequestBody OwnerDTO dto) {
        return ownerService.updateOwner(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
        return "Owner deleted successfully";
    }
    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> checkIfOwnerExists(@PathVariable Long id) {
        return ResponseEntity.ok(ownerService.existsById(id));
    }

}