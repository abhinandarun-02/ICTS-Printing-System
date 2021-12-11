package GUI;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Status extends JFrame implements ActionListener {

    JPanel panel = (JPanel) getContentPane();

    JLabel id;
    JTextField idTextField;
    JButton submit;

    JLabel status;
    JTextField statusTextField;

    Status() {

        id = new JLabel("Request ID");
        idTextField = new JTextField();
        submit = new JButton("SUBMIT");
        status = new JLabel("Status of Print:  ");
        statusTextField = new JTextField();

        //Calling methods inside constructor.
        setLayoutManager();
        setLocationAndSize();
        setFont();
        addComponentsToContainer();
        setTitle("Status");
        setBounds(450, 75, 600, 450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);

    }

    public void setLayoutManager() {
        panel.setLayout(null);
    }

    public void setLocationAndSize() {
        //Setting location and Size of each component using setBounds() method.

        id.setBounds(150, 100, 100, 30);
        idTextField.setBounds(300, 100, 100, 20);
        submit.setBounds(230, 160, 100, 20);

        status.setBounds(120, 260, 200, 30);
        statusTextField.setBounds(280, 260, 150, 20);
        statusTextField.setEditable(false);
    }

    public void setFont() {
        id.setFont(new Font("Calibri", Font.PLAIN, 16));
        status.setFont(new Font("Calibri", Font.PLAIN, 16));
    }

    public void addComponentsToContainer() {
        //Adding each component to the Container

        panel.add(id);
        panel.add(idTextField);
        panel.add(submit);

        panel.add(status);
        panel.add(statusTextField);


        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 3), "CHECK STATUS", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Serif", Font.PLAIN, 18));
        panel.setBorder(titledBorder);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Status();
    }
}


