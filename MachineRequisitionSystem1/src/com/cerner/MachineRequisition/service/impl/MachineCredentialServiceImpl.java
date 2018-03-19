package com.cerner.MachineRequisition.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cerner.MachineRequisition.Dao.MachineCredentialsDao;
import com.cerner.MachineRequisition.service.MachineCredentialService;
@Service("machinecredservice")
public class MachineCredentialServiceImpl implements MachineCredentialService {
	@Autowired
	private MachineCredentialsDao machinecreddao;
	
	@Override
	@Transactional
	public String getDivNamebyIP(String credential) {
		return machinecreddao.getDivisionNamebyIP(credential);
	}
	@Override
	@Transactional
	public String getDivNamebyServer(String credential) {
		return machinecreddao.getDivisionNamebyServer(credential);
	}
	public MachineCredentialsDao getdao() {
		return machinecreddao;
	}
	public void setMachinecreddao(MachineCredentialsDao machinecreddao) {
		this.machinecreddao = machinecreddao;
	}
	public boolean isIp() {
		return true;
		
	}
}
