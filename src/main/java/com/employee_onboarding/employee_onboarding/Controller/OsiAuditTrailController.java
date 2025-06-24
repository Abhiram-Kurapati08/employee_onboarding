package com.employee_onboarding.employee_onboarding.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employee_onboarding.employee_onboarding.Service.OsiAuditTrailService;
import com.employee_onboarding.employee_onboarding.model.OsiAuditTrail;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/audit-trails")
public class OsiAuditTrailController {

    private final OsiAuditTrailService service;

    public OsiAuditTrailController(OsiAuditTrailService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
        summary = "Get All Audit Trails",
        description = "Retrieves all audit trail records stored in the system. Useful for auditing actions performed by users or the system."
    )
    public List<OsiAuditTrail> getAllAuditTrails() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Get Audit Trail by ID",
        description = "Fetches a specific audit trail record using the given unique ID. This is useful to track a particular operation or employee’s activity."
    )
    public ResponseEntity<OsiAuditTrail> getAuditTrailById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(
        summary = "Create New Audit Trail Entry",
        description = "Creates and saves a new audit trail entry. Typically called internally to log a system or user action."
    )
    public OsiAuditTrail createAuditTrail(@RequestBody OsiAuditTrail auditTrail) {
        return service.save(auditTrail);
    }
}
