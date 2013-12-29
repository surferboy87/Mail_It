package mail_It;

public class MailTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mail amail = new Mail("rap.huber@bluewin.ch", "rhuber computer-coach.ch", "Test Subject", "Testmsg", 0);
		Mail amail2 = new Mail("rap.huber@bluewin.ch", "rhuber@computer-coach.ch, huber3@bfh.ch", "Test Subject", "Testmsg", 0);
		
		System.out.println(amail.toString()); // must give a logging warn message because whitespace
		System.out.println(amail2.toString()); // should be right
	}

}
