/**
 * This is the Machine Credential Dao test class
 * 
 * @author Varsha Das
 */
package javaTest;

import static org.mockito.Mockito.when;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cerner.MachineRequisition.Dao.impl.MachineCredentialDaoImpl;
import com.cerner.MachineRequisition.Model.MachineCredentials;

public class MachineCredentialDaoTest {
	@InjectMocks
	MachineCredentialDaoImpl machinedaoimpl = new MachineCredentialDaoImpl();

	// @Mock annotation is used to create the mock object to be injected
	@Mock
	SessionFactory sessionFactory;

	@Mock
	Session session;

	@Mock
	Query query;

	@Mock
	MachineCredentials machinecredentials;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testbyIP() {
		MachineCredentials machinecredentials = new MachineCredentials();

		machinecredentials.setIpAddress("172.10.10.2");
		machinecredentials.setDivisionName("HR");
		when(sessionFactory.getCurrentSession()).thenReturn(session);
		when(session.createQuery(
				"From MachineCredentials where ipAddress=" + "'" + machinecredentials.getIpAddress() + "'"))
						.thenReturn(query);
		when(query.getSingleResult()).thenReturn(machinecredentials);

		Assert.assertEquals(machinedaoimpl.getDivisionNamebyIP(null), "Invalid IP Address");
		Assert.assertEquals(machinedaoimpl.getDivisionNamebyIP(machinecredentials.getIpAddress()), "HR");

	}
	@Test
	public void testbyServer() {
		MachineCredentials machinecredentials = new MachineCredentials();

		machinecredentials.setServername("server3");
		machinecredentials.setDivisionName("HR");
		when(sessionFactory.getCurrentSession()).thenReturn(session);
		when(session.createQuery(
				"From MachineCredentials where servername=" + "'" + machinecredentials.getServername() + "'"))
						.thenReturn(query);
		when(query.getSingleResult()).thenReturn(machinecredentials);

		Assert.assertEquals(machinedaoimpl.getDivisionNamebyServer(null), "Invalid Server Name");
		Assert.assertEquals(machinedaoimpl.getDivisionNamebyServer(machinecredentials.getServername()), "HR");

	}

}
