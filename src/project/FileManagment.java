package project;

import java.io.FileInputStream;
import java.io.Serializable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException; 
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileManagment  implements Serializable
{
	public static TreeOfDoubly readData()
	{
		FileInputStream fIn;
    	ObjectInputStream in;
    	
    	TreeOfDoubly temp = new TreeOfDoubly();
    	try
    	{
    		in = new ObjectInputStream(new FileInputStream("data/Students.txt"));
    		temp = (TreeOfDoubly) in.readObject();

	    	in.close();
	    	
	    	return temp;
    	}
    	catch (ClassNotFoundException e) 
    	{
    		e.printStackTrace();
    	}
    	catch (IOException e) 
    	{
    		System.out.println(" ");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return temp;
	}
	
	public static void saveData(TreeOfDoubly t)
	{
		FileOutputStream fOut;
    	ObjectOutputStream oOut;
    	
    	try 
    	{
    		fOut = new FileOutputStream("data/Students.txt");
    	    oOut = new ObjectOutputStream(fOut);
    	    
    	    oOut.writeObject(t);
    	}
    	catch (FileNotFoundException e) 
    	{
    	    e.printStackTrace();
    	}
    	catch (IOException e) 
    	{
    	    e.printStackTrace();
    	}
    	
    	System.out.println("Data saved successfully!");
	}
}
