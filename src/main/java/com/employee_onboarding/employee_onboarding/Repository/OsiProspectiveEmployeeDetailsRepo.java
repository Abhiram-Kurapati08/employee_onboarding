package com.employee_onboarding.employee_onboarding.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee_onboarding.employee_onboarding.model.OsiProspectiveEmployeeDetails;

import java.util.List;

@Repository
public interface OsiProspectiveEmployeeDetailsRepo extends JpaRepository<OsiProspectiveEmployeeDetails, Long> {

    List<OsiProspectiveEmployeeDetails> findByProspectiveEmployeeId(Long prospectiveEmployeeId);

    List<OsiProspectiveEmployeeDetails> findByStatus(String status);

    List<OsiProspectiveEmployeeDetails> findBySectionType(String sectionType);

    List<OsiProspectiveEmployeeDetails> findBySubmittedAtNotNull();

    // Custom query if needed: find all approved sections
    List<OsiProspectiveEmployeeDetails> findByStatusAndReviewedAtNotNull(String status);

	List<OsiProspectiveEmployeeDetails> findByReviewedAtIsNotNull();
}
