package com.wave.patient;

import com.wave.address.AddressData;
import com.wave.contact.ContactData;
import com.wave.master.EthnicityData;
import com.wave.master.GenderData;
import com.wave.master.TitleData;
import com.wave.name.NameData;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PATIENT")
@NamedQueries({

        @NamedQuery(name = PatientData.FIND_PATIENT_BY_ID, query =
                "SELECT " +
                        "patientData " +
                        "FROM " +
                        "PatientData patientData " +
                        "WHERE " +
                        "patientData.id = :id")
})
public class PatientData {

    public static final String FIND_PATIENT_BY_ID = "FIND_PATIENT_BY_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="NAME_ID")
    private NameData nameData;

    @Column(name = "NHS_NUMBER")
    private String nhsNumber;

    @ManyToOne
    @JoinColumn(name="ETHNICITY_ID")
    private EthnicityData ethnicity;

    @ManyToOne
    @JoinColumn(name="GENDER_ID")
    private GenderData gender;

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

    public String getNhsNumber() {
        return nhsNumber;
    }

    public void setNhsNumber(String nhsNumber) {
        this.nhsNumber = nhsNumber;
    }

    public EthnicityData getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(EthnicityData ethnicity) {
        this.ethnicity = ethnicity;
    }

    public GenderData getGender() {
        return gender;
    }

    public void setGender(GenderData gender) {
        this.gender = gender;
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
}
