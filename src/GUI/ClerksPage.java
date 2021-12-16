package GUI;
import main.Person;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;


public class ClerksPage extends JFrame {

    Person user = new Person();
    JTabbedPane tabbedPane;

    JPanel ClerkPanel1;
    JLabel pendingRequestsLabel;
    JLabel printerQueueLabel;
    JButton AddButton;
    JButton DeleteButton;
    JButton NextButton;

    JPanel ClerkPanel2;
    JLabel deliveryQueueLabel;
    JButton AddButton2;
    JButton DeleteButton2;
    JLabel printIdLabel;
    JLabel userIdLabel;
    JLabel costPerPageLabel;
    JLabel totalNoPagesLabel;
    JTextField printId;
    JTextField userId;
    JTextField costPerPage;
    JTextField totalNoPages;
    JButton GenerateButton;
    JButton PrevButton;
    JPanel billPanel;
    JPanel resourcesPanel;
    JLabel a3Label;
    JLabel a4Label;
    JLabel a5Label;
    JLabel blackLabel;
    JLabel colourLabel;
    JLabel a3resLabel;
    JLabel a5resLabel;
    JLabel blackresLabel;
    JLabel colourresLabel;
    JLabel a4resLabel;
    JPanel printerDetailsPanel;
    JLabel printer1Label;
    JLabel printer2Label;
    JLabel printer3Label;
    JLabel printer4Label;
    JLabel printer5Label;
    JButton notifyButton;

    ButtonGroup buttonGroup1;
    JRadioButton acceptButton;
    JRadioButton rejectButton;

