/**
* This is the Dao Interface implementation for MachineCredentials
* This class interacts with the database using HQL to check the IP/Server Name
*  
* @author Varsha Das
*/

package com.cerner.MachineRequisition.Dao.impl;

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
    private SessionFactory sessionfactory;

    /**
     * function getDivisionNamebyIP() checks database for the presence of a particular IP
     * 
     * @return String
     */
    @Override
    public String getDivisionNamebyIP(String credential) {
        String DivisionName = "";
        try {
            Session currentsession = sessionfactory.getCurrentSession();
            String ipdetails = "From MachineCredentials where ipAddress=" + "'" + credential + "'";
            Query query = currentsession.createQuery(ipdetails);
            MachineCredentials machinecredentials = (MachineCredentials) query.getSingleResult();
            // fetch the corresponding division name from database
            DivisionName = machinecredentials.getDivisionName();
        } catch (Exception e) {
            // if no division name exists in database for that IP addresss
            return "Invalid IP Address";
        }
        return DivisionName;
    }

    /**
     * function getDivisionNamebyServer() checks database for the presence of a particular Server
     * 
     * @return String
     */
    @Override
    public String getDivisionNamebyServer(String credential) {
        String DivisionName = "";
        try {
            Session currentsession = sessionfactory.getCurrentSession();
            String serverdetails = "From MachineCredentials where servername=" + "'" + credential + "'";
            Query query = currentsession.createQuery(serverdetails);
            MachineCredentials machinecredentials = (MachineCredentials) query.getSingleResult();
            // fetch the corresponding division name from database
            DivisionName = machinecredentials.getDivisionName();
        } catch (Exception e) {
            // if no division name exists in database for that server name
            return "Invalid Server Name";
        }
        return DivisionName;
    }
}
