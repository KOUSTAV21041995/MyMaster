package com.cerner.MachineRequisition.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cerner.MachineRequisition.Dao.MachineCredentialsDao;
import com.cerner.MachineRequisition.service.MachineCredentialService;

@Service("machinecredentialservice")
public class MachineCredentialServiceImpl implements MachineCredentialService {
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
	
	
}
