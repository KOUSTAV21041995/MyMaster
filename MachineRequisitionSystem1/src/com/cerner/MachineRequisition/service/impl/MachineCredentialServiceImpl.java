<<<<<<< HEAD
=======
/** The service class implements the service interface 
 *  It provides logic to operate on the data sent to and from the Machine Credential DAO and the client
 * 
 *  @author Varsha Das
 */

>>>>>>> ba8381470b6d1618adabb0bad9570f789d92ab1a
package com.cerner.MachineRequisition.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cerner.MachineRequisition.Dao.MachineCredentialsDao;
import com.cerner.MachineRequisition.service.MachineCredentialService;

@Service("machinecredentialservice")
public class MachineCredentialServiceImpl implements MachineCredentialService {
<<<<<<< HEAD
	@Autowired
	private MachineCredentialsDao machinecredentialdao;
	@Override
	@Transactional
	public String getDivisionNamebyIP(String credential) {
		return machinecredentialdao.getDivisionNamebyIP(credential);
	}
	@Override
	@Transactional
	public String getDivisionNamebyServer(String credential) {
		return machinecredentialdao.getDivisionNamebyServer(credential);
	}
	
	
=======
    @Autowired
    private MachineCredentialsDao machinecredentialdao;

    @Override
    @Transactional
    public String getDivisionNamebyIP(String credential) {
        return machinecredentialdao.getDivisionNamebyIP(credential);
    }

    @Override
    @Transactional
    public String getDivisionNamebyServer(String credential) {
        return machinecredentialdao.getDivisionNamebyServer(credential);
    }

>>>>>>> ba8381470b6d1618adabb0bad9570f789d92ab1a
}
