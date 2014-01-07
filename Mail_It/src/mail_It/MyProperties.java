package mail_It;

import java.util.Properties;

public class MyProperties {
	
	private static Properties props = new Properties();
	
	// unused constructor
	public MyProperties(){}
	
	/**
	 * Set the SMTP properties without additional transmit security.
	 * @param user the username/account name of a valid e-mail account
	 * @param host a smtp-server e.g. smtp.bluewin.ch
	 * @param port the port number of the smtp-server
	 */
	public static void setSMTPprop(String user, String password, String host, String port){
		props.put("mail.smtp.user", user);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.debug", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", port);
		props.put("mail.smtp.socketFactory.fallback", "false");
	}
	
	/**
	 * Set the SMTPS properties to send a mail over SSL.
	 * @param user the username/account name of a valid e-mail account
	 * @param host a smtps-server e.g. smtpauths.bluewin.ch
	 * @param port the port number of the smtp-server
	 */
	// Do not know if everything is right, but works
	public static void setSMTPSprop(String user, String host, String port){
		props.setProperty("mail.transport.protocol", "smtps");
		props.setProperty("mail.smtp.host", host);
		props.setProperty("mail.smtp.user", user);
		props.setProperty("mail.smtp.port", port);
		props.setProperty("mail.smtp.ssl.enable", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.debug", "true");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.socketFactory.port", port);
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
	}

	/**
	 * 
	 * @return SMTP(S) properties 
	 */
	public static Properties getSMTPsProp(){
		return props;
	}
	
}
