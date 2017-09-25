package com.bridgelabz.BankDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabz.Model.AccountDetails;

public class BankDAO {

	public static int id(String email) {
		int accountId;
		try {
			Connection connection = UserDAO.getConnection();
			String query = "SELECT id FROM registration WHERE email = ?";
			PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(query);
			pstmt.setString(1, email);
			ResultSet rs = (ResultSet) pstmt.executeQuery();
			rs.next();
			accountId = rs.getInt("id");
			return accountId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int saveAccountData(AccountDetails account) {
		int status = 0;
		try {
			Connection connection = UserDAO.getConnection();
			PreparedStatement ps = connection.prepareStatement(
					"insert into addaccount (name,email,city,accountnumber,userId) values(?,?,?,?,?)");
			ps.setString(1, account.getName());
			ps.setString(2, account.getEmail());
			ps.setString(3, account.getCity());
			ps.setString(4, account.getAccountnumber());
			ps.setInt(5, account.getUserId());
			ps.executeUpdate();
			status = 1;
			connection.close();
			return status;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public static List<AccountDetails> getAllAccount(String city) {
		List<AccountDetails> list = new ArrayList<AccountDetails>();
		try {
			Connection con = UserDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from addaccount where city = ?");
			ps.setString(1, city);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountDetails account = new AccountDetails();
				account.setId(rs.getInt(1));
				account.setName(rs.getString(2));
				account.setEmail(rs.getString(3));
				account.setCity(rs.getString(4));
				account.setAccountnumber(rs.getString(5));
				list.add(account);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static int deleteAccount(int id) {
		int status = 0;
		try {
			Connection con = UserDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from addaccount where id = ?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static JSONObject updateAccount(int id) {
		JSONObject obj = new JSONObject();
		PreparedStatement preparetatement = null;
		try {
			Connection con = UserDAO.getConnection();
			preparetatement = con.prepareStatement("select * from addaccount where id = ?");
			preparetatement.setInt(1, id);
			ResultSet rs = preparetatement.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String city = rs.getString("city");
				String accountnumber = rs.getString("accountnumber");
				obj.put("name", name);
				obj.put("email", email);
				obj.put("city", city);
				obj.put("accountnumber", accountnumber);
				JSONArray array = new JSONArray();
				array.add(obj);
				preparetatement.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return obj;
	}
	
	public static void editAccount(int id) {
		try {
			Connection con = UserDAO.getConnection();
			String query = "update addaccount  set name=?, email=? ,city=?, accountnumber=? where id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(5, id);
			AccountDetails account = new AccountDetails();
			pstmt.setString(1, account.getName());
			pstmt.setString(2, account.getEmail());
			pstmt.setString(3, account.getCity());
			pstmt.setString(4, account.getAccountnumber());
			pstmt.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
