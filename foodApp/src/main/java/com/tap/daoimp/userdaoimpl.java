package com.tap.daoimp;

import java.util.ArrayList;
import java.util.List;

import com.food.app.dbconnection;
import com.food.dao.userdao;
import com.food.model.user;
import java.sql.*;

public class userdaoimpl implements userdao{
	private String INSERT = "INSERT INTO `user` (`name`, `username`, `password`, `email`, `phonenumber`, `address`, `role`, `created_date`, `lastlogin_date`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String UPDATE = "UPDATE `user` SET `name`=?, `username`=?, `password`=?, `email`=?, `phonenumber`=?, `address`=?, `role`=?";
	private final  String Getid="SELECT*from `user` WHERE userid=?"; 
	private final String Getid1 = "SELECT userid, name, username, password, email, phonenumber, address, role, created_date, lastlogin_date FROM user";
	private final String delete="DELETE from `user` WHERE `userid`=?";
	@Override
	public List<user> getAllUsers() {
		List<user> users=new ArrayList<user>();
		try(Connection connection=dbconnection.getConnection();
				PreparedStatement preparestatement=connection.prepareStatement(Getid1);){
			
			ResultSet resultSet=preparestatement.executeQuery();
			while(resultSet.next()) {
				int id=resultSet.getInt("userid");
				String name=resultSet.getString("name");
				String username=resultSet.getString("username");
				String password=resultSet.getString("password");
				String email=resultSet.getString("email");
				String phonenumber=resultSet.getString("phonenumber");
				String address=resultSet.getString("address");
				String role=resultSet.getString("role");
				Timestamp created=resultSet.getTimestamp("created_date");
				Timestamp lastlogin=resultSet.getTimestamp("lastlogin_date");
				user u=new user(id,name,username,password,email,phonenumber,address,role, created,lastlogin);
				users.add(u);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public user getUserId(int userid) {
		user u=null;
		try(Connection connection=dbconnection.getConnection();
				PreparedStatement preparestatement=connection.prepareStatement(Getid);){
			preparestatement.setInt(1, userid);
			ResultSet resultSet=preparestatement.executeQuery();
			while(resultSet.next()) {
				int id=resultSet.getInt("userid");
				String name=resultSet.getString("name");
				String username=resultSet.getString("username");
				String password=resultSet.getString("password");
				String email=resultSet.getString("email");
				String phonenumber=resultSet.getString("phonenumber");
				String address=resultSet.getString("address");
				String role=resultSet.getString("role");
				Timestamp created=resultSet.getTimestamp("created_date");
				Timestamp lastlogin=resultSet.getTimestamp("lastlogin_date");
				 u=new user(userid,name,username,password,email,phonenumber,address,role, created,lastlogin);
				
				
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public boolean addUser(user u) {
		try {
		     Class.forName("com.mysql.cj.jdbc.Driver");
		     Connection Connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodapp","root","root");
		     PreparedStatement preparestatement=Connection.prepareStatement(INSERT);
		     preparestatement.setString(1,u.getName());
		     preparestatement.setString(2,u.getUsername());
		     preparestatement.setString(3,u.getPassword());
		     preparestatement.setString(4,u.getEmail());
		     preparestatement.setString(5,u.getPhonenumber());
		     preparestatement.setString(6,u.getAddress());
		     preparestatement.setString(7,u.getRole());
		     preparestatement.setTimestamp(8,new Timestamp(System.currentTimeMillis()));
		     preparestatement.setTimestamp(9,new Timestamp(System.currentTimeMillis()));
		     int i=preparestatement.executeUpdate();
		     System.out.println(i);
		     return true;
		     
		     
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
			
			
		}
		return false;
		
		
	}

	@Override
	public void updateUser(user u) {
		
		try(Connection connection=dbconnection.getConnection();
				PreparedStatement preparestatement=connection.prepareStatement(UPDATE);){
			 preparestatement.setString(1,u.getName());
		     preparestatement.setString(2,u.getUsername());
		     preparestatement.setString(3,u.getPassword());
		     preparestatement.setString(4,u.getEmail());
		     preparestatement.setString(5,u.getPhonenumber());
		     preparestatement.setString(6,u.getAddress());
		     preparestatement.setString(7,u.getRole());
		    
		     
		     
		     int i=preparestatement.executeUpdate();
		     System.out.println(i);
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		
		
		
		
		
	}

	@Override
	public void deleteUser(int userid) {
		try(Connection connection=dbconnection.getConnection();
				PreparedStatement preparestatement=connection.prepareStatement(delete);){
			preparestatement.setInt(1,userid);
		    
		     
		     
		     int i=preparestatement.executeUpdate();
		     System.out.println(i);
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

}
