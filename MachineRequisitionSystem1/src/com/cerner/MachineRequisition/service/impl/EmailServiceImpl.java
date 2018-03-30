/**
 * This is the Email service class 
 */
package com.cerner.MachineRequisition.service.impl;

import org.springframework.stereotype.Service;

import com.cerner.MachineRequisition.Email.EmailGenerator;
import com.cerner.MachineRequisition.service.EmailService;

@Service("emailservice")
public class EmailServiceImpl implements EmailService {

    EmailGenerator emailGenerator = new EmailGenerator();
    public String adminEmail;
    public int requestId;
    public String adminName;
    public String requestorId;
    public String credentials;
    public String divisionName;
    public String startDate;
    public String endDate;
    public String managerEmail;

    public String getRequestorId() {
        return requestorId;
    }

    public void setRequestorId(String requestorId) {
        this.requestorId = requestorId;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String adminemail(String adminemail) {
        return adminemail;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminemail() {
        return adminEmail;
    }

    public void setAdminemail(String adminemail) {
        this.adminEmail = adminemail;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getContent() {

        String content = "<html>";
        content += "<body><table style=\"padding:4px;border-style:double;\">";
        content += "<tr><td style=\"background-color:#0B94D0;padding:10px;font-size:30px;color:white;\">Machine Requisition System</td></tr>";
        content += "<tr><td><br>";
        content += "<i><b>Dear " + getAdminName() + ",</b></i><br><br>";
        content += "<b>The request with the following credentials is waiting for your approval:</b><br><br>";
        content += "<b>Requestor Id: </b>" + "<font color=blue>" + getRequestorId() + "</font><br>";
        content += "<b>Ip Address: </b>" + "<font color=blue>" + getCredentials() + "</font><br>";
        content += "<b>Division name: </b>" + "<font color=blue>" + getDivisionName() + "</font><br>";
        content += "<b>Start Date: </b>" + "<font color=blue>" + getStartDate() + "</font><br>";
        content += "<b>End Date: </b>" + "<font color=blue>" + getEndDate() + "</font><br><br>";
        content += "<font color=red>This is an auto generated email. Please do not reply</font><br><br>";
        content += "<img src=\"cid:image\"><br>";
        content += "</td></tr></table>";
        content += "</body>";
        content += "</html>";
        return content;
    }

    @Override
    public void callEmailService() {

        emailGenerator.send(getAdminemail(), "varsha.das@cerner.com", getRequestId(), getContent());
    }
}
