package com.wave.controller.command;

import com.wave.address.AddressData;
import com.wave.contact.ContactData;
import com.wave.name.NameData;

import javax.persistence.*;
import java.util.Date;

public class ReferrerCommand {

    private Long id;
    private NameData nameData;
    private Date lastUpdated;
    private ContactCommand contactDetails;
    private AddressCommand address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NameData getNameData() {
        return nameData;
    }

    public void setNameData(NameData nameData) {
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
