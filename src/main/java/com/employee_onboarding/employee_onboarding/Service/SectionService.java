package com.employee_onboarding.employee_onboarding.Service;

import com.employee_onboarding.employee_onboarding.model.OsiDocumentAttachment;
import com.employee_onboarding.employee_onboarding.model.OsiProspectiveEmployeeDetails;
import com.employee_onboarding.employee_onboarding.model.ProspectiveEmployee;
import com.employee_onboarding.DTO.SectionDataDTO;
import com.employee_onboarding.employee_onboarding.Repository.OsiDocumentAttachmentRepository;
import com.employee_onboarding.employee_onboarding.Repository.OsiProspectiveEmployeeDetailsRepo;
import com.employee_onboarding.employee_onboarding.Repository.ProspectiveEmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SectionService {

    @Autowired
    private OsiDocumentAttachmentRepository documentRepo;

    @Autowired
    private OsiProspectiveEmployeeDetailsRepo detailsRepository;

    @Autowired
    private ProspectiveEmployeeRepository prospectiveEmployeeRepository;

    public OsiProspectiveEmployeeDetails getSectionWithDocuments(Long candidateId, String sectionType) {
        return detailsRepository.findByProspectiveEmployeeIdAndSectionType(candidateId, sectionType)
                .orElseThrow(() -> new RuntimeException("Section not found for candidate ID " + candidateId));
    }

    @Transactional
    public void saveOrSubmitSection(Long candidateId, String sectionType, String sectionData, boolean submit) {
        OsiProspectiveEmployeeDetails section = detailsRepository.findByProspectiveEmployeeIdAndSectionType(candidateId, sectionType)
                .orElseGet(() -> {
                    OsiProspectiveEmployeeDetails newSection = new OsiProspectiveEmployeeDetails();

                    ProspectiveEmployee employee = prospectiveEmployeeRepository.findById(candidateId)
                            .orElseThrow(() -> new RuntimeException("Candidate not found with ID " + candidateId));
                    newSection.setProspectiveEmployee(employee);

                    newSection.setSectionType(sectionType);
                    newSection.setCreatedAt(LocalDateTime.now());
                    newSection.setCreatedBy("system"); // ✅ Set createdBy
                    return newSection;
                });

        section.setSectionData(sectionData);
        section.setStatus(submit ? "Submitted" : "Draft");
        section.setUpdatedAt(LocalDateTime.now());
        section.setUpdatedBy("system"); // ✅ Set updatedBy

        detailsRepository.save(section);
    }

    public SectionDataDTO getSectionData(Long candidateId, String sectionType) {
        OsiProspectiveEmployeeDetails section = detailsRepository.findByProspectiveEmployeeIdAndSectionType(candidateId, sectionType)
                .orElseThrow(() -> new RuntimeException("Section not found for candidate ID " + candidateId));

        List<OsiDocumentAttachment> documents =
                documentRepo.findByEmployeeIdAndSectionType(candidateId, sectionType); // ✅ Uses correct repo method

        return new SectionDataDTO(section, documents);
    }

    @Transactional
    public void reviewSection(Long candidateId, String sectionType, String reviewer, String comments, String status) {
        OsiProspectiveEmployeeDetails section = detailsRepository.findByProspectiveEmployeeIdAndSectionType(candidateId, sectionType)
                .orElseThrow(() -> new RuntimeException("Section not found for candidate ID " + candidateId));

        section.setReviewedBy(reviewer);
        section.setReviewerComments(comments);
        section.setStatus(status); // "Reviewed", "Follow_Up", "Rejected", etc.
        section.setReviewedAt(LocalDateTime.now());
        section.setUpdatedBy(reviewer); // ✅ Update last updater

        detailsRepository.save(section);
    }

    public List<OsiDocumentAttachment> getDocumentsBySectionType(Long candidateId, String sectionType) {
        return documentRepo.findByEmployeeIdAndSectionType(candidateId, sectionType); 
    }
}
