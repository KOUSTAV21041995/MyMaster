package com.cerner.MachineRequisition.Dao;

public interface MachineCredentialsDao {
	public String getDivisionNamebyIP(String credential);
	public String getDivisionNamebyServer(String credential);


}
