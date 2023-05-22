package com.tech.blog.dao;
import java.sql.*;

import org.springframework.stereotype.Component;

import com.tech.blog.entities.User;




public class UserDao {
	
	private Connection con;
	
	public UserDao(Connection con) {
		this.con=con;
		
	}
	
	
	
	public boolean updateUser(User user) {
		boolean f=false;
		
		try {
			
			String query="update techblog set name=?,email=?,password=?,gender=?,about=?,profile=? where id=?";
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1, user.getName());
			psmt.setString(2,user.getEmail());
			psmt.setString(3, user.getPassword());
			psmt.setString(4, user.getGender());
			psmt.setString(5, user.getAbout());
			
			psmt.setString(6, user.getProfile());
			psmt.setInt(7, user.getId());
			
			psmt.executeUpdate();
			f=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	

}
