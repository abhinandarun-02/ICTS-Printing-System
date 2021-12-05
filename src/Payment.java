import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PayFrame extends JFrame implements ActionListener {

    Container container=getContentPane(); 

    JLabel bill = new JLabel("View Monthly bill");
    JLabel id = new JLabel("Employee ID");
    JTextField billTextField=new JTextField();

    JLabel month = new JLabel("Month");
    String[] list = {"January","February","March","April","May","June","July","August","September","October","November","Decemeber"};
    JList<String> select = new JList<String>(list);
    JScrollPane sp = new JScrollPane(select);
    JButton submit = new JButton("SUBMIT");

    JLabel amount = new JLabel("Amount for the given month");
    JTextField amountTextField=new JTextField();

    
    JLabel note = new JLabel("Please Login to view full payment history"); 

    PayFrame()
    {
       //Calling methods inside constructor.
        setLayoutManager();
        setLocationAndSize();
        setFont();
        addComponentsToContainer();
        setTitle("Payment");
        setBounds(450,75,800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
 
    }
   public void setLayoutManager()
   {
       container.setLayout(null);
   }
   public void setLocationAndSize()
   {
       //Setting location and Size of each components using setBounds() method.

       bill.setBounds(100,100,300,30);
       id.setBounds(250,150,100,30);
       billTextField.setBounds(400,150,100,20);

       month.setBounds(250,200,100,30);
       sp.setBounds(400,200,100,25);
       submit.setBounds(300,270,100,20);

       amount.setBounds(170,360,200,30);
       amountTextField.setBounds(420,360,150,20);

       note.setBounds(240,410,300,30);
    }

    public void setFont()
    {
     bill.setFont(new Font("Calibri", Font.BOLD, 16));
     id.setFont(new Font("Calibri", Font.PLAIN,16));
     month.setFont(new Font("Calibri", Font.PLAIN,16));
     amount.setFont(new Font("Calibri", Font.PLAIN,16));
   }
   
   public void addComponentsToContainer()
   {
      //Adding each components to the Container

       container.add(bill);
       container.add(id);
       container.add(billTextField);
       container.add(bill);
       container.add(month);
       container.add(sp);
       container.add(submit);
       container.add(amount);
       container.add(amountTextField);
       container.add(note);

       TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray,3),"PAYMENT PORTAL", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Serif", Font.PLAIN, 18));
       ((JComponent) container).setBorder(titledBorder);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
 
public class Payment {
    public static void main(String[] a){
        new PayFrame();
    }
 
}