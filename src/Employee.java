import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EmpFrame extends JFrame implements ActionListener {

    Container container=getContentPane(); 

    JLabel status = new JLabel("CHECK STATUS");
    JLabel id1 = new JLabel("Request ID");
    JTextField statusTextField=new JTextField();
    JButton submit1 = new JButton("SUBMIT");

    JLabel req = new JLabel("DELETE REQUEST");
    JLabel id2 = new JLabel("Request ID");
    JTextField reqTextField=new JTextField();
    JButton submit2 = new JButton("SUBMIT");

    JLabel bill = new JLabel("VIEW MONTHLY BILL");
    JLabel month = new JLabel("Month");
    String[] list = {"January","February","March","April","May","June","July","August","September","October","November","Decemeber"};
    JList<String> select = new JList<String>(list);
    JScrollPane sp2 = new JScrollPane(select);
    JButton submit3 = new JButton("SUBMIT");

    String[] column = { "Print ID", "Date", "Time", "Use", "Status", "Bill Payment" }; 
    String[][] data = {{ "", "", "", "", "", "" }, { "", "", "", "", "", "" }};
    JTable table = new JTable(data, column);
    JScrollPane sp = new JScrollPane(table);


    EmpFrame()
    {
       //Calling methods inside constructor.
        setLayoutManager();
        setLocationAndSize();
        setFont();
        addComponentsToContainer();
 
    }
   public void setLayoutManager()
   {
       container.setLayout(null);
   }
   public void setLocationAndSize()
   {
       //Setting location and Size of each components using setBounds() method.
       sp.setBounds(200,100,700,50);

       status.setBounds(200,220,100,30);
       id1.setBounds(400,260,100,30);
       statusTextField.setBounds(550,260,100,20);
       submit1.setBounds(480,300,100,20);

       req.setBounds(200,350,150,30);
       id2.setBounds(400,390,100,30);
       reqTextField.setBounds(550,390,100,20);
       submit2.setBounds(480,430,100,20);

       bill.setBounds(200,480,150,30);
       month.setBounds(400,510,100,30);
       sp2.setBounds(550,510,100,25);
       submit3.setBounds(480,560,100,20);
   }

   public void setFont()
   {
       
    status.setFont(new Font("Calibri", Font.BOLD, 16));
    id1.setFont(new Font("Calibri", Font.PLAIN,16));
    req.setFont(new Font("Calibri", Font.BOLD, 16));
    id2.setFont(new Font("Calibri", Font.PLAIN,16));
    bill.setFont(new Font("Calibri", Font.BOLD, 16));
    month.setFont(new Font("Calibri", Font.PLAIN,16));
   }
   
   public void addComponentsToContainer()
   {
      //Adding each components to the Container
       container.add(sp);

       container.add(status);
       container.add(id1);
       container.add(statusTextField);
       container.add(submit1);

       container.add(req);
       container.add(id2);
       container.add(reqTextField);
       container.add(submit2);

       container.add(bill);
       container.add(month);
       container.add(sp2);
       container.add(submit3);

       TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray,3),"View Request / Print History", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Serif", Font.PLAIN, 18));
       ((JComponent) container).setBorder(titledBorder);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
 
    }
}
 
public class Employee {
    public static void main(String[] a){
        EmpFrame frame=new EmpFrame();
        frame.setTitle("Employee Login");
        frame.setBounds(150,75,1015,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
 
    }
 
}