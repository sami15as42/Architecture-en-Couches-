package model;

public class RentedItemM {
	
	private Client client = null;
	private StockItem item = null;
	
	public Client getCustomer() {
		return client;
	}
	
	public void setCustomer(Client client) {
		this.client = client;
	}

	public StockItem getItem() {
		return item;
	}
	
	public void setItem(StockItem item) {
		this.item = item;
	}

}
