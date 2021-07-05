package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 */
public class CaseSoldeByClientController implements Initializable {

	@FXML
	private TextArea ta;
	@FXML
	private TextField client;
	private QueryProcessorInterface queryInterface;
	
	public void setInterface(QueryProcessorInterface queryInterface)
	{
		this.queryInterface = queryInterface;
	}

	@FXML
	public void changeScreenButtonPushed(ActionEvent event) throws IOException {
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.close();
	}

	@FXML
	public void getPushed(ActionEvent event) throws IOException {
		double solde = queryInterface.Solde(client.getText());
		if (solde == -1.0) {
			ta.setText("The entred name isn't a client.");
		} else {
			ta.setText(Double.toString(solde) + " DA");
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}
}
