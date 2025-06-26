package com.employee_onboarding.employee_onboarding.Controller;

import com.employee_onboarding.employee_onboarding.model.OsiProspectiveEmployeeDetails;
import com.employee_onboarding.DTO.SectionDataDTO;
import com.employee_onboarding.employee_onboarding.Service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/candidate/{id}/sections")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping("/{sectionType}")
    public ResponseEntity<SectionDataDTO> getSection(
            @PathVariable Long id,
            @PathVariable String sectionType) {
        return ResponseEntity.ok(sectionService.getSectionData(id, sectionType));
    }

    @PutMapping("/{sectionType}")
    public ResponseEntity<String> saveOrSubmitSection(
            @PathVariable Long id,
            @PathVariable String sectionType,
            @RequestBody Map<String, Object> payload) {
        String data = payload.get("sectionData").toString();
        boolean submit = Boolean.parseBoolean(payload.getOrDefault("submit", "false").toString());
        sectionService.saveOrSubmitSection(id, sectionType, data, submit);
        return ResponseEntity.ok("Section saved" + (submit ? " and submitted." : "."));
    }

    @PutMapping("/{sectionType}/review")
    public ResponseEntity<String> reviewSection(
            @PathVariable Long id,
            @PathVariable String sectionType,
            @RequestBody Map<String, String> payload) {
        String reviewer = payload.get("reviewedBy");
        String comments = payload.get("reviewerComments");
        String status = payload.get("status"); // e.g., "Reviewed", "Follow_Up"
        sectionService.reviewSection(id, sectionType, reviewer, comments, status);
        return ResponseEntity.ok("Section reviewed.");
    }
}
