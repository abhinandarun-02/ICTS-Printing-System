package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeliveryPerson extends Person {

    private String deliveryCompleted;
    private String deliveryPending;

    public ResultSet checkDeliveryQueue() {
        ResultSet rs = null;
        try {
            Connection connection = getConnection();
            Statement st = connection.createStatement();
            String query = "select print_id, employee_id, status from print_details where status = 'To be Delivered'";
            rs = st.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void updateDeliveryStatus(String print_id) {
        Connection connection = getConnection();
        Statement st = null;
        try {
            st = connection.createStatement();
            String qeury = "update print_details set status = 'Delivered' where print_id = '" + print_id + "'";
            st.executeUpdate(qeury);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
