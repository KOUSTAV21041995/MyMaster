/**
* This is the MachineCredentialService Interface which declares a boolean method
* 
* @author Varsha Das
*/

package com.cerner.MachineRequisition.service;

public interface MachineCredentialService {
    public String getDivisionNamebyIP(String credential);

    public String getDivisionNamebyServer(String credential);
}
