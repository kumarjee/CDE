package com.infosys.internal.cde.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@SuppressWarnings("serial")
@Table(name = "admin")
public class Admin {

	@Id
	@GeneratedValue
	@Column(name = "admin_id")
	private Long adminId;

	@Column(name = "admin_name")
	private String adminName;

	@NotEmpty
	@Column(name = "admin_email")
	private String adminEmail;

	@NotEmpty
	@Column(name = "password")
	private String password;

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
}
