package GUI;

import main.User;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class LoginPage extends JFrame implements ActionListener {

    Container container;
    JLabel userLabel;
    JLabel passwordLabel;
    JTextField userTextField;
    JPasswordField passwordField;
    JButton loginButton;
    JButton resetButton;
    JCheckBox showPassword;
    JLabel picLabel;

    // Using Person Class
    User user;

    LoginPage() {
        ImageIcon image  = new ImageIcon("assets/images/Logo.jpg");
        setIconImage(image.getImage());
        setTitle("ICTS PRINTING SYSTEM");
        setContentPane(new JLabel(new ImageIcon("assets/images/background.jpg")));
        picLabel = new JLabel(new ImageIcon("assets/images/Icon.png"));
        
        userTextField = new JTextField();
        userTextField.setFont(new Font("Arial ", Font.PLAIN, 15));
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));

        container = getContentPane();
        userLabel = new JLabel("USERNAME");
        userLabel.setFont(new Font("Arial ", Font.BOLD, 15));
        passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setFont(new Font("Arial ", Font.BOLD, 15));
        loginButton = new JButton("LOGIN");
        resetButton = new JButton("RESET");
        showPassword = new JCheckBox("Show Password");
        showPassword.setOpaque(false);

        user = new User();

        //Calling methods inside constructor.
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();

        setTitle("Login Form");
        setVisible(true);
        setBounds(450, 75, 600, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        //Setting location and Size of each component using setBounds() method.
        picLabel.setBounds(200, 100, 50, 50);
        userLabel.setBounds(150, 150, 100, 30);
        passwordLabel.setBounds(150, 220, 100, 30);
        userTextField.setBounds(250, 150, 150, 30);
        passwordField.setBounds(250, 220, 150, 30);
        showPassword.setBounds(250, 250, 150, 30);
        loginButton.setBounds(150, 350, 100, 30);
        resetButton.setBounds(320, 350, 100, 30);

    }

    public void addComponentsToContainer() {
        //Adding each component to the Container
        container.add(picLabel);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);


       
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("LOGIN")) {

            String username = userTextField.getText();
            String password = String.valueOf(passwordField.getPassword());
            String usertype = user.getUser_Id(username);
            usertype = usertype.substring(0, 3);

            if (user.verifyUser(username, password)) {
                System.gc();
                for (Window window : Window.getWindows()) window.dispose();
                if (usertype.equals("ADM")) {
                    new AdminPage(username);
                }
                if (usertype.equals("CLK")) {
                    new ClerksPage(username);
                }
                if (usertype.equals("EMP")) {
                    new EmployeePage(username);
                }
                if (usertype.equals("DEL")) {
                    new DeliveryPage(username);
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

    public static void main(String[] args) {
        new LoginPage();
    }
}




