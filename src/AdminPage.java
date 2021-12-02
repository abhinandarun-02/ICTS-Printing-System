import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminPage extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTable orderTable;
    private JTable reqTable;
    private JTable paymentTable;
    private JTable recentPaymentsTable;
    private JTextField staffNameText;
    private JTextField emailText;
    private JTextField staffPhNoText;
    private JTextField staffDateText;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminPage frame = new AdminPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public AdminPage() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 75, 1250, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTabbedPane homeTabbedPane = new JTabbedPane(JTabbedPane.TOP);
        homeTabbedPane.setBounds(191, -30, 1057, 697);
        contentPane.add(homeTabbedPane);

        JPanel homeTab = new JPanel();
        homeTabbedPane.addTab("HOME", null, homeTab, null);
        homeTab.setLayout(null);

        JPanel searchTab = new JPanel();
        homeTabbedPane.addTab("SEARCH", null, searchTab, null);
        searchTab.setLayout(null);

        JPanel headerPanel = new JPanel();
        headerPanel.setBounds(10, 10, 1022, 60);
        searchTab.add(headerPanel);
        headerPanel.setLayout(null);

        JLabel lblNewLabel_3 = new JLabel("User ID :");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_3.setBounds(50, 10, 81, 40);
        headerPanel.add(lblNewLabel_3);

        textField = new JTextField();
        textField.setBounds(150, 10, 130, 40);
        headerPanel.add(textField);
        textField.setColumns(10);

        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Orders", "Requests", "Payment"}));
        comboBox.setSelectedIndex(0);
        comboBox.setBounds(400, 10, 120, 40);
        headerPanel.add(comboBox);

        JLabel lblNewLabel_3_1 = new JLabel("Type :");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_3_1.setBounds(336, 10, 81, 40);
        headerPanel.add(lblNewLabel_3_1);

        JButton btnNewButton = new JButton("SEARCH");
        btnNewButton.setFont(new Font("Arial", Font.PLAIN, 18));
        btnNewButton.setBounds(850, 10, 120, 40);
        headerPanel.add(btnNewButton);

        JTabbedPane searchTabbedPane = new JTabbedPane(JTabbedPane.RIGHT);
        searchTabbedPane.setBounds(10, 80, 1022, 577);
        searchTab.add(searchTabbedPane);

        JPanel blankPanel = new JPanel();
        searchTabbedPane.addTab("blank", null, blankPanel, null);

        JPanel searchReqPanel = new JPanel();
        searchTabbedPane.addTab("Request", null, searchReqPanel, null);
        searchReqPanel.setLayout(null);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 10, 942, 552);
        searchReqPanel.add(scrollPane_1);

        reqTable = new JTable();
        scrollPane_1.setViewportView(reqTable);
        reqTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                },
                new String[] {
                        "Name", "Status", "Date", "Type", "Copies", "Paper"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, false, false, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });

        reqTable.setFillsViewportHeight(true);

        JPanel searchPaymentPanel = new JPanel();
        searchTabbedPane.addTab("Payment", null, searchPaymentPanel, null);
        searchPaymentPanel.setLayout(null);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(10, 10, 942, 552);
        searchPaymentPanel.add(scrollPane_2);

        paymentTable = new JTable();
        scrollPane_2.setViewportView(paymentTable);
        paymentTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[] {
                        "Name", "Status", "Amount", "Method", "Payment ID"
                }
        ));
        paymentTable.setFillsViewportHeight(true);

        JPanel searchOrderPanel = new JPanel();
        searchTabbedPane.addTab("Order", null, searchOrderPanel, null);
        searchTabbedPane.setEnabledAt(3, true);
        searchOrderPanel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 10, 942, 552);
        searchOrderPanel.add(scrollPane);

        orderTable = new JTable();
        orderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        orderTable.setFillsViewportHeight(true);
        scrollPane.setViewportView(orderTable);
        orderTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                },
                new String[] {
                        "Print ID", "Clerk", "Date", "Type", "Delivered By", "Cost"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, true, true, true, true, true
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });

        orderTable.setBorder(new LineBorder(new Color(0, 0, 0)));


