package com.employee_onboarding.employee_onboarding.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;


import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.vladmihalcea.hibernate.type.json.JsonType;

@Entity
@Table(name = "osi_prospective_employees")
@Data
public class ProspectiveEmployee {
	public ProspectiveEmployee() {};
    public ProspectiveEmployee(String firstName, String middleName, String lastName, String preferredName,
			String employeeType, Date dateOfJoining, Date dateOfBirth, String requisitionId, String mobileNumber,
			String email, Map<String, Object> additionalInfo, String status, String createdBy, String updatedBy,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.preferredName = preferredName;
		this.employeeType = employeeType;
		this.dateOfJoining = dateOfJoining;
		this.dateOfBirth = dateOfBirth;
		this.requisitionId = requisitionId;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.additionalInfo = additionalInfo;
		this.status = status;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPreferredName() {
		return preferredName;
	}

	public void setPreferredName(String preferredName) {
		this.preferredName = preferredName;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getRequisitionId() {
		return requisitionId;
	}

	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<String, Object> getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(Map<String, Object> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;
    private String preferredName;
    private String employeeType;

    private Date dateOfJoining;
    private Date dateOfBirth;
    private String requisitionId;
    private String mobileNumber;

    @Column(unique = true)
    private String email;
    @Type(JsonType.class)
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, Object> additionalInfo;
    private String status;
    private String createdBy;
    private String updatedBy;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
	@OneToMany(mappedBy = "prospectiveEmployee", cascade = CascadeType.ALL, orphanRemoval = true)
private List<OsiProspectiveEmployeeDetails> details;

@OneToMany(mappedBy = "prospectiveEmployee", cascade = CascadeType.ALL, orphanRemoval = true)
private List<OsiDocumentAttachment> documentAttachments;

}
