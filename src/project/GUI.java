package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {

	private static QueryProcessorInterface queryInterface;
	private static TransactionProcessorInterface transactionInterface;
	
	public void setInterface(TransactionProcessorInterface transactionInterface, QueryProcessorInterface queryInterface)
	{
		GUI.transactionInterface = transactionInterface;
		GUI.queryInterface = queryInterface;
	}

	@Override
	public void start(Stage stage) throws Exception {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));

		Parent root = (Parent) fxmlLoader.load();
		HomeController cntl = fxmlLoader.<HomeController>getController();
		cntl.setInterface(transactionInterface, queryInterface);

		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("dark_theme.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}

}
