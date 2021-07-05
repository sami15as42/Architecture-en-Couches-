package project;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;

/**
 * FXML Controller class
 */
public class CaseFilmByClientController implements Initializable {

	@FXML
	private TextArea ta;
	private QueryProcessorInterface queryInterface;

	@FXML
	private TextField client;
	
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
		
		List<RentedItem> rented_films = queryInterface.RentedFilms(client.getText());

		String films_s = "";
		for (RentedItem film : rented_films) {
			films_s += "- " + film.getItem().getItemID() + " : " + film.getItem().getTitle() + ", Acteur : "
					+ ((Film) film.getItem()).getActeur() + ", Date : " + film.getDueDate().toString() + "\n";
		}

		if (rented_films.isEmpty()) {
			ta.setText("No films rented by this client.");
		} else {
			ta.setText(films_s);
		}
		
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

}
