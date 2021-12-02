import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class AdminPage extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField textField;
    private JTable table_1;
    private JTable table_2;
    private JTable table_3;

    /**
     * Launch the application.
     */
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

    /**
     * Create the frame.
     */
    public AdminPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 75, 1250, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(191, -29, 1057, 697);
        contentPane.add(tabbedPane);

        JPanel homeTab = new JPanel();
        tabbedPane.addTab("HOME", null, homeTab, null);
        homeTab.setLayout(null);

        JPanel searchTab = new JPanel();
        tabbedPane.addTab("SEARCH", null, searchTab, null);
        searchTab.setLayout(null);

        JPanel panel_4 = new JPanel();
        panel_4.setBounds(10, 10, 1022, 60);
        searchTab.add(panel_4);
        panel_4.setLayout(null);

        JLabel lblNewLabel_3 = new JLabel("User ID :");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_3.setBounds(50, 10, 81, 40);
        panel_4.add(lblNewLabel_3);

        textField = new JTextField();
        textField.setBounds(150, 10, 130, 40);
        panel_4.add(textField);
        textField.setColumns(10);

        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Orders", "Requests", "Payment"}));
        comboBox.setSelectedIndex(0);
        comboBox.setBounds(400, 10, 120, 40);
        panel_4.add(comboBox);

        JLabel lblNewLabel_3_1 = new JLabel("Type :");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_3_1.setBounds(336, 10, 81, 40);
        panel_4.add(lblNewLabel_3_1);

        JButton btnNewButton = new JButton("SEARCH");
        btnNewButton.setFont(new Font("Arial", Font.PLAIN, 18));
        btnNewButton.setBounds(850, 10, 120, 40);
        panel_4.add(btnNewButton);

        JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.RIGHT);
        tabbedPane_1.setBounds(10, 80, 1022, 577);
        searchTab.add(tabbedPane_1);

        JPanel panel_5 = new JPanel();
        tabbedPane_1.addTab("Request", null, panel_5, null);
        panel_5.setLayout(null);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 10, 942, 552);
        panel_5.add(scrollPane_1);

        table_3 = new JTable();
        scrollPane_1.setViewportView(table_3);
        table_3.setModel(new DefaultTableModel(
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
        table_3.getColumnModel().getColumn(0).setResizable(false);
        table_3.getColumnModel().getColumn(1).setResizable(false);
        table_3.getColumnModel().getColumn(2).setResizable(false);
        table_3.getColumnModel().getColumn(3).setResizable(false);
        table_3.getColumnModel().getColumn(4).setResizable(false);
        table_3.getColumnModel().getColumn(5).setResizable(false);
        table_3.setFillsViewportHeight(true);

        JPanel panel_6 = new JPanel();
        tabbedPane_1.addTab("Payment", null, panel_6, null);
        panel_6.setLayout(null);

        table_2 = new JTable();
        table_2.setBounds(10, 10, 942, 552);
        panel_6.add(table_2);

        JPanel panel_3 = new JPanel();
        tabbedPane_1.addTab("Order", null, panel_3, null);
        tabbedPane_1.setEnabledAt(2, true);
        panel_3.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 10, 942, 552);
        panel_3.add(scrollPane);

        table_1 = new JTable();
        table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table_1.setFillsViewportHeight(true);
        scrollPane.setViewportView(table_1);
        table_1.setModel(new DefaultTableModel(
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
        table_1.getColumnModel().getColumn(0).setResizable(false);
        table_1.setBorder(new LineBorder(new Color(0, 0, 0)));

        DefaultTableCellRenderer Renderer = new DefaultTableCellRenderer();
        Renderer.setHorizontalAlignment(JLabel.CENTER);
        table_1.getColumnModel().getColumn(1).setCellRenderer(Renderer);

        JPanel printerTab = new JPanel();
        tabbedPane.addTab("PRINTER", null, printerTab, null);

        JPanel deliveryTab = new JPanel();
        tabbedPane.addTab("DELIVERY", null, deliveryTab, null);
        
        
        String[] column = { "Print ID", "User ID", "Name", "Room no", "Phone no", "Bill Status" }; 
        String[][] data = {{ "", "", "", "", "", "" }, { "", "", "", "", "", "" }};
        JTable table = new JTable(data, column);
        JScrollPane sp = new JScrollPane(table);

        JLabel status = new JLabel("UPDATE STATUS");
        JLabel id = new JLabel("Print ID");
        JTextField statusTextField=new JTextField();
        JButton submit = new JButton("Update status to DELIVERED");
        
        sp.setBounds(120,120,800,80);
        status.setBounds(240,260,150,30);
        id.setBounds(370,320,100,30);
        statusTextField.setBounds(520,325,100,20);
        submit.setBounds(390,400,200,20);
        
        deliveryTab.add(sp);
        deliveryTab.add(status);
        deliveryTab.add(id);
        deliveryTab.add(statusTextField);
        deliveryTab.add(submit);
        
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray,3),"DELIVERY QUEUE", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Serif", Font.PLAIN, 18));
        ((JComponent) deliveryTab).setBorder(titledBorder);
        
        deliveryTab.setLayout(null);
        JPanel manageTab = new JPanel();
        
        tabbedPane.addTab("MANAGE", null, manageTab, null);


        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(0, 0, 0)));
        panel.setBounds(70, 34, 250, 175);
        homeTab.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("10");
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 56));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(90, 50, 150, 90);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(0, 0, 0)));
        panel_1.setBackground(Color.LIGHT_GRAY);
        panel_1.setBounds(390, 34, 250, 175);
        homeTab.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("10");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 56));
        lblNewLabel_1.setBounds(90, 50, 150, 90);
        panel_1.add(lblNewLabel_1);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(0, 0, 0)));
        panel_2.setBackground(Color.LIGHT_GRAY);
        panel_2.setBounds(710, 34, 250, 175);
        homeTab.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("10");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 56));
        lblNewLabel_2.setBounds(90, 50, 147, 90);
        panel_2.add(lblNewLabel_2);


        String[] column6 = {"Employee ID","Name", "Amount", "Room no.", "Phone no."};
        table = new JTable();
        table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        table.setBackground(new Color(128, 128, 128));
        table.setBounds(907, 296, -836, 142);
        homeTab.add(table);

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
                tabbedPane.setSelectedIndex(0);
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
                tabbedPane.setSelectedIndex(1);
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
                tabbedPane.setSelectedIndex(2);
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
                tabbedPane.setSelectedIndex(3);
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
                tabbedPane.setSelectedIndex(4);
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
