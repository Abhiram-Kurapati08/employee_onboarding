package com.employee_onboarding.employee_onboarding.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_onboarding.employee_onboarding.model.OsiDocumentAttachment;

public interface OsiDocumentAttachmentRepository extends JpaRepository<OsiDocumentAttachment,Integer>{
    List<OsiDocumentAttachment> findByProspectiveEmployeeIdAndIsDeletedFalse(Integer empId);

}
