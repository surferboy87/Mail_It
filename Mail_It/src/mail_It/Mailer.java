package mail_It;

import java.util.Date;

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

	public Mailer(){}
	
	/**
	 * 
	 * @param mail
	 * @param props
	 */
	public void sendMail(Mail mail, MyProperties props){
		
		/* 
		 * For more information look further down
		 */
		Authenticator auth = new SMTPAuthenticator();
		// We set up a session with the defined properties before
		Session session = Session.getInstance(props.getSMTPsProp(), auth);
		
		// Comment it out for less information
		session.setDebug(true);

		try {
			Message msg = new MimeMessage(session);
			// Set message attributes
			msg.setFrom(mail.getFrom());
			msg.addRecipients(Message.RecipientType.TO, mail.getAddressee());
			msg.setSubject(mail.getSubject());
			Date sendDate = new Date();
			msg.setSentDate(sendDate);
			// Set the send timestamp in the mail object
			mail.setTimestamp(sendDate);
			msg.setText(mail.getMsg());
			Transport.send(msg);
			log.info("Mail sent successfully!");
			log.info("Send time: " + mail.getTimestamp());
			
		} catch (MessagingException mex) {
			System.out.println(mex);
		}
	}
	
	/**
	 * The authentication model is carried within the mail session, so each message can take it
	 * in and reuse its information.
	 * @author Raphael Huber
	 * @return an Object with the username and password
	 *
	 */
	private class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication(){
			String username = "mail_it@bluewin.ch";
			String password = "java_mail";
			return new PasswordAuthentication(username, password);
			}
		}
}
