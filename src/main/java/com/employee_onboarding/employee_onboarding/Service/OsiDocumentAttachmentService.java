package com.employee_onboarding.employee_onboarding.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_onboarding.employee_onboarding.Repository.OsiDocumentAttachmentRepository;
import com.employee_onboarding.employee_onboarding.model.OsiDocumentAttachment;

import java.util.List;
import java.util.Optional;

@Service
public class OsiDocumentAttachmentService {

    @Autowired
    private OsiDocumentAttachmentRepository repository;

    public OsiDocumentAttachment save(OsiDocumentAttachment doc) {
        return repository.save(doc);
    }

    public List<OsiDocumentAttachment> getAll() {
        return repository.findAll();
    }

    public Optional<OsiDocumentAttachment> getById(Integer id) {
        return repository.findById(id);
    }

    public List<OsiDocumentAttachment> getByEmployeeId(Integer empId) {
        return repository.findByProspectiveEmployeeIdAndIsDeletedFalse(empId);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
     public List<OsiDocumentAttachment> getAttachmentsByEmployeeAndSection(Long employeeId, String sectionType) {
        return repository.findByEmployeeIdAndSectionType(employeeId, sectionType);
    }
}
