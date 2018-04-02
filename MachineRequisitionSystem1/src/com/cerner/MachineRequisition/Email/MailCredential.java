package com.cerner.MachineRequisition.Email;

public class MailCredential {
    public int requestId;
    public String requestorId;
    public String credentials;
    public String divisionName;
    public String adminName;
    public String adminEmail;

    public MailCredential() {
        super();
    }

    public String getAdminEmail() {
        return adminEmail;
    }
    
    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

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

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String admin) {
        this.adminName = admin;
    }

}
