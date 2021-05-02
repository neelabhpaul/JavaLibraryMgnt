import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class frontPage extends student{

	public static void main(String[] args) throws Exception { 
		
		JFrame frame = new JFrame("Biblioteca");
        // Setting the width and height of frame
        frame.setSize(865, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(); 
        
        // adding panel to frame
        frame.add(panel);
        Font titleFont = new Font("Harlow Solid Italic", Font.PLAIN, 40);
        Font titleFont1 = new Font("Courier", Font.PLAIN, 10);
        
        JPanel heading = new JPanel();
        heading.setBackground(new Color(0,0,0,80));
        heading.setBounds(0,0,852,100);
        
        JLabel name1 = new JLabel("biblioteca");
        name1.setForeground(Color.YELLOW);
        name1.setBounds(5,0,100,40);
        name1.setFont(titleFont1);
        heading.add(name1);
        
        JLabel name = new JLabel("The Library");
        name.setForeground(Color.ORANGE);
        name.setBounds(335,25,300,50);
        name.setFont(titleFont);
        heading.add(name);
        //frame.add(heading);
        
        javax.swing.ImageIcon background_image = new javax.swing.ImageIcon("biblioteca_Backdrop.gif");
        
        Image img = background_image.getImage();
        background_image = new javax.swing.ImageIcon(img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 1376, 720);
        
        background.add(heading);
        background.add(panel);
        //frame.add(panel);
        frame.add(background);
        
        
        placeComponents(panel, heading, background);

        // Setting the frame visibility to true
        frame.setVisible(true);
        
    }
	
	private static void placeComponents(JPanel libraryInterface, JPanel heading, JLabel background) {

		heading.setLayout(null);
		libraryInterface.setLayout(null);
		background.setLayout(null);
        
		//heading.setBackground(new Color(187,178,233));
		Font Segoe = new Font("Segoe UI", Font.BOLD, 16);
		Font Arial = new Font("Arial", Font.BOLD, 12);
		
        libraryInterface.setSize(852, 480);
        libraryInterface.setBounds(0,0,852,480);
        libraryInterface.setBackground(new Color(0,0,0,200));
        libraryInterface.setBounds(0, 0, 850, 478);
        
        
        // Student book issue
        JLabel studentLabel = new JLabel("Student Id");
        studentLabel.setForeground(Color.ORANGE);
        studentLabel.setFont(Segoe);
        studentLabel.setBounds(506,110,80,25);
        libraryInterface.add(studentLabel);

        JTextField studentID = new JTextField(20);
        studentID.setBounds(596,110,165,25);
        libraryInterface.add(studentID);


        JLabel bookLabel = new JLabel("Book Id");
        bookLabel.setForeground(Color.ORANGE);
        bookLabel.setFont(Segoe);
        bookLabel.setBounds(506,140,80,25);
        libraryInterface.add(bookLabel);

        JTextField bookID = new JTextField(20);
        bookID.setBounds(596,140,165,25);
        libraryInterface.add(bookID);

        JButton confirmButton = new JButton("Issue Book");
        confirmButton.setForeground(Color.BLUE);
        confirmButton.setFont(Arial);
        confirmButton.setBounds(640, 170, 120, 25);
        libraryInterface.add(confirmButton);
        
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
        	boolean bookAvailable;
            public void actionPerformed(java.awt.event.ActionEvent evt){
            	try {
					bookAvailable = student.getval(studentID.getText(), bookID.getText(), "30-05-3005");
				} catch (Exception e) {
					e.printStackTrace();
				}
            	if (bookAvailable==true){
                JOptionPane.showMessageDialog(libraryInterface,
                		 "Book has been issued\n"+"Submit before: "+student.dueDate );}
            	else {
            		JOptionPane.showMessageDialog(libraryInterface,
                   		 "Requested book not available");
            	}
            	
            }
        });
        //----------------------------------------------
        
        // Student book submission
        JLabel studentLabelsub = new JLabel("Student Id");
        studentLabelsub.setForeground(Color.ORANGE);
        studentLabelsub.setFont(Segoe);
        studentLabelsub.setBounds(506,300,80,25);
        libraryInterface.add(studentLabelsub);

        JTextField studentIDsub = new JTextField(20);
        studentIDsub.setBounds(596,300,165,25);
        libraryInterface.add(studentIDsub);

        JButton confirmButton_sub = new JButton("Submit Book");
        confirmButton_sub.setForeground(Color.BLUE);
        confirmButton_sub.setFont(Arial);
        confirmButton_sub.setBounds(640, 330, 120, 25);
        libraryInterface.add(confirmButton_sub);
        
        confirmButton_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
            	try {
					student.submit(studentIDsub.getText());
				} catch (Exception e) {
					e.printStackTrace();
				}
                JOptionPane.showMessageDialog(libraryInterface,
                		 "Submission successful");
            }
        });
        
        
        //--------------------------------------------------
        
        // Librarian control
        JLabel bookInventoryLabel = new JLabel("Book Id");
        bookInventoryLabel.setForeground(Color.ORANGE);
        bookInventoryLabel.setFont(Segoe);
        bookInventoryLabel.setBounds(75,180,80,25);
        libraryInterface.add(bookInventoryLabel);

        JTextField bookInventoryID = new JTextField(20);
        bookInventoryID.setBounds(170,180,165,25);
        libraryInterface.add(bookInventoryID);


        JLabel bookInventoryName = new JLabel("Book Name");
        bookInventoryName.setForeground(Color.ORANGE);
        bookInventoryName.setFont(Segoe);
        bookInventoryName.setBounds(75,210,100,25);
        libraryInterface.add(bookInventoryName);

        JTextField bookInventoryNameEntry = new JTextField(20);
        bookInventoryNameEntry.setBounds(170,210,165,25);
        libraryInterface.add(bookInventoryNameEntry);

        JButton addBook = new JButton("Add Book");
        addBook.setForeground(Color.BLUE);
        addBook.setFont(Arial);
        addBook.setBounds(214, 240, 120, 25);
        libraryInterface.add(addBook);
        
        addBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
            	try {
					bookRecord.addBook(bookInventoryID.getText(), bookInventoryNameEntry.getText());
				} catch (Exception e) {
					e.printStackTrace();
				}
                JOptionPane.showMessageDialog(libraryInterface,
                		 "Book added successfully");
            }
        });
        
        // Display available books
        JButton showBook = new JButton("Show Library");
        showBook.setBackground(Color.ORANGE);
        showBook.setForeground(Color.DARK_GRAY);
        showBook.setFont(Arial);
        showBook.setBounds(50, 370, 120, 45);
        libraryInterface.add(showBook);
        
        showBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 JOptionPane.showMessageDialog(libraryInterface,
                		 bookRecord.showBooks());
            }
        });
  
        // Display student record
        JButton studentRec = new JButton("Student Record");
        studentRec.setBackground(Color.ORANGE);
        studentRec.setForeground(Color.DARK_GRAY);
        studentRec.setFont(Arial);
        studentRec.setBounds(214, 370, 140, 45);
        libraryInterface.add(studentRec);
        
        studentRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 JOptionPane.showMessageDialog(libraryInterface,
                		 student.show());
            }
        });
    	
 
    	
    }
	
}
	


















