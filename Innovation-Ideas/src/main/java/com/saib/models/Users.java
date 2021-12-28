package com.saib.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@Column(name="user_id")
	private long UserId;
	
	@Column(name="full_name")
	private String FullName;
	
	
	@NotBlank(message = "user name is mandatory")
	@Column(name="user_name")
	private String UserName;
	
	@NotBlank(message = "email is mandatory")
	@Column(name="email")
	private String email;
	
	@NotBlank(message = "phone is mandatory")
	@Column(name="phone_num")
	private String PhoneNum;
	
	@Column(name="city")
	private String city;
	
	@NotBlank(message = "password is mandatory")
	@Column(name="password")
	private String password;
	
/*	@Column(name="SAIB_employee")
	private boolean SAIBEmployee;
*/	
	@Column(name="employee_number")
	private long EmployeeNumber;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(long userId, String fullName, String userName, String email, String phoneNum, String city,
			String password, long employeeNumber) {
		super();
		UserId = userId;
		FullName = fullName;
		UserName = userName;
		this.email = email;
		PhoneNum = phoneNum;
		this.city = city;
		this.password = password;
		EmployeeNumber = employeeNumber;
	}

	public long getUserId() {
		return UserId;
	}

	public void setUserId(long userId) {
		UserId = userId;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return PhoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		PhoneNum = phoneNum;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getEmployeeNumber() {
		return EmployeeNumber;
	}

	public void setEmployeeNumber(long employeeNumber) {
		EmployeeNumber = employeeNumber;
	}

	@Override
	public String toString() {
		return "Users [UserId=" + UserId + ", FullName=" + FullName + ", UserName=" + UserName + ", email=" + email
				+ ", PhoneNum=" + PhoneNum + ", city=" + city + ", password=" + password + ", EmployeeNumber="
				+ EmployeeNumber + "]";
	}

	
	
	}
