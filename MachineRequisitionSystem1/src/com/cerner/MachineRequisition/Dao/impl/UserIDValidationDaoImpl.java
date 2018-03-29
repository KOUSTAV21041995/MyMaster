/**
* This is the Dao Interface implementation for UserIDValidation
* This class interacts with the database using HQL to check the ID
* 
* @author Rahul Ghata
*/

package com.cerner.MachineRequisition.Dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cerner.MachineRequisition.Dao.UserIDValidationDao;
import com.cerner.MachineRequisition.Model.AssociateDetails;

@Repository
public class UserIDValidationDaoImpl implements UserIDValidationDao {

	@Autowired
	private SessionFactory session;

	/**
	 * function isValidUserID() checks database for Id validity
	 * 
	 * @return boolean
	 */
	@Override
	public boolean isValidUserID(String associateId) {
		try {
			Session currentsession = session.getCurrentSession();
			String getId = "From AssociateDetails where associateId= " + "'" + associateId + "'";
			Query query = currentsession.createQuery(getId);
			AssociateDetails details = (AssociateDetails) query.getSingleResult();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
