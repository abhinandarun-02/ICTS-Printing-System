package main;

import java.sql.*;

public class PrinterHistory {

    private String print_id;
    private String username;
    private int printerNo;
    private int no_of_pages;
    private int total_cost;

    public PrinterHistory(String username) {
        this.username = username;
    }

    public ResultSet getPrintHistory() {
        ResultSet resultSet = null;
        Connection connection = null;

        String url = "jdbc:postgresql://localhost:5432/printing-system";
        String username = "root";
        String password = "root";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT  * FROM print_details WHERE employee_id = ?");
            preparedStatement.setString(username);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;

    }

    public void getTotalAmount() {
        ResultSet resultSet = null;
        Connection connection = null;

        String url = "jdbc:postgresql://localhost:5432/printing-system";
        String username = "root";
        String password = "root";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT sum(total_cost) FROM print_details WHERE employee_id= ?");
            preparedStatement.setString(username);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

}
