package com.cerner.MachineRequisition.mail;

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

public class SendMail {

	public void send(String to, String cc, int requestId, String content) {
		
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
			message.setSubject("Machine Request Id : " + requestId);
			//System.setProperty("user.dir", "/");
			/*System.out.println("Working Directory = " +
		              System.getProperty("user.dir"));*/
			
			
			MimeMultipart multipart = new MimeMultipart();
			BodyPart messagebodypart = new MimeBodyPart();
			messagebodypart.setContent(content, "text/html");

			// add it
			multipart.addBodyPart(messagebodypart);

			// second part (the image)
			messagebodypart = new MimeBodyPart();
//			/MachineRequisitionSystem1/WebContent/WEB-INF/resources/images/Cerner_logo.png
			DataSource fds = new FileDataSource("/resources/images/bgimage.jpg");
//			/src/img
			/* C:\\Users\\kg056519\\Desktop\\SlantWithLogo.png */
			messagebodypart.setDataHandler(new DataHandler(fds));
			messagebodypart.setHeader("Content-ID", "<image>");

			// add it
			multipart.addBodyPart(messagebodypart);

			// put everything together
			message.setContent(multipart);

			/* testing image.................................. */

			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
