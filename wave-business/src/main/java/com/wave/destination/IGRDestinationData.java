package com.wave.destination;


import javax.persistence.*;

@Entity
@Table(name = "IGR_DESTINATION")
public class IGRDestinationData {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Long Id;

    @Column(name = "NAME")
	private String name;

    @Column(name = "REG_NAME")
	private String registeredName;

    @Column(name = "SPECIALITY")
	private String specialty;

    @Column(name = "PRACTICE_NAME")
	private String practiceName;

    @Column(name = "REG_PRACTICE_NAME")
	private String registeredPracticeName;

    @Column(name = "REFERRED_TO")
	private String referredTo;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisteredName() {
        return registeredName;
    }

    public void setRegisteredName(String registeredName) {
        this.registeredName = registeredName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPracticeName() {
        return practiceName;
    }

    public void setPracticeName(String practiceName) {
        this.practiceName = practiceName;
    }

    public String getRegisteredPracticeName() {
        return registeredPracticeName;
    }

    public void setRegisteredPracticeName(String registeredPracticeName) {
        this.registeredPracticeName = registeredPracticeName;
    }

    public String getReferredTo() {
        return referredTo;
    }

    public void setReferredTo(String referredTo) {
        this.referredTo = referredTo;
    }
}