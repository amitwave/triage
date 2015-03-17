package com.wave.contact.dao;


import com.wave.address.AddressData;
import com.wave.contact.ContactData;

public interface ContactDao {

    public ContactData getContactData(Long id);
    public void saveContactData(ContactData itemData);
}
