/**
 * This is the Machine Credential Controller test class
 * 
 * @author Varsha Das
 */

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

import com.cerner.MachineRequisition.Model.MachineCredentials;
import com.cerner.MachineRequisition.controllers.MachineCredentialController;
import com.cerner.MachineRequisition.service.impl.MachineCredentialServiceImpl;

import junit.framework.TestCase;

//@RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MachineCredentialControllerTest extends TestCase {
	@Mock
	MachineCredentialServiceImpl ServiceImpl;
	@InjectMocks
	private MachineCredentialController controller;
	@Mock
	HttpServletRequest request;
	@Mock
	HttpServletResponse response;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test divisionName with a mock object with IP
	 * 
	 * @throws Exception
	 * @return Nothing
	 */
	@Test
	public void testDivisionnamebyIP() throws Exception {
		MachineCredentials mc = new MachineCredentials();
		mc.setDivisionName("HR");
		mc.setIpAddress("172.10.10.2");
		Mockito.when(ServiceImpl.getDivisionNamebyIP(mc.getIpAddress())).thenReturn(mc.getDivisionName());
		mc.setIpAddress("151.134.90.23");

		mc.setDivisionName("IPEngineering");
		Mockito.when(ServiceImpl.getDivisionNamebyIP(mc.getIpAddress())).thenReturn(mc.getDivisionName());
		Mockito.when(ServiceImpl.getDivisionNamebyIP("2344143")).thenReturn("Please enter valid IP");
	}

	/**
	 * Test divisionName with a mock object with IP
	 * 
	 * @throws Exception
	 * @return Nothing
	 */
	@Test
	public void testDivisionNamebyServer() throws Exception {
		MachineCredentials mc = new MachineCredentials();
		mc.setDivisionName("HR");
		mc.setServername("server2");
		Mockito.when(ServiceImpl.getDivisionNamebyServer(mc.getServername())).thenReturn(mc.getDivisionName());
		mc.setDivisionName("CTS");
		mc.setServername("server3");
		Mockito.when(ServiceImpl.getDivisionNamebyServer(mc.getServername())).thenReturn(mc.getDivisionName());
	}

	/**
	 * The function tests the HTTP request and response
	 * 
	 * @throws Exception
	 * @return Nothing
	 */
	@Test
	public void testServletIP() throws Exception {
		Mockito.when(request.getParameter("credentialvalue")).thenReturn("172.10.10.2");
		StringWriter stringwriter = new StringWriter();
		PrintWriter printwriter = new PrintWriter(stringwriter);
		Mockito.when(response.getWriter()).thenReturn(printwriter);
		controller.DivisionNamebyIP(request, response);
	}

	/**
	 * The function tests the HTTP request and response
	 * 
	 * @throws Exception
	 * @return Nothing
	 */
	@Test
	public void testServletserver() throws Exception {
		Mockito.when(request.getParameter("credentialvalue")).thenReturn("server2");
		StringWriter stringwriter = new StringWriter();
		PrintWriter printwriter = new PrintWriter(stringwriter);
		Mockito.when(response.getWriter()).thenReturn(printwriter);
		controller.DivisionNamebyServer(request, response);
	}
}
