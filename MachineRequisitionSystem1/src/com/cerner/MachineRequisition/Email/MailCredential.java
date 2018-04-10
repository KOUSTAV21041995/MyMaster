package com.cerner.MachineRequisition.Email;

public class MailCredential {
    public int requestId;
    public String requestorId;
    public String credentials;
    public String divisionName;
    public String adminName;
    public String startDate;
    public String endDate;
    public String adminEmail;
    public String managerEmail;

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

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

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
    
    public String getContent() {

		String content = "<html>";
		content += "<body><table style=\"padding:4px;border-style:double;\">";
		content += "<tr><td style=\"background-color:#0B94D0;padding:10px;font-size:30px;color:white;\">Machine Requisition System</td></tr>";
		content += "<tr><td><br>";
		content += "<i><b>Dear " + adminName + ",</b></i><br><br>";
		content += "<b>The request with the following credentials is waiting for your approval:</b><br><br>";
		content += "<b>Requestor Id: </b>" + "<font color=blue>" + requestorId + "</font><br>";
		content += "<b>Ip Address: </b>" + "<font color=blue>" + credentials + "</font><br>";
		content += "<b>Division name: </b>" + "<font color=blue>" + divisionName + "</font><br>";
		content += "<b>Start Date: </b>" + "<font color=blue>" + startDate + "</font><br>";
		content += "<b>End Date: </b>" + "<font color=blue>" + endDate + "</font><br><br>";	
		content += "<font color=red>This is an auto generated email. Please do not reply</font><br><br>";
		content += "<img src=\"cid:image\"><br>";
		content += "</td></tr></table>";
		content += "</body>";
		content += "</html>";
		return content;
	}
}
