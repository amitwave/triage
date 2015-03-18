package com.wave.referrer;

import com.wave.address.AddressData;
import com.wave.contact.ContactData;
import com.wave.master.EthnicityData;
import com.wave.master.GenderData;
import com.wave.name.NameData;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "REFERRER")
@NamedQueries({

        @NamedQuery(name = ReferrerData.FIND_REFERRER_BY_ID, query =
                "SELECT " +
                        "patientData " +
                        "FROM " +
                        "ReferrerData patientData " +
                        "WHERE " +
                        "patientData.id = :id")
})
public class ReferrerData {

    public static final String FIND_REFERRER_BY_ID = "FIND_REFERRER_BY_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Version
    @Column(name="VERSION")
    private long version;

    @ManyToOne
    @JoinColumn(name="NAME_ID")
    private NameData nameData;

    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdated;

    @ManyToOne
    @JoinColumn(name="CONTACT_DETAILS_ID")
    private ContactData contactDetails;

    @ManyToOne
    @JoinColumn(name="ADDRESS_ID")
    private AddressData address;


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

    public ContactData getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactData contactDetails) {
        this.contactDetails = contactDetails;
    }

    public AddressData getAddress() {
        return address;
    }

    public void setAddress(AddressData address) {
        this.address = address;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
