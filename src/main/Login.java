package main;

import java.sql.Connection;

public interface Login {


    boolean verifyUser(String user, String pass);
    Connection getConnection();


}
