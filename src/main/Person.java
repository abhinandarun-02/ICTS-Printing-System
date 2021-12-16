package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Person implements Login {

    private String name;
    private String email_id;
    private String username;
    private String phoneNO;
    private String dob;
    private String address;

    private Connection connection;

    public void setName(String username) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT employee_name FROM employee WHERE username = ?;");
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                this.name = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String setAddress(String username) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT room_no FROM employee WHERE username = ?;");
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                this.address = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String geetRoomNO() {
        return address;
    }

    public String getPhoneNO() {
        return phoneNO;
    }

    public String getDob() {
        return dob;
    }

    @Override
    public boolean verifyUser(String user, String pass) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT username, password FROM LOGIN WHERE username = ? AND password=?;");
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); //returns true/false if given credentials exist

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void sendRequest(String print_id,String username, String phone_no, String paper_type, String page_type, String colour_type, String status) {

        /* TODO */
    //    int print_id = 12;
//        String room_no = "001";

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {

            setName(username);
            setAddress(username);

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO request_details (print_id, employee_id, name, phone_no, room_no, paper_type, page_type, colour_type, status, date, time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, print_id);
            preparedStatement.setString(2, "EMP001");
            preparedStatement.setString(3, this.getName());
            preparedStatement.setInt(4, Integer.parseInt(phone_no));
            preparedStatement.setString(5, this.geetRoomNO());
            preparedStatement.setString(6, paper_type);
            preparedStatement.setString(7, page_type);
            preparedStatement.setString(8, colour_type);
            preparedStatement.setString(9, status);

            preparedStatement.setDate(10, sqlDate);
            preparedStatement.setTime(11, sqlTime);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
       
    
    public String getUser_Id(String username){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
        } catch (SQLException | ClassNotFoundException e) {
            
            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select Employee_id from(select username,Employee_id from Employee union select username,staff_id from staff) as uEiusi where username=?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return resultSet.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    
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
    
}
