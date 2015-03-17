package com.wave.city.dao;

import com.wave.locality.dao.LocalityData;
import com.wave.state.StateData;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CITY")
@NamedQueries({

        @NamedQuery(name = CityData.FIND_CITY_BY_ID, query =
                "SELECT " +
                        "city " +
                        "FROM " +
                        "CityData city " +
                        "WHERE " +
                        "city.id = :id")
})
public class CityData {

    public static final String FIND_CITY_BY_ID = "FIND_CITY_BY_ID";

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

    @Column(name = "LATITUDE")
    private Float latitude;

    @Column(name = "LONGITUDE")
    private Float longitude;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "CITY_LOCALITY",
            joinColumns = {@JoinColumn(name = "CITY_ID" , table ="CITY", referencedColumnName="ID")},
            inverseJoinColumns = {@JoinColumn(name = "LOCALITY_ID" , table = "LOCALITY", referencedColumnName="ID")})
    private List<LocalityData> localities;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "STATE_CITY",
            joinColumns = {@JoinColumn(name = "STATE_ID" ,  table ="STATE", referencedColumnName="ID")},
            inverseJoinColumns = {@JoinColumn(name = "CITY_ID" , table ="CITY", referencedColumnName="ID")})
    private StateData state;


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

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public List<LocalityData> getLocalities() {
        return localities;
    }

    public void setLocalities(List<LocalityData> localities) {
        this.localities = localities;
    }

    public StateData getState() {
        return state;
    }

    public void setState(StateData state) {
        this.state = state;
    }
}
