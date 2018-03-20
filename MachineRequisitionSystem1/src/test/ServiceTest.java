package test;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.cerner.MachineRequisition.Dao.MachineCredentialsDao;
import com.cerner.MachineRequisition.Model.MachineCredentials;
import com.cerner.MachineRequisition.service.MachineCredentialService;
import com.cerner.MachineRequisition.service.impl.MachineCredentialServiceImpl;

public class ServiceTest {
	@Mock
    private MachineCredentialsDao machinedao;
	@Mock 
	MachineCredentialServiceImpl serviceimpl;
	@InjectMocks
    private static MachineCredentialService machinecredentialservice=new MachineCredentialServiceImpl() ;
	@Before
	public void setUp() throws Exception {
	  MockitoAnnotations.initMocks(this);
	}       
    @Test
    public void testip()
    {
        MachineCredentials mc = new MachineCredentials();
        mc.setDivisionName("HR");
        mc.setIpAddress("172.10.10.2"); 
        Mockito.when(machinecredentialservice.getDivisionNamebyIP(mc.getIpAddress())).thenReturn(mc.getDivisionName());             
    }
    @Test
    public void testserver()
    {
        MachineCredentials mc = new MachineCredentials();
        mc.setDivisionName("HR");
        mc.setServername("server2");
        Mockito.when(machinecredentialservice.getDivisionNamebyServer(mc.getServername())).thenReturn(mc.getDivisionName());     
             
    }
       
}
