package com.restdaoimpl.foodapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.food.app.dbconnection;
import com.food.model.user;
import com.rest.food.app.rest;
import com.restdao.food.app.restdao;

public class restdaoimpl implements restdao{
	private String INSERT = "INSERT INTO resta (name, address, phonenumber, cusine_type, deliverytime, rating, isactive, image, adminuserid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final  String Getid="SELECT*from `resta` WHERE `restaid`=?"; 
	private final String Getid1 = "SELECT restaid, name, address, phonenumber, cusine_type, deliverytime, rating, isactive, image, adminuserid FROM resta";
	
	private final String UPDATE = "UPDATE `resta` SET `name`=?, `address`=?, `phonenumber`=?, `cusine_type`=?, `deliverytime`=?, `rating`=?, `isactive`=?,`image`=?,`adminuserid`=? WHERE `restaid`=? ";
	private final String delete="DELETE from `resta` WHERE `restaid`=?";
	@Override
	public List<rest> getresta() {
		// TODO Auto-generated method stub
		List<rest> users=new ArrayList<rest>();
		try(Connection connection=dbconnection.getConnection();
				PreparedStatement preparestatement=connection.prepareStatement(Getid1);){
			
			ResultSet resultSet=preparestatement.executeQuery();
			while(resultSet.next()) {
				int restaid=resultSet.getInt("restaid");
				String name=resultSet.getString("name");
				String address=resultSet.getString("address");
				String phonenumber=resultSet.getString("phonenumber");
				String cusine_type=resultSet.getString("cusine_type");
				String deliverytime=resultSet.getString("deliverytime");
				String rating=resultSet.getString("rating");
				String isactive=resultSet.getString("isactive");
				String image=resultSet.getString("image");
				String adminuserid=resultSet.getString("adminuserid");
				rest r=new rest(restaid,name,address,phonenumber,cusine_type,deliverytime,rating,isactive,image,adminuserid);
				users.add(r);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
		// TODO Auto-generated method stub
		
		
	


	
	}

	@Override
	public rest getrestaId(int restid) {
		// TODO Auto-generated method n
		rest r=null;
		try(Connection connection=dbconnection.getConnection();
				PreparedStatement preparestatement=connection.prepareStatement(Getid);){
			preparestatement.setInt(1, restid);
			ResultSet resultSet=preparestatement.executeQuery();
			while(resultSet.next()) {
				String name=resultSet.getString("name");
				String address=resultSet.getString("address");
				String phonenumber=resultSet.getString("phonenumber");
				String cusine_type=resultSet.getString("cusine_type");
				String deliverytime=resultSet.getString("deliverytime");
				String rating=resultSet.getString("rating");
				String isactive=resultSet.getString("isactive");
//				Timestamp created=resultSet.getTimestamp("i");
				String adminuserid=resultSet.getString("adminuserid");
				String image=resultSet.getString("image");
			     r=new rest(restid,name,address,phonenumber,cusine_type,deliverytime,rating,isactive,image,adminuserid);
				
								
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r ;
		// TODO Auto-generated method stub
		
		
	


	
	}

	@Override
	public void addresta(rest r) {
		try {
		     Class.forName("com.mysql.cj.jdbc.Driver");
		     Connection Connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodapp","root","root");
		     PreparedStatement preparestatement=Connection.prepareStatement(INSERT);
		     preparestatement.setString(1,r.getName());
		     preparestatement.setString(2,r.getAddress());
		     preparestatement.setString(3,r.getPhonenumber());
		     preparestatement.setString(4,r.getCusine_type());
		     preparestatement.setString(5,r.getDeliverytime());
		     preparestatement.setString(6,r.getRating());
		     preparestatement.setString(7,r.getIsactive());
		     preparestatement.setString(8,r.getImage());
		     preparestatement.setString(9,r.getAdminuserid());
		     int i=preparestatement.executeUpdate();
		     System.out.println(i);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
			
			
		}
		
		
	}

	@Override
	public void updateresta(rest r) {
		// TODO Auto-generated method stub
		try(Connection connection=dbconnection.getConnection();
				PreparedStatement preparestatement=connection.prepareStatement(UPDATE);){
			 preparestatement.setString(1,r.getName());
		     preparestatement.setString(2,r.getAddress());
		     preparestatement.setString(3,r.getPhonenumber());
		     preparestatement.setString(4,r.getCusine_type());
		     preparestatement.setString(5,r.getDeliverytime());
		     preparestatement.setString(6,r.getRating());
		     preparestatement.setString(7,r.getIsactive());
		     preparestatement.setString(8,r.getImage());
		     preparestatement.setString(9,r.getAdminuserid());
		     preparestatement.setInt(10, r.getRestaid());
		     int i=preparestatement.executeUpdate();
		     System.out.println(i);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteresta(int restaid) {
		try(Connection connection=dbconnection.getConnection();
				PreparedStatement preparestatement=connection.prepareStatement(delete);){
			 preparestatement.setInt(1,restaid);
		    
		    
		     
		     
		     int i=preparestatement.executeUpdate();
		     System.out.println(i);
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

}
