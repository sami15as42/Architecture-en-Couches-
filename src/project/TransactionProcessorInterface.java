package project;

public interface TransactionProcessorInterface {
	
	public boolean AddPenality(String name, double penality);

	public boolean CheckOut(String articleTitle, String clientName, String dueDate);

	public boolean CheckIn(String articleTitle, String clientName);

	public boolean AddCustomer(String name, double accountBalance);

	public boolean AddStockItem(double rentalPrice, String title, boolean isGame, String plateforme, String acteur);

}
