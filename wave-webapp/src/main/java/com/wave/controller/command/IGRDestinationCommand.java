package com.wave.controller.command;



public class IGRDestinationCommand {
	
	private Long Id;
	private String name;
	private String registeredName;
	private String specialty;
	private String practiceName;
	private String registeredPracticeName;
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