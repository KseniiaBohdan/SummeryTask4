package service.utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class MailSender {
	private static final String USERNAME = "kseniia.bohdan.payment.system@gmail.com";
	private static final String PASSWORD = "payment.system2016";
	private static final Logger LOGGER = Logger.getLogger(MailSender.class);

	public static void sendMail(String mail, String subject, String message) {
		LOGGER.debug("Message sender begins");
		Message msge = new MimeMessage(getSession());
		try {
			msge.setFrom(new InternetAddress(USERNAME));
			msge.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
			msge.setSubject(subject);
			msge.setText(message);
			Transport.send(msge);
		} catch (AddressException e) {
			LOGGER.error("Error in adress: " + e.getMessage());
		} catch (MessagingException e) {
			LOGGER.error("Error in message: " + e.getMessage());
		}
		LOGGER.debug("Message sender ends");
	}

	private static Session getSession() {
		Session ses = Session.getDefaultInstance(getProperties(), new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USERNAME, PASSWORD);
			}
		});
		return ses;
	}

	private static Properties getProperties() {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
		return properties;
	}
}