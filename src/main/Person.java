package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Person implements Login {

    private String name;
    private String email_id;
    private String username;
    private String phoneNO;
    private String dob;
    private String address;

    private Connection connection;

    public String getName() {
        return name;
    }

    public String getPhoneNO() {
        return phoneNO;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean verifyUser(String user, String pass) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT username, password FROM LOGIN WHERE username = ? AND password=?;");
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); //returns true/false if given credentials exist

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
