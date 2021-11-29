import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ClerksPage2 extends JFrame {

    /* *************** REQUEST_PANEL *************** */
   
    JPanel ClerkPanel;
    JLabel deliveryQueueLabel;
    JButton AddButton2; 
    JButton DeleteButton2;
    JTable deliveryQueue;
    JLabel generateBillLabel;
    JLabel printIdLabel;
    JLabel userIdLabel;
    JLabel costPerPageLabel;
    JLabel totalNoPagesLabel;
    JTextField printId;
    JTextField userId;
    JTextField costPerPage;
    JTextField totalNoPages;
    JButton GenerateButton; 
    JButton PrevButton;

    public ClerksPage2(String title) {

        super(title); //Frame title

        /* ****************************** REQUEST_PANEL_SECTION ****************************** */
        ClerkPanel = new JPanel();
        deliveryQueueLabel = new JLabel("Delivery queue ");
        AddButton2 = new JButton("Add record");
        DeleteButton2 = new JButton("Delete record");
        generateBillLabel = new JLabel("Generate bill ");
        printIdLabel = new JLabel("Print ID: ");
        userIdLabel = new JLabel("User ID: ");
        costPerPageLabel = new JLabel("Cost per page: ");
        totalNoPagesLabel = new JLabel("Total no. of pages: ");
        printId = new JTextField();
        userId = new JTextField();
        costPerPage = new JTextField();
        totalNoPages = new JTextField();
        GenerateButton = new JButton("Generate Bill");
        PrevButton = new JButton("Previous page");
        PrevButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e)
        	{
        		new ClerksPage("Clerk's UI/1");
        		dispose();
        	}
        });
        
        String[][] data5={ {"..","..","..","..","..","..",},{"..","..","..","..","..",".."}};    
        String[] column5={"Print ID","User ID","Name","Room no.","Phone no.","Status"};         
        JTable deliveryQueue=new JTable(data5, column5);  
        JScrollPane sp5 = new JScrollPane(deliveryQueue,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            
 
        ClerkPanel.add(deliveryQueueLabel);
        ClerkPanel.add(sp5);
        ClerkPanel.add(AddButton2);
        ClerkPanel.add(DeleteButton2);
        ClerkPanel.add(generateBillLabel);
        ClerkPanel.add(printIdLabel);
        ClerkPanel.add(userIdLabel);
        ClerkPanel.add(costPerPageLabel);
        ClerkPanel.add(totalNoPagesLabel);
        ClerkPanel.add(printId);
        ClerkPanel.add(userId);
        ClerkPanel.add(costPerPage);
        ClerkPanel.add(totalNoPages);
        ClerkPanel.add(GenerateButton);
        ClerkPanel.add(PrevButton);
       
        deliveryQueueLabel.setBounds(80, 80, 200, 30);
        sp5.setBounds(80,120,800,100);
        AddButton2.setBounds(300,240 , 120, 30);
        DeleteButton2.setBounds(480, 240, 120, 30);
        generateBillLabel.setBounds(80,320,200,30);
        printIdLabel.setBounds(300,330,200,30);
        userIdLabel.setBounds(300,370,200,30);
        costPerPageLabel.setBounds(300,410,200,30);
        totalNoPagesLabel.setBounds(300,450,200,30);
        printId.setBounds(440,330,200,30);
        userId.setBounds(440,370,200,30);
        costPerPage.setBounds(440,410,200,30);
        totalNoPages.setBounds(440,450,200,30);
        GenerateButton.setBounds(410,510 , 120, 30);
        PrevButton.setBounds(410,590 , 120, 30);
       
        ClerkPanel.setBounds(40,20,920,750);
        ClerkPanel.setLayout(null);
        
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray,3),"Clerk's Page", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Ariel", Font.PLAIN, 24));
        ClerkPanel.setBorder(titledBorder);
        /* *************************************************************************** */





        /* ****************************** FRAME_CONFIGURATION ****************************** */
        
        setBounds(150, 75, 1015, 850);
        setLayout(null); 
        add(ClerkPanel);
        setVisible(true);
        setResizable(false); //Disable frame resizing 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        /* *************************************************************************** */


    }

    public static void main(String[] args) {
        new ClerksPage2("Clerk's UI/1");
    }

	
	}