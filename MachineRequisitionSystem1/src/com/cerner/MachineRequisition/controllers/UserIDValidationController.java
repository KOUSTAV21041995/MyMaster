/**
* This is the UserIdValidation Controller class which handles 
* the request for RequestorId validation based on the request mapping
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

import com.cerner.MachineRequisition.service.AssociateDetailsService;

@Controller
public class UserIDValidationController {
    @Autowired(required = true)
    AssociateDetailsService assodetailservice;

    // maps to the AJAX url
    @RequestMapping(value = "/RequestorIDValidation", method = RequestMethod.POST)
    public @ResponseBody void validateUserId(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, NullPointerException {
        PrintWriter out = resp.getWriter();
        String credential = req.getParameter("associateId");
        out.println(assodetailservice.isValidUserID(credential));
    }
}
