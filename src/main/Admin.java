package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Random;

public class Admin extends Staff {

    private boolean resourcesStatus;

    public void addUser(String name, String email, String no, String username, String pass) {

        Connection connection;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");

            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            Random random = new Random();
            int id = random.nextInt(1000);
            String s_id;
            if (username.substring(0, 3) == "CLK") s_id = "CLK" + id;
            else s_id = "DEL" + id;

            String user_type;
            if (username.substring(0, 3) == "CLK") user_type = "Clerk";
            else user_type = "Delivery";

                PreparedStatement ps1 = connection.prepareStatement("insert into login values(?,?);");
                ps1.setString(1, username);
                ps1.setString(2, pass);
                ps1.executeUpdate();

                PreparedStatement ps2 = connection.prepareStatement("INSERT INTO staff values(?, ?, ?, ?, ?, ?, ?);");
                ps2.setString(1, s_id);
                ps2.setString(2, name);
                ps2.setInt(3, Integer.parseInt(no));
                ps2.setString(4, user_type);
                ps2.setString(5, email);
                ps2.setDate(6, sqlDate);
                ps2.setString(7, username);
                ps2.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void deleteUser() {

    }

    public void viewPaymentDetails() {

    }

    public void viewDeliveryQueue() {

    }

    public void checkStatus() {

    }


}
