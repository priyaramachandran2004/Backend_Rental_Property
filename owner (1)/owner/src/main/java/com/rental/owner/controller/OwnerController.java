package com.rental.owner.controller;
 
import com.rental.owner.dto.OwnerDTO;
import com.rental.owner.repository.OwnerRepository;
import com.rental.owner.service.OwnerService;
 
 
import org.apache.hc.core5.http.HttpStatus;
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
    @Autowired
    private OwnerRepository ownerRepository;
    
    
    
    @PostMapping
    public ResponseEntity<?> createOwner(@RequestBody OwnerDTO dto) {
        if (ownerRepository.findByEmail(dto.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.SC_CONFLICT).body("Owner already exists!");
        }
       OwnerDTO newTenant = ownerService.addOwner(dto);
        return ResponseEntity.ok(newTenant);
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
    @GetMapping("login/{email}")
    public OwnerDTO getOwnerByEmail(@PathVariable String email) {
        return ownerService.getOwnerByEmail(email);
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