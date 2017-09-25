package com.bridgelabz.BankDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bridgelabz.Model.User;

public class UserDAO {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/BankApp?user=root&password=password";
			connection = DriverManager.getConnection(dburl);
		} catch (Exception user) {
			System.out.println(user);
		}
		return connection;
	}

	public String loginUser(String email, String password) {
		try {
			Connection connection = UserDAO.getConnection();
			PreparedStatement pstmt = connection
					.prepareStatement("select * from registration where email=? and password = ?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet resultSet = pstmt.executeQuery();
			System.out.println("Execute Statement :");
			if (resultSet.next()) 
			{
				return resultSet.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "false";
	}

	public static int saveRegistration(User user) {
		int status = 0;
		try {
			Connection connection = UserDAO.getConnection();
			String query = "insert into registration (name,email,password,mobilenumber) values (?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getMobilenumber());
			pstmt.executeUpdate();
			status=1;
			connection.close();
			pstmt.close();
			return status;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	
}
