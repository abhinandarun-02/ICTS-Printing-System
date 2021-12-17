package main;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Clerk extends Staff {

    private String date_joined;
    private int approvedRequests;
    private int rejectedRequests;
    private Connection connection;
    
    public void setNotification()
    {
    	try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
        } catch (SQLException | ClassNotFoundException e) {
            
            e.printStackTrace();
        }
    	try {
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

    public void verifyPrintouts() {

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
