package com.employee_onboarding.employee_onboarding.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee_onboarding.employee_onboarding.model.OsiDocumentAttachment;

public interface OsiDocumentAttachmentRepository extends JpaRepository<OsiDocumentAttachment, Integer> {

    // ✅ Find all active (non-deleted) documents by candidate
    List<OsiDocumentAttachment> findByProspectiveEmployeeIdAndIsDeletedFalse(Integer empId);

    // ✅ Find by docCategory (e.g., "Professional", "Personal", etc.)
    List<OsiDocumentAttachment> findByProspectiveEmployeeIdAndDocCategory(Long prospectiveEmployeeId, String docCategory);

    // ❌ REMOVE — INVALID METHOD (this is the cause of the error)
    // List<OsiDocumentAttachment> findByProspectiveEmployeeIdAndSectionType(Long prospectiveEmployeeId, String docCategory);

    // ✅ Custom query to filter by section type from related entity
    @Query("SELECT d FROM OsiDocumentAttachment d " +
           "JOIN d.prospectiveEmployeeDetail detail " +
           "WHERE d.prospectiveEmployee.id = :employeeId " +
           "AND detail.sectionType = :sectionType")
    List<OsiDocumentAttachment> findByEmployeeIdAndSectionType(@Param("employeeId") Long employeeId,
                                                               @Param("sectionType") String sectionType);
}
