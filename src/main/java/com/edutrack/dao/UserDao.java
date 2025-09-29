package com.edutrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.edutrack.model.User;
import com.edutrack.utility.DBConnection;

public class UserDao {
	
	public int insertUser(User u) throws SQLException {
		Connection con = DBConnection.getConnection();
		String query = "insert into users(name, email, password, role) values (?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, u.getName());
		pstmt.setString(2, u.getEmail());
		pstmt.setString(3, u.getPassword());
		pstmt.setString(4, u.getRole());
		int insert = pstmt.executeUpdate();
		return insert;
	}
}
