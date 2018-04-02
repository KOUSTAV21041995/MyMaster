/**
 * This is the Request Dao test class
 * 
 * @author Varsha Das
 */
package javaTest;

import static org.mockito.Mockito.when;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.cerner.MachineRequisition.Dao.impl.RequestDaoImpl;
import com.cerner.MachineRequisition.Model.RequestDetails;

public class RequestDaoTest {
	// @InjectMocks annotation is used to create and inject the mock object
	@InjectMocks
	RequestDaoImpl requestdaoimpl = new RequestDaoImpl();

	// @Mock annotation is used to create the mock object to be injected
	@Mock
	SessionFactory sessionFactory;

	@Mock
	Session session;

	@Mock
	RequestDetails requestdetails;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	/*
	 * Creating mock object and setting values for testing of saving request data
	 */

	@Test
	public void testrequest() {
		RequestDetails requestdetails = new RequestDetails();
		when(sessionFactory.getCurrentSession()).thenReturn(session);
		Assert.assertEquals(requestdaoimpl.addRequestDetails(requestdetails), true);
		Assert.assertEquals(requestdaoimpl.addRequestDetails(null), false);
	}

}
