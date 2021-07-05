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
public class CaseFilmByLocationController implements Initializable {

	@FXML
	private TextArea ta;
	private QueryProcessorInterface queryInterface;

	@FXML
	private TextField location;
	
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
		
		if (queryInterface.FindByTitle(location.getText()))
			ta.setText("Item available for rental");
		else
			ta.setText("Item not available for rental");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}


}
