package com.cerner.MachineRequisition.Dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cerner.MachineRequisition.Dao.MachineCredentialsDao;
import com.cerner.MachineRequisition.Model.MachineCredentials;
@Repository
public class MachineCredentialDaoImpl implements MachineCredentialsDao {
	@Autowired
	private SessionFactory session;
	
	@Override
	public String getDivisionNamebyIP(String credential) {
		String mid="";
		try {
			Session currentsession=session.getCurrentSession();
			String hql = "From MachineCredentials where ipAddress="+"'"+credential+"'";
			Query query = currentsession.createQuery(hql);
			MachineCredentials cred=(MachineCredentials) query.getSingleResult();
			 mid=cred.getDivname();
				
		}
		catch(Exception e) {
			return "Invalid IP Address";
		}
		return mid;
		
	}
	@Override
	public String getDivisionNamebyServer(String credential) {
		String mid="";
		try {
			Session currentsession=session.getCurrentSession();
			String hql = "From MachineCredentials where servername="+"'"+credential+"'";
			
			Query query = currentsession.createQuery(hql);
			
			MachineCredentials cred=(MachineCredentials) query.getSingleResult();
			mid=cred.getDivname();
			
		}
		catch(Exception e) {
			return "Invalid Server Name";
		}
		return mid;
	}

}
