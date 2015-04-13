package com.wave.contact;

import javax.persistence.*;

@Entity
@Table(name = "CONTACT_DETAILS")
@NamedQueries({

        @NamedQuery(name = ContactData.FIND_CONTACT_BY_ID, query =
                "SELECT " +
                        "addressData " +
                        "FROM " +
                        "ContactData addressData " +
                        "WHERE " +
                        "addressData.id = :id")
})
public class ContactData {

    public static final String FIND_CONTACT_BY_ID = "FIND_CONTACT_BY_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Version
    @Column(name="VERSION")
    private Long version;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "FAX")
    private String fax;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PREFERRED_CONTACT")
    private String preferred;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPreferred() {
        return preferred;
    }

    public void setPreferred(String preferred) {
        this.preferred = preferred;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
