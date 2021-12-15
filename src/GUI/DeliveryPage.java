package GUI;

import javax.swing.BorderFactory;
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

    DeliveryPage() {
        column = new String[]{"Print ID", "User ID", "Name", "Room no", "Phone no", "Bill Status"};
        data = new String[][]{};
        table = new JTable(data, column);
        sp = new JScrollPane(table);
        status = new JLabel("UPDATE STATUS");
        id = new JLabel("Print ID");
        statusTextField = new JTextField();
        submit = new JButton("Update status to DELIVERED");


        setLayoutManager();
        setLocationAndSize();
        setFont();
        addComponentsToContainer();

        setTitle("Delivery boy Login");
        setBounds(150, 75, 800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

    }

    public void setLayoutManager() {
        panel.setLayout(null);
    }

    public void setLocationAndSize() {
        //Setting location and Size of each component using setBounds() method.
        sp.setBounds(50, 120, 700, 50);

        status.setBounds(100, 220, 150, 30);
        id.setBounds(300, 260, 100, 30);
        statusTextField.setBounds(450, 260, 100, 20);
        submit.setBounds(300, 330, 200, 20);
    }

    public void setFont() {
        status.setFont(new Font("Calibri", Font.BOLD, 16));
        id.setFont(new Font("Calibri", Font.PLAIN, 16));
    }

    public void addComponentsToContainer() {
        //Adding each component to the Container
        panel.add(sp);

        panel.add(status);
        panel.add(id);
        panel.add(statusTextField);
        panel.add(submit);

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

