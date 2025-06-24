package com.employee_onboarding.employee_onboarding.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "osi_audit_trail")
public class OsiAuditTrail {
	public OsiAuditTrail() {};
	
    public OsiAuditTrail(String objectType, Integer objectId, String action, String object, String createdBy,
			LocalDateTime createdAt) {
		super();
		this.objectType = objectType;
		this.objectId = objectId;
		this.action = action;
		this.object = object;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "object_type", nullable = false, length = 100)
    private String objectType;

    @Column(name = "object_id", nullable = false)
    private Integer objectId;

    @Column(nullable = false, length = 50)
    private String action;

    @Column(columnDefinition = "json")
    private String object; // Storing JSON as String

    @Column(name = "created_by", nullable = false, length = 100)
    private String createdBy;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public Integer getObjectId() {
		return objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

    
}