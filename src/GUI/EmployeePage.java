package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EmployeePage extends JFrame implements ActionListener {

    JLabel status;
    JLabel id1;
    JTextField statusTextField;
    JButton submit1;

    JLabel req;
    JLabel id2;
    JTextField reqTextField;
    JButton submit2;

    JLabel bill;
    JLabel month;
    String[] list;
    JScrollPane sp2;
    JButton submit3;

    String[] column;
    String[][] data;
    JTable table;
    JScrollPane sp;


    EmployeePage() {

        status = new JLabel("CHECK STATUS");
        id1 = new JLabel("Request ID");
        statusTextField = new JTextField();
        submit1 = new JButton("SUBMIT");

        req = new JLabel("DELETE REQUEST");
        id2 = new JLabel("Request ID");
        reqTextField = new JTextField();
        submit2 = new JButton("SUBMIT");

        bill = new JLabel("VIEW MONTHLY BILL");
        month = new JLabel("Month");
        list = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        JList<String> select = new JList<>(list);
        sp2 = new JScrollPane(select);
        submit3 = new JButton("SUBMIT");

        column = new String[]{"Print ID", "Date", "Time", "Use", "Status", "Credit"};
        data = new String[][]{};
        table = new JTable(data, column);
        sp = new JScrollPane(table);


        setLayout(null);

        setTitle("Employee Login");
        setBounds(150, 75, 1015, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

        sp.setBounds(200, 100, 700, 100);

        status.setBounds(200, 220, 100, 30);
        id1.setBounds(400, 260, 100, 30);
        statusTextField.setBounds(550, 260, 100, 20);
        submit1.setBounds(480, 300, 100, 20);

        req.setBounds(200, 350, 150, 30);
        id2.setBounds(400, 390, 100, 30);
        reqTextField.setBounds(550, 390, 100, 20);
        submit2.setBounds(480, 430, 100, 20);

        bill.setBounds(200, 480, 150, 30);
        month.setBounds(400, 510, 100, 30);
        sp2.setBounds(550, 510, 100, 25);
        submit3.setBounds(480, 560, 100, 20);


        status.setFont(new Font("Calibri", Font.BOLD, 16));
        id1.setFont(new Font("Calibri", Font.PLAIN, 16));
        req.setFont(new Font("Calibri", Font.BOLD, 16));
        id2.setFont(new Font("Calibri", Font.PLAIN, 16));
        bill.setFont(new Font("Calibri", Font.BOLD, 16));
        month.setFont(new Font("Calibri", Font.PLAIN, 16));

        //Adding each component to the Container
        this.add(sp);

        this.add(status);
        this.add(id1);
        this.add(statusTextField);
        this.add(submit1);

        this.add(req);
        this.add(id2);
        this.add(reqTextField);
        this.add(submit2);

        this.add(bill);
        this.add(month);
        this.add(sp2);
        this.add(submit3);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new EmployeePage();
    }

}