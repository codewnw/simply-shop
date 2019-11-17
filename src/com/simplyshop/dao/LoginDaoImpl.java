package com.simplyshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.simplyshop.dao.util.DbUtil;
import com.simplyshop.model.Login;

public class LoginDaoImpl implements LoginDao {

	@Override
	public void save(Login login) {
		String SAVE_LOGIN = "INSERT INTO SS_LOGIN VALUES(?, ?, ?)";
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(SAVE_LOGIN)) {
			pstmt.setString(1, login.getEmail());
			pstmt.setString(2, login.getPassword());
			pstmt.setString(3, login.getStatus());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean check(Login login) {
		try (Connection con = DbUtil.getCon();
				PreparedStatement pstmt = con
						.prepareStatement("SELECT * FROM SS_LOGIN WHERE EMAIL = ? AND PASSWORD = ?")) {
			pstmt.setString(1, login.getEmail());
			pstmt.setString(2, login.getPassword());

			ResultSet rs = pstmt.executeQuery();

			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
