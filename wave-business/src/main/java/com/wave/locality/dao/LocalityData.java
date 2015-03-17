package com.wave.locality.dao;

import com.wave.city.dao.CityData;

import javax.persistence.*;

@Entity
@Table(name = "LOCALITY")
@NamedQueries({

        @NamedQuery(name = LocalityData.FIND_LOCALITY_BY_ID, query =
                "SELECT " +
                        "locality " +
                        "FROM " +
                        "LocalityData locality " +
                        "WHERE " +
                        "locality.id = :id")
})
public class LocalityData {

    public static final String FIND_LOCALITY_BY_ID = "FIND_LOCALITY_BY_ID";

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


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
      @JoinTable(name = "CITY_LOCALITY",
              joinColumns = {@JoinColumn(name = "CITY_ID" , table ="CITY", referencedColumnName="ID")},
              inverseJoinColumns = {@JoinColumn(name = "LOCALITY_ID" , table = "LOCALITY", referencedColumnName="ID")})
    private CityData city;

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


}
