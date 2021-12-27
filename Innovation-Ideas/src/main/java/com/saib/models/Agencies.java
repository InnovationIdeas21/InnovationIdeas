package com.saib.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agencies")
public class Agencies{
	@Id
	
	@Column(name = "agency_id")
	private long agencyId;
	
	@Column(name = "agency_name")
	private String agencyName;
	
	@Column(name = "agency_email")
	private String agencyEmail;
	
	@Column(name = "agency_phonenum")
	private String agencyPhonenum;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	@Column(name = "password")
	private String password;
	
	

	public Agencies() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agencies(long agencyId, String agencyName, String agencyEmail, String agencyPhonenum, String country,
			String city, String postalCode, String password) {
		super();
		this.agencyId = agencyId;
		this.agencyName = agencyName;
		this.agencyEmail = agencyEmail;
		this.agencyPhonenum = agencyPhonenum;
		this.country = country;
		this.city = city;
		this.postalCode = postalCode;
		this.password = password;
	}

	public long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(long agencyId) {
		this.agencyId = agencyId;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getAgencyEmail() {
		return agencyEmail;
	}

	public void setAgencyEmail(String agencyEmail) {
		this.agencyEmail = agencyEmail;
	}

	public String getAgencyPhonenum() {
		return agencyPhonenum;
	}

	public void setAgencyPhonenum(String agencyPhonenum) {
		this.agencyPhonenum = agencyPhonenum;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Agencies [agencyId=" + agencyId + ", agencyName=" + agencyName + ", agencyEmail=" + agencyEmail
				+ ", agencyPhonenum=" + agencyPhonenum + ", country=" + country + ", city=" + city + ", postalCode="
				+ postalCode + ", password=" + password + "]";
	}
	
	

}