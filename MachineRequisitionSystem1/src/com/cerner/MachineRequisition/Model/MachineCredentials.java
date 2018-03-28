package com.cerner.MachineRequisition.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="machine")
public class MachineCredentials {
	@Id
	@Column(name="ipAddress")
	private String ipAddress;
	@Column(name="DivisionCode")
	private int divcode;
	@Column(name="DivisionName")
	private String divisionName;
	@Column(name="ServerName")
	private String servername;
	public MachineCredentials() {
		super();
	}	
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}	
	public String getServername() {
		return servername;
	}
	public void setServername(String servername) {
		this.servername = servername;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divname) {
		this.divisionName = divname;
	}	
}

		
