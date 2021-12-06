import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class HomeScreen extends JFrame {

    /* *************** REQUEST_PANEL *************** */
    JPanel requestFormPanel;

    JLabel userIDLabel;
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

    JTextField userIDTextField;
    JPasswordField passwordField;
    JTextField nameTextField;
    JTextField phoneTextField;
    JTextField roomTextField;

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


    public HomeScreen(String title) {

        super(title); //Frame title

        /* ****************************** REQUEST_PANEL_SECTION ****************************** */
        requestFormPanel = new JPanel();

        requestFormPanel = new JPanel();
        userIDLabel = new JLabel("User ID : ");
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
        
        DateFormat format = new SimpleDateFormat("dd-MMMM-yyyy");
        DateFormatter df = new DateFormatter(format);
        JFormattedTextField dateField = new JFormattedTextField(df);
        dateField.setValue(new Date());
        dateField.setEditable(false);
        Font f1 = new Font("Sans",Font.BOLD,15);
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
        


        userIDTextField = new JTextField();
        passwordField=new JPasswordField();
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
        fc=new JFileChooser();  
        submitButton = new JButton("Submit");
        resetButton = new JButton("Reset");


        requestFormPanel.add(userIDLabel); requestFormPanel.add(userIDTextField);
        requestFormPanel.add(passLabel); requestFormPanel.add(passwordField);
        requestFormPanel.add(nameLabel); requestFormPanel.add(nameTextField);
        requestFormPanel.add(printTypeLabel); requestFormPanel.add(officialRButton); requestFormPanel.add(personalRButton);
        requestFormPanel.add(paperSizeLabel); requestFormPanel.add(a3RButton); requestFormPanel.add(a4RButton); requestFormPanel.add(a5RButton);
        requestFormPanel.add(printPageTypeLabel); requestFormPanel.add(singlePrintRButton); requestFormPanel.add(doublePrintRButton);
        requestFormPanel.add(colourLabel); requestFormPanel.add(grayscaleRButton); requestFormPanel.add(colourRButton);
        requestFormPanel.add(pageNoLabel); requestFormPanel.add(pageNoSpinner);
        requestFormPanel.add(copyNoLabel); requestFormPanel.add(copyNoSpinner);
        requestFormPanel.add(phoneLabel); requestFormPanel.add(phoneTextField);
        requestFormPanel.add(roomLabel); requestFormPanel.add(roomTextField);
        requestFormPanel.add(dateField);requestFormPanel.add(timeField);
        requestFormPanel.add(fileButton);
        requestFormPanel.add(submitButton);
        requestFormPanel.add(resetButton);

        
        dateField.setBounds(350, 50, 140, 24); timeField.setBounds(520, 50, 140, 24);
        userIDLabel.setBounds(150, 110, 100, 30); userIDTextField.setBounds(350, 110, 100, 24);
        passLabel.setBounds(500, 110, 100, 30); passwordField.setBounds(650, 110, 100, 24);
        nameLabel.setBounds(150, 150, 100, 30); nameTextField.setBounds(350, 150, 100, 24);
        printTypeLabel.setBounds(150, 190, 100, 30); officialRButton.setBounds(350, 190, 100, 25); personalRButton.setBounds(500, 190, 100, 25);
        paperSizeLabel.setBounds(150, 230, 100, 30); a3RButton.setBounds(350, 230, 100, 25); a4RButton.setBounds(500, 230, 100, 25); a5RButton.setBounds(650, 230, 100, 25);
        printPageTypeLabel.setBounds(150, 270, 100, 30); singlePrintRButton.setBounds(350, 270, 100, 25); doublePrintRButton.setBounds(500, 270, 100, 25);
        colourLabel.setBounds(150, 310, 100, 30); grayscaleRButton.setBounds(350, 310, 100, 25); colourRButton.setBounds(500, 310, 100, 25);
        pageNoLabel.setBounds(150, 350, 100, 30);pageNoSpinner.setBounds(350, 350, 42, 25);
        copyNoLabel.setBounds(150, 390, 100, 30);copyNoSpinner.setBounds(350, 390, 42, 25);
        phoneLabel.setBounds(150, 430, 100, 30); phoneTextField.setBounds(350, 430, 120, 24);
        roomLabel.setBounds(150, 470, 100, 30); roomTextField.setBounds(350, 470, 120, 24);
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
            	passwordField.setText("");
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
      /*  ***************************************************************************************/
        fileButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {       
        	    fc=new JFileChooser();     
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
        	    
        	    
        }});
        
        

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
               
            }
        });
        checkStatusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new statusFrame().setVisible(true); 
               
            }
        });
        paymentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new PayFrame().setVisible(true); 
               
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
