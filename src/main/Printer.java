package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Printer{
	
    private static final int COST_PER_BW = 5;
    private static final int COST_PER_COLOUR = 10;

    private String printer_id;

    private boolean printerStatus;


    public void getPrinterHistory() {

    }

    public void getPrinterStatus() {

    }

    public static int getCostPerBw() {
        return COST_PER_BW;
    }

    public static int getCostPerColour() {
        return COST_PER_COLOUR;
    }
    public int[] getResources() {
    	int[] res = new int[5];
    	ResultSet rs;
    	int i=0;
        try {
        	String url = "jdbc:postgresql://localhost:5432/printing-system";
            Connection connection = null;

            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, "root", "root");
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        
            Statement stmt = connection.createStatement();
            String query = "SELECT * from resource_details;";
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                res[0] = (rs.getInt(1));
                res[1] = (rs.getInt(2));
                res[2] = (rs.getInt(3));
                res[3] = (rs.getInt(4));
                res[4] = (rs.getInt(5));
                return res;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
     return null;
    }

}
