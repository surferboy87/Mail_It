/**
 * Sample Skeleton for "Mail_It.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package mail_It;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.AddressException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Mail_It_Controller {
	
	static Logger log = LogManager.getLogger(LogManager.class.getName());
	private Locale locale;


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
        
    @FXML // fx:id="close"
    private MenuItem close; // Value injected by FXMLLoader
    
    @FXML // fx:id="edit"
    private Menu edit; // Value injected by FXMLLoader
    
    @FXML // fx:id="selectLang"
    private Menu selectLang; // Value injected by FXMLLoader
    
    @FXML // fx:id="germanLang"
    private CheckMenuItem germanLang; // Value injected by FXMLLoader
    
    @FXML // fx:id="englLang"
    private CheckMenuItem englLang; // Value injected by FXMLLoader
    
    @FXML // fx:id="file"
    private Menu file; // Value injected by FXMLLoader

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
    private TextArea logText; // Value injected by FXMLLoader
    
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
    
    @FXML // fx:id="smptSettings"
    private MenuItem smptSettings; // Value injected by FXMLLoader

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
    
    // Handler for CheckMenuItem[fx:id="englLang"] onAction
    // Handler for CheckMenuItem[fx:id="frenchLang"] onAction
    // Handler for CheckMenuItem[fx:id="germanLang"] onAction
    @FXML
    void changeLang(ActionEvent event) {
        // handle the event here
    	if(event.getSource() == germanLang){
    		germanLang.setSelected(true);
    		frenchLang.setSelected(false);
    		englLang.setSelected(false);
    		locale = new Locale("de", "DE");
    		resources = ResourceBundle.getBundle("LangBundle", locale);
    		changeLang(resources);
    		logText.appendText("Changed the language to german\n");
    		log.info("Changed the language to german");
    	} else if (event.getSource() == frenchLang){
    		germanLang.setSelected(false);
    		frenchLang.setSelected(true);
    		englLang.setSelected(false);
    		locale = new Locale("fr", "FR");
    		resources = ResourceBundle.getBundle("LangBundle", locale);
    		changeLang(resources);
    		logText.appendText("Changed the language to french\n");
    		log.info("Changed the language to french");
    	} else if (event.getSource() == englLang){
    		germanLang.setSelected(false);
    		frenchLang.setSelected(false);
    		englLang.setSelected(true);
    		locale = new Locale("en", "UK");
    		resources = ResourceBundle.getBundle("LangBundle", locale);
    		changeLang(resources);
    		logText.appendText("Changed the language to english\n");
    		log.info("Changed the language to french");
    	}
    	
    }
    
    private void changeLang(ResourceBundle rb){
    	this.file.setText(rb.getString("file"));
    	this.close.setText(rb.getString("close"));
    	this.edit.setText(rb.getString("edit"));
    	this.selectLang.setText(rb.getString("language"));
    	this.germanLang.setText(rb.getString("german"));
    	this.frenchLang.setText(rb.getString("french"));
    	this.englLang.setText(rb.getString("english"));
    	this.smptSettings.setText(rb.getString("smtpSettings"));
    	this.fromLab.setText(rb.getString("from"));
    	this.fromAdr.getTooltip().setText(rb.getString("fromTip"));
    	this.toLab.setText(rb.getString("to"));
    	this.toAdr.getTooltip().setText(rb.getString("toTip"));
    	this.subLab.setText(rb.getString("subject"));
    	this.subText.getTooltip().setText(rb.getString("subjectTip"));
    	this.prio.setText(rb.getString("priority"));
    	this.highPrio.setText(rb.getString("high"));
    	this.normPrio.setText(rb.getString("normal"));
    	this.lowPrio.setText(rb.getString("low"));
    	this.logBut.setText(rb.getString("logging"));
    	this.msgText.getTooltip().setText(rb.getString("msgTip"));
    	this.sendBut.setText(rb.getString("send"));
    }
    
    
    // Handler for MenuItem[fx:id="highPrio"] onAction
    // Handler for MenuItem[fx:id="lowPrio"] onAction
    // Handler for MenuItem[fx:id="normPrio"] onAction
    @FXML
    void changePrio(ActionEvent event) {
        // handle the event here
    	if(event.getSource() == highPrio){
    		mail.setPriority("1");
    		logText.appendText("The priority of the mail changed to high\n");
    		log.info("The priority of the mail changed to high");
    		prio.setText(highPrio.getText());
    	} else if(event.getSource() == normPrio){
    		mail.setPriority("3");
    		prio.setText(normPrio.getText());
    		logText.appendText("The priority of the mail changed to normal\n");
    		log.info("The priority of the mail changed to normal");
    	} else if(event.getSource() == lowPrio){
    		mail.setPriority("5");
    		prio.setText(lowPrio.getText());
    		logText.appendText("The priority of the mail changed to low\n");
    		log.info("The priority of the mail changed to low");
    	}
    }

    // Handler for MenuItem[fx:id="close"] onAction
    @FXML
    void close(ActionEvent event) {
        // handle the event here
    	logText.appendText("The windwo will close now\n");
    	log.info("The window was closed in case the user selected the close item");
    	System.exit(0);
    }

    // Handler for ToggleButton[fx:id="logBut"] onMouseClicked
    @FXML
    void logToggle(MouseEvent event) {
        // handle the event here
    		mailer.setLogOn(logBut.isSelected());
    		if(logBut.isSelected()){
    			logText.appendText("Loggin is activated\n");
    			log.info("Loggin is activated");
    		} else {
    			logText.appendText("Loggin is deactivated\n");
    			log.info("Loggin is deactivated");
    		}
    }


    // Handler for Button[fx:id="sendBut"] onMouseClicked
    @FXML
    void sendMail(MouseEvent event){
        // handle the event here
    	logText.appendText("############################################################\n");
    	logText.appendText("Trying to send the Mail...\n");
    	log.info("Trying to send the Mail...");
    	try {
    	mail.setFrom(fromAdr.getText());
		mail.setAddressee(toAdr.getText());
		mail.setSubject(subText.getText());
		mail.setMsg(msgText.getText());
		mailer.sendMail(mail, MyProperties.getSMTPsProp());
		logText.appendText("Mail send succesfully\n");
    	logText.appendText(mail.toString());
    	logText.appendText("############################################################\n\n");
    	log.info("Mail send succesfully");
    	log.info("\n" + mail.toString());
    	}
    	catch (AddressException addEx){
    		logText.appendText("The address " + addEx.getRef() + "is not valid: " + addEx.getMessage());
    		log.error("The address " + addEx.getRef() + "is not valid: " + addEx.getCause());
    	}
    	catch (SendFailedException sendEx){
    		logText.appendText("There was going something wrong. Try it again\n");
    		log.error("There was going something wrong: " + sendEx.getCause());
    		
    	}
    	catch (MessagingException mesEx){
    		logText.appendText(mesEx.getMessage() + "\n");
    		log.error(mesEx.getMessage());
    	}
    	
    }
    
 // Handler for MenuItem[fx:id="smptSettings"] onAction
    @FXML
    void showSMTPDiag(ActionEvent event) {
    	try {
    		BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("smtp_mail_it.fxml"));	
    		Scene secondScene = new Scene(root);
			secondScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage secondStage = new Stage();
			secondStage.setScene(secondScene);
			secondStage.initModality(Modality.APPLICATION_MODAL);
			secondStage.show();
		} catch (Exception e) {
			log.error("The secondeStage smtpSettings could not created");
			e.printStackTrace();
		}
    }

    // Handler for MenuItem[javafx.scene.control.MenuItem@1cda50e6] onAction
    @FXML
    void showAbout(ActionEvent event) {
    	
    }
    
    // This method is called by the FXMLLoader when initialization is complete
    @FXML
    void initialize() {
    	locale = new Locale("de", "DE");
    	resources = ResourceBundle.getBundle("LangBundle", locale);
    	changeLang(resources);
    }


}
