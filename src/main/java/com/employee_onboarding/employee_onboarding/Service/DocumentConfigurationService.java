package com.employee_onboarding.employee_onboarding.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_onboarding.employee_onboarding.Repository.DocumentConfigurationRepository;
import com.employee_onboarding.employee_onboarding.model.DocumentConfiguration;

@Service
public class DocumentConfigurationService {

    @Autowired
    private DocumentConfigurationRepository repository;

    public List<DocumentConfiguration> getAll() {
        return repository.findAll();
    }

    public Optional<DocumentConfiguration> getById(Integer id) {
        return repository.findById(id);
    }

    public DocumentConfiguration create(DocumentConfiguration config) {
        return repository.save(config);
    }

    public DocumentConfiguration update(Integer id, DocumentConfiguration updated) {
        return repository.findById(id).map(existing -> {
            existing.setEmployeeType(updated.getEmployeeType());
            existing.setDocCategory(updated.getDocCategory());
            existing.setDocType(updated.getDocType());
            existing.setEffectiveStartDate(updated.getEffectiveStartDate());
            existing.setEffectiveEndDate(updated.getEffectiveEndDate());
            existing.setIsMandatory(updated.getIsMandatory());
            existing.setIsActive(updated.getIsActive());
            existing.setUpdatedBy(updated.getUpdatedBy());
            existing.setUpdatedAt(java.time.LocalDateTime.now());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
