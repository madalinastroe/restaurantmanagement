package BusinessLayer;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Order implements Serializable{
	
	public int orderID;
	public Date date;
	public int table; //masa
	public static ArrayList<MenuItem> clientOrder;
	
	
	public Order()
	{
		
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTable() {
		return table;
	}
	public void setTable(int table) {
		this.table = table;
	}
	public ArrayList<MenuItem> getClientOrder() {
		return clientOrder;
	}
	public void setClientOrder(ArrayList<MenuItem> clientOrder) {
		this.clientOrder = clientOrder;
	}
	public Order(int orderID, Date date, int table, ArrayList<MenuItem> clientOrder) {
		super();
		this.orderID = orderID;
		this.date = date;
		this.table = table;
		this.clientOrder = clientOrder;
	}
	@Override
	public String toString() {
		String s="";
		SimpleDateFormat ft=new SimpleDateFormat("dd.MM.yyyy ',' hh:mm");
		s+="Order [orderID=" + orderID + ", date=" + ft.format(date) + ", table=" + table+"]\n";//+"client order= "+clientOrder;
		for(MenuItem m:clientOrder)
		{
			s+=m+"\n";
		}
		return s;
	}
	
	/**
	 * calculare pret comanda
	 * @return pretul comenzii
	 */
	public static float price()
	{
		float p=0;
		
		for(MenuItem m:clientOrder)
		{
			if(m instanceof BaseProduct)
			{
				p+=((BaseProduct) m).getPrice();
			}
			
			if(m instanceof CompositeProduct)
			{
				p+=((CompositeProduct) m).computePrice();
			}
		}
		
		assert(p!=0);
		return p;
		
	}
	
	
	
	/**
	 * conversie informatie la string
	 * @return string
	 */
	public String priceToString()
	{
		float p=0;
		
		for(MenuItem m:clientOrder)
		{
			if(m instanceof BaseProduct)
			{
				p+=((BaseProduct) m).getPrice();
			}
			
			if(m instanceof CompositeProduct)
			{
				p+=((CompositeProduct) m).computePrice();
			}
		}
		
		String s=String.valueOf(p); 
		return s;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (clientOrder == null) {
			if (other.clientOrder != null)
				return false;
		} else if (!clientOrder.equals(other.clientOrder))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (orderID != other.orderID)
			return false;
		if (table != other.table)
			return false;
		return true;
	}
	
	
	
	
	
}
