package main;

import java.sql.*;

public class Clerk extends Staff {

    private String date_joined;
    private int approvedRequests;
    private int rejectedRequests;

    public Clerk(String username) {
        super(username);
    }


    public void alertAdmin()
    {
    	try {
            Connection connection = getConnection();
    		Statement s = connection.createStatement();
    		String query ="UPDATE resource_details SET availability='false';";
    		s.executeUpdate(query);
    		
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    public void verifyPrintouts(String print_id, String status) {


        try {
            Connection connection = getConnection();

            PreparedStatement preparedStatement1 = connection.prepareStatement("update request_details set status = ? where print_id = ?");
            PreparedStatement preparedStatement2 = connection.prepareStatement("update print_details set status = ? where print_id = ? ");

            preparedStatement1.setString(1, status);

            if (status.equals("Accepted")) {
                preparedStatement2.setString(1, "queue");
            }
            else {
                preparedStatement2.setString(1, status);
            }

            preparedStatement1.setString(2, print_id);
            preparedStatement2.setString(2, print_id);

            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    

    public void saveData(String print_id, String clerk_id) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO log_details (employee_id, print_id, clerk_id, delivery_status) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, getEmployeeID(print_id));
            preparedStatement.setString(2, print_id);
            preparedStatement.setString(3, clerk_id);
            preparedStatement.setString(4, "To be Delivered");

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getEmployeeID(String print_id) {
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT employee_id FROM print_details WHERE print_id = ?;");
            preparedStatement.setString(1, print_id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
            return resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  "";
    }


    public void generateBill(String print_id, int cost_per_page, int no_of_pages, int no_of_copies) {
        Connection connection = getConnection();
        int total_cost = cost_per_page * no_of_pages * no_of_copies;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE print_details SET cost_per_pg = ?, no_of_pages = ?, no_of_copies = ?, total_cost = ?, status = 'Print Completed' WHERE print_id = ?;");
            preparedStatement.setInt(1, cost_per_page);
            preparedStatement.setInt(2, no_of_pages);
            preparedStatement.setInt(3, no_of_copies);
            preparedStatement.setInt(4, total_cost);
            preparedStatement.setString(5, print_id);

            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());
            PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE print_details SET date = ?, time = ? WHERE  print_id = ?;");
            preparedStatement1.setDate(1, sqlDate);
            preparedStatement1.setTime(2, sqlTime);
            preparedStatement1.setString(3, print_id);

            preparedStatement.executeUpdate();
            preparedStatement1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
