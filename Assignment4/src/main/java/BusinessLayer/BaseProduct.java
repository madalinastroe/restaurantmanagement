package BusinessLayer;

import java.io.Serializable;

public class BaseProduct extends MenuItem implements Serializable{

	//LEAF
	
	private String name;
	private int quantity;
	private float price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	/**
	 * 
	 * @param name nume base product
	 * @param quantity cantitate base product
	 * @param price - pret base product
	 */
	public BaseProduct(String name, int quantity, float price) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	@Override
	public String toString() {
		return "BaseProduct [name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}
	@Override
	public float computePrice() {
		// TODO Auto-generated method stub
		//return 0;
		return price;
	}
	

}
