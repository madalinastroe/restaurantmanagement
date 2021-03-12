package PresentationLayer;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import BusinessLayer.BaseProduct;
import BusinessLayer.CompositeProduct;
import BusinessLayer.MenuItem;
import BusinessLayer.Restaurant;
import DataLayer.RestaurantSerializator;

public class Add implements Serializable{
	
	private JButton b1= new JButton("Add");
	private RestaurantSerializator rs=new RestaurantSerializator();
	private Restaurant restaurant=new Restaurant();
	private ArrayList<MenuItem> menus= new ArrayList<MenuItem>();
	public static String path;
	
	JTextField tf0;
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	JTextField tf4;
	JTextField tf5;
	JTextField tf6;
	JTextField tf7;
	JTextField tf8;
	JTextField tf9;
	JTextField tf10=new JTextField();
	

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

	/**
	 * fereastra in care adaugam in meniu base product sau composite product
	 */
	public Add()
	{
		//this.path=AdministratorPage.path;
		this.restaurant.setMenus(menus);
		JFrame frame = new JFrame("Welcome Page");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(1000, 800);
		
		JPanel content0 = new JPanel();
		JLabel l0= new JLabel("Add in Menu");
		content0.add(l0);
		
		JLabel l4= new JLabel("Name:");
		JLabel l5= new JLabel("Quantity:");
		JLabel l6= new JLabel("Price:");
		
		JLabel l7= new JLabel("Base Product 1:");
		JLabel l8= new JLabel("Base Product 2:");
		JLabel l9= new JLabel("Composite Product:");

		JLabel l11= new JLabel("Quantity:");
		JLabel l12= new JLabel("Price:");
		
		
		
		JPanel content1 = new JPanel();
		JLabel l1= new JLabel("Add Base Product");
		content1.add(l1);
		
		JPanel content2 = new JPanel();
		tf1= new JTextField(); //nume
		tf1.setPreferredSize(new Dimension(200,35));
		tf1.setText(null);
		tf2= new JTextField(); //cantitate
		tf2.setPreferredSize(new Dimension(200,35));
		tf2.setText("0");
		tf3= new JTextField(); //pret
		tf3.setPreferredSize(new Dimension(200,35));
		tf3.setText("0");
		content2.add(l4);
		content2.add(tf1);
		content2.add(l5);
		content2.add(tf2);
		content2.add(l6);
		content2.add(tf3);
		
		JPanel content3 = new JPanel();
		JLabel l3= new JLabel("Add Composite Product");
		content3.add(l3);
		
		JPanel content4 = new JPanel();
		tf4= new JTextField(); //bp1
		tf4.setPreferredSize(new Dimension(200,35));
		tf4.setText(null);
		tf5= new JTextField(); //bp2
		tf5.setPreferredSize(new Dimension(200,35));
		tf5.setText(null);
		tf6= new JTextField(); //nume
		tf6.setPreferredSize(new Dimension(200,35));
		tf6.setText(null);
		content4.add(l7);
		content4.add(tf4);
		content4.add(l8);
		content4.add(tf5);
		content4.add(l9);
		content4.add(tf6);
		
		JPanel content5 = new JPanel();
		 tf8= new JTextField(); //cantitate
		tf8.setPreferredSize(new Dimension(200,35));
		tf8.setText("0");
		 tf9= new JTextField(); //pret
		tf9.setPreferredSize(new Dimension(200,35));
		tf9.setText("0");
	
		content5.add(l11);
		content5.add(tf8);
		content5.add(l12);
		content5.add(tf9);
		
		JPanel content6 = new JPanel();
		content6.add(b1);
		
		 
		 JPanel panel= new JPanel();
		 panel.add(content0);
		 panel.add(content1);
		 panel.add(content2);
		 panel.add(content3);
		 panel.add(content4);
		 panel.add(content5);
		 panel.add(content6);
		 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));			


		frame.setContentPane(panel);
			
		frame.setVisible(true);

	}
	
	public void addButton()
	{
		b1.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				addInMenuBaseProduct();
				addInMenuCompositeProduct();
				System.out.println("You added.");
				//aici deschidem fereastra noua
				
			}
		});
	}
	
	/*
	 * metoda adaugare base product
	 */
	
	public void addInMenuBaseProduct()
	{	
		String nume="";
		int cantitate=0;
		float pret=0;
		try
		{
			
			if(tf1.getText()!=null)
			{
				nume=tf1.getText();
				cantitate=Integer.parseInt(tf2.getText());
				pret=Float.parseFloat(tf3.getText());
			}
			
			if(nume!=""&&cantitate!=0&&pret!=0)
			{
				BaseProduct bp=new BaseProduct(nume,cantitate,pret);
				System.out.println(bp);		
				MenuItem aux=(MenuItem) bp;
				restaurant.addInMenu(aux);
				tf1.setText(null);
				tf2.setText("0");
				tf3.setText("0");
				System.out.println(restaurant);
				
			}
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
		
		
	
	}
	
	/*
	 * metoda adaugare composite product in meniu
	 */
	public void addInMenuCompositeProduct()
	{
		
		String bp1="";
		String bp2="";
		String nume="";
		int cantitate=0;
		float pret=0;
		
		if(tf4.getText()!=null&&tf5.getText()!=null&&tf6.getText()!=null)
		{
			bp1=tf4.getText();
			bp2=tf5.getText();
			nume=tf6.getText();
			cantitate=Integer.parseInt(tf8.getText());
			pret=Float.parseFloat(tf9.getText());
		}
		
		try
		{
			
			if(bp1!=""&&bp2!=""&&nume!=""&&cantitate!=0&&pret!=0)
			{
				BaseProduct base1=new BaseProduct(bp1,cantitate,pret);
				BaseProduct base2=new BaseProduct(bp2,cantitate,pret);
				
				CompositeProduct cp=new CompositeProduct();
				ArrayList<MenuItem> list=new ArrayList<MenuItem>();
				cp.setMenus(list);
				list.add(base1);
				list.add(base2);
				cp.setName(nume);
				restaurant.addInMenu(cp);
				System.out.println(restaurant);
				tf4.setText(null);
				tf5.setText(null);
				tf6.setText("0");
				tf8.setText("0");
				tf9.setText("0");
				
			}
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
		
		
	}
	

}
