package com.vedant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class signupMentorModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String experise;
	
	private String city;
	
	private String gitlink;
	
	private String phone; 
	
	private String availability;

	public signupMentorModel() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExperise() {
		return experise;
	}

	public void setExperise(String experise) {
		this.experise = experise;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGitlink() {
		return gitlink;
	}

	public void setGitlink(String gitlink) {
		this.gitlink = gitlink;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "signupMentorModel [id=" + id + ", name=" + name + ", email=" + email + ", experise=" + experise
				+ ", city=" + city + ", gitlink=" + gitlink + ", phone=" + phone + ", availability=" + availability
				+ "]";
	}
	
	
	
}
