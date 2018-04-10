/**
* This is the Admin Details Controller class
* It handles the request and response based on the request mapping for getting Admin details
* 
* @author Rahul Ghata
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

import com.cerner.MachineRequisition.Email.MailCredential;
import com.cerner.MachineRequisition.Email.EmailGenerator;
import com.cerner.MachineRequisition.service.AdminDetailsService;

@Controller
public class AdminDetailsController {
    @Autowired(required = true)
    AdminDetailsService admindetailservice;
    
    MailCredential mc;
    
    public AdminDetailsController() {
        super();
    }

    // maps to Ajax url
    @RequestMapping(value = "/getAdminMail", method = RequestMethod.POST)
    public @ResponseBody void AdminEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String credential = request.getParameter("divName");
        String adminemail = admindetailservice.getAdminEmailByDiv(credential);
        mc=new MailCredential();
        mc.setAdminEmail(adminemail);
        out.println(adminemail);
    } 
    
    @RequestMapping(value="/mail", method = RequestMethod.POST)
    public String sendMail() {
        MailCredential mailcredential = new MailCredential();
        EmailGenerator sendmail = new EmailGenerator();
        String adminemail="Koustav.Ghosh@cerner.com";
        sendmail.send(adminemail, "Koustav.Ghosh@cerner.com", mailcredential.requestId, mailcredential.getContent());
        return "redirect:/Confirmation";
    }
}
