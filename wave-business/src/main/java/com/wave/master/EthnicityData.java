package com.wave.master;

import javax.persistence.*;

@Entity
@Table(name = "ETHNICITY")
@NamedQueries({

        @NamedQuery(name = EthnicityData.FIND_ETHNICITY_BY_ID, query =
                "SELECT " +
                        "ethnicityData " +
                        "FROM " +
                        "EthnicityData ethnicityData " +
                        "WHERE " +
                        "ethnicityData.id = :id")
})
public class EthnicityData {

    public static final String FIND_ETHNICITY_BY_ID = "FIND_ETHNICITY_BY_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DISPLAY_NAME")
    private String displayName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
