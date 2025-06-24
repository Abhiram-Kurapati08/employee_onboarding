package com.employee_onboarding.employee_onboarding.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_onboarding.employee_onboarding.Exception.RecordNotFoundException;
import com.employee_onboarding.employee_onboarding.Repository.OsiProspectiveEmployeeDetailsRepo;
import com.employee_onboarding.employee_onboarding.model.OsiProspectiveEmployeeDetails;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class OsiProspectiveEmployeeDetailsService {

    @Autowired
    private OsiProspectiveEmployeeDetailsRepo repository;

    public List<OsiProspectiveEmployeeDetails> getAllDetails() {
        return repository.findAll();
    }

    public OsiProspectiveEmployeeDetails getDetailsById(Long id) throws RecordNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No record found with ID: " + id));
    }

    public List<OsiProspectiveEmployeeDetails> getByProspectiveEmployeeId(Long empId) {
        return repository.findByProspectiveEmployeeId(empId);
    }

    public List<OsiProspectiveEmployeeDetails> getBySectionType(String sectionType) {
        return repository.findBySectionType(sectionType);
    }

    public List<OsiProspectiveEmployeeDetails> getByStatus(String status) {
        return repository.findByStatus(status);
    }

    public OsiProspectiveEmployeeDetails createDetails(OsiProspectiveEmployeeDetails details) {
        details.setId(null);
        details.setCreatedAt(LocalDateTime.now());
        details.setUpdatedAt(LocalDateTime.now());
        return repository.save(details);
    }

    public OsiProspectiveEmployeeDetails updateDetails(Long id, OsiProspectiveEmployeeDetails newDetails) throws RecordNotFoundException {
        OsiProspectiveEmployeeDetails existing = getDetailsById(id);

        existing.setSectionType(newDetails.getSectionType());
        existing.setSectionData(newDetails.getSectionData());
        existing.setStatus(newDetails.getStatus());
        existing.setReviewerComments(newDetails.getReviewerComments());
        existing.setReviewedBy(newDetails.getReviewedBy());
        existing.setSubmittedAt(newDetails.getSubmittedAt());
        existing.setReviewedAt(LocalDateTime.now());
        existing.setUpdatedBy(newDetails.getUpdatedBy());
        existing.setUpdatedAt(LocalDateTime.now());

        return repository.save(existing);
    }

    public void deleteDetails(Long id) throws RecordNotFoundException {
        OsiProspectiveEmployeeDetails details = getDetailsById(id);
        repository.delete(details);
    }

    public List<OsiProspectiveEmployeeDetails> getReviewedRecords() {
        return repository.findByReviewedAtIsNotNull();
    }
}
