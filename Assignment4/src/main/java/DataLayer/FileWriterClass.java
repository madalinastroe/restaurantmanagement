package DataLayer;
import java.io.*;  

public class FileWriterClass { 
	
	/**
	 * Functie pentru afisarea in format .txt a pretului comezii
	 * @param s - Stringul ce se doreste a fi afisat
	 */
	public void print(String s)
	{
		try {
			FileWriter fw=new FileWriter("bill.txt");
			fw.write(s);
			fw.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}  