package com.wave.itemgroup.dao;

import com.wave.item.dao.ItemData;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ITEM_GROUP")
@NamedQueries({

        @NamedQuery(name = ItemGroupData.FIND_ITEM_GROUP_BY_ID, query =
                "SELECT " +
                        "itemGroupData " +
                        "FROM " +
                        "ItemGroupData itemGroupData " +
                        "WHERE " +
                        "itemGroupData.id = :id")
})
public class ItemGroupData {

    public static  final String FIND_ITEM_GROUP_BY_ID = "FIND_ITEM_GROUP_BY_ID";

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


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "ITEM_GROUP_ITEM",
            joinColumns = {@JoinColumn(name = "ITEM_GROUP_ID" , table = "ITEM_GROUP", referencedColumnName="ID")},
            inverseJoinColumns = {@JoinColumn(name = "ITEM_ID" , table = "ITEM", referencedColumnName="ID")})
    private List<ItemData> items;


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

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<ItemData> getItems() {
        return items;
    }

    public void setItems(List<ItemData> items) {
        this.items = items;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
