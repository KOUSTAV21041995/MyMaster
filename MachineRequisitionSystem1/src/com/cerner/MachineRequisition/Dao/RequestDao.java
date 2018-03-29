/**
* This is a DAO interface concerned with insertion of data in MySQL database
*
* @author  Varsha Das
*          Software Intern,DevAcademy India 
*/
package com.cerner.MachineRequisition.Dao;

import com.cerner.MachineRequisition.Model.RequestDetails;

public interface RequestDao {
	public boolean addRequestDetails(RequestDetails requestdetails);
}
