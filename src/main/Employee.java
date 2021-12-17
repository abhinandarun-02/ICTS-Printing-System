package main;

import java.sql.*;

public class Employee extends Person {

//    private String roomNo;
    private String department;

    public Employee() {

    }

    public Employee(String username) {
        super(username);

        Connection connection = getConnection();

        try {
            /*TODO*/
//            PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT room_no FROM employee WHERE username = ?;");
//            preparedStatement1.setString(1, username);
//            ResultSet resultSet1 = preparedStatement1.executeQuery();
//            if (resultSet1.next()) this.roomNo = resultSet1.getString(1);

            PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT dept_name from employee WHERE username = ?");
            preparedStatement2.setString(1, username);
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            if (resultSet2.next()) this.department = resultSet2.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int usageCount;
    public int requestCount;
    public int pendingCash;

//    public String getRoomNo() {
//        return roomNo;
//    }

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
