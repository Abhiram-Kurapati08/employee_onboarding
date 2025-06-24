package com.employee_onboarding.employee_onboarding.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employee_onboarding.employee_onboarding.Exception.RecordNotFoundException;
import com.employee_onboarding.employee_onboarding.Service.SystemConfigurationService;
import com.employee_onboarding.employee_onboarding.model.SystemConfiguration;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/system-config")
public class SystemConfigurationController {

    @Autowired
    private SystemConfigurationService systemConfigurationService;

    @GetMapping
    @Operation(
        summary = "Get All System Configurations",
        description = "Returns a list of all system configuration entries defined in the application."
    )
    public ResponseEntity<List<SystemConfiguration>> getAllConfigs() {
        List<SystemConfiguration> configs = systemConfigurationService.getAllConfigurations();
        return ResponseEntity.ok(configs);
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Get Configuration by ID",
        description = "Fetches a single system configuration record by its unique ID. Throws 404 if not found."
    )
    public ResponseEntity<SystemConfiguration> getConfigById(@PathVariable Long id) throws RecordNotFoundException {
        SystemConfiguration config = systemConfigurationService.getConfigById(id);
        return ResponseEntity.ok(config);
    }

    @PostMapping
    @Operation(
        summary = "Create or Update Configuration",
        description = "Creates a new configuration or updates an existing one based on the presence of an ID in the request."
    )
    public ResponseEntity<SystemConfiguration> createOrUpdateConfig(@RequestBody SystemConfiguration config) {
        SystemConfiguration saved = systemConfigurationService.createOrUpdateConfig(config);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Delete Configuration by ID",
        description = "Deletes the configuration record with the given ID from the system."
    )
    public ResponseEntity<String> deleteConfig(@PathVariable Long id) throws RecordNotFoundException {
        systemConfigurationService.deleteConfigById(id);
        return ResponseEntity.ok("Deleted configuration with ID: " + id);
    }
}
