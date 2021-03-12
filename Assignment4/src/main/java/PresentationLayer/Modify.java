package PresentationLayer;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BusinessLayer.BaseProduct;
import BusinessLayer.CompositeProduct;
import BusinessLayer.MenuItem;
import BusinessLayer.Restaurant;
import DataLayer.RestaurantSerializator;

public class Modify {
	
	JButton b1= new JButton("Modify");
	JTextField tf1,tf2,tf3,tf4;
	JTextField tf6=new JTextField();
	private RestaurantSerializator rs=new RestaurantSerializator();
	private Restaurant restaurant=new Restaurant();
	public static String path;
	
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

	/*
	 * Fereastra pentru modificarea itemilor din meniu, in functie de tip
	 */
	public Modify()
	{
		//this.path=MainPage.path;
		JFrame frame = new JFrame("Welcome Page");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800, 600);
		
		JPanel content0 = new JPanel();
		JLabel l0= new JLabel("Modify in Menu");
		content0.add(l0);
		
		JLabel l4= new JLabel("Original Name:");
		JLabel l5= new JLabel("Quantity:");
		JLabel l6= new JLabel("Price:");
		JLabel l7= new JLabel("New Name:");
		
		JPanel content2 = new JPanel();
		tf1= new JTextField(); //nume
		tf1.setPreferredSize(new Dimension(200,35));
		tf1.setText(null);
		tf2= new JTextField(); //nume nou
		tf2.setPreferredSize(new Dimension(200,35));
		tf2.setText(null);

		
		JPanel content3=new JPanel();
		tf3= new JTextField(); //cantitate
		tf3.setPreferredSize(new Dimension(100,35));
		tf3.setText("0");
		tf4= new JTextField();//pret
		tf4.setPreferredSize(new Dimension(100,35));
		tf4.setText("0");
		
		
		
		JPanel content4=new JPanel();
		content4.add(b1);
		
		content2.add(l4);
		content2.add(tf1);
		content2.add(l7);
		content2.add(tf2);
		content3.add(l5);
		content3.add(tf3);
		content3.add(l6);
		content3.add(tf4);
		
		JPanel content5=new JPanel();
		JLabel l8=new JLabel("OPTIONAL - Name Composite Product:");
		tf6= new JTextField();
		tf6.setPreferredSize(new Dimension(200,35));
		tf6.setText("null");
		
		content5.add(l8);
		content5.add(tf6);
					
		 JPanel panel= new JPanel();
		 panel.add(content0);
		 panel.add(content5);
		 panel.add(content2);
		 panel.add(content3);
		 panel.add(content4);
		
		 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));			


		frame.setContentPane(panel);
			
		frame.setVisible(true);

	}
	
	/**
	 * Functia pentru modificarea produsului in functie de infomatiile preluate si de tipul acestuia
	 */
	
	public void modifyProduct()
	{
		RestaurantSerializator rs=new RestaurantSerializator();
		restaurant.setSerializator(rs);
		ArrayList<MenuItem> list= new ArrayList<MenuItem>();
		list=rs.deserialization();
		System.out.println(list);
		restaurant.setMenus(list);

		MenuItem modified=null;
		MenuItem modifiedComposite=null;
		ArrayList<MenuItem> baseList=new ArrayList<MenuItem>();

		String nume="";
		String numeNou="";
		int cantitate=0;
		float pret=0;
		
		if(tf1.getText()!=null&&tf2.getText()!=null&&tf3.getText()!="0"&&tf4.getText()!="0")
		{
				nume=tf1.getText();
				numeNou=tf2.getText();
				cantitate=Integer.parseInt(tf3.getText());
				pret=Float.parseFloat(tf4.getText());
				
				modified=new BaseProduct(numeNou,cantitate,pret);
			
				if(tf6.getText().equals("null"))
				{
					//inseamna ca avem base product
					modified=new BaseProduct(numeNou,cantitate,pret);
					
				}
				else
				{
					modified=new BaseProduct(numeNou,cantitate,pret);
					modifiedComposite=new CompositeProduct();
					((CompositeProduct)modifiedComposite).setName(tf6.getText());
					((CompositeProduct)modifiedComposite).setMenus(baseList);
				}
			
		}

				
		
		int contor=0;
		for(MenuItem m: list)
		{
			if(m instanceof BaseProduct)
			{
				if (((BaseProduct)m).getName().equals(nume))
				{
					list.set(contor,modified);
					restaurant.modifyInMenu(list,modified,contor);
										
				}
			}
			
			if(m instanceof CompositeProduct)
			{
				ArrayList<MenuItem> l=new ArrayList<MenuItem>();
				if (((CompositeProduct)m).getName().equals(tf6.getText()))
				{
					int c=0;
					l=((CompositeProduct)m).getMenus();
					for(MenuItem x:l)
					{
						if(((BaseProduct)x).getName().equals(nume))
						{
							l.set(c,modified);
						}
						c++;
					}
					
					//aici am modificat lista de base products a composite productului
					baseList.addAll(l);
				}
				
				System.out.println(modifiedComposite);
				restaurant.modifyInMenu(list,modifiedComposite,contor);
			}
			contor++;
		}
	
		
		tf1.setText(null);
		tf2.setText(null);
		tf3.setText("0");
		tf4.setText("0");
		tf6.setText("null");
			
	}
	
	public void modifyButton()
	{
		b1.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				modifyProduct();
				System.out.println("You modified.");				
			}
		});
	}

}
