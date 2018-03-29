/**
* This is a DAO implementation class which uses 
* Hibernate Query language to communicate with the
* Model class and insert data accordingly.
*
* @author  Varsha Das
*          Software Intern,DevAcademy India 
*/
package com.cerner.MachineRequisition.Dao.impl;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cerner.MachineRequisition.Dao.RequestDao;
import com.cerner.MachineRequisition.Model.MachineCredentials;
import com.cerner.MachineRequisition.Model.RequestDetails;

@Repository
public class RequestDaoImpl implements RequestDao {
	@Autowired
	private SessionFactory sessionFactory;
	int RequestId = 0;

	@Override
	public boolean addRequestDetails(RequestDetails requestdetails) {
		boolean saveFlag = false;
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			// setting the request ID with an unique random number
			requestdetails.setRequestid(randomIdGenerator());
			currentSession.save(requestdetails);
			saveFlag = true;
		} catch (Exception e) {
			saveFlag = false;
		}
		return saveFlag;
	}

	public int randomIdGenerator() {
		Random random = new Random();
		int randomInteger = Math.abs(random.nextInt());
		RequestId = randomInteger;
		return RequestId;
	}
}
