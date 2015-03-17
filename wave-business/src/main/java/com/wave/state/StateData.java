package com.wave.state;

import com.wave.city.dao.CityData;
import com.wave.country.dao.CountryData;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "STATE")
@NamedQueries({

        @NamedQuery(name = StateData.FIND_STATE_BY_ID, query =
                "SELECT " +
                        "state " +
                        "FROM " +
                        "StateData state " +
                        "WHERE " +
                        "state.id = :id")
})
public class StateData {

    public static final String FIND_STATE_BY_ID = "FIND_STATE_BY_ID";

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


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "STATE_CITY",
            joinColumns = {@JoinColumn(name = "STATE_ID", table = "STATE", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "CITY_ID", table = "CITY", referencedColumnName = "ID")})
    private List<CityData> cities;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "COUNTRY_STATE",
            joinColumns = {@JoinColumn(name = "STATE_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID")})
    private CountryData country;


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

    public List<CityData> getCities() {
        return cities;
    }

    public void setCities(List<CityData> cities) {
        this.cities = cities;
    }

    public CountryData getCountry() {
        return country;
    }

    public void setCountry(CountryData country) {
        this.country = country;
    }
}
