/**
 * 
 */
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

import com.cerner.MachineRequisition.Dao.impl.UserIDValidationDaoImpl;
import com.cerner.MachineRequisition.Model.AssociateDetails;

import junit.framework.Assert;
import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class UserIDValidationDaoTest extends TestCase{
    
    @Mock
    SessionFactory sessionFactory;
    
    @Mock
    Session session;
    
    @Mock
    Query query;
    
    @InjectMocks 
    UserIDValidationDaoImpl useridValidationDaoImpl = new UserIDValidationDaoImpl();
    
    AssociateDetails associateDetails;
    
    @Before
    public void setUp() throws Exception {
      MockitoAnnotations.initMocks(this);
      associateDetails = new  AssociateDetails();
    }
    
    @Test
    public void testUserIDValidationDao() throws Exception {
        //setting data 1
        associateDetails.setAssociateId("KG056715");
        
        //Mock SessionFactory.getCurrentSession() object to return mocked Session object
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.createQuery("From AssociateDetails where associateId= '"+associateDetails.getAssociateId()+"'")).thenReturn(query);
        when(query.getSingleResult()).thenReturn(associateDetails);
        Assert.assertEquals(useridValidationDaoImpl.isValidUserID(associateDetails.getAssociateId()),true);
        
      //setting data 2
        associateDetails.setAssociateId("056715");
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.createQuery("From AssociateDetails where associateId= '"+associateDetails.getAssociateId()+"'")).thenReturn(query);
        when(query.getSingleResult()).thenReturn(associateDetails);
        Assert.assertEquals(useridValidationDaoImpl.isValidUserID(associateDetails.getAssociateId()),true);
    }
    
    @Test
    public void testUserIDValidationDaoException() throws Exception {
      //setting data 
        associateDetails.setAssociateId("KG056715");
        
        Assert.assertEquals(useridValidationDaoImpl.isValidUserID(associateDetails.getAssociateId()),false);
    }
}
