package com.cerner.MachineRequisition.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Home Page Controller Class
@Controller
public class RequestPagecontroller {
    
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String displayHome() {
		return "index";        //redirects to the home page
	}
	
	@RequestMapping(value="/Confirmation",method = RequestMethod.GET)
	public String displayConfirmationPage() {
		return "Confirmation";        //redirects to the Confirmation page
	}
	@RequestMapping(value="/backToRequest",method = RequestMethod.GET)
	public String backToRequest() {
		return "index";        //redirects to the Confirmation page
	}
}


