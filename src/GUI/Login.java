package GUI;

import main.Person;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class LoginFrame extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");

    Person user = new Person();

    LoginFrame() {
        //Calling methods inside constructor.
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        setTitle("Login Form");
        setVisible(true);
        setBounds(450, 75, 600, 500);
        //  setDefaultCloseOperation();
        setResizable(false);


        userTextField.setFont(new Font("Arial ", Font.PLAIN, 15));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public void setLayoutManager() {
        container.setLayout(null);

        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    public void setLocationAndSize() {
        //Setting location and Size of each components using setBounds() method.
        userLabel.setBounds(150, 150, 100, 30);
        passwordLabel.setBounds(150, 220, 100, 30);
        userTextField.setBounds(250, 150, 150, 30);
        passwordField.setBounds(250, 220, 150, 30);
        showPassword.setBounds(250, 250, 150, 30);
        loginButton.setBounds(150, 350, 100, 30);
        resetButton.setBounds(320, 350, 100, 30);

        // title.setFont(new Font("Serif", Font.PLAIN, 18));

    }

    public void addComponentsToContainer() {
        //Adding each components to the Container
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);


        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 3), "ICTS PRINTING SYSTEM", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Serif", Font.PLAIN, 18));
        ((JComponent) container).setBorder(titledBorder);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("LOGIN")) {
            String username = userTextField.getText();
            String password = passwordField.getText();

            if (user.verifyUser(username, password)) {
                if (username.startsWith("ADM")) {
                    new AdminPage();
                }
                else if (username.startsWith("CLK")) {
                    new ClerksPage();
                }
                else if (username.startsWith("EMP")) {
                    new EmployeePage();
                }
                else if (username.startsWith("DEL")) {
                    new DeliveryPage();
                }
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(loginButton, "Invalid Credentials", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getActionCommand().equals("Show Password")) {
            JCheckBox c = (JCheckBox) e.getSource();
            passwordField.setEchoChar(c.isSelected() ? '\u0000' : (Character) UIManager.get("PasswordField.echoChar"));
        }

        if (e.getActionCommand().equals("RESET")) {
            userTextField.setText(null);
            passwordField.setText(null);
        }
    }
}


public class Login {
    public static void main(String[] a) {
        new LoginFrame();


    }

}