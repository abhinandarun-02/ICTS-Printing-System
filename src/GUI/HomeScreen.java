package GUI;

import main.User;

import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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

import java.awt.*;
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

    Container container;

    /* *************** REQUEST_PANEL *************** */
    JPanel requestFormPanel;

    JFormattedTextField dateField;
    DateFormat format;
    DateFormatter df;

    JLabel usernameLabel;
    JLabel passLabel;
    JLabel printTypeLabel;
    JLabel paperSizeLabel;
    JLabel printPageTypeLabel;
    JLabel colourLabel;
    JLabel pageNoLabel;
    JLabel copyNoLabel;
    JLabel dateLabel;

    JTextField usernameTextField;
    JPasswordField passwordField;

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

        setContentPane(new JLabel(new ImageIcon("assets/images/bg.jpg")));

        /* ****************************** REQUEST_PANEL_SECTION ****************************** */
        requestFormPanel = new JPanel();
        ImageIcon image  = new ImageIcon("assets/images/Logo.jpg");
        setIconImage(image.getImage());
        setTitle("ICTS PRINTING SYSTEM");
        container = getContentPane();

        requestFormPanel = new JPanel();
        usernameLabel = new JLabel("Username : ");
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        passLabel = new JLabel("Password : ");
        passLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        printTypeLabel = new JLabel("Print Type");
        printTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        paperSizeLabel = new JLabel("Paper Size");
        paperSizeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        printPageTypeLabel = new JLabel("Page Type");
        printPageTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        colourLabel = new JLabel("Colour Type");
        colourLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        pageNoLabel = new JLabel("No of Pages");
        pageNoLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        copyNoLabel = new JLabel("No of Copies");
        copyNoLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        dateLabel = new JLabel("Date");

        format = new SimpleDateFormat("dd-MMMM-yyyy");
        df = new DateFormatter(format);
        dateField = new JFormattedTextField(df);
        dateField.setValue(new Date());
        dateField.setEditable(false);
        dateField.setOpaque(false);
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
        timeField.setOpaque(false);


        usernameTextField = new JTextField();
        usernameTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));


        officialRButton = new JRadioButton("Official");
        officialRButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        officialRButton.setOpaque(false);
        officialRButton.setActionCommand("Official");
        personalRButton = new JRadioButton("Personal");
        personalRButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        personalRButton.setOpaque(false);
        personalRButton.setActionCommand("Personal");
        buttonGroup1.add(officialRButton);
        buttonGroup1.add(personalRButton);

        a3RButton = new JRadioButton("A3");
        a3RButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        a3RButton.setOpaque(false);
        a3RButton.setActionCommand("A3");
        a4RButton = new JRadioButton("A4");
        a4RButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        a4RButton.setOpaque(false);
        a4RButton.setActionCommand("A4");
        a5RButton = new JRadioButton("A5");
        a5RButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        a5RButton.setOpaque(false);
        a5RButton.setActionCommand("A5");
        buttonGroup2.add(a3RButton);
        buttonGroup2.add(a4RButton);
        buttonGroup2.add(a5RButton);

        singlePrintRButton = new JRadioButton("Single Side");
        singlePrintRButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        singlePrintRButton.setOpaque(false);
        singlePrintRButton.setActionCommand("Single");
        doublePrintRButton = new JRadioButton("Double Side");
        doublePrintRButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        doublePrintRButton.setOpaque(false);
        doublePrintRButton.setActionCommand("Double");
        buttonGroup3.add(singlePrintRButton);
        buttonGroup3.add(doublePrintRButton);

        grayscaleRButton = new JRadioButton("Grayscale");
        grayscaleRButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        grayscaleRButton.setOpaque(false);
        grayscaleRButton.setActionCommand("Grayscale");
        colourRButton = new JRadioButton("Colour");
        colourRButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        colourLabel.setOpaque(false);
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

        requestFormPanel.add(dateField);
        requestFormPanel.add(timeField);
        requestFormPanel.add(fileButton);
        requestFormPanel.add(submitButton);
        requestFormPanel.add(resetButton);
        requestFormPanel.setOpaque(false);


        dateField.setBounds(350, 50, 140, 24);
        timeField.setBounds(520, 50, 140, 24);
        usernameLabel.setBounds(185, 100, 100, 30);
        usernameTextField.setBounds(355, 110, 130, 25);
        passLabel.setBounds(185, 150, 100, 30);
        passwordField.setBounds(355, 155, 130, 24);
        printTypeLabel.setBounds(185, 207, 100, 30);
        officialRButton.setBounds(355, 210, 100, 25);
        personalRButton.setBounds(505, 210, 100, 25);
        paperSizeLabel.setBounds(185, 260, 100, 30);
        a3RButton.setBounds(355, 263, 100, 25);
        a4RButton.setBounds(505, 263, 100, 25);
        a5RButton.setBounds(665, 263, 100, 25);
        printPageTypeLabel.setBounds(185, 316, 100, 30);
        singlePrintRButton.setBounds(355, 319, 100, 25);
        doublePrintRButton.setBounds(505, 319, 100, 25);
        colourLabel.setBounds(185, 368, 100, 30);
        grayscaleRButton.setBounds(355, 371, 100, 25);
        colourRButton.setBounds(505, 371, 100, 25);
        pageNoLabel.setBounds(185, 419, 100, 30);
        pageNoSpinner.setBounds(355, 421, 42, 25);
        copyNoLabel.setBounds(185, 476, 100, 30);
        copyNoSpinner.setBounds(355, 478, 42, 25);
        fileButton.setBounds(185, 530, 100, 25);
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
        sidePanel.setOpaque(false);
        /* *************************************************************************** */

        container.add(sidePanel);
        container.add(requestFormPanel);

        /* ****************************** FRAME_CONFIGURATION ****************************** */
        setBounds(150, 75, 1250, 700);
        getContentPane().setLayout(null);
        setResizable(false); //Disable frame resizing 
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

       
        /* *************************************************************************** */


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Submit")) {
            String username = usernameTextField.getText();
            String password = String.valueOf(passwordField.getPassword());

            User user = new User(username);

            if (user.verifyUser(username, password)) {

                String print_type = buttonGroup1.getSelection().getActionCommand();
                String paper_type = buttonGroup2.getSelection().getActionCommand();
                String page_type = buttonGroup3.getSelection().getActionCommand();
                String colour_type = buttonGroup4.getSelection().getActionCommand();

                String status = "Not Accepted";

                int no_of_pages = (int) pageNoSpinner.getValue();
                int no_of_copies = (int) copyNoSpinner.getValue();


                Random random = new Random();
                int id = random.nextInt(1000);
                String p_id = "P" + id;

                JOptionPane.showInternalMessageDialog(null, "Request ID : " + p_id);

                String print_id = p_id;


                try {
                    user.sendRequest(print_id, username, paper_type, page_type, colour_type, status);
                    user.sendRequest(print_id, print_type, colour_type, no_of_pages, no_of_copies);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showInternalMessageDialog(null, "Please click submit again..\nSorry for the inconvenience");

                }

            }
            else
                JOptionPane.showMessageDialog(null, "User credentials not registered", "INVALID LOGIN", JOptionPane.ERROR_MESSAGE, null);


        }

        if (e.getActionCommand().equals("Reset")) {
            usernameTextField.setText("");
            passwordField.setText("");
            buttonGroup1.clearSelection();
            buttonGroup2.clearSelection();
            buttonGroup3.clearSelection();
            buttonGroup4.clearSelection();
            pageNoSpinner.setValue(1);
            copyNoSpinner.setValue(1);
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
