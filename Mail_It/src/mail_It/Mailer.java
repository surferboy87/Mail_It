package mail_It;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Mailer {
	
	static Logger log = LogManager.getLogger(LogManager.class.getName());
	private boolean isLogOn = false;

	public Mailer(){}
	
	/**
	 * Will send a mail from the Mail-Class with defined connection properties to the addressee stored
	 * in the mail Object.
	 * 
	 * @param mail the mail who will be send
	 * @param props the connection properties
	 * @exception MessagingException if something didn't work
	 * @see Mail
	 */
	public void sendMail(Mail mail, Properties props){
		
		/* 
		 * For more information look further down
		 */
		Authenticator auth = new SMTPAuthenticator(props.getProperty("mail.smtp.user"),
				props.getProperty("mail.smtp.password"));
		
		// We set up a session with the defined properties before
		Session session = Session.getInstance(props, auth);
		
		// Set it to false for less information
		session.setDebug(isLogOn);

		try {
			Message msg = new MimeMessage(session);
			// Set message attributes
			msg.setFrom(mail.getFrom());
			msg.addRecipients(Message.RecipientType.TO, mail.getAddressee());
			msg.setSubject(mail.getSubject());
			msg.addHeader("X-Priority", mail.getPriority());
			Date sendDate = new Date();
			msg.setSentDate(sendDate);
			msg.setText(mail.getMsg());
			// Set the send timestamp in the mail object
			mail.setTimestamp(sendDate);
			Transport.send(msg);
			log.info("Mail sent successfully!");
			log.info("Send time: " + mail.getTimestamp());
			log.info(mail.toString());
		} catch (MessagingException mex) {
			// here we need more logging
			System.out.println(mex);
		}
	}
	
	public void setLogOn(boolean log){
		this.isLogOn = log;
	}
	
	/**
	 * The authentication model is carried within the mail session, so each message can take it
	 * in and reuse its information.
	 * @author Raphael Huber
	 * @return an Object with the username and password
	 *
	 */
	private class SMTPAuthenticator extends javax.mail.Authenticator {
		String username;
		String password;
		
		public SMTPAuthenticator(String user, String pass){
			this.username = user;
			this.password = pass;
		}
		
		public PasswordAuthentication getPasswordAuthentication(){
			return new PasswordAuthentication(this.username, this.password);
			}
		}
}
