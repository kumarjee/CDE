package com.infosys.internal.cde.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@SuppressWarnings("serial")
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "password")
	private String password;

	@Column(name = "phone_no")
	private String phoneNo;

	@Column(name = "address")
	private String address;
	
	//added to find activation status of user
	@Column(name ="status")
	private String status;
	
	@Column(name="random")
	private int random;

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRandom() {
		return random;
	}

	public void setRandom(int random) {
		this.random = random;
	}
}
