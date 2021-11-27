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

    JButton fileButton;
    JButton submitButton;
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
        phoneLabel = new JLabel("Phone No");
        roomLabel = new JLabel("Room No");
        dateLabel = new JLabel("Date");

        userIDTextField = new JTextField();
        nameTextField = new JTextField();
        phoneTextField = new JTextField();
        roomTextField = new JTextField();
        dateTextField = new JTextField();

        officialRButton = new JRadioButton("Official"); personalRButton = new JRadioButton("Personal");
        buttonGroup1.add(officialRButton); buttonGroup1.add(personalRButton);
        a3RButton = new JRadioButton("A3"); a4RButton = new JRadioButton("A4"); a5RButton = new JRadioButton("A5");
        buttonGroup2.add(a3RButton); buttonGroup2.add(a4RButton); buttonGroup2.add(a5RButton);
        singlePrintRButton = new JRadioButton("Single Side"); doublePrintRButton = new JRadioButton("Double Side");
        buttonGroup3.add(singlePrintRButton); buttonGroup3.add(doublePrintRButton);
        grayscaleRButton = new JRadioButton("Grayscale"); colourRButton = new JRadioButton("Colour");
        buttonGroup4.add(grayscaleRButton); buttonGroup4.add(colourRButton);

        pageNoSpinner = new JSpinner();

        fileButton = new JButton("Choose File...");
        submitButton = new JButton("Submit");


        requestFormPanel.add(userIDLabel); requestFormPanel.add(userIDTextField);
        requestFormPanel.add(nameLabel); requestFormPanel.add(nameTextField);
        requestFormPanel.add(printTypeLabel); requestFormPanel.add(officialRButton); requestFormPanel.add(personalRButton);
        requestFormPanel.add(paperSizeLabel); requestFormPanel.add(a3RButton); requestFormPanel.add(a4RButton); requestFormPanel.add(a5RButton);
        requestFormPanel.add(printPageTypeLabel); requestFormPanel.add(singlePrintRButton); requestFormPanel.add(doublePrintRButton);
        requestFormPanel.add(colourLabel); requestFormPanel.add(grayscaleRButton); requestFormPanel.add(colourRButton);
        requestFormPanel.add(pageNoLabel); requestFormPanel.add(pageNoSpinner);
        requestFormPanel.add(phoneLabel); requestFormPanel.add(phoneTextField);
        requestFormPanel.add(roomLabel); requestFormPanel.add(roomTextField);
        requestFormPanel.add(dateLabel); requestFormPanel.add(dateTextField);
        requestFormPanel.add(fileButton);
        requestFormPanel.add(submitButton);


        userIDLabel.setBounds(150, 100, 100, 30); userIDTextField.setBounds(350, 100, 100, 25);
        nameLabel.setBounds(150, 140, 100, 30); nameTextField.setBounds(350, 140, 100, 25);
        printTypeLabel.setBounds(150, 180, 100, 30); officialRButton.setBounds(350, 180, 100, 25); personalRButton.setBounds(500, 180, 100, 25);
        paperSizeLabel.setBounds(150, 220, 100, 30); a3RButton.setBounds(350, 220, 100, 25); a4RButton.setBounds(500, 220, 100, 25); a5RButton.setBounds(650, 220, 100, 25);
        printPageTypeLabel.setBounds(150, 260, 100, 30); singlePrintRButton.setBounds(350, 260, 100, 25); doublePrintRButton.setBounds(500, 260, 100, 25);
        colourLabel.setBounds(150, 300, 100, 30); grayscaleRButton.setBounds(350, 300, 100, 25); colourRButton.setBounds(500, 300, 100, 25);
        pageNoLabel.setBounds(150, 340, 100, 30); pageNoSpinner.setBounds(350, 340, 28, 25);
        phoneLabel.setBounds(150, 380, 100, 30); phoneTextField.setBounds(350, 380, 100, 25);
        roomLabel.setBounds(150, 420, 100, 30); roomTextField.setBounds(350, 420, 100, 25);
        dateLabel.setBounds(150, 460, 100, 30); dateTextField.setBounds(350, 460, 100, 25);
        fileButton.setBounds(150, 510, 100, 25);
        fileButton.setFont( new Font("Arial", Font.PLAIN, 10));
        submitButton.setBounds(420, 560, 100, 30);

        requestFormPanel.setBounds(20, 30, 960, 620);
        requestFormPanel.setLayout(null);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray,2),"REQUEST PRINT", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Arial", Font.PLAIN, 24));
        requestFormPanel.setBorder(titledBorder);
        /* *************************************************************************** */


        /* ****************************** SIDE_PANEL_SECTION ****************************** */
        sidePanel = new JPanel();
        sidePanel.setBounds(980, 230, 253, 160);
        sidePanel.setLayout(new GridLayout(3, 1));

        loginButton = new JButton("Login");
        checkStatusButton = new JButton("Check Status");
        paymentButton = new JButton("Payment Portal");

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
