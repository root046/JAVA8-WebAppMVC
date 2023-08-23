package org.demo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.demo.entity.User;

public class UsersModel {
	public List<User> listUsers(DataSource dataSource) {
		// step 1 : Initialize connection objects
				List<User> listUsers = new ArrayList<>();
				
				Connection connect = null;
				Statement stmt = null;
				ResultSet rs = null;
				try {
					connect = dataSource.getConnection();
					
					// step 2 : Create a SQL statements string
					
					String query = "Select * from users";
					stmt = connect.createStatement();
					
					// step 3 : Execute SQL query
					
					rs = stmt.executeQuery(query);
					
					// step 4 : Process the result set
					
					while (rs.next()) {
						listUsers.add(new User(rs.getInt("users_id"), rs.getString("username"), rs.getString("email")));
						
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						connect.close();
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				return listUsers;
	}

	public void addUser(DataSource dataSource, User newUser) {
		Connection connect = null;
		PreparedStatement statement = null;
		
		try {
			connect = dataSource.getConnection();
			String username = newUser.getUsername();
			String email = newUser.getEmail();
			
			String query = "insert into users (username,email) values (?,?)";
			statement = connect.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, email);
			
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connect.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public void updateUser(DataSource dataSource, User updateUser) {
		Connection connect = null;
		PreparedStatement statement = null;
		
		try {
			connect = dataSource.getConnection();
			int userId = updateUser.getUsers_id();
			String username = updateUser.getUsername();
			String email = updateUser.getEmail();
			
			String query = "update users set username = ? , email = ?  where users_Id = ? ";
			statement = connect.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, email);
			statement.setInt(3, userId);
			
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void deleteUser(DataSource dataSource, int userID) {
		Connection connect = null;
		PreparedStatement statement = null;
		
		try {
			connect = dataSource.getConnection();
			
			String query = "delete from users where users_Id = ? ";
			statement = connect.prepareStatement(query);
			statement.setInt(1, userID);
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
