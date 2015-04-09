package com.wave.controller.command;

import com.wave.name.NameData;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PatientCommand {
	
    private Long id;
    private NameCommand name;
    private String nhsNumber;
    private EthnicityCommand ethnicity;
    private GenderCommand gender;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    private Date lastUpdated;
    private ContactCommand contactDetails;
    private AddressCommand address;
    private String primarySpokenLanguage;
    private String secondarySpokenLanguage;
    private String writtenLanguage;
    private Boolean interpreterRequired;
    private Boolean assistanceRequired;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NameCommand getName() {
        return name;
    }

    public void setName(NameCommand name) {
        this.name = name;
    }

    public String getNhsNumber() {
        return nhsNumber;
    }

    public void setNhsNumber(String nhsNumber) {
        this.nhsNumber = nhsNumber;
    }

    public EthnicityCommand getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(EthnicityCommand ethnicity) {
        this.ethnicity = ethnicity;
    }

    public GenderCommand getGender() {
        return gender;
    }

    public void setGender(GenderCommand gender) {
        this.gender = gender;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public ContactCommand getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactCommand contactDetails) {
        this.contactDetails = contactDetails;
    }

    public AddressCommand getAddress() {
        return address;
    }

    public void setAddress(AddressCommand address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSecondarySpokenLanguage() {
        return secondarySpokenLanguage;
    }

    public void setSecondarySpokenLanguage(String secondarySpokenLanguage) {
        this.secondarySpokenLanguage = secondarySpokenLanguage;
    }

    public String getPrimarySpokenLanguage() {
        return primarySpokenLanguage;
    }

    public void setPrimarySpokenLanguage(String primarySpokenLanguage) {
        this.primarySpokenLanguage = primarySpokenLanguage;
    }

    public String getWrittenLanguage() {
        return writtenLanguage;
    }

    public void setWrittenLanguage(String writtenLanguage) {
        this.writtenLanguage = writtenLanguage;
    }

    public Boolean getInterpreterRequired() {
        return interpreterRequired;
    }

    public void setInterpreterRequired(Boolean interpreterRequired) {
        this.interpreterRequired = interpreterRequired;
    }

    public Boolean getAssistanceRequired() {
        return assistanceRequired;
    }

    public void setAssistanceRequired(Boolean assistanceRequired) {
        this.assistanceRequired = assistanceRequired;
    }
}
