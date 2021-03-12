package DataLayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import BusinessLayer.MenuItem;
import BusinessLayer.Order;
import PresentationLayer.MainPage;

public class RestaurantSerializator implements Serializable {
	
	public static String path;
	
	@Override
	public String toString() {
		return "RestaurantSerializator [deserialization()=" + deserialization() + "]";
	}

	/**
	 * Clasa care implementeaza interfata Serializable ce contine metode de serializare si deserializare
	 * pentru meniu si comenzi
	 */
	public RestaurantSerializator()
	{
		this.path=MainPage.path;
	}
	
	
	public void serialization(ArrayList<MenuItem> menus)
	{
		try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(path); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object
            out.writeObject(menus); 
            out.flush();
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
           ex.printStackTrace(); 
        } 
	  
	}
	
	public ArrayList<MenuItem> deserialization()
	{
		ArrayList<MenuItem> menuAux= new ArrayList<MenuItem>();
		
		 try
	        {    
	            // Reading the object from a file 
	            FileInputStream file = new FileInputStream(path); 
	            ObjectInputStream in = new ObjectInputStream(file); 
	              
	            // Method for deserialization of object 
	            menuAux = (ArrayList<MenuItem>)in.readObject();
	              
	            in.close(); 
	            file.close(); 
	              
	            System.out.println("Object has been deserialized "); 
	            return menuAux;
	        } 
	          
	        catch(IOException ex) 
	        { 
	            System.out.println("IOException is caught"); 
	        } 
	          
	        catch(ClassNotFoundException ex) 
	        { 
	            System.out.println("ClassNotFoundException is caught"); 
	        }
		return menuAux; 
	}
	
	
	public void serializationO(ArrayList<Order> o)
	{
		try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream("orders.ser"); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object
            out.writeObject(o); 
            out.flush();
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
           ex.printStackTrace(); 
        } 
	  
	}
	
	
	
	public ArrayList<Order> deserializationO()
	{
		ArrayList<Order> aux= new ArrayList<Order>();
		
		 try
	        {    
	            // Reading the object from a file 
	            FileInputStream file = new FileInputStream("orders.ser"); 
	            ObjectInputStream in = new ObjectInputStream(file); 
	              
	            // Method for deserialization of object 
	            aux = (ArrayList<Order>)in.readObject();
	              
	            in.close(); 
	            file.close(); 
	              
	            System.out.println("Object has been deserialized "); 
	            return aux;
	        } 
	          
	        catch(IOException ex) 
	        { 
	            System.out.println("IOException is caught"); 
	        } 
	          
	        catch(ClassNotFoundException ex) 
	        { 
	            System.out.println("ClassNotFoundException is caught"); 
	        }
		return aux; 
	}
	
	public void serializationHM(HashMap<Order,ArrayList<MenuItem>> o)
	{
		try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream("HM.ser"); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object
            out.writeObject(o); 
            out.flush();
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
           ex.printStackTrace(); 
        } 
	  
	}
	
	public HashMap<Order,ArrayList<MenuItem>> deserializationHM()
	{
		HashMap<Order,ArrayList<MenuItem>> aux=new HashMap<Order,ArrayList<MenuItem>>();
		
		 try
	        {    
	            // Reading the object from a file 
	            FileInputStream file = new FileInputStream("HM.ser"); 
	            ObjectInputStream in = new ObjectInputStream(file); 
	              
	            // Method for deserialization of object 
	            aux = (HashMap<Order,ArrayList<MenuItem>>)in.readObject();
	              
	            in.close(); 
	            file.close(); 
	              
	            System.out.println("Object has been deserialized "); 
	            return aux;
	        } 
	          
	        catch(IOException ex) 
	        { 
	            System.out.println("IOException is caught"); 
	        } 
	          
	        catch(ClassNotFoundException ex) 
	        { 
	            System.out.println("ClassNotFoundException is caught"); 
	        }
		return aux; 
	}
	
	
	

}
