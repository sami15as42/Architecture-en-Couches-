package project;

import javafx.application.Application;

public class Main {
	public static void main(String[] args) {

		DataBaseDAOInterface db_dao = new DataBaseDAO();
		QueryProcessorInterface qp = new QueryProcessor(db_dao);
		TransactionProcessorInterface tp = new TransactionProcessor(db_dao);

		GUI gui = new GUI();
		gui.setInterface(tp, qp);

		new Thread() {
			@Override
			public void run() {
				Application.launch(GUI.class, args);
			}
		}.start();
		
	}
}