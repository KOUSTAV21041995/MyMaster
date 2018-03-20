package com.cerner.MachineRequisition.service;

public interface MachineCredentialService {
	public String getDivisionNamebyIP(String credential);
	public String getDivisionNamebyServer(String credential);
}
