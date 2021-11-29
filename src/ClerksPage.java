import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ClerksPage extends JFrame {

    /* *************** REQUEST_PANEL *************** */
   
    JPanel ClerkPanel;
    JLabel pendingRequestsLabel;
    JLabel printerDetailsLabel;
    JLabel resourceDetailsLabel;
    JButton notifyButton; 
    JLabel printerQueueLabel;
    JButton AddButton; 
    JButton DeleteButton; 
    JButton NextButton;

    public ClerksPage(String title) {

        super(title); //Frame title

        /* ****************************** REQUEST_PANEL_SECTION ****************************** */
        ClerkPanel = new JPanel();
        pendingRequestsLabel = new JLabel("Pending requests ");
        printerDetailsLabel = new JLabel("Printer details ");
        resourceDetailsLabel = new JLabel("Resource details ");
        notifyButton = new JButton("Notify Admin");
        printerQueueLabel = new JLabel("Printer queue ");
        AddButton = new JButton("Add record");
        DeleteButton = new JButton("Delete record");
        NextButton = new JButton("Next page");
        NextButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e)
        	{
        		new ClerksPage2("Clerk's UI/2");
        		dispose();
        	}
        });
        String[][] data1={ {"..","..","..","..","..","..",".."},{"..","..","..","..","..","..",".."}};    
        String[] column1={"User ID","Name","Print ID","Use","Date","Time","Accept/Reject"};         
        JTable pendingRequests=new JTable(data1, column1);  
        JScrollPane sp1 = new JScrollPane(pendingRequests , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        String[][] data2={ {"..","..",".."},{"..","..",".."}};    
        String[] column2={"Available","Currently Working","Out of Order"};         
        JTable printerDetails=new JTable(data2, column2);  
        JScrollPane sp2 = new JScrollPane(printerDetails , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        String[][] data3={ {"..","..","..","..",".."},{"..","..","..","..",".."}};    
        String[] column3={"A3","A4","A5","Colour cartridge","Black cartridge"};         
        JTable resourceDetails=new JTable(data3, column3);  
        JScrollPane sp3 = new JScrollPane(resourceDetails, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        String[][] data4={ {"..","..","..","..","..","..","..",".."},{"..","..","..","..","..","..","..",".."}};    
        String[] column4={"Print ID","User ID","Paper size","Print Type","Single/Double side","No. of pages","Printer#"};         
        JTable printerQueue=new JTable(data4, column4);  
        JScrollPane sp4 = new JScrollPane(printerQueue,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      


        ClerkPanel.add(pendingRequestsLabel);
        ClerkPanel.add(sp1);
        ClerkPanel.add(printerDetailsLabel);
        ClerkPanel.add(sp2);
        ClerkPanel.add(resourceDetailsLabel);
        ClerkPanel.add(sp3);
        ClerkPanel.add(notifyButton);
        ClerkPanel.add(printerQueueLabel);
        ClerkPanel.add(sp4);
        ClerkPanel.add(AddButton);
        ClerkPanel.add(DeleteButton);
        ClerkPanel.add(NextButton);
        
        pendingRequestsLabel.setBounds(80, 80, 200, 30);
        sp1.setBounds(80,120,800,80);
        printerDetailsLabel.setBounds(80, 200, 200, 30);
        sp2.setBounds(80,240,400,80);
        resourceDetailsLabel.setBounds(80, 320, 200, 30);
        sp3.setBounds(80,360,600,80);
        notifyButton.setBounds(760, 360, 120, 30);
        printerQueueLabel.setBounds(80,450 , 200, 30);
        sp4.setBounds(80,490,800,80);
        AddButton.setBounds(350, 600, 120, 30);
        DeleteButton.setBounds(500, 600, 120, 30);
        NextButton.setBounds(430,690 , 120, 30);
        
       
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
        new ClerksPage("Clerk's UI/1");
    }
}