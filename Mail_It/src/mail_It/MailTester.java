package mail_It;

public class MailTester {

	public static void main(String[] args) {
		
		/*
		 * mail_1: 	Have got a whitespace in "rhuber computer-coach.ch" and is in this case not a valid
		 * 			mail address. There should be a log-message in console
		 * mail_2:	Is everything OK and have two addressee
		 */
		
//		Mail mail_1 = new Mail("rap.huber@bluewin.ch", "rhuber computer-coach.ch", "Test Subject", "Testmsg");
		Mail mail_2;
		try {
			mail_2 = new Mail("rap.huber@bluewin.ch", "rap.huber@bluewin.ch", "Test Subject", "Testmsg äöüèéà");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * The next two line are an output of the mail.
		 */
		
//		System.out.println(mail_1.toString()); // must give a logging warn message because whitespace
//		System.out.println(mail_2.toString()); // should be right
		
		/*
		 * Now we will send a Mail.
		 * With MyProperties we set the parameters for the SMTP-connection
		 * We create a new mailer and call sendMail with the mail_2 and the smtp-properties
		 */
	
		//MyProperties.setSMTPprop("mail_it@bluewin.ch", "smtpauth.bluewin.ch", "587");
		MyProperties.setSMTPSprop("mail_it@bluewin.ch", "smtpauths.bluewin.ch", "465");
		
		Mailer mailer = new Mailer();
		mailer.sendMail(mail_2, MyProperties.getSMTPsProp());
		
	}

}
