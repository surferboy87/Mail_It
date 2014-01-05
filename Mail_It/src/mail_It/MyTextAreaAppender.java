package mail_It;

import javafx.scene.Scene;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import com.sun.media.jfxmediaimpl.platform.Platform;

public class MyTextAreaAppender extends AppenderSkeleton {

//	private static volatile TextArea textArea = null;
//
//	/** Set the target JTextArea for the logging information to appear. */
//	public static void setTextArea(final TextArea textArea) {
//		MyTextAreaAppender.textArea = textArea;
//	}

	/**
	 * Format and then append the loggingEvent to the stored JTextArea.
	 */
	public void append(LoggingEvent loggingEvent) {
		String message = this.layout.format(loggingEvent);
		Mail_It_Controller.logText.setText(message);
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
		// TODO Auto-generated method stub
		return false;
	}

}
