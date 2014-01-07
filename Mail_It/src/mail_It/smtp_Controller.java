package mail_It;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class smtp_Controller {

	@FXML
	// ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML
	// URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML
	// fx:id="cancelBut"
	private Button cancelBut; // Value injected by FXMLLoader

	@FXML
	// fx:id="okBut"
	private Button okBut; // Value injected by FXMLLoader

	@FXML
	// fx:id="password"
	private PasswordField password; // Value injected by FXMLLoader

	@FXML
	// fx:id="passwordLab"
	private Label passwordLab; // Value injected by FXMLLoader

	@FXML
	// fx:id="port"
	private TextField port; // Value injected by FXMLLoader

	@FXML
	// fx:id="portLab"
	private Label portLab; // Value injected by FXMLLoader

	@FXML
	// fx:id="smtp"
	private TextField smtp; // Value injected by FXMLLoader

	@FXML
	// fx:id="smtpLab"
	private Label smtpLab; // Value injected by FXMLLoader

	@FXML
	// fx:id="title"
	private Label title; // Value injected by FXMLLoader

	@FXML
	// fx:id="username"
	private TextField username; // Value injected by FXMLLoader

	@FXML
	// fx:id="usernameLab"
	private Label usernameLab; // Value injected by FXMLLoader
	
	private Label test;

	// Handler for Button[fx:id="cancelBut"] onMouseClicked
	@FXML
	void cancel(MouseEvent event) {
		Stage stage = (Stage) cancelBut.getScene().getWindow();
		stage.close();
	}

	// Handler for Button[fx:id="okBut"] onMouseClicked
	@FXML
	void ok(MouseEvent event) {
		okBut.setText("juhee");
		MyProperties.setSMTPprop(username.getText(), password.getText(),
				smtp.getText(), port.getText());
		//Stage stage = (Stage) okBut.getScene().getWindow();
		//stage.close();
	}
	
	public void changeLang(){
		test.setText("hai");
	 }

	public void createSMTPStage() {
		try {
			// Load the fxml file and create a new stage for the smtp settings
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("smtp_mail_it.fxml"));
			Scene secondScene = new Scene(root);
			secondScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage secondStage = new Stage();
			secondStage.setScene(secondScene);
			secondStage.initModality(Modality.APPLICATION_MODAL);
			secondStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
