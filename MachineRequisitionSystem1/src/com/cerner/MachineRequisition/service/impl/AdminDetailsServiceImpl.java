/** The AdminDetails service class implements the service interface 
 *  It provides logic to operate on the data sent to and from the AdminDetails DAO and the client
 * 
 *  @author Rahul Ghata
 */
package com.cerner.MachineRequisition.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerner.MachineRequisition.Dao.AdminDetailsDao;
import com.cerner.MachineRequisition.service.AdminDetailsService;

@Service("admindetailservice")
public class AdminDetailsServiceImpl implements AdminDetailsService {
    @Autowired
    private AdminDetailsDao admindetaildao;

    @Override
    @Transactional
    public String getAdminEmailByDiv(String credential) {
        return admindetaildao.getAdminEmailByDiv(credential);
    }
}
