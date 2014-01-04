/**
 * Sample Skeleton for "Mail_It.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package mail_It;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Mail_It_Controller {
	
	static Logger log = LogManager.getLogger(LogManager.class.getName());


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML // fx:id="close"
    private MenuItem close; // Value injected by FXMLLoader
    
    @FXML // fx:id="selectLang"
    private Menu selectLang; // Value injected by FXMLLoader
    
    @FXML // fx:id="germanLang"
    private CheckMenuItem germanLang; // Value injected by FXMLLoader
    
    @FXML // fx:id="englLang"
    private CheckMenuItem englLang; // Value injected by FXMLLoader

    @FXML // fx:id="frenchLang"
    private CheckMenuItem frenchLang; // Value injected by FXMLLoader

    @FXML // fx:id="fromAdr"
    private TextField fromAdr; // Value injected by FXMLLoader

    @FXML // fx:id="fromLab"
    private Label fromLab; // Value injected by FXMLLoader
    
    @FXML // fx:id="highPrio"
    private MenuItem highPrio; // Value injected by FXMLLoader

    @FXML // fx:id="logBut"
    private ToggleButton logBut; // Value injected by FXMLLoader

    @FXML // fx:id="logText"
    public static TextArea logText; // Value injected by FXMLLoader
    
    @FXML // fx:id="lowPrio"
    private MenuItem lowPrio; // Value injected by FXMLLoader

    @FXML // fx:id="msgText"
    private TextArea msgText; // Value injected by FXMLLoader
    
    @FXML // fx:id="normPrio"
    private MenuItem normPrio; // Value injected by FXMLLoader
    
    @FXML // fx:id="prio"
    private MenuButton prio; // Value injected by FXMLLoader

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
    
    private Mail mail = new Mail();
    private Mailer mailer = new Mailer();
    private MyProperties props = new MyProperties();


    
 // Handler for CheckMenuItem[fx:id="englLang"] onAction
    // Handler for CheckMenuItem[fx:id="frenchLang"] onAction
    // Handler for CheckMenuItem[fx:id="germanLang"] onAction
    @FXML
    void changeLang(ActionEvent event) {
        // handle the event here
    }
    
    
    // Handler for MenuItem[fx:id="highPrio"] onAction
    // Handler for MenuItem[fx:id="lowPrio"] onAction
    // Handler for MenuItem[fx:id="normPrio"] onAction
    @FXML
    void changePrio(ActionEvent event) {
        // handle the event here
    	if(event.getSource() == highPrio){
    		mail.setPriority("1");
    		log.info("The priority of the mail changed to high");
    		prio.setText(highPrio.getText());
    	} else if(event.getSource() == normPrio){
    		mail.setPriority("3");
    		log.info("The priority of the mail changed to normal");
    		prio.setText(normPrio.getText());
    	} else if(event.getSource() == lowPrio){
    		mail.setPriority("5");
    		log.info("The priority of the mail changed to low");
    		prio.setText(lowPrio.getText());
    	}
    }

    // Handler for MenuItem[fx:id="close"] onAction
    @FXML
    void close(ActionEvent event) {
        // handle the event here
    	log.info("The window was closed in case you used the quit function");
    	System.exit(0);
    }

    // Handler for ToggleButton[fx:id="logBut"] onMouseClicked
    @FXML
    void logToggle(MouseEvent event) {
        // handle the event here
    		mailer.setLogOn(logBut.isSelected());
    		if(logBut.isSelected()){
    			log.info("Loggin is activated");
    		} else {
    			log.info("Loggin is deactivated");
    		}
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
    	props.setSMTPprop("mail_it@bluewin.ch", "smtpauth.bluewin.ch", "587");
    	mail.setFrom(fromAdr.getText());
    	mail.setAddressee(toAdr.getText());
    	mail.setSubject(subText.getText());
    	mail.setMsg(msgText.getText());
    	mailer.sendMail(mail, props);
    }

    // Handler for MenuItem[javafx.scene.control.MenuItem@1cda50e6] onAction
    @FXML
    void showAbout(ActionEvent event) {
        // handle the event here
    }


}
