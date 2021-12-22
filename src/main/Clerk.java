package main;

import java.sql.*;

public class Clerk extends Staff {

    private String date_joined;
    private int approvedRequests;
    private int rejectedRequests;


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

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
