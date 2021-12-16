package GUI;

import main.Clerk;
import main.Staff;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ClerksPage extends JFrame implements ActionListener {


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
    JTextField printer_id_tf;
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

    DefaultTableModel requestModel;
    DefaultTableModel queueModel;
    JTable pendingRequests;
    JTable printerQueue;

    Staff user;
    Clerk clerk;


    public ClerksPage() {

        user = new Clerk();
        clerk = new Clerk();

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
        NextButton.addActionListener(e -> tabbedPane.setSelectedIndex(1));

        requestModel = new DefaultTableModel();
        pendingRequests = new JTable(requestModel);

        queueModel = new DefaultTableModel();
        printerQueue = new JTable(queueModel);

        pendingRequests.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String print_id = requestModel.getValueAt(pendingRequests.getSelectedRow(), 0).toString();
                printer_id_tf.setText(print_id);
            }
        });

        requestModel.addColumn("Print ID");
        requestModel.addColumn("Name");
        requestModel.addColumn("Employee ID");
        requestModel.addColumn("Page Type");
        requestModel.addColumn("Paper Type");
        requestModel.addColumn("Colour Type");
        requestModel.addColumn("Date");

        JScrollPane sp1 = new JScrollPane(pendingRequests, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        pendingRequests.setDefaultRenderer(String.class, centerRenderer);
        printerQueue.setDefaultRenderer(String.class, centerRenderer);

        //Populating values inside JTable
        this.loadRequestTable();

        //Aligning table values
        for (int x = 0; x < pendingRequests.getColumnCount(); x++) {
            pendingRequests.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
        }

        queueModel.addColumn("Print ID");
        queueModel.addColumn("Employee ID");
        queueModel.addColumn("Paper Type");
        queueModel.addColumn("Colour Type");
        queueModel.addColumn("Page Type");
        queueModel.addColumn("No of Pages");
        queueModel.addColumn("No of Copies");

        this.loadPrintTable();

        for (int x = 0; x < printerQueue.getColumnCount(); x++) {
            printerQueue.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
        }

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
        AddButton.setBounds(1000, 402, 200, 40);
        DeleteButton.setBounds(1000, 475, 200, 40);
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

        PrevButton.addActionListener(e -> tabbedPane.setSelectedIndex(0));

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
        panel.setBounds(1000, 152, 200, 130);
        ClerkPanel1.add(panel);
        panel.setLayout(null);

        acceptButton = new JRadioButton("Accept");
        acceptButton.setActionCommand("Accept");
        acceptButton.setHorizontalAlignment(SwingConstants.CENTER);
        acceptButton.setSelected(true);
        acceptButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        acceptButton.setBounds(0, 30, 99, 20);
        panel.add(acceptButton);

        rejectButton = new JRadioButton("Reject");
        rejectButton.setActionCommand("Reject");
        rejectButton.setHorizontalAlignment(SwingConstants.CENTER);
        rejectButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        rejectButton.setBounds(101, 30, 93, 20);
        panel.add(rejectButton);

        buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(acceptButton);
        buttonGroup1.add(rejectButton);

        JButton requestSubmitButton = new JButton("Submit");
        requestSubmitButton.addActionListener(this);

        requestSubmitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        requestSubmitButton.setBounds(0, 83, 200, 37);
        panel.add(requestSubmitButton);

        printer_id_tf = new JTextField();
        printer_id_tf.setHorizontalAlignment(SwingConstants.CENTER);
        printer_id_tf.setFont(new Font("SansSerif", Font.PLAIN, 18));
        printer_id_tf.setEditable(false);
        printer_id_tf.setBounds(1104, 101, 96, 30);
        ClerkPanel1.add(printer_id_tf);
        printer_id_tf.setColumns(10);

        JLabel lblNewLabel = new JLabel("Print ID :");
        lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        lblNewLabel.setBounds(1000, 102, 80, 30);
        ClerkPanel1.add(lblNewLabel);
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
        notifyButton.addActionListener(e -> JOptionPane.showConfirmDialog(requestSubmitButton, "Are You Sure?", "CONFIRM", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
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

    public void loadRequestTable() {

        int i = 0;
        ResultSet rs = user.getRequestTable();

        try {
            while (rs.next()) {
                requestModel.insertRow(i, new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)});
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void loadPrintTable() {

        int i = 0;
        ResultSet rs = user.getPrintTable();
        System.out.println(queueModel.getColumnCount());
        try {
            while (rs.next()) {
                queueModel.insertRow(i, new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)});
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ClerksPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Submit")) {
            if (buttonGroup1.getSelection().getActionCommand().equals("Accept")) {
                String print_id = printer_id_tf.getText();

                if (!print_id.equals("")) {
                    clerk.verifyPrintouts(print_id);
                    printer_id_tf.setText("");
                    requestModel.removeRow(pendingRequests.getSelectedRow());
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please Select a Row", "TRY AGAIN", JOptionPane.ERROR_MESSAGE);

                }
            }
            /*TODO*/
//            else {
//            }
        }
    }
}