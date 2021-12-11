package GUI;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Payment extends JFrame implements ActionListener {

    JPanel panel = (JPanel) getContentPane();

    JLabel bill;
    JLabel id;
    JTextField billTextField;

    JLabel month;
    String[] list;
    JList<String> select;
    JScrollPane sp;
    JButton submit;

    JLabel amount;
    JTextField amountTextField;

    JLabel note;

    Payment() {

        bill = new JLabel("View Monthly bill");
        id = new JLabel("Employee ID");
        billTextField = new JTextField();
        month = new JLabel("Month");
        list = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        select = new JList<>(list);
        sp = new JScrollPane(select);
        submit = new JButton("SUBMIT");
        amount = new JLabel("Amount for the given month");
        amountTextField = new JTextField();
        note = new JLabel("Please Login to view full payment history");

        //Calling methods inside constructor.
        setLayoutManager();
        setLocationAndSize();
        setFont();
        addComponentsToContainer();

        setTitle("Payment");
        setBounds(450, 75, 800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    public void setLayoutManager() {
        panel.setLayout(null);
    }

    public void setLocationAndSize() {
        //Setting location and Size of each component using setBounds() method.

        bill.setBounds(100, 100, 300, 30);
        id.setBounds(250, 150, 100, 30);
        billTextField.setBounds(400, 150, 100, 20);

        month.setBounds(250, 200, 100, 30);
        sp.setBounds(400, 200, 100, 25);
        submit.setBounds(300, 270, 100, 20);

        amount.setBounds(170, 360, 200, 30);
        amountTextField.setBounds(420, 360, 150, 20);
        amountTextField.setEditable(false);

        note.setBounds(240, 410, 300, 30);
    }

    public void setFont() {
        bill.setFont(new Font("Calibri", Font.BOLD, 16));
        id.setFont(new Font("Calibri", Font.PLAIN, 16));
        month.setFont(new Font("Calibri", Font.PLAIN, 16));
        amount.setFont(new Font("Calibri", Font.PLAIN, 16));
    }

    public void addComponentsToContainer() {
        //Adding each component to the Container

        panel.add(bill);
        panel.add(id);
        panel.add(billTextField);
        panel.add(bill);
        panel.add(month);
        panel.add(sp);
        panel.add(submit);
        panel.add(amount);
        panel.add(amountTextField);
        panel.add(note);

        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 3), "PAYMENT PORTAL", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Serif", Font.PLAIN, 18));
        panel.setBorder(titledBorder);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] a) {
        new Payment();
    }
}


