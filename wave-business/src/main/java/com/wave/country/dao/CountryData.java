package com.wave.country.dao;

import com.wave.state.StateData;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COUNTRY")
@NamedQueries({

        @NamedQuery(name = CountryData.FIND_COUNTRY_BY_ID, query =
                "SELECT " +
                        "country " +
                        "FROM " +
                        "CountryData country " +
                        "WHERE " +
                        "country.id = :id")
})
public class CountryData {

    public static final String FIND_COUNTRY_BY_ID = "FIND_COUNTRY_BY_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DISPLAY_NAME")
    private String displayName;

    @Column(name = "ACTIVE")
    private Boolean active;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "COUNTRY_STATE",
            joinColumns = {@JoinColumn(name = "COUNTRY_ID" ,  referencedColumnName="ID")},
            inverseJoinColumns = {@JoinColumn(name = "CITY_ID" , referencedColumnName="ID")})
    private List<StateData> states;

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
