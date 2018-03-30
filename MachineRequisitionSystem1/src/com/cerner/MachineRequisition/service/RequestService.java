/**
* This is a service layer interface for handling insertion of data
* 
* @author  Varsha Das
*          Software Intern,DevAcademy India 
*/
package com.cerner.MachineRequisition.service;

import com.cerner.MachineRequisition.Model.RequestDetails;

public interface RequestService {
    public boolean addRequestDetails(RequestDetails requestdetails);
}
