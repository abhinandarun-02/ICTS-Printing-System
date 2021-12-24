package GUI;

import main.Employee;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

class EmployeePage extends JFrame implements ActionListener {

	Employee employee = new Employee();
	Container container;

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
	DefaultTableModel historyModel;
	JTable table;
	JScrollPane sp;

	EmployeePage(String username) {

		setContentPane(new JLabel(new ImageIcon("assets/images/bg.jpg")));
		ImageIcon image  = new ImageIcon("assets/images/Logo.jpg");
        setIconImage(image.getImage());
        setTitle("ICTS PRINTING SYSTEM");

		this.username = username;
		container = getContentPane();
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

		historyModel = new DefaultTableModel();
		column = new String[] { "Print ID", "Date", "Time", "Use", "Status", "Credit" };
		for (String x: column) historyModel.addColumn(x);
		table = new JTable(historyModel);
		sp = new JScrollPane(table);

		loadHistoryTable();

		container.setLayout(null);

        
		setBounds(270, 75, 1015, 700);
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

		// Adding each component to the Container
		container.add(sp);

		container.add(status);
		container.add(id1);
		container.add(statusTextField);
		container.add(submit1);

		container.add(req);
		container.add(id2);
		container.add(reqTextField);
		container.add(submit2);

		container.add(bill);
		container.add(credits);
		container.add(amount);
		container.add(amountField);
		container.add(creditsField);
		container.add(submit3);
		submit3.addActionListener(this);
		submit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ans = reqTextField.getText();
				int opt = JOptionPane.showConfirmDialog(null, "Are You Sure?", "CONFIRM", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (opt == JOptionPane.YES_OPTION) {
					int res = employee.deleteRequest(EmployeePage.this.username, ans);
					if (res == 1)
						{JOptionPane.showMessageDialog(null, "Request deleted. Deletion successful");
						 reqTextField.setText("");
						}
					else if (res == 0)
						JOptionPane.showMessageDialog(null, "Print already in queue", "Deletion period exceeded",
								JOptionPane.WARNING_MESSAGE);
					else if (res == 2)
						JOptionPane.showMessageDialog(null, "Request ID does not correspond to your Employee ID",
								"Invalid request", JOptionPane.ERROR_MESSAGE);
					else if(res==-1)
						JOptionPane.showMessageDialog(null, "Record not found ", "Error", JOptionPane.ERROR_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "Deletion failed", "Error!!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double x = employee.viewAmount(username);
		double y = employee.viewCredit(username);
		amountField.setText(String.valueOf(x));
		creditsField.setText(String.valueOf(y));

	}

	public void loadHistoryTable() {
		int i = 0;
		ResultSet rs = employee.viewPrintHistory();
		try {
			while (rs.next()) {
				historyModel.insertRow(i, new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)});
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new EmployeePage("abhinand_02");
	}

}