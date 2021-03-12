package PresentationLayer;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import BusinessLayer.BaseProduct;
import BusinessLayer.CompositeProduct;
import BusinessLayer.MenuItem;
import BusinessLayer.Order;
import BusinessLayer.Restaurant;
import DataLayer.RestaurantSerializator;

public class CreateOrder  {
	
	private JButton b1=new JButton("Create Order");
	private JButton b2=new JButton("Add in List");
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	private RestaurantSerializator rs=new RestaurantSerializator();
	private Restaurant restaurant=new Restaurant();
	ArrayList<MenuItem> clientList=new ArrayList<MenuItem>();
	ArrayList<MenuItem> alo=new ArrayList<MenuItem>();

	
	public RestaurantSerializator getRs() {
		return rs;
	}

	public void setRs(RestaurantSerializator rs) {
		this.rs = rs;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public CreateOrder()
	{
		JFrame frame = new JFrame("Welcome Page");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(900,900);
		
		JPanel content0=new JPanel();
		content0 = new JPanel();
		l0= new JLabel("Add Product in Order");
		content0.add(l0);
		
		JPanel content1=new JPanel();
		 l1= new JLabel("Name:");
		content1.add(l1);
		tf1=new JTextField();
		tf1.setText(null);
		content1.add(tf1);
		tf1.setPreferredSize(new Dimension(200,35));
		l2= new JLabel("Quantity:");
		content1.add(l2);
		tf2=new JTextField();
		content1.add(tf2);
		tf2.setPreferredSize(new Dimension(200,35));
		tf2.setText("0");
		JPanel content4=new JPanel();
		 l7= new JLabel("OrderID:");
		tf6=new JTextField();
		tf6.setPreferredSize(new Dimension(200,35));
		tf6.setText("0");
		content4.add(l7);
		content4.add(tf6);
		 l8= new JLabel("Table:");
		 tf7=new JTextField();
		tf7.setPreferredSize(new Dimension(200,35));
		tf7.setText("0");
		content4.add(l8);
		content4.add(tf7);
		JPanel content5=new JPanel();
		content5.add(b1);
		content5.add(b2);
		 JPanel panel=new JPanel();
		 panel.add(content0);
		 panel.add(content1);
		 panel.add(content4);
		 panel.add(content5);
		 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));			

		frame.setContentPane(panel);
			
		frame.setVisible(true);
		
		
	}
	
	void createOrderButton()
	{
		b1.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				process();
				System.out.println("You created an order.");
				
			}
		});
	}
	
	void addInListButton()
	{
		b2.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
			addInList();
				System.out.println("We added menu item in list");
				
			}
		});
	}
	
	public void addBP(ArrayList<MenuItem> menuList,MenuItem m,String name, int quantity)
	{
		MenuItem aux=null;
		int qAux=0;
		if(quantity<((BaseProduct)m).getQuantity())
			qAux=quantity;
		else
			qAux=((BaseProduct)m).getQuantity();
		aux=new BaseProduct(name,qAux,((BaseProduct)m).getPrice());
		menuList.add(aux);
	}
	
	public void addCP(ArrayList<MenuItem> menuList,MenuItem m,String name, int quantity)
	{
		int min=10000;
		for(MenuItem x: ((CompositeProduct)m).getMenus())
		{
			if(((BaseProduct)x).getQuantity()<min)
				min=((BaseProduct)x).getQuantity();
		}
		
		for(MenuItem x: ((CompositeProduct)m).getMenus())
			((BaseProduct)x).setQuantity(min);
		
		CompositeProduct aux=new CompositeProduct(name,((CompositeProduct)m).getMenus());
		System.out.println(aux);
		menuList.add(aux);
	}
	
	public ArrayList<MenuItem> addInList()
	{
		
		ArrayList<MenuItem> menuList=new ArrayList<MenuItem>();
		menuList=rs.deserialization();
		System.out.println("Meniu: "+menuList);
		ArrayList<String> s=new ArrayList<String>();
		String name="";
		int quantity=0;
		BaseProduct b=null;
		CompositeProduct c=null;
		if(tf1.getText()!=null && tf2.getText()!="0")
		{
			name=tf1.getText();
			quantity=Integer.parseInt(tf2.getText());
			for(MenuItem m: menuList)
			{
				if(m instanceof BaseProduct) 
				{
					if(((BaseProduct)m).getName().equals(name))
						addBP(alo,m,name,quantity);
				}
			}
			for(MenuItem m:menuList)
			{
				if(m instanceof CompositeProduct) 
				{
					if(((CompositeProduct)m).getName().equals(name))
						addCP(alo,m,name,quantity);
				}
			}
						
		}
		tf1.setText(null);
		tf2.setText("0");
		//System.out.println("Comanda unui client: "+alo);
		return alo;
	}
	
	public Order createOrder(ArrayList<MenuItem> list)
	{	
		Date d=new Date();
		int orderID=0;
		int table=0;
		Order o=null;
		if(tf6.getText()!="0"&&tf7.getText()!="0")
		{
			orderID=Integer.parseInt(tf6.getText());
			table=Integer.parseInt(tf7.getText());
		}
		
		if(orderID!=0&& table!=0)
		{
			o=new Order(orderID,d,table,list);	
			//restaurant.addOrder(o);
		}
		tf6.setText("0");
		tf7.setText("0");
		return o;
	}
	
	public void process()
	{
		
		clientList=addInList();
		System.out.println("Lista clienti: "+clientList);
		Order aux=createOrder(clientList);
		restaurant.addOrder(aux);
		
	}
	
	
	public static void main(String[] args)
	{
		CreateOrder o=new CreateOrder();
		o.createOrderButton();
		o.addInListButton();
	}
	

}
