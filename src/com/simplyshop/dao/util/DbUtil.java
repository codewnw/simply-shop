package com.simplyshop.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringJoiner;

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
			stmt.execute(buildCreateUserTableQuery());
			stmt.execute(buildCreateLoginTableQuery());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void dropTables() {
		try (Connection con = getCon(); Statement stmt = con.createStatement()) {
			String USER_TABLE = "DROP TABLE SS_USER";
			String LOGIN_TABLE = "DROP TABLE SS_LOGIN";
			stmt.execute(USER_TABLE);
			stmt.execute(LOGIN_TABLE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static String buildCreateUserTableQuery() {
		StringJoiner joiner = new StringJoiner("");
		joiner.add("CREATE TABLE SS_USER");
		joiner.add("(");
		joiner.add("EMAIL VARCHAR(255) PRIMARY KEY, ");
		joiner.add("AGE INT, ");
		joiner.add("GENDER VARCHAR(55), ");
		joiner.add("NAME VARCHAR(255)");
		joiner.add(")");
		return joiner.toString();
	}

	private static String buildCreateLoginTableQuery() {
		StringJoiner joiner = new StringJoiner("");
		joiner.add("CREATE TABLE SS_LOGIN");
		joiner.add("(");
		joiner.add("EMAIL VARCHAR(255) PRIMARY KEY, ");
		joiner.add("PASSWORD VARCHAR(255) NOT NULL, ");
		joiner.add("STATUS VARCHAR(55)");
		joiner.add(")");
		return joiner.toString();
	}
}
