package com.cerner.MachineRequisition.Email;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.core.io.ClassPathResource;

public class EmailGenerator {

	public String send(String to, String cc, int requestId, String content) {

		String from = "noreply.machinerequisition@gmail.com";
		String password = "Admin@123456789";
		// MailContent content = new MailContent();
		// Get properties object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
			message.setSubject("Machine Request Id : " + requestId);

			MimeMultipart multipart = new MimeMultipart();
			BodyPart messagebodypart = new MimeBodyPart();
			messagebodypart.setContent(content, "text/html");

			// add it
			multipart.addBodyPart(messagebodypart);

			// second part (the image)
			messagebodypart = new MimeBodyPart();
			DataSource fds = new FileDataSource("SlantWithLogo.png");
			
			/*"C:\\Users\\kg056519\\Desktop\\SlantWithLogo.png"*/
			//DataSource fds1 = new FileDataSource(new File("../MachineRequisitionSystem1/WebContent/WEB-INF/resources/images/SlantWithLogo.png"));
			//DataSource fds2 = new FileDataSource(new File("../MachineRequisitionSystem1/WebContent/WEB-INF/resources/images/SlantWithLogo.png").getAbsolutePath());
					
					/*(DataSource) new ClassPathResource("SlantWithLogo.png");*/

			 messagebodypart.setDataHandler(new DataHandler(fds));
			//messagebodypart.setDataHandler((DataHandler) fds);
			//messagebodypart.setFileName(fds.getName());
			messagebodypart.setHeader("Content-ID", "<image>");

			// add it
			multipart.addBodyPart(messagebodypart);

			// put everything together
			message.setContent(multipart);

			//System.out.println("Working Directory = " + System.getProperty("user.dir"));
			// send message
			System.out.println("sending...");
			Transport.send(message);
			System.out.println("sent");
			return "message sent successfully";
		} catch (MessagingException e) {
			System.out.println("hi");
			return "Unsuccessful";
		}
	}
}
