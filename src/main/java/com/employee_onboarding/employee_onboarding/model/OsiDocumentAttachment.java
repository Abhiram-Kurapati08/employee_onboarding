package com.employee_onboarding.employee_onboarding.model;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "osi_document_attachments")
public class OsiDocumentAttachment {
	public OsiDocumentAttachment() {};
    public OsiDocumentAttachment(Integer prospectiveEmployeeId, Integer prospectiveEmployeeDetailId, String docCategory,
			String docType, String docName, String filePath, Long fileSize, String fileMimeType, String attachmentType,
			String attachmentUrl, Boolean isVerified, Timestamp verificationDate, String verifiedBy, String status,
			Boolean isMandatory, Boolean isDeleted, String createdBy, String updatedBy, Timestamp createdAt,
			Timestamp updatedAt) {
		this.prospectiveEmployeeId = prospectiveEmployeeId;
		this.prospectiveEmployeeDetailId = prospectiveEmployeeDetailId;
		this.docCategory = docCategory;
		this.docType = docType;
		this.docName = docName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.fileMimeType = fileMimeType;
		this.attachmentType = attachmentType;
		this.attachmentUrl = attachmentUrl;
		this.isVerified = isVerified;
		this.verificationDate = verificationDate;
		this.verifiedBy = verifiedBy;
		this.status = status;
		this.isMandatory = isMandatory;
		this.isDeleted = isDeleted;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProspectiveEmployeeId() {
		return prospectiveEmployeeId;
	}

	public void setProspectiveEmployeeId(Integer prospectiveEmployeeId) {
		this.prospectiveEmployeeId = prospectiveEmployeeId;
	}

	public Integer getProspectiveEmployeeDetailId() {
		return prospectiveEmployeeDetailId;
	}

	public void setProspectiveEmployeeDetailId(Integer prospectiveEmployeeDetailId) {
		this.prospectiveEmployeeDetailId = prospectiveEmployeeDetailId;
	}

	public String getDocCategory() {
		return docCategory;
	}

	public void setDocCategory(String docCategory) {
		this.docCategory = docCategory;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileMimeType() {
		return fileMimeType;
	}

	public void setFileMimeType(String fileMimeType) {
		this.fileMimeType = fileMimeType;
	}

	public String getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}

	public String getAttachmentUrl() {
		return attachmentUrl;
	}

	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public Timestamp getVerificationDate() {
		return verificationDate;
	}

	public void setVerificationDate(Timestamp verificationDate) {
		this.verificationDate = verificationDate;
	}

	public String getVerifiedBy() {
		return verifiedBy;
	}

	public void setVerifiedBy(String verifiedBy) {
		this.verifiedBy = verifiedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getIsMandatory() {
		return isMandatory;
	}

	public void setIsMandatory(Boolean isMandatory) {
		this.isMandatory = isMandatory;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer prospectiveEmployeeId;
    //private Boolean isDeleted;
    private Integer prospectiveEmployeeDetailId;
    private String docCategory;
    private String docType;
    private String docName;
    private String filePath;
    private Long fileSize;
    private String fileMimeType;

    @Column(nullable = false)
    private String attachmentType = "file_upload";

    private String attachmentUrl;

    @Column(nullable = false)
    private Boolean isVerified = false;

    private Timestamp verificationDate;
    private String verifiedBy;

    private String status = "In Process";

    @Column(nullable = false)
    private Boolean isMandatory = false;

    @Column(nullable = false)
    private Boolean isDeleted = false;

    @Column(nullable = false)
    private String createdBy;

    private String updatedBy;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
