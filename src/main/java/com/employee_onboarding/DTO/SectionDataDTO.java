package com.employee_onboarding.DTO;

import com.employee_onboarding.employee_onboarding.model.OsiProspectiveEmployeeDetails;
import com.employee_onboarding.employee_onboarding.model.OsiDocumentAttachment;

import java.util.List;

public class SectionDataDTO {
    private OsiProspectiveEmployeeDetails sectionDetails;
    private List<OsiDocumentAttachment> attachments;

    public SectionDataDTO(OsiProspectiveEmployeeDetails sectionDetails, List<OsiDocumentAttachment> attachments) {
        this.sectionDetails = sectionDetails;
        this.attachments = attachments;
    }

    public OsiProspectiveEmployeeDetails getSectionDetails() {
        return sectionDetails;
    }

    public void setSectionDetails(OsiProspectiveEmployeeDetails sectionDetails) {
        this.sectionDetails = sectionDetails;
    }

    public List<OsiDocumentAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<OsiDocumentAttachment> attachments) {
        this.attachments = attachments;
    }
}
