package main;

import java.sql.*;

public class Clerk extends Staff {

    private String date_joined;
    private int approvedRequests;
    private int rejectedRequests;

    public boolean checkStaffEligility() {
        return true;
    }

    public void verifyPrintouts(String print_id) {
        Connection connection;
        Statement statement1;
        Statement statement2;
        PreparedStatement preparedStatement1;
        PreparedStatement preparedStatement2;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");

            preparedStatement1 = connection.prepareStatement("update request_details set status = 'Accepted' where print_id = ?");
            preparedStatement1.setString(1, print_id);

            preparedStatement2 = connection.prepareStatement("update print_details set status = 'queue' where print_id = ? ");
            preparedStatement2.setString(1, print_id);

            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();

            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
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
