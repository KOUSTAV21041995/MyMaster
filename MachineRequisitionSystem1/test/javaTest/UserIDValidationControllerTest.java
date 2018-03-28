package javaTest;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.cerner.MachineRequisition.Model.AssociateDetails;
import com.cerner.MachineRequisition.controllers.UserIDValidationController;
import com.cerner.MachineRequisition.service.impl.AssociateDetailsServiceImpl;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class UserIDValidationControllerTest extends TestCase{
    @Mock 
    AssociateDetailsServiceImpl ServiceImpl;
    @InjectMocks
    private UserIDValidationController controller;
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Before
    public void setUp() throws Exception {
      MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testUserIDValidation() throws Exception {
        AssociateDetails ad = new AssociateDetails();
        ad.setAssociateId("KG056715");
        Mockito.when(ServiceImpl.isValidUserID(ad.getAssociateId())).thenReturn(true);
        ad.setAssociateId("056715");
        Mockito.when(ServiceImpl.isValidUserID(ad.getAssociateId())).thenReturn(false);
    }
    
    @Test
    public void testServletUserId() throws Exception {      
        Mockito.when(request.getParameter("associateId")).thenReturn("KG056715");
        StringWriter stringwriter = new StringWriter();
        PrintWriter printwriter = new PrintWriter(stringwriter);
        Mockito.when(response.getWriter()).thenReturn(printwriter);
        controller.ValidateUserId(request, response);   
    }
}
