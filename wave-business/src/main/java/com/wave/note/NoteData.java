package com.wave.note;

import com.wave.referral.ReferralData;
import com.wave.user.dao.UserData;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "NOTE")
@NamedQueries({

        @NamedQuery(name = NoteData.FIND_NOTE_BY_ID, query =
                "SELECT " +
                        "patientData " +
                        "FROM " +
                        "NoteData patientData " +
                        "WHERE " +
                        "patientData.id = :id")
})
public class NoteData {

    public static final String FIND_NOTE_BY_ID = "FIND_NOTE_BY_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private UserData createdBy;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdated;

    @ManyToOne
    @JoinColumn(name="REFERRAL_ID", insertable=false, updatable=false)
    private ReferralData referralData;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserData getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserData createdBy) {
        this.createdBy = createdBy;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
