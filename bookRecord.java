import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class bookRecord{

	public static String bookID = null;
	public static String bookName = null;
	public static List<String> bookData = new ArrayList<String>();
	
	public static void addBook(String bkID, String bkNM) throws Exception
	{
		List<String> lines = new ArrayList<String>();
	    //String line = null;
	    
		// Reading data using readLine
        //System.out.println("Enter Book-ID: ");
        bookID = bkID;
        
        //System.out.println("Enter Name of the Book: ");
        bookName = bkNM;
        
        //System.out.println("Book has been added to Inventory");
        bookData = Arrays.asList(bookID, ", ", bookName, "\n");
        
        File bookRec = new File("book_inventory.txt");
        FileReader fr = new FileReader(bookRec);
        BufferedReader br = new BufferedReader(fr);
        
        lines.addAll(bookData);
        
        fr.close();
        br.close();

        FileWriter fw = new FileWriter(bookRec, true);
        BufferedWriter out = new BufferedWriter(fw);
        for(String s : lines)
             out.write(s);
        out.flush();
        out.close();
	}
	
	public static String showBooks()
	{
		String data = "LIBRARY BOOKS:\n";
		try {
		      File bookRec = new File("book_inventory.txt");
		      Scanner bookReader = new Scanner(bookRec);
		      while (bookReader.hasNextLine())
		      {
		        data = data + "\n" + bookReader.nextLine();
		      }
		      bookReader.close();
		    } 
		    catch (FileNotFoundException e) 
		    {
		      System.out.println("An error occurred.");
		    }
		return data;
	}
	
}
