/**
 * Sample Skeleton for "Mail_It.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package mail_It;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;


public class Mail_It_Controller {
	
	static Logger log = LogManager.getLogger(LogManager.class.getName());

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="fromAdr"
    private TextField fromAdr; // Value injected by FXMLLoader

    @FXML // fx:id="fromLab"
    private Label fromLab; // Value injected by FXMLLoader

    @FXML // fx:id="logBut"
    private ToggleButton logBut; // Value injected by FXMLLoader

    @FXML // fx:id="logText"
    private TextArea logText; // Value injected by FXMLLoader

    @FXML // fx:id="msgText"
    private TextArea msgText; // Value injected by FXMLLoader

    @FXML // fx:id="prioBut"
    private ComboBox<?> prioBut; // Value injected by FXMLLoader

    @FXML // fx:id="sendBut"
    private Button sendBut; // Value injected by FXMLLoader

    @FXML // fx:id="subLab"
    private Label subLab; // Value injected by FXMLLoader

    @FXML // fx:id="subText"
    private TextField subText; // Value injected by FXMLLoader

    @FXML // fx:id="toAdr"
    private TextField toAdr; // Value injected by FXMLLoader

    @FXML // fx:id="toLab"
    private Label toLab; // Value injected by FXMLLoader


    // Handler for ComboBox[fx:id="prioBut"] onAction
    @FXML
    void changePrio(ActionEvent event) {
        // handle the event here
    }

    // Handler for MenuItem[javafx.scene.control.MenuItem@4b3669e1] onAction
    @FXML
    void close(ActionEvent event) {
        // handle the event here
    	log.info("The window will close know");
    	System.exit(0);
    	
    }

    // Handler for ToggleButton[fx:id="logBut"] onMouseClicked
    @FXML
    void logToggle(MouseEvent event) {
        // handle the event here
    }

    // Handler for MenuItem[javafx.scene.control.MenuItem@90a1a9a] onAction
    @FXML
    void selectLang(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="sendBut"] onMouseClicked
    @FXML
    void sendMail(MouseEvent event) {
        // handle the event here
    }

    // Handler for MenuItem[javafx.scene.control.MenuItem@1cda50e6] onAction
    @FXML
    void showAbout(ActionEvent event) {
        // handle the event here
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert fromAdr != null : "fx:id=\"fromAdr\" was not injected: check your FXML file 'Mail_It.fxml'.";
        assert fromLab != null : "fx:id=\"fromLab\" was not injected: check your FXML file 'Mail_It.fxml'.";
        assert logBut != null : "fx:id=\"logBut\" was not injected: check your FXML file 'Mail_It.fxml'.";
        assert logText != null : "fx:id=\"logText\" was not injected: check your FXML file 'Mail_It.fxml'.";
        assert msgText != null : "fx:id=\"msgText\" was not injected: check your FXML file 'Mail_It.fxml'.";
        assert prioBut != null : "fx:id=\"prioBut\" was not injected: check your FXML file 'Mail_It.fxml'.";
        assert sendBut != null : "fx:id=\"sendBut\" was not injected: check your FXML file 'Mail_It.fxml'.";
        assert subLab != null : "fx:id=\"subLab\" was not injected: check your FXML file 'Mail_It.fxml'.";
        assert subText != null : "fx:id=\"subText\" was not injected: check your FXML file 'Mail_It.fxml'.";
        assert toAdr != null : "fx:id=\"toAdr\" was not injected: check your FXML file 'Mail_It.fxml'.";
        assert toLab != null : "fx:id=\"toLab\" was not injected: check your FXML file 'Mail_It.fxml'.";

        // Initialize your logic here: all @FXML variables will have been injected

    }

}
