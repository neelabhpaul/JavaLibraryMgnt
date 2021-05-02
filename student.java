import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileWriter; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class student extends bookRecord
{
	public static String info = "";
	public static List<String> dataList = new ArrayList<String>();
	public static String dueDate = null;
	public static String issueDate = null;
	
	public static String dueDateCalc(String date)
		throws Exception {
		issueDate = date;  // Start date | of format "02-01-2021"
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(issueDate));
		c.add(Calendar.DATE, 15);  // 15 days of book use
		String new_date = sdf.format(c.getTime());
		
		return new_date;
		}
	
	
	public static boolean getval(String a, String b, String c)
		throws Exception{
		dueDate = dueDateCalc(c);
		info = a + ", " + b + ", " + c + ", " + dueDate + "\n";
		dataList.add(info);
		
		// Student record maintenance
		File studentFile = new File("student_data.txt");
		try
		{
			  if (studentFile.createNewFile())
			  {
			    System.out.println("File created: " + studentFile.getName());
			  } 
			  else 
			  {
			    System.out.println("File already exists.");
			  }
		}
	      catch (IOException e)
		{
          System.out.println("An error occurred.");
	    }
		
	        
	    // Make new student entry
        
        try
        {
        	
        	File bookRecFile = new File("book_inventory.txt");
            FileReader fr = new FileReader(bookRecFile);
            BufferedReader br = new BufferedReader(fr);
            Scanner ScannerFile = new Scanner(bookRecFile);
            String line = "";
            while (ScannerFile.hasNextLine()){
        		line = line + "\n" + ScannerFile.nextLine();}
        	ScannerFile.close();
        	if (line.contains(b)){
                	FileWriter myWriter = new FileWriter("student_data.txt", true);
	    		    myWriter.write(info);
	    		    myWriter.close();
	    		    System.out.println("Successfully wrote to the file.");
	    		    fr.close();
	    		    br.close();
	    		    return true;}
	            
        	else {
        	System.out.println("Book not available");
        	fr.close();
        	br.close();
        	return false;}
        
            
        }
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
        }
        
        dataList.clear();
        return true;
    }
	      
	public static String show()
	{
		String data = "Student Id, Book Id, Issue date, Due date\n";
		    try {
		      File studentFile = new File("student_data.txt");
		      Scanner studentReader = new Scanner(studentFile);
		      while (studentReader.hasNextLine())
		      {
		        data = data + "\n" + studentReader.nextLine();
		      }
		      
		      studentReader.close();
		    } 
		    catch (FileNotFoundException e) 
		    {
		      System.out.println("An error occurred.");
		    }
		   return data;
		    
	}

	public static void submit(String prn)
	{
		List<String> lines = new ArrayList<String>();
	    String line = null;
	    String admissionID = null;
	    
		try {
	        //System.out.println("Enter PRN: ");
	        admissionID = prn;
            File studentFile = new File("student_data.txt");
            FileReader fr = new FileReader(studentFile);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (line.contains(admissionID))
                	line = " ";
                	lines.add(line);
            }
            System.out.println("Book has been submitted");
            fr.close();
            br.close();

            FileWriter fw = new FileWriter(studentFile);
            BufferedWriter out = new BufferedWriter(fw);
            for(String s : lines)
                 out.write(s+"\n");
            out.flush();
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

	
}
	

