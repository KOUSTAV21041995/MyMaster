/**
* This is the Dao Interface implementation for AdminDetails
* This class interacts with the database using HQL to fetch the Admin email address
*  
* @author Rahul Ghata
*/
package com.cerner.MachineRequisition.Dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cerner.MachineRequisition.Dao.AdminDetailsDao;
import com.cerner.MachineRequisition.Model.AdminDetails;

@Repository
public class AdminDetailsDaoImpl implements AdminDetailsDao {
    @Autowired
    private SessionFactory sessionfactory;

    @Override
    public String getAdminEmailByDiv(String credential) {
        String adminEmail = "";
        try {
            Session currentsession = sessionfactory.getCurrentSession();
            String adminDetails = "From AdminDetails where divName=" + "'" + credential + "'";
            Query query = currentsession.createQuery(adminDetails);
            AdminDetails ad = (AdminDetails) query.getSingleResult();
            // fetch the corresponding admin email
            adminEmail = ad.getAdminEmail();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return adminEmail;
    }
}
