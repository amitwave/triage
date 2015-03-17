package com.wave.name;

import com.wave.master.TitleData;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "NAME")
@NamedQueries({

        @NamedQuery(name = NameData.FIND_NAME_BY_ID, query =
                "SELECT " +
                        "nameData " +
                        "FROM " +
                        "NameData nameData " +
                        "WHERE " +
                        "nameData.id = :id")
})
public class NameData {

    public static final String FIND_NAME_BY_ID = "FIND_NAME_BY_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="TITLE_ID")
    private TitleData title;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PREFERRED_NAME")
    private String preferredName;

    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TitleData getTitle() {
        return title;
    }

    public void setTitle(TitleData title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
