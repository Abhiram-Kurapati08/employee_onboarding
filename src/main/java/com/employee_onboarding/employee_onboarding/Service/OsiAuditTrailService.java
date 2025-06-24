package com.employee_onboarding.employee_onboarding.Service;
import org.springframework.stereotype.Service;

import com.employee_onboarding.employee_onboarding.Repository.OsiAuditTrailRepository;
import com.employee_onboarding.employee_onboarding.model.OsiAuditTrail;

import java.util.List;
import java.util.Optional;

@Service
public class OsiAuditTrailService {

    private final OsiAuditTrailRepository repository;

    public OsiAuditTrailService(OsiAuditTrailRepository repository) {
        this.repository = repository;
    }

    public OsiAuditTrail save(OsiAuditTrail auditTrail) {
        return repository.save(auditTrail);
    }

    public List<OsiAuditTrail> findAll() {
        return repository.findAll();
    }

    public Optional<OsiAuditTrail> findById(Long id) {
        return repository.findById(id);
    }
}


