package main;

import java.sql.*;

public abstract class Staff extends User {

    public Staff(String username) {
        super(username);
    }


    public void updatePrinterStatus(String print_id, String status) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement;

            preparedStatement = connection.prepareStatement("UPDATE print_details SET status = ? WHERE print_id = ? ");
            preparedStatement.setString(1, status);
            preparedStatement.setString(2, print_id);
            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getRequestTable() {
        ResultSet rs = null;
        try {
            Connection connection = getConnection();
            Statement st = connection.createStatement();
            String query = "SELECT  print_id, name, employee_id, page_type, paper_type, colour_type, date FROM request_details WHERE status = 'Not Accepted';";
            rs = st.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet getPrintTable() {
        ResultSet rs = null;
        try {
            Connection connection = getConnection();
            Statement st = connection.createStatement();
            String query = "select p.print_id, p.employee_id, r.paper_type, r.colour_type, r.page_type, p.no_of_pages, p.no_of_copies, p.status from request_details r, print_details p where p.status in ('queue','Print Completed') and r.print_id = p.print_id and r.employee_id = p.employee_id;";
            rs = st.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet getDeliveryTable() {
        ResultSet rs = null;
        try {
            Connection connection = getConnection();
            Statement st = connection.createStatement();
            String query = "select print_id, employee_id, employee_name, room_no, phone_no, status, total_cost from employee natural join print_details pd where pd.status = 'To be Delivered';";
            rs = st.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

}
