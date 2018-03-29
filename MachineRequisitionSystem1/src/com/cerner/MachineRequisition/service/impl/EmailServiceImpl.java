package com.cerner.MachineRequisition.service.impl;

import org.springframework.stereotype.Service;

import com.cerner.MachineRequisition.Email.EmailCredential;
import com.cerner.MachineRequisition.Email.EmailGenerator;
import com.cerner.MachineRequisition.service.EmailService;
@Service("emailservice")
public class EmailServiceImpl implements EmailService {
    
    EmailCredential emailcredential = new EmailCredential();
    EmailGenerator emailgenerator = new EmailGenerator();
    public String adminemail;
    public int requestId;
    
    public String getAdminemail() {
        return adminemail;
    }
    public void setAdminemail(String adminemail) {
        this.adminemail = adminemail;
    }
    public int getRequestId() {
        return requestId;
    }
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
   /* @Autowired
    AdminDetailsDaoImpl admindetaildao = new AdminDetailsDaoImpl();*/
    @Override
    public void callEmailService() {
        //admindetaildao.getAdminEmailByDiv(credential);
        emailgenerator.send(getAdminemail(), "vdaskol@gmail.com", getRequestId(), emailcredential.getContent());
    }
}
