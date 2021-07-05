package project;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.*;

/**
 * FXML Controller class
 */
public class CaseOverDueArticleController implements Initializable {

	@FXML
	private TextArea ta;
	private QueryProcessorInterface queryInterface;
	
	public void setInterface(QueryProcessorInterface queryInterface)
	{
		this.queryInterface = queryInterface;
	}

	public CaseOverDueArticleController() {
		super();

	}

	@FXML
	public void changeScreenButtonPushed(ActionEvent event) throws IOException {
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.close();

	}

	@FXML
	public void getPushed(ActionEvent event) throws IOException {
		
		String overdueItems_s = "";
		ArrayList<RentedItem> overdueItems = queryInterface.OverdueItems();
		for (RentedItem item : overdueItems) {
			overdueItems_s += "- " + item.getItemID() + " : " + item.getItem().getTitle()
					+ ", Client : " + item.getCustomer().getName() + ", Due Date : "
					+ item.getDueDate().toString() + "\n";
		}
		if (overdueItems.isEmpty()) {
			ta.setText("No overdued items.");
		} else {
			ta.setText(overdueItems_s);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

}
