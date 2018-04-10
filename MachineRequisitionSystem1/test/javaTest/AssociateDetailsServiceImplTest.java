/**
 * This is the Associate Details Service test class
 * 
 * @author Rahul Ghata
 */

package javaTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cerner.MachineRequisition.Dao.UserIDValidationDao;
import com.cerner.MachineRequisition.Model.AssociateDetails;
import com.cerner.MachineRequisition.Model.MachineCredentials;
import com.cerner.MachineRequisition.service.AssociateDetailsService;
import com.cerner.MachineRequisition.service.impl.AssociateDetailsServiceImpl;

public class AssociateDetailsServiceImplTest {
	@Mock
	private UserIDValidationDao useriddao;
	@Mock
	AssociateDetailsServiceImpl serviceimpl;
	@InjectMocks
	private static AssociateDetailsService associatedetailservice = new AssociateDetailsServiceImpl();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	/*
	 * Creating mock object and setting values for testing
	 */

	@Test
	public void testuserid() {
		AssociateDetails ad = new AssociateDetails();
		ad.setAssociateId("KG056715");
		Mockito.when(associatedetailservice.isValidUserID(ad.getAssociateId())).thenReturn(true);
		ad.setAssociateId("056715");
		Mockito.when(associatedetailservice.isValidUserID(ad.getAssociateId())).thenReturn(false);
	}
}
