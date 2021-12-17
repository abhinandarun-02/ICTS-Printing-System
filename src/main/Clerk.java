package main;

import java.sql.*;

public class Clerk extends Staff {

    private String date_joined;
    private int approvedRequests;
    private int rejectedRequests;


    public void setNotification()
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
    


    public boolean checkStaffEligility() {
        return true;
    }

    public void verifyPrintouts(String print_id) {


        try {
            Connection connection = getConnection();

            PreparedStatement preparedStatement1 = connection.prepareStatement("update request_details set status = 'Accepted' where print_id = ?");
            preparedStatement1.setString(1, print_id);

            PreparedStatement preparedStatement2 = connection.prepareStatement("update print_details set status = 'queue' where print_id = ? ");
            preparedStatement2.setString(1, print_id);

            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void generateBill() {

    }

    public void pushToQueue() {

    }

    public void getPrintQueue() {

    }

    public void checkDeliveryQueue() {

    }

    public void checkStatus() {

    }


}
