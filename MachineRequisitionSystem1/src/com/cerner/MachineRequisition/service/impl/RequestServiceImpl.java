/**
* This is a Service implementation class for handling insertion
* of data into the request table
*
* @author  Varsha Das
*          Software Intern,DevAcademy India 
*/
package com.cerner.MachineRequisition.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cerner.MachineRequisition.Dao.MachineCredentialsDao;
import com.cerner.MachineRequisition.Dao.RequestDao;
import com.cerner.MachineRequisition.Model.RequestDetails;
import com.cerner.MachineRequisition.service.RequestService;

@Service("requestservice")
public class RequestServiceImpl implements RequestService {
	@Autowired
	private RequestDao requestdao;

	@Override
	@Transactional
	public boolean addRequestDetails(RequestDetails requestdetails) {
		return requestdao.addRequestDetails(requestdetails);
	}
}
