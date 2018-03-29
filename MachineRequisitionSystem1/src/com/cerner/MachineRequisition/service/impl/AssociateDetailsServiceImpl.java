/** The service class implements the service interface 
 *  It provides logic to operate on the data sent to and from the UserIDVAlidation DAO and the client
 * 
 * @author Rahul Ghata
 */

package com.cerner.MachineRequisition.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerner.MachineRequisition.Dao.UserIDValidationDao;
import com.cerner.MachineRequisition.service.AssociateDetailsService;

@Service("assodetailservice")
public class AssociateDetailsServiceImpl implements AssociateDetailsService {
	@Autowired
	private UserIDValidationDao useridvaldao;

	@Override
	@Transactional
	public boolean isValidUserID(String associateId) {
		return useridvaldao.isValidUserID(associateId);
	}

}
