package com.cerner.MachineRequisition.Email;

import com.cerner.MachineRequisition.controllers.AdminDetailsController;

public class MailContent {
    //AdminDetailsController adc=new AdminDetailsController();
	public int requestId = 100;
	public String requestorId = "KG056519";
	public String credentials = "172.10.10.1";
	public String divisionName = "HR";
	public String admin = "Rahul"; 

	public String getContent() {

		String content = "<html>";
		content += "<body><table style=\"padding:4px;border-style:double;\">";
		content += "<tr><td style=\"background-color:#0B94D0;padding:10px;font-size:30px;color:white;\">Machine Requisition System</td></tr>";
		content += "<tr><td><br>";
		content += "<i><b>Dear "+admin+",</b></i><br><br>";
		content += "<b>The request with the following credentials is waiting for your approval:</b><br><br>";
		content += "<b>Requestor Id: </b>" + "<font color=blue>" + requestorId + "</font><br>";
		content += "<b>Ip Address: </b>" + "<font color=blue>" + credentials + "</font><br>";
		content += "<b>Division name: </b>" + "<font color=blue>" + divisionName + "</font><br><br>";
		content += "<font color=red>This is an auto generated email. Please do not reply</font><br><br>";
		content += "<img src=\"cid:image\"><br>";
		content += "</td></tr></table>";
		content += "</body>";
		content += "</html>";
		return content;
	}

}
