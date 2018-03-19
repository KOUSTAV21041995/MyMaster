package com.cerner.MachineRequisition.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Home Page Controller Class
@Controller
public class RequestPagecontroller {
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String displayHome() {
		return "index";//redirect to index file
	}

}