/**************************************************************************************************************************************/
        JPanel printerTab = new JPanel();
        homeTabbedPane.addTab("PRINTER", null, printerTab, null);

        JLabel printerQueueLabel;
        JButton AddButton;
        JButton DeleteButton;
        printerQueueLabel = new JLabel("Printer queue ");
        AddButton = new JButton("Add record");
        DeleteButton = new JButton("Delete record");


        String[][] data4 = {{"..", "..", "..", "..", "..", "..", "..", ".."}, {"..", "..", "..", "..", "..", "..", "..", ".."},{"..", "..", "..", "..", "..", "..", "..", ".."},{"..", "..", "..", "..", "..", "..", "..", ".."},{"..", "..", "..", "..", "..", "..", "..", ".."},};
        String[] column4 = {"Print ID", "User ID", "Paper size", "Print Type", "Single/Double side", "No. of pages", "Printer#"};
        JTable printerQueue = new JTable(data4, column4);
        JScrollPane sp4 = new JScrollPane(printerQueue, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        printerTab.add(printerQueueLabel);
        printerTab.add(sp4);
        printerTab.add(AddButton);
        printerTab.add(DeleteButton);

        printerQueueLabel.setBounds(100,112, 200, 30);
        sp4.setBounds(100, 152, 850, 150);
        AddButton.setBounds(348, 390, 120, 30);
        DeleteButton.setBounds(498, 390, 120, 30);

        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 3), "PRINTER QUEUE", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Ariel", Font.PLAIN, 24));
        printerTab.setBorder(titledBorder);
        printerTab.setLayout(null);
