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
public class CasePenalizeClientController implements Initializable {

	@FXML
	private Label label;
	@FXML
	private TextField clientName;
	@FXML
	private TextField clientPen;
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
	public void penalizePushed(ActionEvent event) throws IOException { 
		try {
			double penality = Double.parseDouble(clientPen.getText());
			if (transactionInterface.AddPenality(clientName.getText(), penality))
				label.setText("Client balnace debited.");
			else
				label.setText("Not enough balance or client account doesn't exist.");
		} catch (NumberFormatException nfe) {
			label.setText("Operation failed. Please entre a valide balance.");
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

}
