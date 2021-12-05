import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import javax.swing.JFormattedTextField;
import javax.swing.text.DateFormatter;

public class HomeScreen extends JFrame {

    /* *************** REQUEST_PANEL *************** */
    JPanel requestFormPanel;

    JLabel userIDLabel;
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

    JTextField userIDTextField;
    JTextField nameTextField;
    JTextField phoneTextField;
    JTextField roomTextField;
    JTextField dateTextField;

    ButtonGroup buttonGroup1 = new ButtonGroup();
    JRadioButton officialRButton; JRadioButton personalRButton;

    ButtonGroup buttonGroup2 = new ButtonGroup();
    JRadioButton a3RButton; JRadioButton a4RButton; JRadioButton a5RButton;

    ButtonGroup buttonGroup3 = new ButtonGroup();
    JRadioButton singlePrintRButton; JRadioButton doublePrintRButton;

    ButtonGroup buttonGroup4 = new ButtonGroup();
    JRadioButton grayscaleRButton; JRadioButton colourRButton;

    JSpinner pageNoSpinner;
    JSpinner copyNoSpinner;

    JButton fileButton;
    JButton submitButton;
    JButton resetButton;
    /* ****************************** */


    /* *************** SIDE_PANEL *************** */
    JPanel sidePanel;

    JButton loginButton;
    JButton checkStatusButton;
    JButton paymentButton;
    /* ****************************** */


