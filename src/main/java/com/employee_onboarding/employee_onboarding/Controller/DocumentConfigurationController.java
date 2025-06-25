package com.employee_onboarding.employee_onboarding.Controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employee_onboarding.employee_onboarding.Service.DocumentConfigurationService;
import com.employee_onboarding.employee_onboarding.model.DocumentConfiguration;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/document-config-")
public class DocumentConfigurationController {

    @Autowired
    private DocumentConfigurationService service;

    @GetMapping
    
    public List<DocumentConfiguration> getAllConfigs() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Get Document Configuration by ID",
        description = "Fetches a specific document configuration using its unique ID."
    )
    public ResponseEntity<DocumentConfiguration> getById(@PathVariable Integer id) {
        Optional<DocumentConfiguration> config = service.getById(id);
        return config.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(
        summary = "Create New Document Configuration",
        description = "Creates a new document configuration with the provided details."
    )
    public ResponseEntity<DocumentConfiguration> createConfig(@RequestBody DocumentConfiguration config) {
        DocumentConfiguration created = service.create(config);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "Update Existing Document Configuration",
        description = "Updates the document configuration identified by the given ID with new values."
    )
    public ResponseEntity<DocumentConfiguration> updateConfig(
            @PathVariable Integer id,
            @RequestBody DocumentConfiguration updatedConfig) {
        try {
            DocumentConfiguration updated = service.update(id, updatedConfig);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Delete Document Configuration",
        description = "Deletes the document configuration associated with the specified ID."
    )
    public ResponseEntity<Void> deleteConfig(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
