package com.employee_onboarding.employee_onboarding.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employee_onboarding.employee_onboarding.Service.OsiDocumentAttachmentService;
import com.employee_onboarding.employee_onboarding.model.OsiDocumentAttachment;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/attachments")
public class OsiDocumentAttachmentController {

    @Autowired
    private OsiDocumentAttachmentService service;

    @PostMapping
    @Operation(
            summary = "Upload Document Attachment",
            description = "Creates and stores a new document attachment related to a prospective employee."
        )
    
    public ResponseEntity<OsiDocumentAttachment> create(@RequestBody OsiDocumentAttachment doc) {
        return ResponseEntity.ok(service.save(doc));
    }

    @GetMapping
    @Operation(
            summary = "Get All Attachments",
            description = "Retrieves a list of all document attachments stored in the system."
        )
    public ResponseEntity<List<OsiDocumentAttachment>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get Attachment by ID",
            description = "Fetches a single document attachment using its unique ID."
        )
    public ResponseEntity<OsiDocumentAttachment> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/employee/{empId}")
    @Operation(
            summary = "Get Attachments by Employee ID",
            description = "Fetches all document attachments associated with a specific prospective employee."
        )
    public ResponseEntity<List<OsiDocumentAttachment>> getByEmployeeId(@PathVariable Integer empId) {
        return ResponseEntity.ok(service.getByEmployeeId(empId));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete Attachment by ID",
            description = "Deletes a specific document attachment using its ID. Useful for managing or cleaning up uploads."
        )
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
