/**
* This is the Request page Controller class which delegates tasks to be performed based on the request mapping
*
* @author Varsha Das
*/

package com.cerner.MachineRequisition.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cerner.MachineRequisition.Model.RequestDetails;
import com.cerner.MachineRequisition.service.RequestService;
import com.cerner.MachineRequisition.service.impl.EmailServiceImpl;

//Request Page Controller Class
@Controller
public class RequestPagecontroller {
    @Autowired(required = true)
    RequestService requestservice;
    @Autowired(required = true)
    EmailServiceImpl emailservice;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayHome(Model model) {
        model.addAttribute("request", new RequestDetails());
        return "index"; // redirects to the home page
    }

    @RequestMapping(value = "/request.save", method = RequestMethod.POST)
    public String saveRequest(@Valid @ModelAttribute("request") RequestDetails details, BindingResult result,
            Model model) {
        if (result.hasErrors())
            return "/";
        else {
            requestservice.addRequestDetails(details);
            emailservice.setRequestId(details.getRequestid());
            emailservice.setCredentials(details.getCredential());
            System.out.println(details.getCredential());
            emailservice.setStartDate(details.getStartdate());
            emailservice.setEndDate(details.getEnddate());
            emailservice.setRequestorId(details.getAssocid());
            emailservice.setDivisionName(details.getDivname());
            emailservice.callEmailService();
            return "redirect:/";
        }
    }
}
