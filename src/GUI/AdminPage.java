package GUI;

import javax.swing.BorderFactory;
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

import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

import main.Person;

public class AdminPage extends JFrame implements ActionListener {

    JPanel contentPane;
    JTextField user_idText;
    JTable orderTable;
    JTable reqTable;
    JTable paymentTable;
    JTable recentPaymentsTable;
    JTextField staffNameText;
    JTextField emailText;
    JTextField staffPhNoText;
    JTextField staffDateText;
    JTextField staffpassText;

    JTabbedPane homeTabbedPane;

    JPanel sideBarPanel;
    JPanel homePanel;
    JPanel tabPanel;

    JPanel homeButtonPanel;
    JPanel searchButtonPanel;
    JPanel printerButtonPanel;
    JPanel deliveryButtonPanel;
    JPanel manageButtonPanel;

    JComboBox staffTypeCB;

    Color primaryColor = new Color(255, 255, 255);
    Color secondaryColor = new Color(70, 100, 130);

    Person user;


    public static void main(String[] args) {
        new AdminPage();
    }


    public AdminPage() {

        user = new Person();

        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 75, 1250, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        /* *************************************************************************************************************************************/

        JLabel printerQueueLabel;
        JButton AddButton;
        JButton DeleteButton;


        String[][] data4 = {};
        String[] column4 = {"Print ID", "User ID", "Paper size", "Print Type", "Single/Double side", "No. of pages", "Printer#"};

        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 3), "PRINTER QUEUE", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Ariel", Font.PLAIN, 24));
        /* *********************************************************************************************************************************************************/


        String[] column = {"Print ID", "User ID", "Name", "Room no", "Phone no", "Bill Status"};
        String[][] data = {{"", "", "", "", "", ""}, {"", "", "", "", "", ""}};

