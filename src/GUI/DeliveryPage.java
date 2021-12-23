package GUI;
import main.DeliveryPerson;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

class DeliveryPage extends JFrame implements ActionListener {
	
    DeliveryPerson deliveryPerson;
    JPanel panel = (JPanel) getContentPane();
    JLabel status;
    JScrollPane sp;
    JLabel id;
    JTextField statusTextField;
    JButton submit;
    DefaultTableModel delivery;
	JTable deliveryTable;
	JLabel statusLabel;
    
    private JLabel pendingRequestsLabel;

    String username;

    DeliveryPage(String username) {

        this.username = username;
        //TODO
        deliveryPerson = new DeliveryPerson(username);
 
        status = new JLabel("UPDATE STATUS");
        id = new JLabel("Print ID :");
        statusTextField = new JTextField();
        submit = new JButton("Update Status");
        
        statusLabel = new JLabel("Set Status:");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        String[] options = new String[]{"Delivered", "Out for delivery", "File missing"};
        JComboBox<String> statusCB = new JComboBox<>(options);
        statusCB.setFont(new Font("Arial", Font.PLAIN, 16));
        statusCB.setBounds(810, 495, 150, 30);
        this.add(statusCB);
        submit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int opt = JOptionPane.showConfirmDialog(null, "Are You Sure?", "CONFIRM", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        		if(opt==JOptionPane.YES_OPTION)
        		{
        		int res= deliveryPerson.updateDeliveryStatus(statusTextField.getText(),statusCB.getSelectedItem().toString());
        		if(res==1)
        		{
        			JOptionPane.showMessageDialog(null, "Status updated successfully!");
					statusTextField.setText("");
        		}
        		else if(res==-1)
        		{
        			JOptionPane.showMessageDialog(null, "Print ID not found!","Invalid ID", JOptionPane.ERROR_MESSAGE);
        		}
        		}
        		
        	}
        });
    	
    	delivery = new DefaultTableModel();
		deliveryTable = new JTable(delivery);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		deliveryTable.setDefaultRenderer(String.class, centerRenderer);

		delivery.addColumn("Print ID");
		delivery.addColumn("Clerk ID");
		delivery.addColumn("User ID");
		delivery.addColumn("Name");
		delivery.addColumn("Room.No");
		delivery.addColumn("Department");
		delivery.addColumn("Phone No.");
		delivery.addColumn("Cost");
	

    	this.loadDeliveryTable();

		for (int x = 0; x < deliveryTable.getColumnCount(); x++) {
			deliveryTable.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
		}
   
		sp = new JScrollPane(deliveryTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 	
        submit.setFont(new Font("Arial", Font.PLAIN, 20));


        setLayoutManager();
        setLocationAndSize();
        setFont();
        addComponentsToContainer();

        ImageIcon image  = new ImageIcon("assets/images/Logo.jpg");
        setIconImage(image.getImage());
        setTitle("ICTS PRINTING SYSTEM");
        setBounds(150, 75, 1250, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

    }

    public void setLayoutManager() {
        panel.setLayout(null);
    }

    public void setLocationAndSize() {
        //Setting location and Size of each component using setBounds() method.
        sp.setBounds(50, 120, 1125, 250);

        status.setBounds(315, 415, 260, 42);
        id.setBounds(315, 495, 127, 30);
        statusTextField.setBounds(445, 495, 175, 30);
        statusLabel.setBounds(665, 495, 175, 30);
        submit.setBounds(448, 582, 332, 54);
    }

    public void setFont() {
        status.setFont(new Font("Calibri", Font.PLAIN, 28));
        id.setFont(new Font("SansSerif", Font.PLAIN, 24));
        statusLabel.setFont(new Font("SansSerif", Font.PLAIN, 24));
    }

    public void addComponentsToContainer() {
        //Adding each component to the Container
        panel.add(sp);

        panel.add(status);
        panel.add(id);
        panel.add(statusTextField);
        panel.add(statusLabel);
        panel.add(submit);
        
        pendingRequestsLabel = new JLabel("PENDING REQUESTS");
        pendingRequestsLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
        pendingRequestsLabel.setBounds(50, 80, 230, 30);
        getContentPane().add(pendingRequestsLabel);

        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 3), "DELIVERY QUEUE", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Serif", Font.PLAIN, 18));
        panel.setBorder(titledBorder);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] a) {
        new DeliveryPage("DEL");
    }
    
   public void loadDeliveryTable() {

		int i = 0;
	    ResultSet rs = deliveryPerson.checkDeliveryQueue();
		try {
			while (rs.next()) {
				delivery.insertRow(i, new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6),rs.getString(7), rs.getString(8)});
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    
}

