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
public class CaseFilmByActorController implements Initializable {

	@FXML
	private TextArea ta;
	private QueryProcessorInterface queryInterface;
	
	public void setInterface(QueryProcessorInterface queryInterface)
	{
		this.queryInterface = queryInterface;
	}

	public CaseFilmByActorController() {
		super();

	}

	@FXML
	private TextField actorName;

	@FXML
	public void changeScreenButtonPushed(ActionEvent event) throws IOException {
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.close();

	}

	@FXML
	public void getPushed(ActionEvent event) throws IOException {
		String films_s = "";
		List<Film> films = queryInterface.NdByActor(actorName.getText());
		for (Film film : films) {
			films_s += "- " + film.getItemID() + " : " + film.getTitle() + ", rental price: "
					+ Double.toString(film.getRentalPrice()) + " DA\n";
		}
		if (films.isEmpty()) {
			ta.setText("No availabe films for this actor");
		} else {
			ta.setText(films_s);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

}
