package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 */
public class CaseReturnArticleController implements Initializable {

	@FXML
	private Label label;
	@FXML
	private TextField client;
	@FXML
	private TextField articleName;
	private TransactionProcessorInterface transactionInterface;
	
	public void setInterface(TransactionProcessorInterface transactionInterface)
	{
		this.transactionInterface = transactionInterface;
	}

	@FXML
	public void changeScreenButtonPushed(ActionEvent event) throws IOException {
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.close();

	}

	@FXML
	public void getPushed(ActionEvent event) throws IOException {
		
		if (transactionInterface.CheckIn(articleName.getText(), client.getText()))
			label.setText("Item returned successfully.");
		else
			label.setText("Operation failed.");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

}
