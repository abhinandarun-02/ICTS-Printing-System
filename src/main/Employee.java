package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee extends Person {

    private String roomNo;
    private String department;
    
    
    public int usageCount;
    public int requestCount;
    public int pendingCash;

    public String getRoomNo() {
        return roomNo;
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
