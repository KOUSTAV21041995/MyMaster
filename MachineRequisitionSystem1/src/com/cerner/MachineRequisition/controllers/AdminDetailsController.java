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

<<<<<<< HEAD
import com.cerner.MachineRequisition.Email.MailCredential;
import com.cerner.MachineRequisition.Email.EmailGenerator;
=======
>>>>>>> ef7139c9266eb040f84a785a38c478798cdfa731
import com.cerner.MachineRequisition.service.AdminDetailsService;
import com.cerner.MachineRequisition.service.impl.EmailServiceImpl;

@Controller
public class AdminDetailsController {
    @Autowired(required = true)
    AdminDetailsService admindetailservice;
    @Autowired(required = true)
    EmailServiceImpl emailservice;

    public AdminDetailsController() {
        super();
    }

    // maps to Ajax url
    @RequestMapping(value = "/getAdminMail", method = RequestMethod.POST)
    public @ResponseBody void AdminEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String credential = request.getParameter("divName");
        String adminemail = admindetailservice.getAdminEmailByDiv(credential);
<<<<<<< HEAD
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
=======
        emailservice.setAdminemail(adminemail);
        // emailservice.adminemail(adminemail);
        /*
         * System.out.println(adminemail); emailservice.setAdminemail(adminemail);
         */ out.println(adminemail);
>>>>>>> ef7139c9266eb040f84a785a38c478798cdfa731
    }
}
