package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeliveryPerson extends User {

	private String deliveryCompleted;
	private String deliveryPending;

	public DeliveryPerson(String username) {
		super(username);
	}

	public ResultSet checkDeliveryQueue() {

		int i = 0;
		ResultSet rs = null;
		try {
			Connection connection = getConnection();
			Statement st = connection.createStatement();
			String query = "SELECT l.print_id,l.clerk_id, l.employee_id,e.employee_name,e.room_no, e.dept_name, e.phone_no, l.total_cost FROM log_details l, employee e WHERE e.employee_id=l.employee_id;";
			rs = st.executeQuery(query);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int updateDeliveryStatus(String print_id, String option) {

		String query1 = "UPDATE log_details SET delivery_status='" + option + "' WHERE print_id='" + print_id + "' AND delivery_status='To be delivered';";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			int c = stmt.executeUpdate(query1);
			if (c == 1) {
				return 1;
			}
			else
				return -1;

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}

	}


}


