package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee extends Person {

    private String department;

    /*TODO*/
//    private int usageCount;
//    private int requestCount;
//    private int pendingCash;

    public Employee() {

    }

    public Employee(String username) {
        super(username);
        Connection connection = getConnection();
        try {
            PreparedStatement preparedstatement1 = connection.prepareStatement("SELECT dept_name FROM employee WHERE username = ?");
            preparedstatement1.setString(1, username);
            ResultSet resultSet1 = preparedstatement1.executeQuery();
            if (resultSet1.next()) this.department = resultSet1.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String checkStatus(String print_id) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT status FROM print_details WHERE print_id=?;");
            preparedStatement.setString(1, print_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }


    public ResultSet viewPrintHistory() {
        ResultSet rs = null;
        try {
            Connection connection = getConnection();
            Statement st = connection.createStatement();
            String query = "SELECT print_details.print_id, request_details.date,request_details.time, print_details.priority, print_details.status, print_details.total_cost FROM print_details, request_details WHERE print_details.employee_id = 'EMP679' AND print_details.print_id = request_details.print_id ORDER BY date, time;";
            rs = st.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int deleteRequest(String username, String req_id) {

        String query0 = "select count(print_id) from print_details where print_id='" + req_id + "';";
        String query1 = "select employee_id from employee where username='" + username + "';";
        String query2 = "select employee_id from print_details where print_id='" + req_id + "';";
        String query4 = "select status from print_details where print_id='" + req_id + "';";
        String query5 = "update print_details set status ='Deleted' where print_id='" + req_id + "';";
        String emp_id = "/", emp_id2 = "/", status = "";
        int count = -1;
        try {
            Connection connection = getConnection();

            Statement stmt = connection.createStatement();
            ResultSet rsp = stmt.executeQuery(query0);
            while (rsp.next()) {
                count = rsp.getInt("count");
            }
            rsp.close();
            if (count == 1) {
                ResultSet rs = stmt.executeQuery(query1);
                while (rs.next()) {
                    emp_id = rs.getString("employee_id");
                }
                rs.close();
                ResultSet rs2 = stmt.executeQuery(query2);
                while (rs2.next()) {
                    emp_id2 = rs2.getString("employee_id");
                }
                rs2.close();
                if (emp_id.equals(emp_id2)) {
                    ResultSet rs3 = stmt.executeQuery(query4);
                    while (rs3.next()) {
                        status = rs3.getString("status");
                    }
                    rs3.close();
                    if (status.equals("Pending")) {
                        stmt.executeUpdate(query5);
                        return 1;
                    }
                    else
                        return 0;
                }
                else
                    return 2;
            }
            else
                return -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -2;
    }

}
