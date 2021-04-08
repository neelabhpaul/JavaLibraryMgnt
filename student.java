import java.util.*; 
import java.io.File;  // Import the File class
import java.io.FileWriter; 
import java.io.FileNotFoundException;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class student 
{
	private String info = "";
	private List<String> dataList = new ArrayList<String>();
	private String dueDate = "";
	private String issueDate = "";
	
	public String dueDateCalc(String date)
		throws Exception {
		issueDate = date;  // Start date | of format "02-01-2021"
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(issueDate));
		c.add(Calendar.DATE, 15);  // 15 days of book use
		String new_date = sdf.format(c.getTime());
		
		return new_date;
		}
	void getval(String a, String b, String c)
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
          //e.printStackTrace();
	    }
		
	        
	    // Make new student entry
        
        try
        {
        	FileWriter myWriter = new FileWriter("student_data.txt");
		    myWriter.write(info);
		    myWriter.close();
		    System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
            //e.printStackTrace();
        }
        
        dataList.clear();
    }
	      
	void show()
	{
	
		    try {
		      File studentFile = new File("student_data.txt");
		      Scanner studentReader = new Scanner(studentFile);
		      while (studentReader.hasNextLine())
		      {
		        String data = studentReader.nextLine();
		        System.out.println(data);
		      }
		      studentReader.close();
		    } 
		    catch (FileNotFoundException e) 
		    {
		      System.out.println("An error occurred.");
		      //e.printStackTrace();
		    }
		    
	}

	void submit(String entry)
	{
		File studentFile = new File("student_data.txt");
		if (!studentFile.isFile()) {
	        System.out.println("Parameter is not an existing file");
	        return;
		}
		
		File tempFile = new File("temp.txt");
		try
		{
			  if (tempFile.createNewFile())
			  {
			    System.out.println("File created: " + tempFile.getName());
			  } 
			  else 
			  {
			    System.out.println("File already exists.");
			  }
		}
	      catch (IOException e)
		{
          System.out.println("An error occurred.");
          //e.printStackTrace();
	    }
		
		
		Scanner scanFile = new Scanner("student_data.txt");
		try 
		{	FileWriter bufferWriter = new FileWriter("temp.txt");
			while (scanFile.hasNextLine())
		      {
				if (scanFile.nextLine()!=entry) {
		        String data = scanFile.nextLine();
		        bufferWriter.write(data);
				}
		      }
			bufferWriter.close();
		}
		
		catch (IOException e)
		{
			System.out.println("An error occured");
		}
		scanFile.close();
		
		//File studentFile =new File("student_data.txt");
        File temp = new File("temp.txt");

        if(temp.renameTo(studentFile)){
            System.out.println("File renamed");
        }else{
            System.out.println("Sorry! the file can't be renamed");
        }
	}

	
	public static void main(String[] args) throws Exception
	{
		student Neelabh = new student();
		// getval(PRN, Book Id, Issue date)
		Neelabh.getval("084", "14819", "08-04-2021");
		
	}
	
}
