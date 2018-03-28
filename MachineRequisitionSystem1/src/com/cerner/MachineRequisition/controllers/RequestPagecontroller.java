package com.cerner.MachineRequisition.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cerner.MachineRequisition.mail.MailContent;
import com.cerner.MachineRequisition.mail.SendMail;

//Home Page Controller Class
@Controller
public class RequestPagecontroller {
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String displayHome() {
		return "index";//redirect to index file
	}

	@RequestMapping(value="/mail", method = RequestMethod.POST)
	public String mailSend() {
		MailContent mailcontent = new MailContent();
		SendMail sendmail = new SendMail();
		sendmail.send( "Koustav.Ghosh@cerner.com","Varsha.Das@cerner.com", mailcontent.requestId, mailcontent.getContent());
		return "redirect:/";
	}
}
