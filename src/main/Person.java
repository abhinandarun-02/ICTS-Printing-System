package main;

public class Person implements Login {

    private String name;
    private String email_id;
    private String username;
    private String phoneNO;
    private String dob;
    private String address;

    public String getName() {
        return name;
    }

    public String getPhoneNO() {
        return phoneNO;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean checkUser(String user, String pass) {
        return false;
    }
}
