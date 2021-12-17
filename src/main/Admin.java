package main;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Admin extends Staff {

    private boolean resourcesStatus;
    private Connection connection;
    
    
    
    public boolean getNotification()
    {
    	ResultSet rs = null;
    	try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
        } catch (SQLException | ClassNotFoundException e) {
            
            e.printStackTrace();
        }
    	try {
   		 Statement s = connection.createStatement();
   		 String query ="SELECT availability FROM resource_details; ";
   		 rs = s.executeQuery(query);
            while(rs.next())
            {
           	 return(rs.getBoolean("availability"));
            }
            
   	 }
   	 catch(SQLException e){
   		 e.printStackTrace();
   	 }
    	return false;
    }
    
    
    public void updateResources()
    {
    	try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
        } catch (SQLException | ClassNotFoundException e) {
            
            e.printStackTrace();
        }
    	try {
    		Statement s = connection.createStatement();
    		String query ="UPDATE resource_details SET availability='true';";
    		s.executeUpdate(query);
    		
    		
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    

    public void addUser() {

    }

    public void deleteUser() {

    }

    public void viewPaymentDetails() {

    }

    public void viewDeliveryQueue() {

    }

    public void checkStatus() {

    }


}
