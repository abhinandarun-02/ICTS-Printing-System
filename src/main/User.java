package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User implements Login {

    private String name;
    private String person_id;
    private String email_id;
    private String phoneNO;
    private String address;


    public User() {

    }

    public User(String username) {

        Connection connection = getConnection();

        try {
            PreparedStatement preparedStatement1 = connection.prepareStatement("select employee_name from(select username,employee_name from Employee union select username,staff_name from staff) as uEiusi where username=?;");
            preparedStatement1.setString(1, username);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            if (resultSet1.next()) this.name = resultSet1.getString(1);

            PreparedStatement preparedStatement2 = connection.prepareStatement("select Employee_id from(select username,Employee_id from Employee union select username,staff_id from staff) as uEiusi where username=?;");
            preparedStatement2.setString(1, username);
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            if (resultSet2.next()) this.person_id = resultSet2.getString(1);

            if(getUser_Id(username).startsWith("EMP")){
                PreparedStatement preparedStatement3 = connection.prepareStatement("SELECT room_no FROM employee WHERE username = ?;");
                preparedStatement3.setString(1, username);
                ResultSet resultSet3 = preparedStatement3.executeQuery();
                if (resultSet3.next()) this.address = resultSet3.getString(1);
            }
            else{
                this.address = "Office";
            }

            PreparedStatement preparedStatement4 = connection.prepareStatement("select phone_no from(select username,phone_no from Employee union select username, phone_no from staff) as uEiusi where username=?;");
            preparedStatement4.setString(1, username);
            ResultSet resultSet4 = preparedStatement4.executeQuery();
            if (resultSet4.next()) this.phoneNO = resultSet4.getString(1);

            PreparedStatement preparedStatement5 = connection.prepareStatement("select email_id from(select username,email_id from Employee union select username, email_id from staff) as uEiusi where username=?;");
            preparedStatement5.setString(1, username);
            ResultSet resultSet5 = preparedStatement5.executeQuery();
            if (resultSet5.next()) this.email_id = resultSet5.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    @Override
    public boolean verifyUser(String user, String pass) {

        Connection connection = getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT username, password FROM LOGIN WHERE username = ? AND password=?;");
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);

            ResultSet resultSet = preparedStatement.executeQuery();
            //returns true/false if given credentials exist
            return resultSet.next();

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





    public String checkStatus(String print_id) {
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

    public void sendRequest(String print_id, String username, String paper_type, String page_type, String colour_type, String status) {

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO request_details (print_id, employee_id, name, phone_no, room_no, paper_type, page_type, colour_type, status, date, time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, print_id);
            preparedStatement.setString(2, this.person_id);
            preparedStatement.setString(3, this.name);
            preparedStatement.setLong(4, Long.parseLong(phoneNO));
            preparedStatement.setString(5, this.address);
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
            preparedStatement.setString(3, this.person_id);
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
        ResultSet rs;
        try {
            Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT amount FROM EMPLOYEE WHERE employee_id= '" + emp_id + "';";
            rs = stmt.executeQuery(query);
            if (rs.next()) {
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
            if (rs.next()) {
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

            if (resultSet.next()) return resultSet.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


public void getDeliveryQueue()
{
    try {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select print_id, employee_id, name, room_no, phone_no, status from request_details where status='Out for delivery';");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next())  
            System.out.print(resultSet.getString(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public void updateDeliveryStatus(String id)
{
    try {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update request_details set status='Delivered' where print_id = ?;");
        preparedStatement.setString(1, id);
        preparedStatement.executeQuery();
        
    }
     catch (SQLException e) {
        e.printStackTrace();
    }
}
}