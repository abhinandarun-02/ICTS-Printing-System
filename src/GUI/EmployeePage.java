package GUI;
import main.Employee;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EmployeePage extends JFrame implements ActionListener {
	
    Employee user = new Employee();
    String username;
    JLabel status;
    JLabel id1;
    JTextField statusTextField;
    JButton submit1;

    JLabel req;
    JLabel id2;
    JTextField reqTextField;
    JButton submit2;

    JLabel bill;
    JLabel amount;
    JTextField amountField;
    JTextField creditsField;
    JLabel credits;
    String[] list;
    JButton submit3;

    String[] column;
    String[][] data;
    JTable table;
    JScrollPane sp;

    EmployeePage(String u) {
    	
        this.username = u;
        status = new JLabel("CHECK STATUS");
        id1 = new JLabel("REQUEST ID");
        statusTextField = new JTextField();
        submit1 = new JButton("SUBMIT");

        req = new JLabel("DELETE REQUEST");
        id2 = new JLabel("Request ID");
        reqTextField = new JTextField();
        submit2 = new JButton("SUBMIT");

        bill = new JLabel("VIEW AMOUNT/CREDITS");
        amount = new JLabel("Amount:");
        credits = new JLabel("Credits:");
        submit3 = new JButton("SUBMIT");
        amountField = new JTextField("");
        creditsField = new JTextField("");

        column = new String[]{"Print ID", "Date", "Time", "Use", "Status", "Credit"};
        data = new String[][]{};
        table = new JTable(data, column);
        sp = new JScrollPane(table);


        getContentPane().setLayout(null);

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

        bill.setBounds(200, 480, 180, 30);
        amount.setBounds(400, 510, 100, 30);
        amountField.setBounds(510, 509, 100, 30);
        credits.setBounds(400, 550, 100, 30);
        creditsField.setBounds(510, 550, 100, 30);
        submit3.setBounds(480, 600, 100, 20);


        status.setFont(new Font("Calibri", Font.BOLD, 16));
        id1.setFont(new Font("Calibri", Font.PLAIN, 16));
        req.setFont(new Font("Calibri", Font.BOLD, 16));
        id2.setFont(new Font("Calibri", Font.PLAIN, 16));
        bill.setFont(new Font("Calibri", Font.BOLD, 16));
        credits.setFont(new Font("Calibri", Font.PLAIN, 16));
        amount.setFont(new Font("Calibri", Font.PLAIN, 16));

        //Adding each component to the Container
        getContentPane().add(sp);

        getContentPane().add(status);
        getContentPane().add(id1);
        getContentPane().add(statusTextField);
        getContentPane().add(submit1);

        getContentPane().add(req);
        getContentPane().add(id2);
        getContentPane().add(reqTextField);
        getContentPane().add(submit2);

        getContentPane().add(bill);
        getContentPane().add(credits);
        getContentPane().add(amount);
        getContentPane().add(amountField);
        getContentPane().add(creditsField);
        getContentPane().add(submit3);
        submit3.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double x = user.viewAmount(username);
        double y = user.viewCredit(username);
        amountField.setText(String.valueOf(x));
        creditsField.setText(String.valueOf(y));
        
    

    }

    public static void main(String[] args) {
        new EmployeePage("/null");
    }

}