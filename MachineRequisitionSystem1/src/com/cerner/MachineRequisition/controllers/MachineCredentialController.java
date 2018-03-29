/**
 * This is the MachineCredentialController class which handles
* the request and response based on the request mapping for auto population of divisionName
* 
* @author Varsha Das
*/

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
	@Autowired(required = true)
	MachineCredentialService machinecredentialservice;

	public MachineCredentialController() {
		super();
	}

	// maps to the AJAX url
	@RequestMapping(value = "/credentialbyIP", method = RequestMethod.POST)
	public @ResponseBody void DivisionNamebyIP(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter out = response.getWriter();
		String credential = request.getParameter("credentialvalue");
		out.println(machinecredentialservice.getDivisionNamebyIP(credential));
	}

	// maps to the AJAX url
	@RequestMapping(value = "/credentialbyServer", method = RequestMethod.POST)
	public @ResponseBody void DivisionNamebyServer(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PrintWriter out = resp.getWriter();
		String credential = req.getParameter("credentialvalue");
		out.println(machinecredentialservice.getDivisionNamebyServer(credential));
	}
}
