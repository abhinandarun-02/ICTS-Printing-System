import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DeliFrame extends JFrame implements ActionListener {

    Container container=getContentPane(); 

    String[] column = { "Print ID", "User ID", "Name", "Room no", "Phone no", "Bill Status" }; 
    String[][] data = {{ "", "", "", "", "", "" }, { "", "", "", "", "", "" }};
    JTable table = new JTable(data, column);
    JScrollPane sp = new JScrollPane(table);

    JLabel status = new JLabel("UPDATE STATUS");
    JLabel id = new JLabel("Print ID");
    JTextField statusTextField=new JTextField();
    JButton submit = new JButton("Update status to DELIVERED");

    DeliFrame()
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
       sp.setBounds(50,120,700,50);

       status.setBounds(100,220,150,30);
       id.setBounds(300,260,100,30);
       statusTextField.setBounds(450,260,100,20);
       submit.setBounds(300,330,200,20);
   }
   public void setFont()
   {
    status.setFont(new Font("Calibri", Font.BOLD, 16));
    id.setFont(new Font("Calibri", Font.PLAIN,16));
    }
   
  public void addComponentsToContainer()
   {
     //Adding each components to the Container
    container.add(sp);

    container.add(status);
    container.add(id);
    container.add(statusTextField);
    container.add(submit);

    TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray,3),"DELIVERY QUEUE", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Serif", Font.PLAIN, 18));
    ((JComponent) container).setBorder(titledBorder);
}
 
@Override
public void actionPerformed(ActionEvent e) {

}
}

public class Delivery {
public static void main(String[] a){
    DeliFrame frame=new DeliFrame();
    frame.setTitle("Delivery boy Login");
    frame.setBounds(150,75,800,500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setResizable(false);

}

}