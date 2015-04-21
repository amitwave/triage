package com.wave.user.dao;

import com.wave.role.RoleData;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "USER")
@NamedQueries({
        @NamedQuery(name = UserData.FIND_BY_USER_NAME, query =
                "SELECT " +
                        "user " +
                        "FROM " +
                        "UserData user " +
                        "WHERE " +
                        "user.userName = :name"),
        @NamedQuery(name = UserData.FIND_BY_USER_ID, query =
                "SELECT " +
                        "user " +
                        "FROM " +
                        "UserData user " +
                        "WHERE " +
                        "user.userId = :id"),
        @NamedQuery(name = UserData.FIND_ALL_NEW_USERS, query =
                "SELECT " +
                        "user " +
                        "FROM " +
                        "UserData user " +
                        "WHERE " +
                        "user.active = 0"),
        @NamedQuery(name = UserData.FIND_ALL_USERS, query =
                "SELECT " +
                        "user " +
                        "FROM " +
                        "UserData user ")
})
public class UserData {

    public static final String FIND_BY_USER_NAME = "FIND_BY_USER_NAME";
    public static final String FIND_BY_USER_ID = "FIND_BY_USER_ID";
    public static final String FIND_ALL_NEW_USERS = "FIND_ALL_NEW_USERS";
    public static final String FIND_ALL_USERS = "FIND_ALL_USERS";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long userId;


    @Column(name = "USER_GUID")
    private String userGuid;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "DISPLAY_NAME")
    private String displayName;

    @Column(name = "CREATED_DATE")
    private Date createDate = new Date();

    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "EMAIL_ADDRESS")
    private String email;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "ACTIVE")
    private Boolean active;


    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {@JoinColumn(name = "USER_ID" , table ="USER", referencedColumnName="ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID" , table = "ROLE", referencedColumnName="ID")})
    private List<RoleData> roles;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


    public List<RoleData> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleData> roles) {
        this.roles = roles;
    }
}