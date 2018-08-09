package com.jda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jda.model.UserModel;

public class jdbcUtill{
	static Connection con=null;
	static PreparedStatement pst=null;
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection connection = DriverManager.getConnection("jdbc:mysql://10.0.0.160/db1000216", "u1000216","7hIXZYjHI5");
		return connection;
	}
	public static void registerUser(UserModel user) throws ClassNotFoundException, SQLException
	{
		 con=jdbcUtill.getConnection();
		 pst = con.prepareStatement("insert into users (name,gender,age,user_name,email,password,phone) values(?,?,?,?,?,?,?)");
		 pst.setString(1,user.getName());
		 pst.setString(2,user.getGender());
		 pst.setInt(3,user.getAge());
		 pst.setString(4, user.getUsername());
		 pst.setString(5, user.getEmail());
		 pst.setString(6, user.getPassword());
		 pst.setString(7,user.getPhone());
		 pst.executeUpdate();
		 con.close();
	}
	public static UserModel logInUser(String email) throws ClassNotFoundException, SQLException
	{
		con=jdbcUtill.getConnection();
		String selectSQL = "SELECT * FROM users WHERE email= ?";
		pst = con.prepareStatement(selectSQL);
		pst.setString(1,email);
		ResultSet rs = pst.executeQuery() ;
		
		if(rs!=null)
		{	
			UserModel user=new UserModel();
			while(rs.next()){
			System.out.println("what");
				user.setName(rs.getString("name"));
				System.out.println(rs.getString("name"));
				user.setGender(rs.getString("gender"));
				user.setAge(rs.getInt("age"));
				user.setUsername(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
			}
			return user;
		}
			return null;
	}
}
	
