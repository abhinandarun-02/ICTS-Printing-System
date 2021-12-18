package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Person implements Login {

    public Person() {
    }

    public Person(String username) {
        this.username = username;
    }

    private String name;
    private String username;
    private String person_id;
    private String email_id;
    private String phoneNO;
    private String address;
    private String print_id;
    public String status;


    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPerson_id() {
        return person_id;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNO() {
        return phoneNO;
    }
    public String status(){
        return print_id;
    }


    public void setName(String username) {
        try {
            Connection connection = getConnection();
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

    public void setPerson_id(String username) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select Employee_id from(select username,Employee_id from Employee union select username,staff_id from staff) as uEiusi where username=?;");
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                this.person_id = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAddress(String username) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT room_no FROM employee WHERE username = ?;");
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                this.address = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setPhoneNO(String phoneNO) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT phone_no FROM employee WHERE username = ?;");
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                this.phoneNO = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String setstatus(String print_id) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select status from request_details where print_id=?;");
            preparedStatement.setString(1, print_id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean verifyUser(String user, String pass) {
        try {
            Connection connection = getConnection();
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

    @Override
    public Connection getConnection() {

        String url = "jdbc:postgresql://localhost:5432/printing-system";
        String username = "root";
        String password = "root";
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void sendRequest(String print_id, String username, String phone_no, String paper_type, String page_type, String colour_type, String status) {

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());


        try {

            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO request_details (print_id, employee_id, name, phone_no, room_no, paper_type, page_type, colour_type, status, date, time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, print_id);
            preparedStatement.setString(2, this.getPerson_id());
            preparedStatement.setString(3, this.getName());
            preparedStatement.setLong(4, Long.parseLong(this.getPhoneNO()));
            preparedStatement.setString(5, this.getAddress());
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

    public void sendRequest(String print_id, String priority, String colour_type, int no_of_pages, int no_of_copies) {

        int cost_per_page = colour_type.equals("Grayscale") ? Printer.getCostPerBw() : Printer.getCostPerColour();
        int total_cost = cost_per_page * no_of_pages * no_of_copies;

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO  print_details (print_id, status, employee_id, priority, date, time, cost_per_pg, no_of_pages, no_of_copies, total_cost) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, print_id);
            preparedStatement.setString(2, "Pending");
            preparedStatement.setString(3, this.getPerson_id());
            preparedStatement.setString(4, priority);
            preparedStatement.setDate(5, null);
            preparedStatement.setTime(6, null);
            preparedStatement.setInt(7, cost_per_page);
            preparedStatement.setInt(8, no_of_pages);
            preparedStatement.setInt(9, no_of_copies);
            preparedStatement.setInt(10, total_cost);

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public double viewAmount(String emp_id) {
        ResultSet rs = null;


        try {
            Connection connection = getConnection();
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
            Connection connection = getConnection();
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
            Connection connection = getConnection();
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

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }


}
