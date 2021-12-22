package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee extends Person {

	private String department;

	/* TODO */
	// private int usageCount;
	// private int requestCount;
	// private int pendingCash;

	public Employee() {

	}

	public Employee(String username) {
		super(username);
		Connection connection = getConnection();
		try {
			PreparedStatement preparedstatement = connection
					.prepareStatement("SELECT dept_name from employee WHERE username = ?");
			preparedstatement.setString(1, username);
			ResultSet resultSet = preparedstatement.executeQuery();
			if (resultSet.next())
				this.department = resultSet.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String checkStatus(String print_id, String username) {

		ResultSet resultSet1;
		ResultSet resultSet2;
		String e1 = "", e2 = "";
		try {
			String status = super.checkStatus(print_id);
			Connection connection = getConnection();
			PreparedStatement preparedStatement1 = connection
					.prepareStatement("select employee_id from employee where username=?;");
			PreparedStatement preparedStatement2 = connection
					.prepareStatement("select employee_id from print_details where print_id=?;");

			preparedStatement1.setString(1, username);
			resultSet1 = preparedStatement1.executeQuery();
			if (resultSet1.next()) {
				e1 = resultSet1.getString(1);
			}
			preparedStatement2.setString(1, print_id);
			resultSet2 = preparedStatement2.executeQuery();
			if (resultSet2.next()) {
				e2 = resultSet2.getString(1);
			} else
				return "NotFound";
			if (e1.equals(e2)) {
				return status;
			} else {
				return "NoMatch";
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "NotFound";

	}

	public ResultSet viewPrintHistory(String username) {
		ResultSet rs = null;
		String e_id="";
		try {
			Connection connection = getConnection();
			Statement st = connection.createStatement();
			String query0 = "SELECT employee_id FROM employee where username='"+username+"';";
			rs = st.executeQuery(query0);
			if(rs.next())
			{
				e_id = rs.getString(1);
			}
			String query = "SELECT print_id, date, time, priority, status, total_cost FROM print_details where employee_id = '"+e_id+"';";
			rs = st.executeQuery(query);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int deleteRequest(String username, String req_id) {

		String query1 = "select employee_id from employee where username='" + username + "';";
		String query2 = "select employee_id from print_details where print_id='" + req_id + "';";
		String query4 = "select status from print_details where print_id='" + req_id + "';";
		String query5 = "update print_details set status ='Deleted' where print_id='" + req_id + "';";
		String emp_id = "", emp_id2 = "", status = "";

		try {
			Connection connection = getConnection();

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query1);
			if (rs.next()) {
				emp_id = rs.getString("employee_id");
			}
			ResultSet rs2 = stmt.executeQuery(query2);
			if (rs2.next()) {
				emp_id2 = rs2.getString("employee_id");
			}
			if (emp_id.equals(emp_id2)) {
				ResultSet rs3 = stmt.executeQuery(query4);
				if (rs3.next()) {
					status = rs3.getString("status");
				} else
					return -1;
				if (status.equals("Pending")) {
					stmt.executeUpdate(query5);
					return 1;
				} else
					return 0;
			} else
				return 2;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -2;
	}

}
