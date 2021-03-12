package PresentationLayer;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import BusinessLayer.MenuItem;
import BusinessLayer.Order;
import DataLayer.FileWriterClass;
import DataLayer.RestaurantSerializator;

public class Compute {
	
	JButton b1=new JButton("Compute Price");
	private RestaurantSerializator rs=new RestaurantSerializator();
	JTextField tf1;
	JTextArea tf2;
	
	/**
	 * Calculare nota de plata in functie de id Comanda.
	 */
	public Compute()
	{
		JFrame frame = new JFrame("Welcome Page");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(900,700);
		
		JPanel content0 = new JPanel();
		JLabel l0= new JLabel("Compute order price");
		content0.add(l0);
		
		
		JPanel content1 = new JPanel();
		 tf1= new JTextField(); //nume
		JLabel l1= new JLabel("OrderID:");
		tf1.setPreferredSize(new Dimension(200,35));
		content1.add(l1);
		content1.add(tf1);
		
		 tf2=new JTextArea("Aici afisam informatiile comenzii"); //display some info
		JScrollPane scroll = new JScrollPane ( tf2 );
		scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		tf2.setPreferredSize(new Dimension(800,500));
		tf2.setEditable(false);
		content1.add ( scroll );
		
		
		JPanel content5 = new JPanel();
		content5.add(b1);
		
		 
		 JPanel panel= new JPanel();
		 panel.add(content0);
		 panel.add(content1);
		 panel.add(content5);
		 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));			


		frame.setContentPane(panel);
			
		frame.setVisible(true);
	}
	
	public void billButton()
	{
		b1.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				bill();
				
			}
		});
	}
	
	public void printOrderDetails(Order o,String price)
	{
		String s=o.toString();
		s+="\nTotal Price: "+price;
		tf2.setText(s);
	}
	
	/**
	 * Functie pentru afisare in pagina a detaliilor comenzii
	 */
	public void bill()
	{
		int order=0;
		if(tf1.getText()!=null)
		{
			order=Integer.parseInt(tf1.getText());
		}
		
		ArrayList<Order> aux=new ArrayList<Order>();
		aux=rs.deserializationO();
		HashMap<Order,ArrayList<MenuItem>> a=new  HashMap<Order,ArrayList<MenuItem>>();
		a=rs.deserializationHM();
		Order buna=null;
		//System.out.println(a);
		
		for(Order o:aux)
		{
			if(o.getOrderID()==order)
			{
				String s=o.priceToString();
				buna=o;
				FileWriterClass f=new FileWriterClass();
				f.print(s);
				printOrderDetails(o,s);
			}
		}
		 for (Map.Entry me : a.entrySet()) {
	          //
			 Order o=(Order) me.getKey();
				if(o.hashCode()==buna.hashCode())
					System.out.println("This is me:\nKey: "+me.getKey() + " & Value: " + me.getValue());
			
		 }
		
	}
	
}
