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
import javax.swing.JTable;

import BusinessLayer.Restaurant;
import DataLayer.RestaurantSerializator;
import BusinessLayer.MenuItem;

public class AdministratorPage extends JFrame{
	
	Restaurant restaurant= new Restaurant();
	RestaurantSerializator serializator= new RestaurantSerializator();
	private JButton addInMenu= new JButton("Add in menu");
	private JButton deleteFromMenu= new JButton("Delete from menu");
	private JButton modifyInMenu= new JButton("Modify in menu");
	private JButton view= new JButton("View All");
	private JTable table=new JTable();
	public static String path;
	
	
	public RestaurantSerializator getSerializator() {
		return serializator;
	}

	public void setSerializator(RestaurantSerializator serializator) {
		this.serializator = serializator;
	}

	/**
	 * Pagina pentru Administrator.
	 * Acesta poate sa adauge in meniu, sa modifice in meniu sau sa stearga din meniu
	 */
	public AdministratorPage()
	{
		//this.path=MainPage.path;
		JFrame frame = new JFrame("Welcome Page");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(700, 600);
		
		//initializare componente
		 JPanel content0= new JPanel();
		 JLabel l0= new JLabel("Welcome to the Administrator page!");
		 l0.setPreferredSize(new Dimension(220,100));
		 content0.add(l0);
		 
		 
		 JPanel content1= new JPanel();
		 addInMenu.setPreferredSize(new Dimension(300,50));
		 content1.add(addInMenu);
		 
		 JPanel content2= new JPanel();
		 deleteFromMenu.setPreferredSize(new Dimension(300,50));
		 content2.add(deleteFromMenu);
		 
		 JPanel content3= new JPanel();
		 modifyInMenu.setPreferredSize(new Dimension(300,50));
		 content3.add(modifyInMenu);
		 
		 JPanel content4= new JPanel();
		 view.setPreferredSize(new Dimension(200,50));
		 content4.add(view);
		 
		 
		 
		 JPanel panel= new JPanel();
		 panel.add(content0);
		 panel.add(content1);
		 panel.add(content2);
		 panel.add(content3);
		 panel.add(content4);
		 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));			


		frame.setContentPane(panel);
			
		frame.setVisible(true);
	}
	
	public void newMenuItem()
	{
		addInMenu.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Add in menu");
				//aici deschidem fereastra noua
				Add add= new Add();
				add.addButton();
			}
		});
	}
	
	public void deleteMenuItem()
	{
		deleteFromMenu.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Delete from menu");
				//aici deschidem fereastra noua
				Delete d=new Delete();
				d.deleteButton();
			}
		});
	}
	
	public void editMenuItem()
	{
		modifyInMenu.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Modify in menu");
				//aici deschidem fereastra noua
				Modify m= new Modify();
				m.modifyButton();
							
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
	 * Functia pentru afisare in tabel a meniului
	 */
	public void afisare()
	{
		Table table=new Table();
		
		ArrayList<MenuItem> aux=new ArrayList<MenuItem>();
		serializator.path=MainPage.path;
		aux=serializator.deserialization();
		restaurant.setMenus(aux);
		
		String[][] s=table.getMenu(aux);
		table.menuTable(s);
					
	}

}
