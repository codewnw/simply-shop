package com.simplyshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.simplyshop.dao.util.DbUtil;
import com.simplyshop.model.Login;
import com.simplyshop.model.User;

public class UserDaoImpl implements UserDao {

	private LoginDao loginDao;

	public UserDaoImpl() {
		loginDao = new LoginDaoImpl();
	}

	@Override
	public void save(User user) {
		System.out.println(">> save of " + this.getClass().getSimpleName());
	/*	
		Login login = new Login();
		login.setEmail(user.getEmail());
		login.setPassword(user.getPassword());
		login.setStatus("Not Verified");
		loginDao.save(login);*/
		
		String SAVE_USER = "INSERT INTO SS_USER VALUES(?, ?)";
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(SAVE_USER)) {
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
		}
	}

	@Override
	public User get(String email) {
		User user = null;
		String GET_USER = "SELECT * FROM SS_USER WHERE EMAIL = ?";
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(GET_USER)) {
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setEmail(rs.getString(1));
				user.setName(rs.getString(2));
			}
		} catch (SQLException e) {
		}
		return user;
	}

	@Override
	public List<User> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String email) {
		// TODO Auto-generated method stub

	}

}
