package PresentationLayer;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import BusinessLayer.MenuItem;
import BusinessLayer.Order;
import BusinessLayer.Restaurant;
import DataLayer.RestaurantSerializator;

public class WaiterPage extends JFrame{
	
	private JButton createOrder= new JButton("Create Order");
	private JButton computeBill= new JButton("Compute Bill");
	private JButton view= new JButton("View All");
	private RestaurantSerializator rs=new RestaurantSerializator();
	private Restaurant restaurant=new Restaurant();
	private JTable table=new JTable();
	private int newOrder=0;
	
	

	public int getNewOrder() {
		return newOrder;
	}

	public void setNewOrder(int newOrder) {
		this.newOrder = newOrder;
	}

	/**
	 * Fereastra pentru Waiter
	 * Optiunile pentru acesta sunt de Creare comanda, calculare nota de plata si de afisare comenzi
	 */
	public WaiterPage()
	{
		this.newOrder=0;
		JFrame frame = new JFrame("Welcome Page");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800, 600);
		
		//initializare componente
		 JPanel content0= new JPanel();
		 JLabel l0= new JLabel("Welcome to the Waiter page!");
		 l0.setPreferredSize(new Dimension(220,100));
		 content0.add(l0);
		 
		 
		 JPanel content1= new JPanel();
		 createOrder.setPreferredSize(new Dimension(300,50));
		 content1.add(createOrder);
		 
		 JPanel content2= new JPanel();
		 computeBill.setPreferredSize(new Dimension(300,50));
		 content2.add(computeBill);		 
		 
		 JPanel content4= new JPanel();
		 view.setPreferredSize(new Dimension(200,50));
		 content4.add(view);
		 
		 JPanel panel= new JPanel();
		 panel.add(content0);
		 panel.add(content1);
		 panel.add(content2);
		 panel.add(content4);
		 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));			


		frame.setContentPane(panel);
			
		frame.setVisible(true);
	}
	
	public void newOrder()
	{
		createOrder.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Create Order");
				afisareMeniu();
				//aici deschidem fereastra noua
				CreateOrder o=new CreateOrder();
				
				o.createOrderButton();
				o.addInListButton();
				//newOrder=1;
				
			}
		});
	}
	
	public void generateBill()
	{
		computeBill.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Compute Bill");
				//aici deschidem fereastra noua
				Compute c= new Compute();
				c.billButton();

				
			}
		});
	}
	

	
	public void viewButton()
	{
		view.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				afisare();
				
			}
		});
	}
/**
 * Functie pentru afisarea comenzilor preluate
 */
	public void afisare()
	{

		Table table=new Table();
		
		ArrayList<Order> aux=new ArrayList<Order>();
		
		aux=rs.deserializationO();
		restaurant.setClientOrders(aux);
		
		String[][] s=table.getOrders(aux);
		table.orderTable(s);
					
	}
	
	/**
	 * Functie pentru afisarea meniului pentru a se vedea optiunile de comanda
	 */
	
	public void afisareMeniu()
	{
		Table table=new Table();
		
		ArrayList<MenuItem> aux=new ArrayList<MenuItem>();
		rs.path=MainPage.path;
		aux=rs.deserialization();
		restaurant.setMenus(aux);
		
		String[][] s=table.getMenu(aux);
		table.menuTable(s);
					
	}
/*
	public static void main(String[] args)
	{
		WaiterPage wp= new WaiterPage();
		wp.newOrder();
		wp.generateBill();
		wp.viewButton();
		
	}
*/
	
	
}
