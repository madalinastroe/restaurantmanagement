package PT2020.Assignment4.Assignment4;

import DataLayer.RestaurantSerializator;
import PresentationLayer.MainPage;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String file=args[0];
    	MainPage mp= new MainPage();
    	mp.path=file;
		mp.buttonAdministrator();
		mp.buttonChef();
		mp.buttonWaiter();

    }
}
