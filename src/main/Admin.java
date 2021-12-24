package main;

import java.sql.*;
import java.util.Random;

public class Admin extends Staff {

    private boolean resourcesStatus;

    public Admin(String username) {
        super(username);
    }


    public boolean getNotification() {
        ResultSet rs = null;

        try {
            Connection connection = getConnection();
            Statement s = connection.createStatement();
            String query = "SELECT availability FROM resource_details; ";
            rs = s.executeQuery(query);
            while (rs.next()) {
                return (rs.getBoolean("availability"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void updateResources() {
        try {
            Connection connection = getConnection();
            Statement s = connection.createStatement();
            String query = "UPDATE resource_details SET availability='true';";
            s.executeUpdate(query);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addUser(String name, String email, String PhoneNo, String user_type, String username, String pass) {


        try {

            Connection connection = getConnection();
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            Random random = new Random();
            int id = random.nextInt(1000);
            
            String s_id;
            if (user_type.equals("CLERK")) s_id = "CLK" + id;
            else s_id = "DEL" + id;

            if (user_type.equals("CLERK")) user_type = "Clerk";
            else user_type = "Delivery";

            PreparedStatement ps1 = connection.prepareStatement("insert into login values(?,?);");
            ps1.setString(1, username);
            ps1.setString(2, pass);
            ps1.executeUpdate();

            PreparedStatement ps2 = connection.prepareStatement("INSERT INTO staff values(?, ?, ?, ?, ?, ?, ?);");
            ps2.setString(1, s_id);
            ps2.setString(2, name);
            ps2.setInt(3, Integer.parseInt(PhoneNo));
            ps2.setString(4, user_type);
            ps2.setString(5, email);
            ps2.setDate(6, sqlDate);
            ps2.setString(7, username);
            ps2.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int getNoOfPendingRequests() {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT count(print_id) FROM request_details WHERE status = 'Not Accepted'");
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public long getTotalRevenue() {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT sum(total_cost) FROM print_details");
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public void updateDeliveryStatus(String print_id, String status) {

        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE print_details set status = ? WHERE print_id = ?");
            preparedStatement.setString(1, status);
            preparedStatement.setString(2, print_id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet getRecentOrders() {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT p.print_id, e.employee_name,p.total_cost, p.date,l.clerk_id  FROM print_details p, log_details l, employee e where e.employee_id=l.employee_id AND l.employee_id=p.employee_id AND p.employee_id=e.employee_id;");
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*TODO
    public void getDeliveryQueue() {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT print_id, employee_id, status FROM print_details WHERE status = 'To be Delivered';");
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/

}
