package com.wave.referralstatus;

import com.wave.referral.ReferralData;
import com.wave.status.Status;
import com.wave.user.dao.UserData;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "REFERRAL_STATUS")
@NamedQueries({

        @NamedQuery(name = ReferralStatusData.FIND_RS_BY_ID, query =
                "SELECT " +
                        "patientData " +
                        "FROM " +
                        "ReferralStatusData patientData " +
                        "WHERE " +
                        "patientData.id = :id")
})
public class ReferralStatusData implements Comparable<ReferralStatusData>{

    public static final String FIND_RS_BY_ID = "FIND_RS_BY_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private UserData user;

    @ManyToOne
    @JoinColumn(name="REFERRAL_ID", insertable=false, updatable=false)
    private ReferralData referralData;

    @Enumerated(EnumType.STRING)
    @Column(name = "FROM_STATUS")
    private Status fromStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "TO_STATUS")
    private Status toStatus;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    public ReferralData getReferralData() {
        return referralData;
    }

    public void setReferralData(ReferralData referralData) {
        this.referralData = referralData;
    }

    public Status getFromStatus() {
        return fromStatus;
    }

    public void setFromStatus(Status fromStatus) {
        this.fromStatus = fromStatus;
    }

    public Status getToStatus() {
        return toStatus;
    }

    public void setToStatus(Status toStatus) {
        this.toStatus = toStatus;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public int compareTo(ReferralStatusData referralStatusData) {

        return referralStatusData.getLastUpdated().compareTo(this.getLastUpdated());

    }
}
