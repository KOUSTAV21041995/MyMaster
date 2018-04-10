package javaTest;

import static org.mockito.Mockito.when;

import java.util.Properties;

import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.context.Theme;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cerner.MachineRequisition.Email.EmailGenerator;

import junit.framework.Assert;
import junit.framework.TestCase;

@ContextConfiguration(locations="file:WebContent/WEB-INF/appServlet-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@RunWith(MockitoJUnitRunner.class)
public class EmailGeneratorTest extends TestCase {
	
	@Mock
	Properties props;
	
	//@Mock
	//Session session;
	
	@Mock
	MimeMessage message;
	
	@Mock
	MimeMultipart multipart;
	
	@Mock
	BodyPart messagebodypart;
	
	@Mock
	DataSource fds;
	
	@InjectMocks 
	EmailGenerator emailgenerator = new EmailGenerator();
	
	@Before
    public void setUp() throws Exception {
      MockitoAnnotations.initMocks(this);
	}
	//Test Email Generator 
	@Test
    public void testEmailGenerator() throws Exception{
		String from = "noreply.machinerequisition@gmail.com";
		String password = "Admin@123456789";
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		
		Assert.assertEquals(emailgenerator.send("ghatarahul@gmail.com", "Koustav.Ghosh@cerner.com", 100, "content"),"message sent successfully");
		//Assert.assertEquals(emailgenerator.send("ghatarahul@gmail.com", "Koustav.Ghosh@cerner.com", 100, "content"),"Unsuccessful");
		
	}
	
}
