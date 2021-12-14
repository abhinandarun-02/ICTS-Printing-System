package main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class Person implements Login {

    private String name;
    private String email_id;
    private String username;
    private String phoneNO;
    private String dob;
    private String address;

    private Connection connection;

    public void setName(String username) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT employee_name FROM employee WHERE username = ?;");
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                this.name = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    public void sendRequest(String username, String phone_no, String paper_type, String page_type, String colour_type, String status) {

        /* TODO */
        int print_id = 001;
        String room_no = "001";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            setName(username);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO request_details (print_id, employee_id, name, phone_no, room_no, paper_type, page_type, colour_type, status, date, time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setInt(1, print_id);
            preparedStatement.setString(2, "EMP001");
            preparedStatement.setString(3, this.getName());
            preparedStatement.setInt(4, Integer.parseInt(phone_no));
            preparedStatement.setString(5, room_no);
            preparedStatement.setString(6, paper_type);
            preparedStatement.setString(7, page_type);
            preparedStatement.setString(8, colour_type);
            preparedStatement.setString(9, status);
            /*TODO*/
            preparedStatement.setDate(10, Date.valueOf("2021-12-15"));
            preparedStatement.setTime(11, Time.valueOf("03:07:00"));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
