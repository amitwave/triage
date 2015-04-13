package com.wave.command;


import java.util.Date;

public class ReferrerCommand {

    private Long id;
    private NameCommand name;
    private Date lastUpdated;
    private ContactCommand contactDetails;
    private AddressCommand address;
    private String speciality;
    private String practiceName;
    private String practiceCode;

    private RoleCommand role;


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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPracticeName() {
        return practiceName;
    }

    public void setPracticeName(String practiceName) {
        this.practiceName = practiceName;
    }


    public RoleCommand getRole() {
        return role;
    }

    public void setRole(RoleCommand role) {
        this.role = role;
    }

    public String getPracticeCode() {
        return practiceCode;
    }

    public void setPracticeCode(String practiceCode) {
        this.practiceCode = practiceCode;
    }
}
