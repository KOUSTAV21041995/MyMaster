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
	private String divname;
	@Column(name="ServerName")
	private String servername;
	public MachineCredentials() {
		super();
	}
	public MachineCredentials(String ipAddress, int divcode, String servername,String divname) {
		super();
		this.ipAddress = ipAddress;
		this.divcode = divcode;
		this.servername = servername;
		this.divname=divname;
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
	public String getDivname() {
		return divname;
	}
	public void setDivname(String divname) {
		this.divname = divname;
	}
	
}

		
