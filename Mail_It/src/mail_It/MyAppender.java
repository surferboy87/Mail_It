package mail_It;

import javafx.scene.control.TextField;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class MyAppender extends AppenderSkeleton {
	
	private TextField logText;
	
	public MyAppender(TextField logArea){
		this.logText = logArea;
	}

	@Override
	public void close() {
		if (this.closed) {
			return;
		}
		this.closed = true;
	}

	@Override
	public boolean requiresLayout() {
		return false;
	}

	@Override
	protected void append(LoggingEvent e) {
		// TODO Auto-generated method stub
		this.logText.appendText(e.toString());

	}

}
