package com.vedant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class paymentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String referralCode;
	
	private String address;
	
	private String city;
	
	private String state;

	private String hashedzip;
	
	private String hashednameOnCard;
	
	private String hashedcardNumber;
	
	private String hashedexpiryMonth;
	
	private String hashedexpiryYear;
	
	private String hashedCVV;
	
	

	public paymentModel() {
		
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

	public String getReferralCode() {
		return referralCode;
	}

	public void setReferralCode(String referralCode) {
		this.referralCode = referralCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getHashedzip() {
		return hashedzip;
	}

	public void setHashedzip(String hashedzip) {
		this.hashedzip = hashedzip;
	}

	public String getHashednameOnCard() {
		return hashednameOnCard;
	}

	public void setHashednameOnCard(String hashednameOnCard) {
		this.hashednameOnCard = hashednameOnCard;
	}

	public String getHashedcardNumber() {
		return hashedcardNumber;
	}

	public void setHashedcardNumber(String hashedcardNumber) {
		this.hashedcardNumber = hashedcardNumber;
	}

	public String getHashedexpiryMonth() {
		return hashedexpiryMonth;
	}

	public void setHashedexpiryMonth(String hashedexpiryMonth) {
		this.hashedexpiryMonth = hashedexpiryMonth;
	}

	public String getHashedexpiryYear() {
		return hashedexpiryYear;
	}

	public void setHashedexpiryYear(String hashedexpiryYear) {
		this.hashedexpiryYear = hashedexpiryYear;
	}

	public String getHashedCVV() {
		return hashedCVV;
	}

	public void setHashedCVV(String hashedCVV) {
		this.hashedCVV = hashedCVV;
	}

	@Override
	public String toString() {
		return "paymentModel [id=" + id + ", name=" + name + ", email=" + email + ", referralCode=" + referralCode
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", hashedzip=" + hashedzip
				+ ", hashednameOnCard=" + hashednameOnCard + ", hashedcardNumber=" + hashedcardNumber
				+ ", hashedexpiryMonth=" + hashedexpiryMonth + ", hashedexpiryYear=" + hashedexpiryYear + ", hashedCVV="
				+ hashedCVV + "]";
	}


	
	
}
