package com.employee_onboarding.employee_onboarding.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employee_onboarding.employee_onboarding.Exception.RecordNotFoundException;
import com.employee_onboarding.employee_onboarding.Service.OsiProspectiveEmployeeDetailsService;
import com.employee_onboarding.employee_onboarding.model.OsiProspectiveEmployeeDetails;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/employee-details")
public class OsiProspectiveEmployeeDetailsController {

    @Autowired
    private OsiProspectiveEmployeeDetailsService Empservice;

    @GetMapping
    @Operation(
        summary = "Get All Employee Details",
        description = "Fetches all section records submitted by prospective employees across the system."
    )
    public ResponseEntity<List<OsiProspectiveEmployeeDetails>> getAllDetails() {
        return ResponseEntity.ok(Empservice.getAllDetails());
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Get Details by ID",
        description = "Retrieves a single record of section details using its unique database ID."
    )
    public ResponseEntity<OsiProspectiveEmployeeDetails> getDetailsById(@PathVariable Long id) throws RecordNotFoundException {
        return ResponseEntity.ok(Empservice.getDetailsById(id));
    }

    @GetMapping("/by-employee/{employeeId}")
    @Operation(
        summary = "Get Details by Employee ID",
        description = "Fetches all section records submitted by a specific prospective employee."
    )
    public ResponseEntity<List<OsiProspectiveEmployeeDetails>> getByEmployeeId(@PathVariable Long employeeId) {
        return ResponseEntity.ok(Empservice.getByProspectiveEmployeeId(employeeId));
    }

    @GetMapping("/by-section/{sectionType}")
    @Operation(
        summary = "Get Details by Section Type",
        description = "Fetches section details by section type such as 'PERSONAL', 'BANK', or 'DOCUMENT'."
    )
    public ResponseEntity<List<OsiProspectiveEmployeeDetails>> getBySection(@PathVariable String sectionType) {
        return ResponseEntity.ok(Empservice.getBySectionType(sectionType));
    }

    @GetMapping("/by-status/{status}")
    @Operation(
        summary = "Get Details by Status",
        description = "Returns all section entries that match the provided status like 'SUBMITTED', 'REVIEWED', etc."
    )
    public ResponseEntity<List<OsiProspectiveEmployeeDetails>> getByStatus(@PathVariable String status) {
        return ResponseEntity.ok(Empservice.getByStatus(status));
    }

    @PostMapping
    @Operation(
        summary = "Create New Section Details",
        description = "Creates a new section entry for a prospective employee (e.g., when they fill a form)."
    )
    public ResponseEntity<OsiProspectiveEmployeeDetails> createDetails(@RequestBody OsiProspectiveEmployeeDetails details) {
        return ResponseEntity.ok(Empservice.createDetails(details));
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "Update Section Details",
        description = "Updates an existing section entry using its ID and new data provided."
    )
    public ResponseEntity<OsiProspectiveEmployeeDetails> updateDetails(@PathVariable Long id, @RequestBody OsiProspectiveEmployeeDetails updated) throws RecordNotFoundException {
        return ResponseEntity.ok(Empservice.updateDetails(id, updated));
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Delete Section Entry by ID",
        description = "Deletes a specific record from the system using its unique ID."
    )
    public ResponseEntity<String> deleteDetails(@PathVariable Long id) throws RecordNotFoundException {
        Empservice.deleteDetails(id);
        return ResponseEntity.ok("Record deleted successfully.");
    }

    @GetMapping("/reviewed")
    @Operation(
        summary = "Get Reviewed Sections",
        description = "Fetches all section records that have already been reviewed by HR/admin."
    )
    public ResponseEntity<List<OsiProspectiveEmployeeDetails>> getReviewedRecords() {
        return ResponseEntity.ok(Empservice.getReviewedRecords());
    }
}
