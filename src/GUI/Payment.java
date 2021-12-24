package GUI;

import main.Employee;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Payment extends JFrame {

    Employee user = new Employee();

    Container container;
    JLabel bill;
    JLabel id;
    JTextField billTextField;

    JButton submit;

    JLabel amount;
    JLabel credit;
    JTextField amountTextField;
    JTextField creditTextField;

    JLabel note;

    Payment() {

        setContentPane(new JLabel(new ImageIcon("assets/images/background.jpg")));
        ImageIcon image = new ImageIcon("assets/images/Logo.jpg");
        setIconImage(image.getImage());
        setTitle("ICTS PRINTING SYSTEM");

        container = getContentPane();
        // getContentPane().setBackground(Color.BLUE);

        bill = new JLabel("VIEW BILL");
        id = new JLabel("Employee ID");
        billTextField = new JTextField();

        submit = new JButton("SUBMIT");
        amount = new JLabel("Amount :");
        credit = new JLabel("Credits left :");
        amountTextField = new JTextField();
        creditTextField = new JTextField();
        note = new JLabel("Please Login to view more details");

        // Calling methods inside constructor.
        setLayoutManager();
        setLocationAndSize();
        setFont();
        addComponentsToContainer();
        setBounds(450, 75, 650, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        // Setting location and Size of each component using setBounds() method.

        bill.setBounds(120, 80, 300, 30);
        id.setBounds(230, 150, 100, 30);
        billTextField.setBounds(380, 150, 100, 20);

        submit.setBounds(290, 230, 100, 20);

        amount.setBounds(150, 330, 200, 30);
        credit.setBounds(150, 370, 200, 30);
        amountTextField.setBounds(400, 330, 150, 20);
        amountTextField.setEditable(false);
        creditTextField.setBounds(400, 370, 150, 20);
        creditTextField.setEditable(false);

        note.setBounds(240, 440, 300, 30);
    }

    public void setFont() {
        bill.setFont(new Font("Calibri", Font.BOLD, 20));
        id.setFont(new Font("Calibri", Font.BOLD, 16));

        amount.setFont(new Font("Calibri", Font.BOLD, 16));
        credit.setFont(new Font("Calibri", Font.BOLD, 16));

    }

    public void addComponentsToContainer() {
        // Adding each component to the Container

        container.add(bill);
        container.add(id);
        container.add(billTextField);
        container.add(bill);
        container.add(submit);
        container.add(amount);
        container.add(credit);
        container.add(amountTextField);
        container.add(creditTextField);
        container.add(note);

        /*
         * TitledBorder titledBorder =
         * BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray,
         * 3), "PAYMENT PORTAL", TitledBorder.CENTER, TitledBorder.CENTER, new
         * Font("Serif", Font.PLAIN, 18));
         * container.setBorder(titledBorder);
         */

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String e_id = billTextField.getText();
                double x = user.viewAmount(e_id);
                double y = user.viewCredit(e_id);
                if (x == -1) {
                    amountTextField.setText("null");
                    creditTextField.setText("null");
                    JOptionPane.showMessageDialog(submit, "Employee ID not found", "INVALID ID",
                            JOptionPane.ERROR_MESSAGE, null);
                } else {
                    amountTextField.setText(String.valueOf(x));
                    creditTextField.setText(String.valueOf(y));
                }
            }
        });

    }

    public static void main(String[] a) {
        new Payment();
    }
}
