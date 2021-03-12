package BusinessLayer;
import java.io.Serializable;
import java.util.*;

import DataLayer.RestaurantSerializator;
import PresentationLayer.ChefPage;

public class Restaurant  implements Serializable,Observable{

	private static final long serialVersionUID = 1L;
	public HashMap<Order,ArrayList<MenuItem>> orderInfo=new HashMap<Order,ArrayList<MenuItem>>();
	public static ArrayList<MenuItem> menus;
	public ArrayList<MenuItem> orders;
	public ArrayList<Order> clientOrders=new ArrayList<Order>();
	RestaurantSerializator serializator= new RestaurantSerializator();
	ArrayList<Observer> obsList=new ArrayList<Observer>();
	Order o;
	
	

	
	public Order getO() {
		return o;
	}

	public void setO(Order o) {
		this.o = o;
	}

	public RestaurantSerializator getSerializator() {
		return serializator;
	}

	public void setSerializator(RestaurantSerializator serializator) {
		this.serializator = serializator;
	}

	
	
	public Map<Order, ArrayList<MenuItem>> getOrderInfo() {
		return orderInfo;
	}
	

	/**
	 * 
	 * @param orderInfo - hashMap ce contine comenzile clientilor
	 * @param orders - comenzi ?
	 * @param clientOrders - comenzile clientilor
	 * @param serializator - serializatorul 
	 */
	public Restaurant(HashMap<Order, ArrayList<MenuItem>> orderInfo, ArrayList<MenuItem> orders,
			ArrayList<Order> clientOrders, RestaurantSerializator serializator) {
		super();
		 obsList=new ArrayList<Observer>();
		this.orderInfo = orderInfo;
		this.orders = orders;
		this.clientOrders = clientOrders;
		this.serializator = serializator;
	}

	public void setOrderInfo(HashMap<Order, ArrayList<MenuItem>> orderInfo) {
		this.orderInfo = orderInfo;
	}

	public ArrayList<Order> getClientOrders() {
		return clientOrders;
	}

	public void setClientOrders(ArrayList<Order> clientOrders) {
		this.clientOrders = clientOrders;
	}

	public ArrayList<MenuItem> getMenus() {
		return menus;
	}
	public void setMenus(ArrayList<MenuItem> menus) {
		this.menus = menus;
	}
	
	public ArrayList<MenuItem> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<MenuItem> orders) {
		this.orders = orders;
	}

	public Restaurant()
	{
		
	}


	@Override
	public String toString() {
		return "Restaurant [orderInfo=" + orderInfo +","+ "orders=" + orders + ", clientOrders=" + clientOrders;
				//+ ", serializator=" + serializator + "]";
	}

	/**
	 * 
	 * @return true daca formatul este bun, adica lista contine elemente
	 */
	public boolean wellFormed()
	{
		if(this.menus==null&&this.orderInfo==null)
			return false;
		return true;
	}
	/**
	 * metoda de adaugat item in meniu
	 * @param m ce se doreste sa se adauge
	 */
	
	public void addInMenu(MenuItem m)
	{
		assert wellFormed();
		assert m != null;
		try
		{
				menus.add(m);
				System.out.println(m);
				serializator.serialization(menus);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * metoda de stergere din meniu
	 * @param remove ceea ce doreste a fi sters
	 */
	public void deleteFromMenu(ArrayList<MenuItem> remove)
	{
		assert wellFormed();
		assert remove != null;
		try
		{
				menus.removeAll(remove);
				serializator.serialization(menus);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * metoda de modificare in meniu 
	 * @param menus lista in care modificam
	 * @param modified cu ce modificam itemul existent
	 * @param contor pozitia unde modificam
	 */
	public void modifyInMenu(ArrayList<MenuItem> menus,MenuItem modified,int contor)
	{
		assert wellFormed();
		
		try
		{
			if(modified instanceof BaseProduct)
			{
				menus.set(contor,modified);
				
			}
				serializator.serialization(menus);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

	/**
	 * metoda de adaugare a comenzii
	 * @param o comanda pe care o adaugam
	 */
	public void addOrder(Order o)
	{
		assert wellFormed();
		assert o != null;
		try
		{
				clientOrders.add(o);
				notifyObservers();
				orderInfo.put(o,o.getClientOrder());
				serializator.serializationO(clientOrders);
				serializator.serializationHM(orderInfo);
				 for (Map.Entry me : orderInfo.entrySet()) {
			          System.out.println("Key: "+me.getKey() + " & Value: " + me.getValue());
			        }
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	/**
	 * metoda de notificare observatori
	 */
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(Observer obs:obsList)
		{
			 obs.update(null, o); 
		}
	}

	/**
	 * eliminam obs
	 */
	public void removeObserver(Object o) {
		// TODO Auto-generated method stub
		obsList.remove(o);
		
	}

	/**
	 * adaugam obs
	 */
	public void registerObserver(Object o) {
		// TODO Auto-generated method stub
		obsList.add((Observer) o);
		
	}

	/**
	 * date schimbate
	 * @param c comanda noua
	 */
	public void dataChanged(Order c)
	{
		this.o=c;
		notifyObservers();
	}
}

