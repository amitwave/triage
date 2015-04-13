package com.wave.referrer;

import com.wave.address.AddressData;
import com.wave.contact.ContactData;
import com.wave.name.NameData;
import com.wave.role.RoleData;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="NAME_ID")
    private NameData nameData;

    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdated;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="CONTACT_DETAILS_ID")
    private ContactData contactDetails;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ADDRESS_ID")
    private AddressData address;

    @ManyToOne
    @JoinColumn(name="ROLE_ID")
    private RoleData roleData;

    @Column(name = "SPECIALITY")
    private String speciality;

    @Column(name = "CLINIC_NAME")
    private String practiceName;

    @Column(name = "PRACTICE_CODE")
    private String practiceCode;


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

    public RoleData getRoleData() {
        return roleData;
    }

    public void setRoleData(RoleData roleData) {
        this.roleData = roleData;
    }

    public String getPracticeCode() {
        return practiceCode;
    }

    public void setPracticeCode(String practiceCode) {
        this.practiceCode = practiceCode;
    }

    public String getPracticeName() {
        return practiceName;
    }

    public void setPracticeName(String practiceName) {
        this.practiceName = practiceName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
