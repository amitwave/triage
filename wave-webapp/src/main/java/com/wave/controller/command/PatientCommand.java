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
    private String isInterpreterRequired;
    private String isAssistanceRequired;
    
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
    
    public String getPrimarySpokenLanguage() {
        return primarySpokenLanguage;
    }

    public void setPrimarySpokenLanguage(String primarySpokenLanguage) {
        this.primarySpokenLanguage = primarySpokenLanguage;
    }
    
    public String getSecondarySpokenLanguage() {
        return secondarySpokenLanguage;
    }

    public void setSecondarySpokenLanguage(String secondarySpokenLanguage) {
        this.secondarySpokenLanguage = secondarySpokenLanguage;
    }
    
    public String getWrittenLanguage() {
        return writtenLanguage;
    }

    public void setWrittenLanguage(String writtenLanguage) {
        this.writtenLanguage = writtenLanguage;
    }
    
    public String getIsInterpreterRequired() {
        return isInterpreterRequired;
    }

    public void setSecondarySpokenLanguage(String isInterpreterRequired) {
        this.isInterpreterRequired = isInterpreterRequired;
    }
    
    public String getIsAssistanceRequired() {
        return isAssistanceRequired;
    }

    public void setIsAssistanceRequired(String isAssistanceRequired) {
        this.isAssistanceRequired = isAssistanceRequired;
    }
    
    
}
