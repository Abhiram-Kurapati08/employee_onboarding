package com.employee_onboarding.employee_onboarding.model;


import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="osi_prospective_employee_details")
public class OsiProspectiveEmployeeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "prospective_employee_id", nullable = false)
	private Long prospectiveEmployeeId;

	@Column(name = "section_type", nullable = false, length = 50)
	private String sectionType;

	@Column(name = "section_data", columnDefinition = "json", nullable = false)
	private String sectionData; 

	@Column(name = "status", nullable = false, length = 50)
	private String status = "Draft"; 

	@Column(name = "reviewer_comments", columnDefinition = "TEXT")
	private String reviewerComments;

	@Column(name = "reviewed_by", length = 100)
	private String reviewedBy;

	@Column(name = "submitted_at")
	private LocalDateTime submittedAt;

	@Column(name = "reviewed_at")
	private LocalDateTime reviewedAt;

	@Column(name = "created_by", nullable = false, length = 100)
	private String createdBy;

	@Column(name = "updated_by", length = 100)
	private String updatedBy;

	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}

	public Long getProspectiveEmployeeId() {
	    return prospectiveEmployeeId;
	}

	public void setProspectiveEmployeeId(Long prospectiveEmployeeId) {
	    this.prospectiveEmployeeId = prospectiveEmployeeId;
	}

	public String getSectionType() {
	    return sectionType;
	}

	public void setSectionType(String sectionType) {
	    this.sectionType = sectionType;
	}

	public String getSectionData() {
	    return sectionData;
	}

	public void setSectionData(String sectionData) {
	    this.sectionData = sectionData;
	}

	public String getStatus() {
	    return status;
	}

	public void setStatus(String status) {
	    this.status = status;
	}

	public String getReviewerComments() {
	    return reviewerComments;
	}

	public void setReviewerComments(String reviewerComments) {
	    this.reviewerComments = reviewerComments;
	}

	public String getReviewedBy() {
	    return reviewedBy;
	}

	public void setReviewedBy(String reviewedBy) {
	    this.reviewedBy = reviewedBy;
	}

	public LocalDateTime getSubmittedAt() {
	    return submittedAt;
	}

	public void setSubmittedAt(LocalDateTime submittedAt) {
	    this.submittedAt = submittedAt;
	}

	public LocalDateTime getReviewedAt() {
	    return reviewedAt;
	}

	public void setReviewedAt(LocalDateTime reviewedAt) {
	    this.reviewedAt = reviewedAt;
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

	public LocalDateTime getCreatedAt() {
	    return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
	    this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
	    return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
	    this.updatedAt = updatedAt;
	}
	@ManyToOne
@JoinColumn(name = "prospective_employee_id", nullable = false)
private ProspectiveEmployee prospectiveEmployee;
@OneToMany(mappedBy = "prospectiveEmployeeDetail", cascade = CascadeType.ALL, orphanRemoval = true)
private List<OsiDocumentAttachment> documentAttachments;
//


}
