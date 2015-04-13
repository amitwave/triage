package com.wave.referral;

import com.wave.destination.IGRDestinationData;
import com.wave.note.NoteData;
import com.wave.patient.PatientData;
import com.wave.referralstatus.ReferralStatusData;
import com.wave.referrer.ReferrerData;
import com.wave.status.Status;
import com.wave.user.dao.UserData;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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
                        ),
        @NamedQuery(name = ReferralData.FIND_ALL_REFERRALS_BY_USER, query =
                "SELECT " +
                        "rd " +
                        "FROM " +
                        "ReferralData rd " +
                        "WHERE " +
                        "rd.user.id= :id " +

                        " "),
        @NamedQuery(name = ReferralData.FIND_ALL_OPEN_REFERRALS_BY_USER, query =
        "SELECT " +
                "rd " +
                "FROM " +
                "ReferralData rd " +
                "WHERE " +
                "rd.user.id= :id " +
                " and rd.status = 'CHECKOUT' "
                ),
        @NamedQuery(name = ReferralData.FIND_ALL_REFERRALS_BY_USER_AND_STATUS, query =
                "SELECT " +
                        "rd " +
                        "FROM " +
                        "ReferralData rd " +
                        "WHERE " +
                        "rd.user.id= :id " +
                        " and rd.status = :status "
        ),

        @NamedQuery(name = ReferralData.FIND_ALL_REFERRALS_COUNT__BY_USER_AND_STATUS, query =
        "SELECT " +
                "count(rd) " +
                "FROM " +
                "ReferralData rd " +
                "WHERE " +
                "rd.user.id= :id " +
                " and rd.status = :status "
),
        @NamedQuery(name = ReferralData.FIND_ALL_VALIDATED_REFERRALS_BY_USER, query =
                "SELECT " +
                        "rd " +
                        "FROM " +
                        "ReferralData rd " +
                        "WHERE " +
                        "rd.user.id= :id " +
                        " and rd.status = 'VALIDATED' " +
                        " "),
        @NamedQuery(name = ReferralData.FIND_ALL_REJECTED_REFERRALS_BY_USER, query =
                "SELECT " +
                        "rd " +
                        "FROM " +
                        "ReferralData rd join  rd.referralStatusDatas rsd " +
                        "WHERE " +
                        "rsd.user.id= :id " +
                        " and rsd.toStatus <> 'REFERRAL_INCOMPLETE' " +
                        " "),
        @NamedQuery(name = ReferralData.FIND_ALL_REFERRAL_DATA_BY_STATUS, query =
                "SELECT " +
                        "rd " +
                        "FROM " +
                        "ReferralData rd " +
                        "WHERE " +
                        "rd.status= :status  ")
        ,
        @NamedQuery(name = ReferralData.FIND_ALL_REFERRAL_DATA_COUNT_BY_STATUS, query =
                "SELECT " +
                        "count(rd) " +
                        "FROM " +
                        "ReferralData rd " +
                        "WHERE " +
                        "rd.status= :status  ")
        ,
        @NamedQuery(name = ReferralData.FIND_ALL_NEW_REFERRAL_DATA_COUNT, query =
                "SELECT " +
                        "count(rd) " +
                        "FROM " +
                        "ReferralData rd " +
                        "WHERE " +
                        "rd.status= 'NEW'  ")

})
public class ReferralData {

    public static final String FIND_REFERRAL_BY_ID = "FIND_REFERRAL_BY_ID";
    public static final String FIND_ALL_REFERRALS = "FIND_ALL_REFERRALS";
    public static final String FIND_ALL_REFERRALS_BY_USER = "FIND_ALL_REFERRALS_BY_USER";

    public static final String FIND_ALL_REFERRAL_DATA_BY_STATUS = "FIND_ALL_REFERRAL_DATA_BY_STATUS";
    public static final String FIND_ALL_REFERRAL_DATA_COUNT_BY_STATUS = "FIND_ALL_REFERRAL_DATA_COUNT_BY_STATUS";


    public static final String FIND_ALL_NEW_REFERRAL_DATA_COUNT = "FIND_ALL_NEW_REFERRAL_DATA_COUNT";
    public static final String FIND_ALL_OPEN_REFERRALS_BY_USER = "FIND_ALL_OPEN_REFERRALS_BY_USER";

    public static final String FIND_ALL_VALIDATED_REFERRALS_BY_USER = "FIND_ALL_VALIDATED_REFERRALS_BY_USER";
    public static final String FIND_ALL_REJECTED_REFERRALS_BY_USER = "FIND_ALL_REJECTED_REFERRALS_BY_USER";

    public static final String FIND_ALL_REFERRALS_BY_USER_AND_STATUS = "FIND_ALL_REFERRALS_BY_USER_AND_STATUS";
    public static final String FIND_ALL_REFERRALS_COUNT__BY_USER_AND_STATUS = "FIND_ALL_REFERRALS_COUNT__BY_USER_AND_STATUS";

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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATE_DATE")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdated;

    @Column(name = "ACTIVE")
    private boolean active;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="PATIENT_ID")
    private PatientData patient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="REFERRER_ID")
    private ReferrerData referrerData;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="IGR_DESTINATION_ID")
    private IGRDestinationData igrDestinationData;

    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="REFERRAL_ID")
    private List<NoteData> notes;


    @OrderBy("lastUpdated desc" )
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="REFERRAL_ID")
    private List<ReferralStatusData> referralStatusDatas;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;

    @ManyToOne
    @JoinColumn(name="CREATED_BY")
    private UserData createdBy;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private UserData user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public List<NoteData> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteData> notes) {
        this.notes = notes;
    }

    public List<ReferralStatusData> getReferralStatusDatas() {
        if(referralStatusDatas != null) {
            Collections.sort(referralStatusDatas);
        }
        return referralStatusDatas;
    }

    public void setReferralStatusDatas(List<ReferralStatusData> referralStatusDatas) {
        this.referralStatusDatas = referralStatusDatas;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    public UserData getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserData createdBy) {
        this.createdBy = createdBy;
    }

    public IGRDestinationData getIgrDestinationData() {
        return igrDestinationData;
    }

    public void setIgrDestinationData(IGRDestinationData igrDestinationData) {
        this.igrDestinationData = igrDestinationData;
    }
}
