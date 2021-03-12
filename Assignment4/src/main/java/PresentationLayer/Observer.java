package PresentationLayer;

import BusinessLayer.Order;

public interface Observer {
	
	public void update(Order o);

}
