package com.employee_onboarding.employee_onboarding.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee_onboarding.employee_onboarding.model.OsiAuditTrail;

@Repository
public interface OsiAuditTrailRepository extends JpaRepository<OsiAuditTrail, Long> {
    
}
