package com.wave.controller.command;

import com.wave.name.NameData;

import java.util.Date;

public class ReferrerCommand {

    private Long id;
    private NameCommand name;
    private Date lastUpdated;
    private ContactCommand contactDetails;
    private AddressCommand address;
    private String speciality;
    private String practiceName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NameData getNameData() {
        return nameData;
    }

    public void setName(NameData nameData) {
        this.nameData = nameData;
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
}
