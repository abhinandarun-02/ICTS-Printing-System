package GUI;

import main.Person;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.text.DateFormatter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class HomeScreen extends JFrame implements ActionListener {

    Person user = new Person();

    /* *************** REQUEST_PANEL *************** */
    JPanel requestFormPanel;

    JFormattedTextField dateField;
    DateFormat format;
    DateFormatter df;

    JLabel usernameLabel;
    JLabel passLabel;
    JLabel nameLabel;
    JLabel printTypeLabel;
    JLabel paperSizeLabel;
    JLabel printPageTypeLabel;
    JLabel colourLabel;
    JLabel pageNoLabel;
    JLabel copyNoLabel;
    JLabel phoneLabel;
    JLabel roomLabel;
    JLabel dateLabel;

    JTextField usernameTextField;
    JPasswordField passwordField;
    JTextField nameTextField;
    JTextField phoneTextField;
    JTextField roomTextField;

    ButtonGroup buttonGroup1 = new ButtonGroup();
    JRadioButton officialRButton;
    JRadioButton personalRButton;

    ButtonGroup buttonGroup2 = new ButtonGroup();
    JRadioButton a3RButton;
    JRadioButton a4RButton;
    JRadioButton a5RButton;

    ButtonGroup buttonGroup3 = new ButtonGroup();
    JRadioButton singlePrintRButton;
    JRadioButton doublePrintRButton;

    ButtonGroup buttonGroup4 = new ButtonGroup();
    JRadioButton grayscaleRButton;
    JRadioButton colourRButton;

    JSpinner pageNoSpinner;
    JSpinner copyNoSpinner;

    JButton fileButton;
    JFileChooser fc;
    JButton submitButton;
    JButton resetButton;
    /* ****************************** */


    /* *************** SIDE_PANEL *************** */
    JPanel sidePanel;

    JButton loginButton;
    JButton checkStatusButton;
    JButton paymentButton;
    /* ****************************** */


    public HomeScreen() {

        /* ****************************** REQUEST_PANEL_SECTION ****************************** */
        requestFormPanel = new JPanel();

        requestFormPanel = new JPanel();
        usernameLabel = new JLabel("Username : ");
        passLabel = new JLabel("Password : ");
        nameLabel = new JLabel("Name");
        printTypeLabel = new JLabel("Print Type");
        paperSizeLabel = new JLabel("Paper Size");
        printPageTypeLabel = new JLabel("Page Type");
        colourLabel = new JLabel("Colour Type");
        pageNoLabel = new JLabel("No of Pages");
        copyNoLabel = new JLabel("No of Copies");
        phoneLabel = new JLabel("Phone No");
        roomLabel = new JLabel("Room No");
        dateLabel = new JLabel("Date");

        format = new SimpleDateFormat("dd-MMMM-yyyy");
        df = new DateFormatter(format);
        dateField = new JFormattedTextField(df);
        dateField.setValue(new Date());
        dateField.setEditable(false);
        Font f1 = new Font("Sans", Font.BOLD, 15);
        dateField.setFont(f1);
        dateField.setForeground(Color.black);
        dateField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        DateFormat shortTime = DateFormat.getTimeInstance(DateFormat.SHORT);
        JFormattedTextField timeField = new JFormattedTextField(shortTime);
        timeField.setValue(new Date());
        timeField.setEditable(false);
        timeField.setForeground(Color.black);
        timeField.setFont(f1);
        timeField.setBorder(javax.swing.BorderFactory.createEmptyBorder());


        usernameTextField = new JTextField();
        usernameTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        phoneTextField = new JTextField();
        phoneTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        roomTextField = new JTextField();
        roomTextField.setFont(new Font("Arial", Font.PLAIN, 14));


        officialRButton = new JRadioButton("Official");
        officialRButton.setActionCommand("Official");
        personalRButton = new JRadioButton("Personal");
        personalRButton.setActionCommand("Personal");
        buttonGroup1.add(officialRButton);
        buttonGroup1.add(personalRButton);

        a3RButton = new JRadioButton("A3");
        a3RButton.setActionCommand("A3");
        a4RButton = new JRadioButton("A4");
        a4RButton.setActionCommand("A4");
        a5RButton = new JRadioButton("A5");
        a5RButton.setActionCommand("A5");
        buttonGroup2.add(a3RButton);
        buttonGroup2.add(a4RButton);
        buttonGroup2.add(a5RButton);

        singlePrintRButton = new JRadioButton("Single Side");
        singlePrintRButton.setActionCommand("Single");
        doublePrintRButton = new JRadioButton("Double Side");
        doublePrintRButton.setActionCommand("Double");
        buttonGroup3.add(singlePrintRButton);
        buttonGroup3.add(doublePrintRButton);

        grayscaleRButton = new JRadioButton("Grayscale");
        grayscaleRButton.setActionCommand("Grayscale");
        colourRButton = new JRadioButton("Colour");
        colourRButton.setActionCommand("Colour");
        buttonGroup4.add(grayscaleRButton);
        buttonGroup4.add(colourRButton);

        SpinnerModel model1 = new SpinnerNumberModel(1, 1, 5000, 1);
        pageNoSpinner = new JSpinner(model1);
        pageNoSpinner.setFont(new Font("Arial", Font.PLAIN, 14));
        SpinnerModel model2 = new SpinnerNumberModel(1, 1, 2000, 1);
        copyNoSpinner = new JSpinner(model2);
        copyNoSpinner.setFont(new Font("Arial", Font.PLAIN, 14));

        fileButton = new JButton("Choose File...");
        fc = new JFileChooser();
        submitButton = new JButton("Submit");
        resetButton = new JButton("Reset");


        requestFormPanel.add(usernameLabel);
        requestFormPanel.add(usernameTextField);
        requestFormPanel.add(passLabel);
        requestFormPanel.add(passwordField);
        requestFormPanel.add(nameLabel);
        requestFormPanel.add(nameTextField);
        requestFormPanel.add(printTypeLabel);
        requestFormPanel.add(officialRButton);
        requestFormPanel.add(personalRButton);
        requestFormPanel.add(paperSizeLabel);
        requestFormPanel.add(a3RButton);
        requestFormPanel.add(a4RButton);
        requestFormPanel.add(a5RButton);
        requestFormPanel.add(printPageTypeLabel);
        requestFormPanel.add(singlePrintRButton);
        requestFormPanel.add(doublePrintRButton);
        requestFormPanel.add(colourLabel);
        requestFormPanel.add(grayscaleRButton);
        requestFormPanel.add(colourRButton);
        requestFormPanel.add(pageNoLabel);
        requestFormPanel.add(pageNoSpinner);
        requestFormPanel.add(copyNoLabel);
        requestFormPanel.add(copyNoSpinner);
        requestFormPanel.add(phoneLabel);
        requestFormPanel.add(phoneTextField);
        requestFormPanel.add(roomLabel);
        requestFormPanel.add(roomTextField);
        requestFormPanel.add(dateField);
        requestFormPanel.add(timeField);
        requestFormPanel.add(fileButton);
        requestFormPanel.add(submitButton);
        requestFormPanel.add(resetButton);


        dateField.setBounds(350, 50, 140, 24);
        timeField.setBounds(520, 50, 140, 24);
        usernameLabel.setBounds(185, 110, 100, 30);
        usernameTextField.setBounds(355, 110, 100, 24);
        passLabel.setBounds(505, 110, 100, 30);
        passwordField.setBounds(655, 110, 100, 24);
        nameLabel.setBounds(185, 150, 100, 30);
        nameTextField.setBounds(355, 150, 100, 24);
        printTypeLabel.setBounds(185, 190, 100, 30);
        officialRButton.setBounds(355, 190, 100, 25);
        personalRButton.setBounds(505, 190, 100, 25);
        paperSizeLabel.setBounds(185, 230, 100, 30);
        a3RButton.setBounds(355, 230, 100, 25);
        a4RButton.setBounds(505, 230, 100, 25);
        a5RButton.setBounds(655, 230, 100, 25);
        printPageTypeLabel.setBounds(185, 270, 100, 30);
        singlePrintRButton.setBounds(355, 270, 100, 25);
        doublePrintRButton.setBounds(505, 270, 100, 25);
        colourLabel.setBounds(185, 310, 100, 30);
        grayscaleRButton.setBounds(355, 310, 100, 25);
        colourRButton.setBounds(505, 310, 100, 25);
        pageNoLabel.setBounds(185, 350, 100, 30);
        pageNoSpinner.setBounds(355, 350, 42, 25);
        copyNoLabel.setBounds(185, 390, 100, 30);
        copyNoSpinner.setBounds(355, 390, 42, 25);
        phoneLabel.setBounds(185, 430, 100, 30);
        phoneTextField.setBounds(355, 430, 120, 24);
        roomLabel.setBounds(185, 470, 100, 30);
        roomTextField.setBounds(355, 470, 120, 24);
        fileButton.setBounds(185, 528, 100, 25);
        fileButton.setFont(new Font("Arial", Font.PLAIN, 10));
        submitButton.setBounds(370, 580, 100, 30);
        resetButton.setBounds(490, 580, 100, 30);

        requestFormPanel.setBounds(20, 30, 960, 620);
        requestFormPanel.setLayout(null);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 2), "REQUEST PRINT", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Arial", Font.PLAIN, 24));
        requestFormPanel.setBorder(titledBorder);

        resetButton.addActionListener(this);
        fileButton.addActionListener(this);
        submitButton.addActionListener(this);
        /* *************************************************************************** */
        /*  ***************************************************************************************/



        /* ****************************** SIDE_PANEL_SECTION ****************************** */
        sidePanel = new JPanel();
        sidePanel.setBounds(983, 110, 253, 470);

        loginButton = new JButton("LOGIN");
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        loginButton.setBounds(0, 50, 240, 60);
        checkStatusButton = new JButton("CHECK STATUS");
        checkStatusButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        checkStatusButton.setBounds(0, 200, 240, 60);
        paymentButton = new JButton("PAYMENT PORTAL");
        paymentButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        paymentButton.setBounds(0, 350, 240, 60);

        loginButton.addActionListener(this);

        checkStatusButton.addActionListener(this);

        paymentButton.addActionListener(this);

        sidePanel.setLayout(null);

        sidePanel.add(loginButton);
        sidePanel.add(checkStatusButton);
        sidePanel.add(paymentButton);
        /* *************************************************************************** */


        /* ****************************** FRAME_CONFIGURATION ****************************** */
        setBounds(150, 75, 1250, 700);
        getContentPane().setLayout(null);
        setResizable(false); //Disable frame resizing 
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().add(requestFormPanel);
        getContentPane().add(sidePanel);
        /* *************************************************************************** */


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Submit")) {
            String username = usernameTextField.getText();
            String password = String.valueOf(passwordField.getPassword());

            if (user.verifyUser(username, password)) {
                String phone_no = phoneTextField.getText();
                String paper_type = buttonGroup2.getSelection().getActionCommand();
                String page_type = buttonGroup3.getSelection().getActionCommand();
                String colour_type = buttonGroup4.getSelection().getActionCommand();
                String status = buttonGroup1.getSelection().getActionCommand();

                user.sendRequest(username, phone_no, paper_type, page_type, colour_type, status);
            }
        }

        if (e.getActionCommand().equals("Reset")) {
            usernameTextField.setText("");
            nameTextField.setText("");
            passwordField.setText("");
            buttonGroup1.clearSelection();
            buttonGroup2.clearSelection();
            buttonGroup3.clearSelection();
            buttonGroup4.clearSelection();
            pageNoSpinner.setValue(1);
            copyNoSpinner.setValue(1);
            phoneTextField.setText("");
            roomTextField.setText("");
            dateField.setValue(new Date());
        }

        if (e.getActionCommand().equals("Choose File...")) {
            fc = new JFileChooser();
            fc.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter1 = new FileNameExtensionFilter("PDF files", "pdf");
            fc.addChoosableFileFilter(filter1);
            FileNameExtensionFilter filter2 = new FileNameExtensionFilter("Doc files", "docx");
            fc.addChoosableFileFilter(filter2);
            FileNameExtensionFilter filter3 = new FileNameExtensionFilter("Pictures", "jpg");
            fc.addChoosableFileFilter(filter3);
            FileNameExtensionFilter filter4 = new FileNameExtensionFilter("Excel sheets", "xlsx");
            fc.addChoosableFileFilter(filter4);
            fc.showOpenDialog(null);
        }

        if (e.getActionCommand().equals("LOGIN")) {
            new LoginPage();
        }

        if (e.getActionCommand().equals("CHECK STATUS")) {
            new Status();
        }

        if (e.getActionCommand().equals("PAYMENT PORTAL")) {
            new Payment();
        }

    }

    public static void main(String[] args) {
        new HomeScreen();
    }
}