    public HomeScreen(String title) {

        super(title); //Frame title

        /* ****************************** REQUEST_PANEL_SECTION ****************************** */
        requestFormPanel = new JPanel();

        requestFormPanel = new JPanel();
        userIDLabel = new JLabel("User ID : ");
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
        
        DateFormat format = new SimpleDateFormat("dd-MMMM-yyyy");
        DateFormatter df = new DateFormatter(format);
        JFormattedTextField dateField = new JFormattedTextField(df);
        dateField.setValue(new Date());


        userIDTextField = new JTextField();
        nameTextField = new JTextField();
        phoneTextField = new JTextField();
        roomTextField = new JTextField();
        

        officialRButton = new JRadioButton("Official"); personalRButton = new JRadioButton("Personal");
        buttonGroup1.add(officialRButton); buttonGroup1.add(personalRButton);
        a3RButton = new JRadioButton("A3"); a4RButton = new JRadioButton("A4"); a5RButton = new JRadioButton("A5");
        buttonGroup2.add(a3RButton); buttonGroup2.add(a4RButton); buttonGroup2.add(a5RButton);
        singlePrintRButton = new JRadioButton("Single Side"); doublePrintRButton = new JRadioButton("Double Side");
        buttonGroup3.add(singlePrintRButton); buttonGroup3.add(doublePrintRButton);
        grayscaleRButton = new JRadioButton("Grayscale"); colourRButton = new JRadioButton("Colour");
        buttonGroup4.add(grayscaleRButton); buttonGroup4.add(colourRButton);

        pageNoSpinner = new JSpinner();
        copyNoSpinner = new JSpinner();

        fileButton = new JButton("Choose File...");
        submitButton = new JButton("Submit");
        resetButton = new JButton("Reset");


        requestFormPanel.add(userIDLabel); requestFormPanel.add(userIDTextField);
        requestFormPanel.add(nameLabel); requestFormPanel.add(nameTextField);
        requestFormPanel.add(printTypeLabel); requestFormPanel.add(officialRButton); requestFormPanel.add(personalRButton);
        requestFormPanel.add(paperSizeLabel); requestFormPanel.add(a3RButton); requestFormPanel.add(a4RButton); requestFormPanel.add(a5RButton);
        requestFormPanel.add(printPageTypeLabel); requestFormPanel.add(singlePrintRButton); requestFormPanel.add(doublePrintRButton);
        requestFormPanel.add(colourLabel); requestFormPanel.add(grayscaleRButton); requestFormPanel.add(colourRButton);
        requestFormPanel.add(pageNoLabel); requestFormPanel.add(pageNoSpinner);
        requestFormPanel.add(copyNoLabel); requestFormPanel.add(copyNoSpinner);
        requestFormPanel.add(phoneLabel); requestFormPanel.add(phoneTextField);
        requestFormPanel.add(roomLabel); requestFormPanel.add(roomTextField);
        requestFormPanel.add(dateLabel); requestFormPanel.add(dateField);
        requestFormPanel.add(fileButton);
        requestFormPanel.add(submitButton);
        requestFormPanel.add(resetButton);


        userIDLabel.setBounds(150, 80, 100, 30); userIDTextField.setBounds(350, 80, 100, 25);
        nameLabel.setBounds(150, 120, 100, 30); nameTextField.setBounds(350, 120, 100, 25);
        printTypeLabel.setBounds(150, 160, 100, 30); officialRButton.setBounds(350, 160, 100, 25); personalRButton.setBounds(500, 160, 100, 25);
        paperSizeLabel.setBounds(150, 200, 100, 30); a3RButton.setBounds(350, 200, 100, 25); a4RButton.setBounds(500, 200, 100, 25); a5RButton.setBounds(650, 200, 100, 25);
        printPageTypeLabel.setBounds(150, 240, 100, 30); singlePrintRButton.setBounds(350, 240, 100, 25); doublePrintRButton.setBounds(500, 240, 100, 25);
        colourLabel.setBounds(150, 280, 100, 30); grayscaleRButton.setBounds(350, 280, 100, 25); colourRButton.setBounds(500, 280, 100, 25);
        pageNoLabel.setBounds(150, 320, 100, 30);pageNoSpinner.setBounds(350, 320, 42, 25);
        copyNoLabel.setBounds(150, 360, 100, 30);copyNoSpinner.setBounds(350, 360, 42, 25);
        phoneLabel.setBounds(150, 400, 100, 30); phoneTextField.setBounds(350, 400, 120, 25);
        roomLabel.setBounds(150, 440, 100, 30); roomTextField.setBounds(350, 440, 120, 25);
        dateLabel.setBounds(150, 480, 100, 30); dateField.setBounds(350, 480, 120, 25);
        fileButton.setBounds(150, 540, 100, 25);
        fileButton.setFont( new Font("Arial", Font.PLAIN, 10));
        submitButton.setBounds(400, 580, 100, 30);
        resetButton.setBounds(520, 580, 100, 30);

        requestFormPanel.setBounds(20, 30, 960, 620);
        requestFormPanel.setLayout(null);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray,2),"REQUEST PRINT", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Arial", Font.PLAIN, 24));
        requestFormPanel.setBorder(titledBorder);
        /* *************************************************************************** */
        resetButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	userIDTextField.setText("");
            	nameTextField.setText("");
            	buttonGroup1.clearSelection();
            	buttonGroup2.clearSelection();
            	buttonGroup3.clearSelection();
            	buttonGroup4.clearSelection();
            	pageNoSpinner.setValue(0);
            	copyNoSpinner.setValue(0);
            	phoneTextField.setText("");
            	roomTextField.setText("");
            	dateField.setValue(new Date());
            	
            }
        });

        /* ****************************** SIDE_PANEL_SECTION ****************************** */
        sidePanel = new JPanel();
        sidePanel.setBounds(980, 230, 253, 160);
        sidePanel.setLayout(new GridLayout(3, 1));

        loginButton = new JButton("Login");
        checkStatusButton = new JButton("Check Status");
        paymentButton = new JButton("Payment Portal");
        
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new LoginFrame().setVisible(true); 
               dispose();
            }
        });
        checkStatusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new statusFrame().setVisible(true); 
               dispose();
            }
        });
        paymentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new PayFrame().setVisible(true); 
               dispose();
            }
        });

        sidePanel.add(loginButton);
        sidePanel.add(checkStatusButton);
        sidePanel.add(paymentButton);
        /* *************************************************************************** */


        /* ****************************** FRAME_CONFIGURATION ****************************** */
        setBounds(150, 75, 1250, 700);
        setLayout(null);
        setResizable(false); //Disable frame resizing 
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(requestFormPanel);
        add(sidePanel);
        /* *************************************************************************** */


    }

    public static void main(String[] args) {
        new HomeScreen("ICTS PRINTING SOFTWARE");
    }
}
