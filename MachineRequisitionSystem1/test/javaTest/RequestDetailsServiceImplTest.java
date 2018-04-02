/**
 * This is the Request Details Service implementation test class
 * 
 * @author Varsha Das
 */
package javaTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cerner.MachineRequisition.Dao.RequestDao;
import com.cerner.MachineRequisition.Model.RequestDetails;
import com.cerner.MachineRequisition.service.RequestService;
import com.cerner.MachineRequisition.service.impl.RequestServiceImpl;

public class RequestDetailsServiceImplTest {

	@Mock
	private RequestDao requestdao;
	@Mock
	RequestServiceImpl serviceimpl;
	@InjectMocks
	private static RequestService service = new RequestServiceImpl();

	RequestDetails requestdetails;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		requestdetails = new RequestDetails();
	}

	/*
	 * Creating mock object and setting values for testing
	 * the request service
	 */

	@Test
	public void testrequestservice() {

		Mockito.when(requestdao.addRequestDetails(requestdetails)).thenReturn(true);
		Mockito.when(requestdao.addRequestDetails(null)).thenReturn(false);
		Assert.assertEquals(service.addRequestDetails(requestdetails), true);
		Assert.assertEquals(service.addRequestDetails(null), false);

	}

}
