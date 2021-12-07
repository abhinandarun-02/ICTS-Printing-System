import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


class statusFrame extends JFrame implements ActionListener {

    Container container=getContentPane(); 

    JLabel id = new JLabel("Request ID");
    JTextField idTextField=new JTextField();
    JButton submit = new JButton("SUBMIT");

    JLabel status = new JLabel("Status of Print:  ");
    JTextField statusTextField=new JTextField();
    statusFrame()
    {
       //Calling methods inside constructor.
        setLayoutManager();
        setLocationAndSize();
        setFont();
        addComponentsToContainer();
        setTitle("Status");
        setBounds(450,75,600,450);
        //DefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

       id.setBounds(150,100,100,30);
       idTextField.setBounds(300,100,100,20);
       submit.setBounds(230,160,100,20);

       status.setBounds(120,260,200,30);
       statusTextField.setBounds(280,260,150,20);
       statusTextField.setEditable(false);
    }

    public void setFont()
    {
     id.setFont(new Font("Calibri", Font.PLAIN,16));
     status.setFont(new Font("Calibri", Font.PLAIN,16));
   }
   
   public void addComponentsToContainer()
   {
      //Adding each components to the Container

       container.add(id);
       container.add(idTextField);
       container.add(submit);

       container.add(status);
       container.add(statusTextField);
      
      

       TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray,3),"CHECK STATUS", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Serif", Font.PLAIN, 18));
       ((JComponent) container).setBorder(titledBorder);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "root");
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
 
public class Status {
    public static void main(String[] a){
        new statusFrame();
    }
 
}
