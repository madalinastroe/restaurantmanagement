package PresentationLayer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import BusinessLayer.Restaurant;
import DataLayer.RestaurantSerializator;

public class MainPage extends JFrame{
	
	private JButton administrator= new JButton("Administrator");
	private JButton chef= new JButton("Chef");
	private JButton waiter= new JButton("Waiter");
	public static String path;

	/**
	 * Pagina principala
	 * Contine 3 butoane de unde putem selecta una dintre functii: Administrator, Chef sau Waiter
	 */
	
	public MainPage()
	{
		JFrame frame = new JFrame("Welcome Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setSize(700, 600);
		
		//initializare componente
		 JPanel content0= new JPanel();
		 JLabel l0= new JLabel("Welcome to the main page!");
		 l0.setPreferredSize(new Dimension(180,100));
		 content0.add(l0);
		 
		 
		 JPanel content1= new JPanel();
		 administrator.setPreferredSize(new Dimension(300,50));
		 content1.add(administrator);
		 
		 JPanel content2= new JPanel();
		 chef.setPreferredSize(new Dimension(300,50));
		 content2.add(chef);
		 
		 JPanel content3= new JPanel();
		 waiter.setPreferredSize(new Dimension(300,50));
		 content3.add(waiter);
		 
		 JPanel panel= new JPanel();
		 panel.add(content0);
		 panel.add(content1);
		 panel.add(content2);
		 panel.add(content3);
		 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));			


		frame.setContentPane(panel);
			
		frame.setVisible(true);
	}
	
	public void buttonAdministrator()
	{
		administrator.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You are the admin");
				//aici deschidem fereastra noua
				AdministratorPage ap= new AdministratorPage();
				ap.newMenuItem();
				ap.deleteMenuItem();
				ap.editMenuItem();
				ap.viewButton();
			}
		});
	}

	
	public void buttonChef()
	{
		chef.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You are the chef");
				//aici deschidem fereastra noua
				ChefPage cp= new ChefPage();
				Restaurant r=new Restaurant();
				r.registerObserver(cp);
				r.dataChanged(r.getO());
				ChefPage.infoBox("YOU'VE GOT A NEW ORDER\nIT'S TIME TO MAKE SOMEONE HAPPY","New Order");
				
			}
		});
	}
	
	public void buttonWaiter()
	{
		waiter.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You are the waiter");
				//aici deschidem fereastra noua
				WaiterPage wp= new WaiterPage();
				wp.newOrder();
				wp.generateBill();
				wp.viewButton();
			}
		});
	}
	
	 

	
	
}

