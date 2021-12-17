package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class Staff extends Person {


    public ResultSet getRequestTable() {
        Connection connection;
        Statement st;
        ResultSet rs = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
            st = connection.createStatement();
            String query = "SELECT  print_id, name, employee_id, page_type, paper_type, colour_type, date FROM request_details WHERE status = 'Not Accepted';";
            rs = st.executeQuery(query);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet getPrintTable() {
        Connection connection;
        Statement st;
        ResultSet rs = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/printing-system", "root", "root");
            st = connection.createStatement();
            String query = "select r.print_id, r.employee_id, r.paper_type, r.colour_type, r.page_type, p.no_of_pages, p.no_of_copies from request_details r, print_details p where r.status = 'Accepted' and r.print_id = p.print_id and r.employee_id = p.employee_id;";
            rs = st.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}