        TitledBorder titledBorder1;
        titledBorder1 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 3), "DELIVERY QUEUE", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Ariel", Font.PLAIN, 24));

        sideBarPanel = new JPanel();
        sideBarPanel.setBounds(0, 0, 249, 668);
        contentPane.add(sideBarPanel);
        sideBarPanel.setLayout(null);


        homePanel = new JPanel();
        homePanel.setBounds(0, 0, 250, 160);
        sideBarPanel.add(homePanel);
        homePanel.setBorder(new MatteBorder(0, 0, 0, 3, new Color(128, 128, 128)));
        homePanel.setBackground(primaryColor);

        homeButtonPanel = new JPanel();
        homeButtonPanel.setBounds(10, 34, 229, 70);
        homeButtonPanel.setBorder(new MatteBorder(2, 2, 2, 2, new Color(0, 0, 0)));
        homeButtonPanel.setBackground(Color.WHITE);


        JLabel homeLabel = new JLabel("   HOME");
        homeLabel.setBounds(10, 2, 209, 66);
        homeLabel.setIcon(new ImageIcon("assets\\images\\Admin\\tabPanel\\home.png"));
        homeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homeTabbedPane.setSelectedIndex(0);
                homeButtonPanel.setBackground(Color.GRAY);
                searchButtonPanel.setBackground(Color.WHITE);
                deliveryButtonPanel.setBackground(Color.WHITE);
                printerButtonPanel.setBackground(Color.WHITE);
                manageButtonPanel.setBackground(Color.WHITE);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (homeTabbedPane.getSelectedIndex() != 0) {
                    homeButtonPanel.setBackground(Color.LIGHT_GRAY);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (homeTabbedPane.getSelectedIndex() != 0) {
                    homeButtonPanel.setBackground(Color.WHITE);
                }
            }

        });
        homePanel.setLayout(null);
        homeButtonPanel.setLayout(null);
        homeLabel.setFont(new Font("Arial", Font.PLAIN, 26));
        homeButtonPanel.add(homeLabel);
        homePanel.add(homeButtonPanel);

        tabPanel = new JPanel();
        tabPanel.setBorder(new MatteBorder(0, 0, 0, 3, new Color(128, 128, 128)));
        tabPanel.setBackground(primaryColor);
        tabPanel.setBounds(-1, 143, 250, 515);
        sideBarPanel.add(tabPanel);
        tabPanel.setLayout(null);

        searchButtonPanel = new JPanel();
        searchButtonPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
        searchButtonPanel.setBackground(Color.WHITE);
        searchButtonPanel.setBounds(10, 20, 230, 60);
        tabPanel.add(searchButtonPanel);

        JLabel searchLabel = new JLabel("   SEARCH");
        searchLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        searchLabel.setBounds(10, 0, 210, 60);
        searchLabel.setIcon(new ImageIcon("assets\\images\\Admin\\tabPanel\\search.png"));
        searchLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homeTabbedPane.setSelectedIndex(1);
                homeButtonPanel.setBackground(Color.WHITE);
                searchButtonPanel.setBackground(Color.GRAY);
                deliveryButtonPanel.setBackground(Color.WHITE);
                printerButtonPanel.setBackground(Color.WHITE);
                manageButtonPanel.setBackground(Color.WHITE);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (homeTabbedPane.getSelectedIndex() != 1) {
                    searchButtonPanel.setBackground(Color.LIGHT_GRAY);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (homeTabbedPane.getSelectedIndex() != 1) {
                    searchButtonPanel.setBackground(Color.WHITE);
                }
            }
        });
        searchButtonPanel.setLayout(null);
        searchButtonPanel.add(searchLabel);

        printerButtonPanel = new JPanel();
        printerButtonPanel.setBackground(Color.WHITE);
        printerButtonPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
        printerButtonPanel.setBounds(10, 140, 230, 60);
        tabPanel.add(printerButtonPanel);

        JLabel printerLabel = new JLabel("  PRINTER");
        printerLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        printerLabel.setBounds(10, 2, 220, 56);
        printerLabel.setIcon(new ImageIcon("assets\\images\\Admin\\tabPanel\\print.png"));
        printerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homeTabbedPane.setSelectedIndex(2);
                homeButtonPanel.setBackground(Color.WHITE);
                searchButtonPanel.setBackground(Color.WHITE);
                deliveryButtonPanel.setBackground(Color.WHITE);
                printerButtonPanel.setBackground(Color.GRAY);
                manageButtonPanel.setBackground(Color.WHITE);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (homeTabbedPane.getSelectedIndex() != 2) {
                    printerButtonPanel.setBackground(Color.LIGHT_GRAY);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (homeTabbedPane.getSelectedIndex() != 2) {
                    printerButtonPanel.setBackground(Color.WHITE);
                }
            }
        });
        printerButtonPanel.setLayout(null);
        printerButtonPanel.add(printerLabel);

        deliveryButtonPanel = new JPanel();
        deliveryButtonPanel.setBackground(Color.WHITE);
        deliveryButtonPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
        deliveryButtonPanel.setBounds(10, 260, 230, 60);
        tabPanel.add(deliveryButtonPanel);


        JLabel deliveryLabel = new JLabel("  DELIVERY");
        deliveryLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        deliveryLabel.setIcon(new ImageIcon("assets\\images\\Admin\\tabPanel\\delivery.png"));
        deliveryLabel.setBounds(10, 2, 218, 56);
        deliveryLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homeTabbedPane.setSelectedIndex(3);
                homeButtonPanel.setBackground(Color.WHITE);
                searchButtonPanel.setBackground(Color.WHITE);
                deliveryButtonPanel.setBackground(Color.GRAY);
                printerButtonPanel.setBackground(Color.WHITE);
                manageButtonPanel.setBackground(Color.WHITE);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (homeTabbedPane.getSelectedIndex() != 3) {
                    deliveryButtonPanel.setBackground(Color.LIGHT_GRAY);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (homeTabbedPane.getSelectedIndex() != 3) {
                    deliveryButtonPanel.setBackground(Color.WHITE);
                }
            }
        });
        deliveryButtonPanel.setLayout(null);
        deliveryButtonPanel.add(deliveryLabel);

        manageButtonPanel = new JPanel();
        manageButtonPanel.setBackground(Color.WHITE);
        manageButtonPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
        manageButtonPanel.setBounds(10, 390, 230, 60);
        tabPanel.add(manageButtonPanel);

        JLabel manageLabel = new JLabel("  MANAGE");
        manageLabel.setIcon(new ImageIcon("assets\\images\\Admin\\tabPanel\\manage.png"));
        manageLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        manageLabel.setBounds(10, 2, 218, 56);
        manageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homeTabbedPane.setSelectedIndex(4);
                homeButtonPanel.setBackground(Color.WHITE);
                searchButtonPanel.setBackground(Color.WHITE);
                deliveryButtonPanel.setBackground(Color.WHITE);
                printerButtonPanel.setBackground(Color.WHITE);
                manageButtonPanel.setBackground(Color.GRAY);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (homeTabbedPane.getSelectedIndex() != 4) {
                    manageButtonPanel.setBackground(Color.LIGHT_GRAY);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (homeTabbedPane.getSelectedIndex() != 4) {
                    manageButtonPanel.setBackground(Color.WHITE);
                }
            }
        });
        manageButtonPanel.setLayout(null);
        manageButtonPanel.add(manageLabel);


        homeTabbedPane = new JTabbedPane(JTabbedPane.TOP);
        homeTabbedPane.setBounds(242, -30, 1006, 697);
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

        user_idText = new JTextField();
        user_idText.setFont(new Font("Arial", Font.PLAIN, 20));
        user_idText.setBounds(150, 10, 130, 40);
        headerPanel.add(user_idText);
        user_idText.setColumns(10);

        JComboBox comboBox = new JComboBox(new String[]{"Orders", "Requests", "Payment"});
        comboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        //        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Orders", "Requests", "Payment"}));
        comboBox.setSelectedIndex(0);
        comboBox.setBounds(400, 10, 120, 40);
        headerPanel.add(comboBox);

        JLabel lblNewLabel_3_1 = new JLabel("Type :");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_3_1.setBounds(336, 10, 60, 40);
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
                new String[][]{
                },
                new String[]{
                        "Name", "Status", "Date", "Type", "Copies", "Paper"
                }));

        JPanel searchPaymentPanel = new JPanel();
        searchTabbedPane.addTab("Payment", null, searchPaymentPanel, null);
        searchPaymentPanel.setLayout(null);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(10, 10, 942, 552);
        searchPaymentPanel.add(scrollPane_2);

        paymentTable = new JTable();
        scrollPane_2.setViewportView(paymentTable);
        paymentTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Name", "Status", "Amount", "Method", "Payment ID"
                }
        ));

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
        scrollPane.setViewportView(orderTable);
        orderTable.setModel(new DefaultTableModel(
                new String[][]{
                },
                new String[]{
                        "Print ID", "Clerk", "Date", "Type", "Delivered By", "Cost"
                }
        ));

        orderTable.setBorder(new LineBorder(new Color(0, 0, 0)));
        JPanel printerTab = new JPanel();
        homeTabbedPane.addTab("PRINTER", null, printerTab, null);
        printerQueueLabel = new JLabel("QUEUE");
        printerQueueLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        AddButton = new JButton("ADD");
        AddButton.setFont(new Font("Arial", Font.PLAIN, 20));
        DeleteButton = new JButton("DELETE");
        DeleteButton.setFont(new Font("Arial", Font.PLAIN, 20));
        JTable printerQueue = new JTable(data4, column4);
        JScrollPane sp4 = new JScrollPane(printerQueue, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        printerTab.add(printerQueueLabel);
        printerTab.add(sp4);
        printerTab.add(AddButton);
        printerTab.add(DeleteButton);

        printerQueueLabel.setBounds(100, 112, 200, 30);
        sp4.setBounds(100, 152, 850, 150);
        AddButton.setBounds(320, 390, 150, 50);
        DeleteButton.setBounds(498, 390, 150, 50);
        printerTab.setBorder(titledBorder);
        printerTab.setLayout(null);


        JPanel pendingRequestPanel = new JPanel();
        pendingRequestPanel.setBackground(Color.LIGHT_GRAY);
        pendingRequestPanel.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(0, 0, 0)));
        pendingRequestPanel.setBounds(70, 70, 230, 175);
        homeTab.add(pendingRequestPanel);
        pendingRequestPanel.setLayout(null);

        JLabel reqPending = new JLabel("  7");
        reqPending.setIcon(new ImageIcon("assets\\images\\Admin\\home-page\\pending requests.png"));
        reqPending.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 56));
        reqPending.setBounds(10, 50, 230, 90);
        pendingRequestPanel.add(reqPending);

        JPanel completedOrdersPanel = new JPanel();
        completedOrdersPanel.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(0, 0, 0)));
        completedOrdersPanel.setBackground(Color.LIGHT_GRAY);
        completedOrdersPanel.setBounds(390, 70, 230, 175);
        homeTab.add(completedOrdersPanel);
        completedOrdersPanel.setLayout(null);

        JLabel completedOrder = new JLabel("   4");
        completedOrder.setIcon(new ImageIcon("assets\\images\\Admin\\home-page\\queue.png"));
        completedOrder.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 56));
        completedOrder.setBounds(10, 50, 210, 90);
        completedOrdersPanel.add(completedOrder);

        JPanel revenuePanel = new JPanel();
        revenuePanel.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(0, 0, 0)));
        revenuePanel.setBackground(Color.LIGHT_GRAY);
        revenuePanel.setBounds(710, 70, 255, 175);
        homeTab.add(revenuePanel);
        revenuePanel.setLayout(null);

        JLabel revenue = new JLabel("12,342");
        revenue.setIcon(new ImageIcon("assets\\images\\Admin\\home-page\\revenue.png"));
        revenue.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 36));
        revenue.setBounds(10, 50, 235, 90);
        revenuePanel.add(revenue);

        JScrollPane scrollPane_3 = new JScrollPane();
        scrollPane_3.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPane_3.setBounds(70, 319, 895, 311);
        homeTab.add(scrollPane_3);

        recentPaymentsTable = new JTable();
        scrollPane_3.setViewportView(recentPaymentsTable);
        recentPaymentsTable.setModel(new DefaultTableModel(
                new String[][]{
                },
                new String[]{
                        "User ID", "Name", "Amount/Credit", "Date", "Clerk"
                }
        ));

        JLabel recentOrderLabel = new JLabel("RECENT ORDERS");
        recentOrderLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        recentOrderLabel.setBounds(70, 263, 183, 46);
        homeTab.add(recentOrderLabel);

        JLabel pendingRequestsLabel = new JLabel("PENDING REQUESTS");
        pendingRequestsLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
        pendingRequestsLabel.setBounds(70, 37, 230, 30);
        homeTab.add(pendingRequestsLabel);

        JLabel netRevenueLabel = new JLabel("IN QUEUE");
        netRevenueLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
        netRevenueLabel.setBounds(390, 37, 230, 30);
        homeTab.add(netRevenueLabel);

        JLabel lblNetRevenue = new JLabel("NET REVENUE");
        lblNetRevenue.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
        lblNetRevenue.setBounds(710, 37, 255, 30);
        homeTab.add(lblNetRevenue);

        JPanel deliveryTab = new JPanel();
        homeTabbedPane.addTab("DELIVERY", null, deliveryTab, null);
        JTable deliveryQueueTable = new JTable(data, column);
        deliveryQueueTable.setModel(new DefaultTableModel(
                new String[][]{
                },
                new String[]{
                        "Print ID", "User ID", "Name", "Room no", "Phone no", "Bill Status"
                }
        ));

        deliveryQueueTable.setFillsViewportHeight(true);
        JScrollPane scrollPaneDelQueue = new JScrollPane(deliveryQueueTable);
        scrollPaneDelQueue.setBounds(120, 120, 800, 264);
        scrollPaneDelQueue.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JLabel statusLabel = new JLabel("UPDATE STATUS");
        statusLabel.setBounds(120, 450, 170, 30);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        JLabel print_idLabel = new JLabel("Print ID :");
        print_idLabel.setBounds(222, 493, 84, 50);
        print_idLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        JTextField print_idText = new JTextField();
        print_idText.setFont(new Font("Arial", Font.PLAIN, 16));
        print_idText.setBounds(316, 503, 110, 30);
        JButton updateStatusButton = new JButton("UPDATE");
        updateStatusButton.setBounds(422, 578, 95, 36);
        updateStatusButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        deliveryTab.setLayout(null);

        deliveryTab.add(scrollPaneDelQueue);
        deliveryTab.add(statusLabel);
        deliveryTab.add(print_idLabel);
        deliveryTab.add(print_idText);
        deliveryTab.add(updateStatusButton);
        ((JComponent) deliveryTab).setBorder(titledBorder1);

        JComboBox comboBox_1 = new JComboBox(new String[]{"NOT DELIVERED", "DELIVERED"});
        comboBox_1.setBounds(544, 504, 150, 30);
        comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        //        comboBox_1.setModel(new DefaultComboBoxModel());
        deliveryTab.add(comboBox_1);

        JLabel print_idLabel_1 = new JLabel("Status :");
        print_idLabel_1.setBounds(464, 493, 84, 50);
        print_idLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        deliveryTab.add(print_idLabel_1);


        JPanel manageTab = new JPanel();
        homeTabbedPane.addTab("MANAGE", null, manageTab, null);
        manageTab.setLayout(null);

        JPanel addUserPanel = new JPanel();
        addUserPanel.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.gray, 2), "ADD STAFF", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 24)));
        addUserPanel.setBounds(105, 28, 787, 615);
        manageTab.add(addUserPanel);
        addUserPanel.setLayout(null);

        JLabel staffNameLabel = new JLabel("Name :");
        staffNameLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        staffNameLabel.setBounds(218, 80, 150, 40);
        addUserPanel.add(staffNameLabel);

        staffNameText = new JTextField();
        staffNameText.setFont(new Font("Arial", Font.PLAIN, 16));
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

        staffTypeCB = new JComboBox(new String[]{"DELIVERY BOY", "CLERK"});
        staffTypeCB.setBounds(2, 2, 146, 36);
        comboBorderPanel.add(staffTypeCB);
        staffTypeCB.setFont(new Font("Arial", Font.PLAIN, 16));
        //        staffTypeCB.setModel(new DefaultComboBoxModel());


        JLabel emailLabel = new JLabel("Email ID : ");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        emailLabel.setBounds(218, 153, 150, 40);
        addUserPanel.add(emailLabel);

        emailText = new JTextField();
        emailText.setFont(new Font("Arial", Font.PLAIN, 16));
        emailText.setColumns(10);
        emailText.setBounds(386, 158, 150, 40);
        addUserPanel.add(emailText);

        JLabel staffPhNoLabel = new JLabel("Phone No :");
        staffPhNoLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        staffPhNoLabel.setBounds(218, 313, 150, 40);
        addUserPanel.add(staffPhNoLabel);

        JLabel staffDateLabel = new JLabel("Username :");
        staffDateLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        staffDateLabel.setBounds(218, 392, 150, 40);
        addUserPanel.add(staffDateLabel);

        JLabel staffpassLabel = new JLabel("Password :");
        staffpassLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        staffpassLabel.setBounds(218, 471, 150, 40);
        addUserPanel.add(staffpassLabel);

        staffPhNoText = new JTextField();
        staffPhNoText.setFont(new Font("Arial", Font.PLAIN, 16));
        staffPhNoText.setColumns(10);
        staffPhNoText.setBounds(386, 313, 150, 40);
        addUserPanel.add(staffPhNoText);

        staffDateText = new JTextField();
        staffDateText.setFont(new Font("Arial", Font.PLAIN, 16));
        staffDateText.setColumns(10);
        staffDateText.setBounds(386, 392, 150, 40);
        addUserPanel.add(staffDateText);

        staffpassText = new JTextField();
        staffpassText.setFont(new Font("Arial", Font.PLAIN, 16));
        staffpassText.setColumns(10);
        staffpassText.setBounds(386, 471, 150, 40);
        addUserPanel.add(staffpassText);

        JButton staffSubmitButton = new JButton("SUBMIT");
        staffSubmitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        staffSubmitButton.setBounds(318, 520, 150, 50);
        addUserPanel.add(staffSubmitButton);
        staffSubmitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("SUBMIT")) {

            String name = staffNameText.getText();
            String mail = emailText.getText();
            String phone = staffPhNoText.getText();
            String value = staffTypeCB.getItemAt(staffTypeCB.getSelectedIndex()).toString();
            String username = staffDateText.getText();
            String pass = staffpassText.getText();

            try {
                user.staff(name, mail, phone, username, pass);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
