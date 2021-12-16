package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee extends Person {

    private String roomNo;
    private String department;
    
    private Connection connection;
    
    public int usageCount;
    public int requestCount;
    public int pendingCash;

    public String getRoomNo() {
        return roomNo;
    }

    public double viewAmount(String emp_id)
    {
    	ResultSet rs =null;
    	 try {
             Class.forName("org.postgresql.Driver");
             connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
         } 
    	 catch (SQLException | ClassNotFoundException e) {
             e.printStackTrace();
         }
    	 try {
    		 Statement s = connection.createStatement();
    		 String query = "SELECT amount FROM EMPLOYEE WHERE employee_id= '"+ emp_id+ "';";
    		 rs = s.executeQuery(query);
             while(rs.next())
             {
            	 return(rs.getDouble("amount"));
             }
             
    	 }
    	 catch(SQLException e){
    		 e.printStackTrace();
    	 }
    	 return -1;    	
    }
    
    public double viewCredit(String emp_id)
    {
    	ResultSet rs =null;
    	 try {
             Class.forName("org.postgresql.Driver");
             connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
         } 
    	 catch (SQLException | ClassNotFoundException e) {
             e.printStackTrace();
         }
    	 try {
    		 Statement s = connection.createStatement();
    		 String query = "SELECT credits FROM EMPLOYEE WHERE employee_id= '"+ emp_id+ "';";
    		 rs = s.executeQuery(query);
             while(rs.next())
             {
            	 return(rs.getDouble("credits"));
             }
             
    	 }
    	 catch(SQLException e){
    		 e.printStackTrace();
    	 }
    	 return -1;    	
    }
    

    public void payBill() {

    }

    public void requestPrint() {

    }

    public void checkStatus() {

    }

    public void viewPrintHistory() {

    }

    public void deleteRequest() {

    }
}
