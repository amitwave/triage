package com.wave.controller.command;

import com.wave.status.Status;

import java.util.Date;

public class ReferralCommand {

    private Long id;
    private String ubrn;
    private String type;
    private String description;
    private Date createDate;
    private Date lastUpdated;
    private boolean active;
    private UserCommand createdBy;
    private PatientCommand patient;
    private ReferrerCommand referrerData;
    private Status status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUbrn() {
        return ubrn;
    }

    public void setUbrn(String ubrn) {
        this.ubrn = ubrn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public UserCommand getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserCommand createdBy) {
        this.createdBy = createdBy;
    }

    public PatientCommand getPatient() {
        return patient;
    }

    public void setPatient(PatientCommand patient) {
        this.patient = patient;
    }

    public ReferrerCommand getReferrerData() {
        return referrerData;
    }

    public void setReferrerData(ReferrerCommand referrerData) {
        this.referrerData = referrerData;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
