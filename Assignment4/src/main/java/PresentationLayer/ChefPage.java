package PresentationLayer;

import java.awt.Dimension;
import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import BusinessLayer.MenuItem;
import BusinessLayer.Order;
import BusinessLayer.Restaurant;

public class ChefPage extends JFrame implements Observer {

	private Restaurant r=new Restaurant();
	private Order o=new Order();
	
	public Restaurant getR() {
		return r;
	}

	public void setR(Restaurant r) {
		this.r = r;
	}

	public Order getO() {
		return o;
	}

	public void setO(Order o) {
		this.o = o;
	}
	public ChefPage()
	{
		
	}

	/**
	 * cand s-a detectat o schimbare, observatorul este anuntat.
	 * cand s-a creat o comanda, cheful este anuntat printr-un mesaj
	 */
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		System.out.println("IT'S TIME TO MAKE SOMEONE HAPPY!");

	}
	
	public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "CHEF: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	
	/*
	public ChefPage()
	{
		JFrame frame = new JFrame("Welcome Page");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(700, 600);
		
		//initializare componente
		 JPanel content0= new JPanel();
		 JLabel l0= new JLabel("Welcome to the Chef page!");
		 l0.setPreferredSize(new Dimension(220,100));
		 content0.add(l0);
		 
		 
		 JPanel panel= new JPanel();
		 panel.add(content0);
		 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));			


		frame.setContentPane(panel);
			
		frame.setVisible(true);
	}
*/
	
	
	
	
		

}
