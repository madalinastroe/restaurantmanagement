package BusinessLayer;

public interface IRestaurantProcessing {
	
	//ADMINISTRATOR
	public void newMenuItem();
	public void deleteMenuItem();
	public void editMenuItem();
	
	//WAITER
	public void newOrder();
	public void generateBill();

}
