package com.cerner.MachineRequisition.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cerner.MachineRequisition.service.MachineCredentialService;

@Controller
public class MachineCredentialController {
	@Autowired(required=true)
	MachineCredentialService machinecredservice;
	
	@RequestMapping(value="/credentialbyIP", method=RequestMethod.POST)
	public  @ResponseBody void DivNamebyIP(HttpServletRequest req,HttpServletResponse resp) throws IOException,NullPointerException {
		PrintWriter out = resp.getWriter();
	    String credential=req.getParameter("credentialvalue");
	    System.out.println(credential);
	    	out.println(machinecredservice.getDivNamebyIP(credential));
	    
	  		
	}
	
	@RequestMapping(value="/credentialbyServer", method=RequestMethod.POST)
	public  @ResponseBody void DivNamebyServer(HttpServletRequest req,HttpServletResponse resp) throws IOException,NullPointerException {
		PrintWriter out = resp.getWriter();
	    String credential=req.getParameter("credentialvalue");
	    System.out.println(credential);
	    	out.println(machinecredservice.getDivNamebyServer(credential));
	  
	   
	  			
	}

}
