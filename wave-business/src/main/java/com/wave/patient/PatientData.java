package com.wave.patient;

import com.wave.address.AddressData;
import com.wave.contact.ContactData;
import com.wave.gender.Gender;
import com.wave.master.EthnicityData;
import com.wave.name.NameData;
import org.springframework.format.annotation.DateTimeFormat;

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

    @Version
    @Column(name="VERSION")
    private Long version;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="NAME_ID")
    private NameData nameData;

    @Column(name = "NHS_NUMBER")
    private String nhsNumber;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "DOB")
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name="ETHNICITY_ID")
    private EthnicityData ethnicity;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdated;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="CONTACT_DETAILS_ID")
    private ContactData contactDetails;

    @ManyToOne(cascade = CascadeType.ALL)
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
