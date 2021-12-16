package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

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

    public String setAddress(String username) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT room_no FROM employee WHERE username = ?;");
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                this.address = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String geetRoomNO() {
        return address;
    }

    public String getPhoneNO() {
        return phoneNO;
    }

    public String getDob() {
        return dob;
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

    public void sendRequest(String print_id, String username, String phone_no, String paper_type, String page_type, String colour_type, String status) {

        /* TODO */
        //    int print_id = 12;
//        String room_no = "001";

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {

            setName(username);
            setAddress(username);

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO request_details (print_id, employee_id, name, phone_no, room_no, paper_type, page_type, colour_type, status, date, time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, print_id);
            preparedStatement.setString(2, "EMP001");
            preparedStatement.setString(3, this.getName());
            preparedStatement.setInt(4, Integer.parseInt(phone_no));
            preparedStatement.setString(5, this.geetRoomNO());
            preparedStatement.setString(6, paper_type);
            preparedStatement.setString(7, page_type);
            preparedStatement.setString(8, colour_type);
            preparedStatement.setString(9, status);

            preparedStatement.setDate(10, sqlDate);
            preparedStatement.setTime(11, sqlTime);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public double viewAmount(String emp_id) {
        ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT amount FROM EMPLOYEE WHERE employee_id= '" + emp_id + "';";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                return (rs.getDouble("amount"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public double viewCredit(String emp_id) {
        ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT credits FROM EMPLOYEE WHERE employee_id= '" + emp_id + "';";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                return (rs.getDouble("credits"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }


    public String getUser_Id(String username) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select Employee_id from(select username,Employee_id from Employee union select username,staff_id from staff) as uEiusi where username=?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void staff(String name, String email, String no, String username, String pass) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();
        }

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        Random random = new Random();
        int id = random.nextInt(1000);
        String s_id;
        if (username.substring(0, 3) == "CLK")
            s_id = "CLK" + id;
        else
            s_id = "DEL" + id;

        String user_type;
        if (username.substring(0, 3) == "CLK")
            user_type = "Clerk";
        else
            user_type = "Delivery";


        try {

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
}
