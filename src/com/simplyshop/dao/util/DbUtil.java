package com.simplyshop.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {

	static Connection con;

	public static Connection getCon() throws SQLException {
		if (con == null || con.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplyshop", "simplyshop", "routinecart");
		}
		return con;
	}

	public static void createTables() {
		try (Connection con = getCon(); Statement stmt = con.createStatement()) {
			String USER_TABLE = "CREATE TABLE SS_USER(EMAIL VARCHAR(255), NAME VARCHAR(255))";
			String LOGIN_TABLE = "CREATE TABLE SS_LOGIN(EMAIL VARCHAR(255), PASSWORD VARCHAR(255), STATUS VARCHAR(20))";
			stmt.execute(USER_TABLE);
			stmt.execute(LOGIN_TABLE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
