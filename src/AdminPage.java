import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;


public class AdminPage extends JFrame {

    private JPanel contentPane;


    public AdminPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 75, 1250, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(190, 10, 1047, 653);
        contentPane.add(tabbedPane);

        JPanel homeTab = new JPanel();
        tabbedPane.addTab("HOME", null, homeTab, null);

        JPanel employeeTab = new JPanel();
        tabbedPane.addTab("EMPLOYEE", null, employeeTab, null);

        JPanel printerTab = new JPanel();
        tabbedPane.addTab("PRINTER", null, printerTab, null);

        JPanel deliveryTab = new JPanel();
        tabbedPane.addTab("DELIVERY", null, deliveryTab, null);

        JPanel manageTab = new JPanel();
        tabbedPane.addTab("MANAGE", null, manageTab, null);

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

        JPanel employeeButtonPanel = new JPanel();
        employeeButtonPanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        employeeButtonPanel.setBackground(Color.LIGHT_GRAY);
        employeeButtonPanel.setBounds(10, 0, 171, 60);
        tabPanel.add(employeeButtonPanel);
        employeeButtonPanel.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel employeeLabel = new JLabel("EMPLOYEE");
        employeeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tabbedPane.setSelectedIndex(1);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                employeeButtonPanel.setBackground(Color.darkGray);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                employeeButtonPanel.setBackground(Color.LIGHT_GRAY);
            }
        });
        employeeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        employeeButtonPanel.add(employeeLabel);

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
}
