package com.cerner.MachineRequisition.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Home Page Controller Class
@Controller
public class RequestPagecontroller {
	
	@RequestMapping("/")
	public String displayHome() {
		return "index";//redirect to index file
	}

}