    public ClerksPage() {

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        /* ****************************** PAGE 1 ****************************** */
        ClerkPanel1 = new JPanel();
        pendingRequestsLabel = new JLabel("PENDING REQUESTS");
        pendingRequestsLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 24));
        printerQueueLabel = new JLabel("PRINTER QUEUE");
        printerQueueLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 24));
        AddButton = new JButton("Update Status");
        DeleteButton = new JButton("Remove Record");
        NextButton = new JButton("Next Page");
        NextButton.setFont(new Font("Arial", Font.BOLD, 14));
        NextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(1);
            }
        });
        String[][] data1 = {};
        String[] column1 = {};
        JTable pendingRequests = new JTable(data1, column1);
        pendingRequests.setModel(new DefaultTableModel(
                new String[][]{
                        
                },
                new String[]{
                        "User ID", "Name", "Print ID", "Use", "No of Copies", "Date", "Credits"
                }
        ));
        JScrollPane sp1 = new JScrollPane(pendingRequests, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        String[][] data4 = {};
        String[] column4 = {};
        JTable printerQueue = new JTable(data4, column4);
        printerQueue.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Print ID", "User ID", "Paper Size", "Print Type", "Single/Double side", "No of Pages", "Printer#"
                }
        ));

        JScrollPane sp4 = new JScrollPane(printerQueue, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        ClerkPanel1.add(pendingRequestsLabel);
        ClerkPanel1.add(sp1);
        ClerkPanel1.add(printerQueueLabel);
        ClerkPanel1.add(sp4);
        ClerkPanel1.add(AddButton);
        ClerkPanel1.add(DeleteButton);
        ClerkPanel1.add(NextButton);

        pendingRequestsLabel.setBounds(78, 39, 240, 30);
        sp1.setBounds(78, 82, 900, 200);
        printerQueueLabel.setBounds(78, 315, 200, 30);
        sp4.setBounds(78, 360, 900, 200);
        AddButton.setBounds(1020, 402, 180, 40);
        DeleteButton.setBounds(1020, 475, 180, 40);
        NextButton.setBounds(545, 600, 140, 30);


        ClerkPanel1.setBounds(40, 20, 920, 750);
        ClerkPanel1.setLayout(null);

        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 3), "Clerk Page", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Ariel", Font.PLAIN, 24));
        ClerkPanel1.setBorder(titledBorder);
        /* *************************************************************************** */

        /* ****************************** PAGE 2 ****************************** */
        ClerkPanel2 = new JPanel();
        deliveryQueueLabel = new JLabel("DELIVERY QUEUE");
        deliveryQueueLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 24));
        AddButton2 = new JButton("Add record");
        DeleteButton2 = new JButton("Delete record");
        PrevButton = new JButton("Previous Page");
        PrevButton.setFont(new Font("Arial", Font.BOLD, 14));
        PrevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(0);
            }
        });

        String[][] data5 = {};
        String[] column5 = {};
        JTable deliveryQueue = new JTable(data5, column5);
        deliveryQueue.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Print ID", "User ID", "Name", "Room No", "Phone No", "Status"
                }
        ));
        JScrollPane sp5 = new JScrollPane(deliveryQueue, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        ClerkPanel2.add(deliveryQueueLabel);
        ClerkPanel2.add(sp5);
        ClerkPanel2.add(AddButton2);
        ClerkPanel2.add(DeleteButton2);
        ClerkPanel2.add(PrevButton);

        deliveryQueueLabel.setBounds(30, 40, 200, 30);
        sp5.setBounds(30, 80, 1170, 126);
        AddButton2.setBounds(440, 216, 140, 40);
        DeleteButton2.setBounds(650, 216, 140, 40);
        PrevButton.setBounds(545, 600, 140, 30);

        ClerkPanel2.setBounds(156, 20, 920, 623);
        ClerkPanel2.setLayout(null);
        ClerkPanel2.setBorder(titledBorder);
        /* *************************************************************************** */

        /* ****************************** TABBED_PANE_CONFIGURATION ****************************** */
        tabbedPane.add(ClerkPanel1);

        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setBounds(1020, 130, 180, 91);
        ClerkPanel1.add(panel);
        panel.setLayout(null);

        acceptButton = new JRadioButton("Accept");
        acceptButton.setFont(new Font("Calibri", Font.PLAIN, 16));
        acceptButton.setBounds(6, 16, 80, 20);
        panel.add(acceptButton);

        rejectButton = new JRadioButton("Reject");
        rejectButton.setFont(new Font("Calibri", Font.PLAIN, 16));
        rejectButton.setBounds(104, 16, 70, 20);
        panel.add(rejectButton);

        buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(acceptButton);
        buttonGroup1.add(rejectButton);

        JButton requestSubmitButton = new JButton("Submit");
        requestSubmitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(requestSubmitButton, "Are You Sure?", "CONFIRM", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            }
        });
        requestSubmitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        requestSubmitButton.setBounds(6, 54, 164, 37);
        panel.add(requestSubmitButton);
        tabbedPane.setTitleAt(0, "Page 1");
        tabbedPane.add(ClerkPanel2);

        billPanel = new JPanel();
        TitledBorder billBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 2), "GENERATE BILL", TitledBorder.CENTER, TitledBorder.TOP, new Font("Ariel", Font.PLAIN, 18));
        billPanel.setBorder(billBorder);
        billPanel.setBounds(850, 275, 350, 300);
        ClerkPanel2.add(billPanel);
        billPanel.setLayout(null);
        printIdLabel = new JLabel("Print ID : ");
        printIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        printIdLabel.setBounds(30, 70, 80, 30);
        billPanel.add(printIdLabel);
        printId = new JTextField();
        printId.setBounds(160, 70, 150, 30);
        billPanel.add(printId);
        userIdLabel = new JLabel("User ID : ");
        userIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        userIdLabel.setBounds(30, 110, 80, 30);
        billPanel.add(userIdLabel);
        userId = new JTextField();
        userId.setBounds(160, 110, 150, 30);
        billPanel.add(userId);
        costPerPageLabel = new JLabel("Cost per Page : ");
        costPerPageLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        costPerPageLabel.setBounds(30, 149, 120, 30);
        billPanel.add(costPerPageLabel);
        costPerPage = new JTextField();
        costPerPage.setBounds(160, 150, 150, 30);
        billPanel.add(costPerPage);
        totalNoPagesLabel = new JLabel("Total Page : ");
        totalNoPagesLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        totalNoPagesLabel.setBounds(30, 187, 120, 30);
        billPanel.add(totalNoPagesLabel);
        totalNoPages = new JTextField();
        totalNoPages.setBounds(160, 190, 150, 30);
        billPanel.add(totalNoPages);
        GenerateButton = new JButton("Generate Bill");
        GenerateButton.setFont(new Font("Arial", Font.BOLD, 14));
        GenerateButton.setBounds(100, 255, 150, 30);
        billPanel.add(GenerateButton);

        resourcesPanel = new JPanel();
        TitledBorder resourcesBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 2), "RESOURCES", TitledBorder.CENTER, TitledBorder.TOP, new Font("Ariel", Font.PLAIN, 18));
        resourcesPanel.setBorder(resourcesBorder);
        resourcesPanel.setBounds(440, 275, 350, 300);
        ClerkPanel2.add(resourcesPanel);
        resourcesPanel.setLayout(null);

        a3Label = new JLabel("A3 Paper");
        a3Label.setFont(new Font("Arial", Font.PLAIN, 16));
        a3Label.setBounds(55, 50, 80, 30);
        resourcesPanel.add(a3Label);

        a4Label = new JLabel("A4 Paper");
        a4Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
        a4Label.setBounds(55, 90, 80, 30);
        resourcesPanel.add(a4Label);

        a5Label = new JLabel("A5 Paper");
        a5Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
        a5Label.setBounds(55, 130, 80, 30);
        resourcesPanel.add(a5Label);

        blackLabel = new JLabel("Black Catridge");
        blackLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        blackLabel.setBounds(55, 170, 120, 30);
        resourcesPanel.add(blackLabel);

        colourLabel = new JLabel("Colour Catridge");
        colourLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        colourLabel.setBounds(55, 210, 120, 30);
        resourcesPanel.add(colourLabel);

        a3resLabel = new JLabel("2400");
        a3resLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        a3resLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        a3resLabel.setBounds(210, 50, 80, 30);
        resourcesPanel.add(a3resLabel);

        a5resLabel = new JLabel("1700");
        a5resLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        a5resLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        a5resLabel.setBounds(210, 130, 80, 30);
        resourcesPanel.add(a5resLabel);

        blackresLabel = new JLabel("90");
        blackresLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        blackresLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        blackresLabel.setBounds(210, 170, 80, 30);
        resourcesPanel.add(blackresLabel);

        colourresLabel = new JLabel("120");
        colourresLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        colourresLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        colourresLabel.setBounds(210, 210, 80, 30);
        resourcesPanel.add(colourresLabel);

        a4resLabel = new JLabel("3200");
        a4resLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        a4resLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        a4resLabel.setBounds(210, 90, 80, 30);
        resourcesPanel.add(a4resLabel);

        notifyButton = new JButton("Notify Admin");
        notifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int ans = JOptionPane.showConfirmDialog(requestSubmitButton, "Are You Sure?", "CONFIRM", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(ans==JOptionPane.YES_OPTION)
                {
                	user.setNotification();
                	JOptionPane.showMessageDialog(null, "Notification sent");
                }
            }
        });
        notifyButton.setFont(new Font("Arial", Font.PLAIN, 16));
        notifyButton.setBounds(110, 255, 150, 30);
        resourcesPanel.add(notifyButton);

        printerDetailsPanel = new JPanel();
        TitledBorder printerDetailsBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 2), "PRINTER DETAILS", TitledBorder.CENTER, TitledBorder.TOP, new Font("Ariel", Font.PLAIN, 18));

        printerDetailsPanel.setBorder(printerDetailsBorder);
        printerDetailsPanel.setBounds(30, 275, 350, 300);
        ClerkPanel2.add(printerDetailsPanel);
        printerDetailsPanel.setLayout(null);

        printer1Label = new JLabel("Printer 1");
        printer1Label.setFont(new Font("Arial", Font.PLAIN, 18));
        printer1Label.setBounds(30, 50, 100, 30);
        printerDetailsPanel.add(printer1Label);

        printer2Label = new JLabel("Printer 2");
        printer2Label.setFont(new Font("Arial", Font.PLAIN, 18));
        printer2Label.setBounds(30, 100, 100, 30);
        printerDetailsPanel.add(printer2Label);

        printer3Label = new JLabel("Printer 3");
        printer3Label.setFont(new Font("Arial", Font.PLAIN, 18));
        printer3Label.setBounds(30, 150, 100, 30);
        printerDetailsPanel.add(printer3Label);

        printer4Label = new JLabel("Printer 4");
        printer4Label.setFont(new Font("Arial", Font.PLAIN, 18));
        printer4Label.setBounds(30, 200, 100, 30);
        printerDetailsPanel.add(printer4Label);

        printer5Label = new JLabel("Printer 5");
        printer5Label.setFont(new Font("Arial", Font.PLAIN, 18));
        printer5Label.setBounds(30, 250, 100, 30);
        printerDetailsPanel.add(printer5Label);

        JComboBox printer1CB = new JComboBox(new String[]{"Available", "Running", "Out of Order"});
        printer1CB.setFont(new Font("Arial", Font.PLAIN, 16));
        printer1CB.setBounds(200, 50, 110, 30);
        printerDetailsPanel.add(printer1CB);

        JComboBox printer2CB = new JComboBox(new String[]{"Available", "Running", "Out of Order"});
        printer2CB.setFont(new Font("Arial", Font.PLAIN, 16));
        printer2CB.setBounds(200, 100, 110, 30);
        printerDetailsPanel.add(printer2CB);

        JComboBox printer3CB = new JComboBox(new String[]{"Available", "Running", "Out of Order"});
        printer3CB.setFont(new Font("Arial", Font.PLAIN, 16));
        printer3CB.setBounds(200, 150, 110, 30);
        printerDetailsPanel.add(printer3CB);

        JComboBox printer4CB = new JComboBox(new String[]{"Available", "Running", "Out of Order"});
        printer4CB.setFont(new Font("Arial", Font.PLAIN, 16));
        printer4CB.setBounds(200, 200, 110, 30);
        printerDetailsPanel.add(printer4CB);

        JComboBox printer5CB = new JComboBox(new String[]{"Available", "Running", "Out of Order"});
        printer5CB.setFont(new Font("Arial", Font.PLAIN, 16));
        printer5CB.setBounds(200, 250, 110, 30);
        printerDetailsPanel.add(printer5CB);
        tabbedPane.setTitleAt(1, "Page 2");
        tabbedPane.setBounds(0, -23, 1236, 685);
        /* *************************************************************************** */

        /* ****************************** FRAME_CONFIGURATION ****************************** */
        setBounds(150, 75, 1250, 700);
        getContentPane().setLayout(null);
        getContentPane().add(tabbedPane);

        setVisible(true);
        setResizable(false); //Disable frame resizing
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        /* *************************************************************************** */


    }

    public static void main(String[] args) {
        new ClerksPage();
    }
}