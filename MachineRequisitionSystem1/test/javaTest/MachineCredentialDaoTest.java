package javaTest;

import static org.mockito.Mockito.when;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.cerner.MachineRequisition.Dao.impl.MachineCredentialDaoImpl;
import com.cerner.MachineRequisition.Model.MachineCredentials;

import junit.framework.Assert;
import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class MachineCredentialDaoTest extends TestCase{
    
    @Mock
    SessionFactory sessionFactory;
    
    @Mock
    Session session;
    
    @Mock
    Query query;
    
    @InjectMocks
    MachineCredentialDaoImpl machinecredentialDaoImpl = new MachineCredentialDaoImpl();
    
    @Mock
    MachineCredentials machineCredentialsMock;
    
    @Before
    public void setUp() throws Exception {
      MockitoAnnotations.initMocks(this);
      
    }
    
    @Test
    public void testMachineCredentialByIpDao()throws Exception {
        MachineCredentials machineCredentials = new  MachineCredentials();
        //setting data 
        machineCredentials.setIpAddress("172.10.10.2");
        machineCredentials.setDivisionName("HR"); 
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.createQuery("From MachineCredentials where ipAddress="+"'"+machineCredentials.getIpAddress()+"'")).thenReturn(query);
        when(query.getSingleResult()).thenReturn(machineCredentials);
        when(machineCredentialsMock.getDivisionName()).thenReturn(machineCredentials.getDivisionName());
        
        //Valid test
        Assert.assertEquals(machinecredentialDaoImpl.getDivisionNamebyIP(machineCredentials.getIpAddress()), "HR");
        
        //Invalid test
        machineCredentials.setIpAddress("172.10.10.6");
        Assert.assertEquals(machinecredentialDaoImpl.getDivisionNamebyIP(machineCredentials.getIpAddress()), "Invalid IP Address");
    }
    
    @Test
    public void testMachineCredentialByServerDao()throws Exception {
        MachineCredentials machineCredentials = new  MachineCredentials();
        //setting data 
        machineCredentials.setServername("server2"); 
        machineCredentials.setDivisionName("HR"); 
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.createQuery("From MachineCredentials where servername="+"'"+machineCredentials.getServername()+"'")).thenReturn(query);
        when(query.getSingleResult()).thenReturn(machineCredentials);
        when(machineCredentialsMock.getDivisionName()).thenReturn(machineCredentials.getDivisionName());
       
        //Valid test
        Assert.assertEquals(machinecredentialDaoImpl.getDivisionNamebyServer(machineCredentials.getServername()), "HR"); 
        
        //Invalid test
        machineCredentials.setServername("server8");
        Assert.assertEquals(machinecredentialDaoImpl.getDivisionNamebyServer(machineCredentials.getServername()), "Invalid Server Name");
    }
}