/**********************************************************************************************************************************************************/


        String[] column = { "Print ID", "User ID", "Name", "Room no", "Phone no", "Bill Status" };
        String[][] data = {{ "", "", "", "", "", "" }, { "", "", "", "", "", "" }};




        JPanel pendingRequestPanel = new JPanel();
        pendingRequestPanel.setBackground(Color.LIGHT_GRAY);
        pendingRequestPanel.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(0, 0, 0)));
        pendingRequestPanel.setBounds(70, 34, 250, 175);
        homeTab.add(pendingRequestPanel);
        pendingRequestPanel.setLayout(null);

        JLabel reqPending = new JLabel("10");
        reqPending.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 56));
        reqPending.setHorizontalAlignment(SwingConstants.CENTER);
        reqPending.setBounds(90, 50, 150, 90);
        pendingRequestPanel.add(reqPending);

        JPanel compleltedOrdersPanel = new JPanel();
        compleltedOrdersPanel.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(0, 0, 0)));
        compleltedOrdersPanel.setBackground(Color.LIGHT_GRAY);
        compleltedOrdersPanel.setBounds(390, 34, 250, 175);
        homeTab.add(compleltedOrdersPanel);
        compleltedOrdersPanel.setLayout(null);

        JLabel completedOrder = new JLabel("10");
        completedOrder.setHorizontalAlignment(SwingConstants.CENTER);
        completedOrder.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 56));
        completedOrder.setBounds(90, 50, 150, 90);
        compleltedOrdersPanel.add(completedOrder);

        JPanel revenuePanel = new JPanel();
        revenuePanel.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(0, 0, 0)));
        revenuePanel.setBackground(Color.LIGHT_GRAY);
        revenuePanel.setBounds(710, 34, 250, 175);
        homeTab.add(revenuePanel);
        revenuePanel.setLayout(null);

        JLabel revenue = new JLabel("10");
        revenue.setHorizontalAlignment(SwingConstants.CENTER);
        revenue.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 56));
        revenue.setBounds(90, 50, 147, 90);
        revenuePanel.add(revenue);

        JScrollPane scrollPane_3 = new JScrollPane();
        scrollPane_3.setBounds(70, 293, 895, 341);
        homeTab.add(scrollPane_3);

        recentPaymentsTable = new JTable();
        recentPaymentsTable.setFillsViewportHeight(true);
        scrollPane_3.setViewportView(recentPaymentsTable);
        recentPaymentsTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[] {
                        "ID", "Name", "Amount", "Date", "Clerk"
                }
        ));

        JLabel lblNewLabel_1 = new JLabel("RECENT ORDERS");
        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel_1.setBounds(70, 237, 183, 46);
        homeTab.add(lblNewLabel_1);

        JPanel deliveryTab = new JPanel();
        homeTabbedPane.addTab("DELIVERY", null, deliveryTab, null);
        JTable deliveryQueueTable = new JTable(data, column);
        deliveryQueueTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                },
                new String[] {
                        "Print ID", "User ID", "Name", "Room no", "Phone no", "Bill Status"
                }
        ));

        TitledBorder titledBorder1 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 3), "DELIVERY QUEUE", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Ariel", Font.PLAIN, 24));

        deliveryQueueTable.setFillsViewportHeight(true);
        JScrollPane scrollPaneDelQueue = new JScrollPane(deliveryQueueTable);
        scrollPaneDelQueue.setBounds(120, 120, 800, 275);
        scrollPaneDelQueue.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JLabel statusLabel = new JLabel("UPDATE STATUS");
        statusLabel.setBounds(120, 430, 170, 30);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        JLabel print_idLabel = new JLabel("Print ID :");
        print_idLabel.setBounds(222, 473, 84, 50);
        print_idLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        JTextField print_idText=new JTextField();
        print_idText.setBounds(316, 483, 110, 30);
        JButton updateStatusButton = new JButton("UPDATE");
        updateStatusButton.setBounds(422, 558, 95, 36);
        updateStatusButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        deliveryTab.setLayout(null);

        deliveryTab.add(scrollPaneDelQueue);
        deliveryTab.add(statusLabel);
        deliveryTab.add(print_idLabel);
        deliveryTab.add(print_idText);
        deliveryTab.add(updateStatusButton);
        ((JComponent) deliveryTab).setBorder(titledBorder1);

        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(544, 484, 130, 30);
        comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Not Delivered", "Delivered"}));
        deliveryTab.add(comboBox_1);

        JLabel print_idLabel_1 = new JLabel("Status :");
        print_idLabel_1.setBounds(464, 473, 84, 50);
        print_idLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        deliveryTab.add(print_idLabel_1);


        String[] column6 = {"Employee ID","Name", "Amount", "Room no.", "Phone no."};


        JPanel manageTab = new JPanel();
        homeTabbedPane.addTab("MANAGE", null, manageTab, null);
        manageTab.setLayout(null);

        JPanel addUserPanel = new JPanel();
        addUserPanel.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.gray,2),"ADD STAFF", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Arial", Font.PLAIN, 24)));
        addUserPanel.setBounds(105, 28, 787, 615);
        manageTab.add(addUserPanel);
        addUserPanel.setLayout(null);

        JLabel staffNameLabel = new JLabel("Name :");
        staffNameLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        staffNameLabel.setBounds(218, 80, 150, 40);
        addUserPanel.add(staffNameLabel);

        staffNameText = new JTextField();
        staffNameText.setBounds(386, 80, 150, 40);
        addUserPanel.add(staffNameText);
        staffNameText.setColumns(10);

        JLabel staffTypeLabel = new JLabel("Type :");
        staffTypeLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        staffTypeLabel.setBounds(218, 227, 150, 40);
        addUserPanel.add(staffTypeLabel);

        JPanel comboBorderPanel = new JPanel();
        comboBorderPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
        comboBorderPanel.setBounds(386, 229, 150, 40);
        addUserPanel.add(comboBorderPanel);
        comboBorderPanel.setLayout(null);

        JComboBox staffTypeCB = new JComboBox();
        staffTypeCB.setBounds(2, 2, 146, 36);
        comboBorderPanel.add(staffTypeCB);
        staffTypeCB.setFont(new Font("Arial", Font.PLAIN, 16));
        staffTypeCB.setModel(new DefaultComboBoxModel(new String[] {"DELIVERY BOY", "CLERK"}));

        JLabel emailLabel = new JLabel("Email ID : ");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        emailLabel.setBounds(218, 153, 150, 40);
        addUserPanel.add(emailLabel);

        emailText = new JTextField();
        emailText.setColumns(10);
        emailText.setBounds(386, 158, 150, 40);
        addUserPanel.add(emailText);

        JLabel staffPhNoLabel = new JLabel("Phone No :");
        staffPhNoLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        staffPhNoLabel.setBounds(218, 313, 150, 40);
        addUserPanel.add(staffPhNoLabel);

        JLabel staffDateLabel = new JLabel("Date :");
        staffDateLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        staffDateLabel.setBounds(218, 392, 150, 40);
        addUserPanel.add(staffDateLabel);

        staffPhNoText = new JTextField();
        staffPhNoText.setColumns(10);
        staffPhNoText.setBounds(386, 313, 150, 40);
        addUserPanel.add(staffPhNoText);

        staffDateText = new JTextField();
        staffDateText.setColumns(10);
        staffDateText.setBounds(386, 392, 150, 40);
        addUserPanel.add(staffDateText);

        JButton staffSubmitButton = new JButton("SUBMIT");
        staffSubmitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        staffSubmitButton.setBounds(318, 490, 150, 50);
        addUserPanel.add(staffSubmitButton);


        JPanel homePanel = new JPanel();
        homePanel.setBorder(new MatteBorder(0, 0, 0, 3, (Color) new Color(128, 128, 128)));
        homePanel.setBackground(Color.LIGHT_GRAY);
        homePanel.setBounds(0, 0, 190, 185);
        contentPane.add(homePanel);
        homePanel.setLayout(null);

        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        homeButtonPanel.setBackground(Color.WHITE);
        homeButtonPanel.setBounds(10, 34, 170, 70);
        homePanel.add(homeButtonPanel);
        homeButtonPanel.setLayout(new GridLayout(1, 0, 0, 0));



        JLabel homeLabel = new JLabel("HOME");
        homeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homeTabbedPane.setSelectedIndex(0);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                homeButtonPanel.setBackground(Color.GRAY);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                homeButtonPanel.setBackground(Color.WHITE);
            }
        });
        homeLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        homeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        homeButtonPanel.add(homeLabel);

        JPanel tabPanel = new JPanel();
        tabPanel.setBorder(new MatteBorder(0, 0, 0, 3, (Color) new Color(128, 128, 128)));
        tabPanel.setBackground(Color.LIGHT_GRAY);
        tabPanel.setBounds(0, 185, 190, 483);
        contentPane.add(tabPanel);
        tabPanel.setLayout(null);

        JPanel searchButtonPanel = new JPanel();
        searchButtonPanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        searchButtonPanel.setBackground(Color.LIGHT_GRAY);
        searchButtonPanel.setBounds(10, 0, 171, 60);
        tabPanel.add(searchButtonPanel);
        searchButtonPanel.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel searchLabel = new JLabel("SEARCH");
        searchLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homeTabbedPane.setSelectedIndex(1);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                searchButtonPanel.setBackground(Color.darkGray);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                searchButtonPanel.setBackground(Color.LIGHT_GRAY);
            }
        });
        searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
        searchButtonPanel.add(searchLabel);

        JPanel printerButtonPanel = new JPanel();
        printerButtonPanel.setBackground(Color.LIGHT_GRAY);
        printerButtonPanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        printerButtonPanel.setBounds(10, 119, 171, 60);
        tabPanel.add(printerButtonPanel);
        printerButtonPanel.setLayout(new GridLayout(1, 0, 0, 0));

        JLabel printerLabel = new JLabel("PRINTER");
        printerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homeTabbedPane.setSelectedIndex(2);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                printerButtonPanel.setBackground(Color.darkGray);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                printerButtonPanel.setBackground(Color.LIGHT_GRAY);
            }
        });
        printerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        printerButtonPanel.add(printerLabel);

        JPanel deliveryButtonPanel = new JPanel();
        deliveryButtonPanel.setBackground(Color.LIGHT_GRAY);
        deliveryButtonPanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        deliveryButtonPanel.setBounds(10, 240, 171, 60);
        tabPanel.add(deliveryButtonPanel);
        deliveryButtonPanel.setLayout(new GridLayout(1, 0, 0, 0));



        JLabel deliveryLabel = new JLabel("DELIVERY");
        deliveryLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homeTabbedPane.setSelectedIndex(3);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                deliveryButtonPanel.setBackground(Color.darkGray);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                deliveryButtonPanel.setBackground(Color.LIGHT_GRAY);
            }
        });
        deliveryLabel.setHorizontalAlignment(SwingConstants.CENTER);
        deliveryButtonPanel.add(deliveryLabel);

        JPanel manageButtonPanel = new JPanel();
        manageButtonPanel.setBackground(Color.LIGHT_GRAY);
        manageButtonPanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        manageButtonPanel.setBounds(10, 360, 171, 60);
        tabPanel.add(manageButtonPanel);
        manageButtonPanel.setLayout(new GridLayout(1, 0, 0, 0));

        JLabel manageLabel = new JLabel("MANAGE");
        manageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homeTabbedPane.setSelectedIndex(4);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                manageButtonPanel.setBackground(Color.darkGray);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                manageButtonPanel.setBackground(Color.LIGHT_GRAY);
            }
        });
        manageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        manageButtonPanel.add(manageLabel);




    }
}
