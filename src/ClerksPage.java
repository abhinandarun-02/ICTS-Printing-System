import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClerksPage extends JFrame {


    JTabbedPane tabbedPane;

    JPanel ClerkPanel1;
    JLabel pendingRequestsLabel;
    JLabel printerDetailsLabel;
    JLabel resourceDetailsLabel;
    JButton notifyButton;
    JLabel printerQueueLabel;
    JButton AddButton;
    JButton DeleteButton;
    JButton NextButton;

    JPanel ClerkPanel2;
    JLabel deliveryQueueLabel;
    JButton AddButton2;
    JButton DeleteButton2;
    JTable deliveryQueue;
    JLabel generateBillLabel;
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

    public ClerksPage(String title) {

        super(title); //Frame title

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        /* ****************************** PAGE 1 ****************************** */
        ClerkPanel1 = new JPanel();
        pendingRequestsLabel = new JLabel("Pending requests ");
        printerDetailsLabel = new JLabel("Printer details ");
        resourceDetailsLabel = new JLabel("Resource details ");
        notifyButton = new JButton("Notify Admin");
        printerQueueLabel = new JLabel("Printer queue ");
        AddButton = new JButton("Add record");
        DeleteButton = new JButton("Delete record");
        NextButton = new JButton("Next page");
        NextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(1);
            }
        });
        String[][] data1 = {{"..", "..", "..", "..", "..", "..", ".."}, {"..", "..", "..", "..", "..", "..", ".."}};
        String[] column1 = {"User ID", "Name", "Print ID", "Use", "Date", "Time", "Accept/Reject"};
        JTable pendingRequests = new JTable(data1, column1);
        JScrollPane sp1 = new JScrollPane(pendingRequests, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        String[][] data2 = {{"..", "..", ".."}, {"..", "..", ".."}};
        String[] column2 = {"Available", "Currently Working", "Out of Order"};
        JTable printerDetails = new JTable(data2, column2);
        JScrollPane sp2 = new JScrollPane(printerDetails, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        String[][] data3 = {{"..", "..", "..", "..", ".."}, {"..", "..", "..", "..", ".."}};
        String[] column3 = {"A3", "A4", "A5", "Colour cartridge", "Black cartridge"};
        JTable resourceDetails = new JTable(data3, column3);
        JScrollPane sp3 = new JScrollPane(resourceDetails, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        String[][] data4 = {{"..", "..", "..", "..", "..", "..", "..", ".."}, {"..", "..", "..", "..", "..", "..", "..", ".."}};
        String[] column4 = {"Print ID", "User ID", "Paper size", "Print Type", "Single/Double side", "No. of pages", "Printer#"};
        JTable printerQueue = new JTable(data4, column4);
        JScrollPane sp4 = new JScrollPane(printerQueue, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        ClerkPanel1.add(pendingRequestsLabel);
        ClerkPanel1.add(sp1);
        ClerkPanel1.add(printerDetailsLabel);
        ClerkPanel1.add(sp2);
        ClerkPanel1.add(resourceDetailsLabel);
        ClerkPanel1.add(sp3);
        ClerkPanel1.add(notifyButton);
        ClerkPanel1.add(printerQueueLabel);
        ClerkPanel1.add(sp4);
        ClerkPanel1.add(AddButton);
        ClerkPanel1.add(DeleteButton);
        ClerkPanel1.add(NextButton);

        pendingRequestsLabel.setBounds(78, 42, 200, 30);
        sp1.setBounds(78, 82, 800, 80);
        printerDetailsLabel.setBounds(78, 162, 200, 30);
        sp2.setBounds(78, 202, 400, 80);
        resourceDetailsLabel.setBounds(78, 282, 200, 30);
        sp3.setBounds(78, 322, 600, 80);
        notifyButton.setBounds(758, 340, 120, 30);
        printerQueueLabel.setBounds(78, 412, 200, 30);
        sp4.setBounds(78, 452, 800, 80);
        AddButton.setBounds(348, 562, 120, 30);
        DeleteButton.setBounds(498, 562, 120, 30);
        NextButton.setBounds(430, 610, 120, 30);


        ClerkPanel1.setBounds(40, 20, 920, 750);
        ClerkPanel1.setLayout(null);

        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 3), "Clerk Page", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Ariel", Font.PLAIN, 24));
        ClerkPanel1.setBorder(titledBorder);
        /* *************************************************************************** */

        /* ****************************** PAGE 2 ****************************** */
        ClerkPanel2 = new JPanel();
        deliveryQueueLabel = new JLabel("Delivery queue ");
        AddButton2 = new JButton("Add record");
        DeleteButton2 = new JButton("Delete record");
        generateBillLabel = new JLabel("Generate bill ");
        printIdLabel = new JLabel("Print ID: ");
        userIdLabel = new JLabel("User ID: ");
        costPerPageLabel = new JLabel("Cost per page: ");
        totalNoPagesLabel = new JLabel("Total no. of pages: ");
        printId = new JTextField();
        userId = new JTextField();
        costPerPage = new JTextField();
        totalNoPages = new JTextField();
        GenerateButton = new JButton("Generate Bill");
        PrevButton = new JButton("Previous page");
        PrevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(0);
            }
        });

        String[][] data5 = {{"..", "..", "..", "..", "..", "..",}, {"..", "..", "..", "..", "..", ".."}};
        String[] column5 = {"Print ID", "User ID", "Name", "Room no.", "Phone no.", "Status"};
        JTable deliveryQueue = new JTable(data5, column5);
        JScrollPane sp5 = new JScrollPane(deliveryQueue, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        ClerkPanel2.add(deliveryQueueLabel);
        ClerkPanel2.add(sp5);
        ClerkPanel2.add(AddButton2);
        ClerkPanel2.add(DeleteButton2);
        ClerkPanel2.add(generateBillLabel);
        ClerkPanel2.add(printIdLabel);
        ClerkPanel2.add(userIdLabel);
        ClerkPanel2.add(costPerPageLabel);
        ClerkPanel2.add(totalNoPagesLabel);
        ClerkPanel2.add(printId);
        ClerkPanel2.add(userId);
        ClerkPanel2.add(costPerPage);
        ClerkPanel2.add(totalNoPages);
        ClerkPanel2.add(GenerateButton);
        ClerkPanel2.add(PrevButton);

        deliveryQueueLabel.setBounds(80, 39, 200, 30);
        sp5.setBounds(80, 79, 800, 100);
        AddButton2.setBounds(367, 200, 120, 30);
        DeleteButton2.setBounds(550, 200, 120, 30);
        generateBillLabel.setBounds(80, 261, 100, 30);
        printIdLabel.setBounds(300, 289, 100, 30);
        userIdLabel.setBounds(300, 329, 100, 30);
        costPerPageLabel.setBounds(300, 369, 100, 30);
        totalNoPagesLabel.setBounds(300, 409, 100, 30);
        printId.setBounds(440, 289, 200, 30);
        userId.setBounds(440, 329, 200, 30);
        costPerPage.setBounds(440, 369, 200, 30);
        totalNoPages.setBounds(440, 409, 200, 30);
        GenerateButton.setBounds(430, 469, 120, 30);
        PrevButton.setBounds(430, 610, 120, 30);

        ClerkPanel2.setBounds(156, 20, 920, 623);
        ClerkPanel2.setLayout(null);
        ClerkPanel2.setBorder(titledBorder);
        /* *************************************************************************** */

        /* ****************************** TABBED_PANE_CONFIGURATION ****************************** */
        tabbedPane.add(ClerkPanel1);
        tabbedPane.setTitleAt(0, "Page 1");
        tabbedPane.add(ClerkPanel2);
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
        new ClerksPage("ICTS PRINTING SOFTWARE");
    }
}