package com.wave.item.dao;

import javax.persistence.*;

@Entity
@Table(name = "ITEM")
@NamedQueries({

        @NamedQuery(name = ItemData.FIND_ITEM_BY_ID, query =
                "SELECT " +
                        "itemData " +
                        "FROM " +
                        "ItemData itemData " +
                        "WHERE " +
                        "itemData.id = :id")
})
public class ItemData {

    public static final String FIND_ITEM_BY_ID = "FIND_ITEM_BY_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DISPLAY_NAME")
    private String displayName;

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

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
