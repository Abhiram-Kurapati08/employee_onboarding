package com.employee_onboarding.employee_onboarding.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employee_onboarding.employee_onboarding.Service.ProspectiveEmployeeService;
import com.employee_onboarding.employee_onboarding.model.ProspectiveEmployee;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/prospective-employees")
public class ProspectiveEmployeeController {

    @Autowired
    private ProspectiveEmployeeService service;

    @PostMapping
    @Operation(
        summary = "Create Prospective Employee",
        description = "Creates a new prospective employee record. If the email already exists, it returns a 400 Bad Request."
    )
    public ResponseEntity<ProspectiveEmployee> create(@RequestBody ProspectiveEmployee employee) {
        if (service.emailExists(employee.getEmail())) {
            return ResponseEntity.badRequest().build(); // Or send custom message
        }
        return ResponseEntity.ok(service.saveEmployee(employee));
    }

    @GetMapping
    @Operation(
        summary = "Get All Prospective Employees",
        description = "Returns a list of all prospective employees currently present in the system."
    )
    public List<ProspectiveEmployee> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Get Prospective Employee by ID",
        description = "Fetches the details of a prospective employee using their unique ID."
    )
    public ResponseEntity<ProspectiveEmployee> getById(@PathVariable Integer id) {
        return service.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Delete Prospective Employee by ID",
        description = "Deletes a prospective employee record from the system using their ID."
    )
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "Update Prospective Employee",
        description = "Updates the details of a prospective employee using their ID. If the employee is not found, returns 404."
    )
    public ResponseEntity<ProspectiveEmployee> update(@PathVariable Integer id,
                                                      @RequestBody ProspectiveEmployee employee) {
        return service.getEmployeeById(id)
                .map(existing -> {
                    employee.setId(existing.getId());
                    return ResponseEntity.ok(service.saveEmployee(employee));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
