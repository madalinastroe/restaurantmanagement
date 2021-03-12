package BusinessLayer;

import java.util.ArrayList;

public class CompositeProduct extends MenuItem {
	
	//COMPOSITE
	private String name;
	private ArrayList<MenuItem> menus;
	
	public CompositeProduct()
	{
		
	}
	/**
	 * 
	 * @param name - nume composite product
	 * @param menus - lista base products 
	 */
	
	public CompositeProduct(String name, ArrayList<MenuItem> menus) {
		super();
		this.name = name;
		this.menus = menus;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<MenuItem> getMenus() {
		return menus;
	}

	public void setMenus(ArrayList<MenuItem> menus) {
		this.menus = menus;
	}
	

	@Override
	public String toString() {
		return "CompositeProduct [name=" + name + ", menus=" + menus + "]";
	}
//----------------------------------------------------------------
	@Override
	public float computePrice() {
		// TODO Auto-generated method stub
		//return 0;
		
		float total=0;
		
		for(MenuItem m:menus)
		{
			if(m instanceof BaseProduct)
			{
				total+=((BaseProduct) m).computePrice();
			}
		}
		
		return total;
	}
//---------------------------------------------------------------------
	public void showAllBaseProducts()
	{
		for(MenuItem m:menus)
		{
			if(m instanceof BaseProduct)
			{
				System.out.println(((BaseProduct) m).getName());
			}
		}
	}
	/**
	 * 
	 * @return pretul total
	 */
	
	public String totalPrice()
	{
		float total=0;
		
		for(MenuItem m:menus)
		{
			if(m instanceof BaseProduct)
			{
				total+=((BaseProduct) m).getPrice();
			}
		}
		
		String s=String.valueOf(total);  
		return s;
	}
	
	/**
	 *
	 * @return cantitatea totala
	 */
	public String totalQuantity()
	{
		float total=0;
		
		for(MenuItem m:menus)
		{
			if(m instanceof BaseProduct)
			{
				total+=((BaseProduct) m).getQuantity();
			}
		}
		
		String s=String.valueOf(total);  
		return s;
	}
	
	
	

}
