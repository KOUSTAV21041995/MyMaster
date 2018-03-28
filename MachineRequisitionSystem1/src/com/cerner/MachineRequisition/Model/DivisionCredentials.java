package com.cerner.MachineRequisition.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="division")
public class DivisionCredentials {
	@Column(name="DivisionName")
	private String DivisionName;
	@Column(name="AdminName")
	private String AdminName;
	@Column(name="AdminEmail")
	private String AdminEmail;
	@Id
	@Column(name="DivisionCode")
	private String DivisionCode;
	
	public DivisionCredentials() {
		super();
	}
	
	public DivisionCredentials(String divisionName, String adminName, String adminEmail, String divisionCode) {
		super();
		DivisionName = divisionName;
		AdminName = adminName;
		AdminEmail = adminEmail;
		DivisionCode = divisionCode;
	}

	public String getDivisionName() {
		return DivisionName;
	}

	public void setDivisionName(String divisionName) {
		DivisionName = divisionName;
	}

	public String getAdminName() {
		return AdminName;
	}

	public void setAdminName(String adminName) {
		AdminName = adminName;
	}

	public String getAdminEmail() {
		return AdminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		AdminEmail = adminEmail;
	}

	public String getDivisionCode() {
		return DivisionCode;
	}

	public void setDivisionCode(String divisionCode) {
		DivisionCode = divisionCode;
	}
}
