package mail_It;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Mail {
	
	static Logger log = LogManager.getLogger(LogManager.class.getName());
	
	private InternetAddress from;
	private InternetAddress[] addressee;
	private String subject;
	private String msg;
	private Date timestamp;
	private int smtpServer;
	private String priority;
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss, dd.MM.yy");
	
	public Mail(){}
	
	/**
	 * Creates a Mail-Object<p>
	 * The <code>to</code> parameter can handle one or more mail addresses. Enter comma separated 
	 * sequence of addresses to add more than one address.<p>
	 * If one address does not follow RFC822 syntax, a AddressException will be thrown and a warn
	 * message will be logged with additional information.
	 * 
	 * @param from the mail address from the sender
	 * @param to the mail address of one or more addressee 
	 * @param subject the subject of the mail
	 * @param msg the message text
	 * @param smtp the index for the smtp properties
	 * 
	 * @exception AddressException if an address does not follow the RFC822 syntax
	 */
	public Mail(String from, String to, String subject, String msg, int smtp){
		try {
			this.from = new InternetAddress(from);
			this.addressee = InternetAddress.parse(to); // durch Komma getrennt mehrere Empfaenger moeglich
			this.subject = subject;
			this.msg = msg;
		} catch (AddressException addEx) {
			log.warn(addEx.getMessage() + " " + "'" + addEx.getRef() + "'");
			this.subject = subject;
			this.msg = msg;
		}
	}
	
	/**
	 * Overwrites the <code>toString()</code>-Method of Object.<p>
	 * 
	 * @return the Mail-Object as String
	 */
	public String toString(){
		String out = "";
		out += "From:\t\t" + getFrom().toString() + "\n";
		out += "To:";
		if(addressee != null){
			for(InternetAddress address : addressee){
				out += "\t\t" + address.toString() + "\n";
			}
		} else {
			out += "\t\tundefined\n";
		}
		out += "Subject:\t" + subject + "\n";
		out += "Message:\t" + msg + "\n";
		if(timestamp != null){
			out += "Send date:\t" + getTimestamp() + "\n";
		} else {
			out += "Send date:\tNot sended yet\n";
		}
		return out;
	}

	/**
	 * @return the from
	 */
	public InternetAddress getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		try {
			this.from = new InternetAddress(from);
		} catch (AddressException addEx) {
			log.warn(addEx.getMessage() + " " + "'" + addEx.getRef() + "'");
		}
	}

	/**
	 * @return the addressee
	 */
	public InternetAddress[] getAddressee() {
		return addressee;
	}

	/**
	 * @param addressee the addressee to set
	 */
	public void setAddressee(String addressee) {
		try {
			this.addressee = InternetAddress.parse(addressee);
		} catch (AddressException addEx) {
			log.warn(addEx.getMessage() + " " + "'" + addEx.getRef() + "'");
		}
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return sdf.format(timestamp);
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the smtpServer
	 */
	public int getSmtpServer() {
		return smtpServer;
	}

	/**
	 * @param smtpServer the smtpServer to set
	 */
	public void setSmtpServer(int smtpServer) {
		this.smtpServer = smtpServer;
	}

	/**
	 * @return the priority of a mail:<br>
	 *	 1 = high<br>
	 *	 3 = medium<br>
	 *	 5 = low
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * Set the priority of the mail to:<p>
	 * 1 = high<br>
	 * 3 = medium<br>
	 * 5 = low
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	

}
