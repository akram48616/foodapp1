package com.food.app;

import java.sql.*;
	public class dbconnection {
	    private static final String URL="jdbc:mysql://localhost:3306/foodapp";
	    private static final String Username="root";
	    private static final String Password="root";
	    private static Connection Connection;
	   

	    public static Connection getConnection(){
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection =DriverManager.getConnection(URL,Username,Password);
	        }catch(ClassNotFoundException e){
	            e.printStackTrace();
	        }catch(SQLException e){
	            e.printStackTrace();
	        }
	        return Connection;
	    }

	}



