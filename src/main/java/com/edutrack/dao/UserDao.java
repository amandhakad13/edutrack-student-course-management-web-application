package com.edutrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.edutrack.model.User;
import com.edutrack.utility.DBConnection;

public class UserDao {
	
	public int insertUser(User u) throws SQLException {
		try {
			Connection con = DBConnection.getConnection();
			String query = "insert into users(name, email, password, role) values (?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, u.getName());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4, u.getRole());
			int insert = pstmt.executeUpdate();
			return insert;
		}catch(SQLIntegrityConstraintViolationException e) {
			return -1;
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public User getIdRoleByEmail(String email) throws SQLException {
		
		Connection con = DBConnection.getConnection();
		String query = "select user_id, role from users where email = ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery();
		
		User u = null;
		if(rs.next()) {
			
			u = new User();
			
			u.setUserId(rs.getInt(1));
			u.setRole(rs.getString(2));

		}
		return u;
	}
	
	public boolean checkUser(String email, String password) throws SQLException {
		Connection con = DBConnection.getConnection();
		String query = "select * from users where email = ? and password = ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			return true;
		}
		
		return false;
	}
}
