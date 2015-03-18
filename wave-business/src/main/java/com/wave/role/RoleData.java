package com.wave.role;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
@NamedQueries({

        @NamedQuery(name = RoleData.FIND_ROLE_BY_ID, query =
                "SELECT " +
                        "role " +
                        "FROM " +
                        "RoleData role " +
                        "WHERE " +
                        "role.id = :id")
})
public class RoleData {

    public static final String FIND_ROLE_BY_ID = "FIND_ROLE_BY_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ACTIVE")
    private Boolean active;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
