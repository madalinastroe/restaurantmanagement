package PresentationLayer;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import BusinessLayer.BaseProduct;
import BusinessLayer.CompositeProduct;
import BusinessLayer.MenuItem;
import BusinessLayer.Order;

public class Table extends JFrame{
	
	JTable menuItems;
	JFrame items;
	
	JTable orders;
	JFrame od;
	
	public Table()
	{
		
		
	}
	
	/**
	 * 
	 * @param menuItems lista de itemi
	 * @return matricea de stringuri data
	 */
	public String[][] getMenu(ArrayList<MenuItem> menuItems)
	{
		String[][] data=new String[100][100];
		int i=0;
		for(MenuItem m: menuItems)
		{
			if(m instanceof BaseProduct)
			{
				try
				{
					BaseProduct product=((BaseProduct)m);
					data[i][0]=m.getClass().getSimpleName();
					data[i][1]=product.getName();
					data[i][2]=String.valueOf(product.getQuantity());
					data[i][3]=String.valueOf(product.getPrice());
					data[i][4]="-";


					i++;
				}
				catch(IllegalArgumentException e)
				{
					e.printStackTrace();
				}
			}
			else if(m instanceof CompositeProduct)
			{
				try
				{
					CompositeProduct product=(CompositeProduct)m;
					data[i][0]=m.getClass().getSimpleName();
					data[i][1]=product.getName();
					data[i][2]=product.totalQuantity();
					data[i][3]=product.totalPrice();
					data[i][4]=String.valueOf(product.getMenus());
					i++;
				}
				catch(IllegalArgumentException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		
		return data;
	}
	
	/**
	 * 
	 * @param orders lista de comenzi
	 * @return matrice stringuri data
	 */
	public String[][] getOrders(ArrayList<Order> orders)
	{
		String[][] data=new String[100][100];
		int i=0;
		for(Order order: orders)
		{
			try
			{
				Order ord= (Order)order;
				data[i][0]=String.valueOf(ord.getOrderID());
				data[i][1]=String.valueOf(ord.getDate());
				data[i][2]=String.valueOf(ord.getTable());
				data[i][3]=String.valueOf(ord.getClientOrder());

				i++;
			}
			catch (IllegalArgumentException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return data;
		
	}
	
	/**
	 * creare tabel cu numele coloanelor
	 * @param menu -aici avem numele coloanelor
	 */
	public void menuTable(String[][] menu)
	{
		items= new JFrame();
		items.setTitle("Tabel items");

		String[] columnNames= {"Tip item","Name item","Quantity item","Price item","X"};

		menuItems= new JTable(menu,columnNames);
		menuItems.setBounds(30, 40, 300, 300);
		
		JScrollPane scrollPane= new JScrollPane(menuItems);
		items.add(scrollPane);
		items.setSize(800, 500);
		items.setVisible(true);
	}
	
	/**
	 * creare tabel cu numele coloanelor
	 * @param order - numele coloanelor
	 */
	public void orderTable(String[][] order)
	{
		od=new JFrame();
		od.setTitle("Teble orders");

		String[] columnNames = {"Order ID", "Date", "Table", "Client Order"};
		
		orders = new JTable(order, columnNames);
		orders.setBounds(30, 40, 300, 300);

		JScrollPane scrollPane = new JScrollPane(orders);
		od.add(scrollPane);
		od.setSize(500, 200);
		od.setVisible(true);
		}

	}

	
	
