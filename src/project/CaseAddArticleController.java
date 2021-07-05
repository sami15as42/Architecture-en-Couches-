package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 */
public class CaseAddArticleController implements Initializable {

	@FXML
	private TextField locationPrice;
	@FXML
	private TextField articleName;
	@FXML
	private ToggleGroup tGroup;
	public String itemName, price;
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
	public void nextPushed(ActionEvent event) throws IOException {

		RadioButton selectedRadioButton = (RadioButton) tGroup.getSelectedToggle();

		if (selectedRadioButton.getText().equals("Film")) {

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/Film.fxml"));
			Parent FilmParent = (Parent) fxmlLoader.load();
			FilmController cntl = fxmlLoader.<FilmController>getController();
			cntl.setLoc(locationPrice.getText());
			cntl.setName(articleName.getText());
			cntl.setInterface(transactionInterface);
			Scene FilmScene = new Scene(FilmParent);
			FilmScene.getStylesheets().add(getClass().getResource("dark_theme.css").toExternalForm());
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(FilmScene);
			window.show();
		} else {

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/Game.fxml"));
			Parent GameParent = (Parent) fxmlLoader.load();
			GameController cntl = fxmlLoader.<GameController>getController();
			cntl.setLoc(locationPrice.getText());
			cntl.setName(articleName.getText());
			cntl.setInterface(transactionInterface);
			Scene GameScene = new Scene(GameParent);
			GameScene.getStylesheets().add(getClass().getResource("dark_theme.css").toExternalForm());
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(GameScene);
			window.show();
		}

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

}
