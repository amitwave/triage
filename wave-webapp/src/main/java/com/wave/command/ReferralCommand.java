package com.wave.command;

import com.wave.status.Status;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ReferralCommand {


    private Long id;
    private String ubrn;
    private String type;
    private String ppwtProcedure;
    private String description;
    private String specialty;
    private String reason;
    private String priority;
    private String provider;
    private String sharePointLinkOne;
    private String sharePointLinkTwo;
    private String sharePointLinkThree;
    private String attachmentOne;
    private String attachmentTwo;
    private String attachmentThree;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createDate;


    private Date lastUpdated;

    private boolean active;
    private UserCommand createdBy;
    private UserCommand user;
    private PatientCommand patient;
    private ReferrerCommand referrer;
    private IGRDestinationCommand igrDestination;
    private Status status;

    public String getSharePointLinkOne() {
        return sharePointLinkOne;
    }

    public void setSharePointLinkOne(String sharePointLinkOne) {
        this.sharePointLinkOne = sharePointLinkOne;
    }

    public String getSharePointLinkTwo() {
        return sharePointLinkTwo;
    }

    public void setSharePointLinkTwo(String sharePointLinkTwo) {
        this.sharePointLinkTwo = sharePointLinkTwo;
    }

    public String getSharePointLinkThree() {
        return sharePointLinkThree;
    }

    public void setSharePointLinkThree(String sharePointLinkThree) {
        this.sharePointLinkThree = sharePointLinkThree;
    }

    public String getAttachmentOne() {
        return attachmentOne;
    }

    public void setAttachmentOne(String attachmentOne) {
        this.attachmentOne = attachmentOne;
    }

    public String getAttachmentTwo() {
        return attachmentTwo;
    }

    public void setAttachmentTwo(String attachmentTwo) {
        this.attachmentTwo = attachmentTwo;
    }

    public String getAttachmentThree() {
        return attachmentThree;
    }

    public void setAttachmentThree(String attachmentThree) {
        this.attachmentThree = attachmentThree;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public ReferrerCommand getReferrer() {
        return referrer;
    }

    public void setReferrer(ReferrerCommand referrer) {
        this.referrer = referrer;
    }

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UserCommand getUser() {
        return user;
    }

    public void setUser(UserCommand user) {
        this.user = user;
    }


    public String getPpwtProcedure() {
        return ppwtProcedure;
    }

    public void setPpwtProcedure(String ppwtProcedure) {
        this.ppwtProcedure = ppwtProcedure;
    }

    public IGRDestinationCommand getIgrDestination() {
        return igrDestination;
    }

    public void setIgrDestination(IGRDestinationCommand igrDestination) {
        this.igrDestination = igrDestination;
    }
}
