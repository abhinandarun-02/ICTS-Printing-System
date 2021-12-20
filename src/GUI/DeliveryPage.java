package GUI;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

class DeliveryPage extends JFrame implements ActionListener {

    JPanel panel = (JPanel) getContentPane();

    String[] column;
    String[][] data;
    JTable table;
    JScrollPane sp;

    JLabel status;
    JLabel id;
    JTextField statusTextField;
    JButton submit;
    private JLabel pendingRequestsLabel;

    DeliveryPage() {
        column = new String[]{"Print ID", "User ID", "Name", "Room no", "Phone no", "Bill Status"};
        data = new String[][]{};
        table = new JTable(data, column);
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Print ID", "User ID", "Name", "Room no", "Phone no", "Status"
        	}
        ));
        sp = new JScrollPane(table);
        status = new JLabel("UPDATE STATUS");
        id = new JLabel("Print ID :");
        statusTextField = new JTextField();
        submit = new JButton("Update Status to DELIVERED");
        submit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
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
        id.setBounds(448, 495, 127, 30);
        statusTextField.setBounds(605, 495, 175, 30);
        submit.setBounds(448, 582, 332, 54);
    }

    public void setFont() {
        status.setFont(new Font("Calibri", Font.PLAIN, 28));
        id.setFont(new Font("SansSerif", Font.PLAIN, 24));
    }

    public void addComponentsToContainer() {
        //Adding each component to the Container
        panel.add(sp);

        panel.add(status);
        panel.add(id);
        panel.add(statusTextField);
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
        new DeliveryPage();
    }
}

