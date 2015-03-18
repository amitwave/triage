package com.wave.referral;

import com.wave.address.AddressData;
import com.wave.contact.ContactData;
import com.wave.name.NameData;
import com.wave.patient.PatientData;
import com.wave.referrer.ReferrerData;
import com.wave.user.dao.UserData;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "REFERRAL")
@NamedQueries({

        @NamedQuery(name = ReferralData.FIND_REFERRAL_BY_ID, query =
                "SELECT " +
                        "patientData " +
                        "FROM " +
                        "ReferralData patientData " +
                        "WHERE " +
                        "patientData.id = :id"),
        @NamedQuery(name = ReferralData.FIND_ALL_REFERRALS, query =
                "SELECT " +
                        "patientData " +
                        "FROM " +
                        "ReferralData patientData "
                        )
})
public class ReferralData {

    public static final String FIND_REFERRAL_BY_ID = "FIND_REFERRAL_BY_ID";
    public static final String FIND_ALL_REFERRALS = "FIND_ALL_REFERRALS";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Version
    @Column(name="OPTLOCK")
    private long version;

    @Column(name="UBRN")
    private String ubrn;

    @Column(name="TYPE")
    private String type;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="CREATE_DATE")
    private Date createDate;

    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdated;

    @Column(name = "ACTIVE")
    private boolean active;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private UserData createdBy;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="PATIENT_ID")
    private PatientData patient;

    @ManyToOne
    @JoinColumn(name="REFERRER_ID")
    private ReferrerData referrerData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUbrn() {
        return ubrn;
    }

    public void setUbrn(String ubrn) {
        this.ubrn = ubrn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public UserData getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserData createdBy) {
        this.createdBy = createdBy;
    }

    public PatientData getPatient() {
        return patient;
    }

    public void setPatient(PatientData patient) {
        this.patient = patient;
    }

    public ReferrerData getReferrerData() {
        return referrerData;
    }

    public void setReferrerData(ReferrerData referrerData) {
        this.referrerData = referrerData;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public boolean isActive() {
        return active;
    }
}
