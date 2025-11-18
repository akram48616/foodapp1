package com.menudaoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.app.dbconnection;
import com.menu.menu;
import com.menudao.menudao;
import com.rest.food.app.rest;

public class menudaoimpl implements menudao {
	private final  String sql = "INSERT INTO menu (restaid, itemname, descrption, price, isavailable, rating, imagepath, menucol) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final  String getid = "SELECT * FROM menu WHERE menuid = ?";
    private final String menuid = "SELECT menuid, restaid, itemname, descrption, price, isavailable, rating, imagepath, menucol FROM menu";
    private final String UPDATE = "UPDATE `menu` SET `restaid`=?, `itemname`=?, `descrption`=?, `price`=?, `isavailable`=?, `rating`=?, `imagepath`=?, `menucol`=? WHERE `menuid`=?";
	private final String delete="DELETE from `menu` WHERE `menuid`=?";
	private final  String sql2 = "SELECT * FROM menu WHERE restaid = ?";

	@Override
	public List<menu> getmenu() {
		// TODO Auto-generated method stub
		List<menu> menu=new ArrayList<menu>();
		try(Connection connection=dbconnection.getConnection();
				PreparedStatement preparestatement=connection.prepareStatement(menuid);){
			
			ResultSet resultSet=preparestatement.executeQuery();
			while(resultSet.next()) {
				int menuid = resultSet.getInt("menuid");
				int restaid = resultSet.getInt("restaid");

				

				// Menu details
				String itemname = resultSet.getString("itemname");
				String description = resultSet.getString("descrption");
				float price = resultSet.getFloat("price");
				boolean available = resultSet.getBoolean("isavailable");
				float menurating = resultSet.getFloat("rating"); // assuming alias if both have 'rating'
				String imagepath = resultSet.getString("imagepath");
				String menucol = resultSet.getString("menucol");

				// Create objects
				
				menu m = new menu(menuid, restaid, itemname, description, price, available, menurating, imagepath, menucol);

				menu.add(m); // assuming you have a List<menu> menus
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return menu;
	}

	@Override
	public menu getmenuId(int menuid) {
	  menu r=null;
		try(Connection connection=dbconnection.getConnection();
				PreparedStatement preparestatement=connection.prepareStatement(getid);){
			preparestatement.setInt(1, menuid);
			ResultSet resultSet=preparestatement.executeQuery();
			while(resultSet.next()) {
				int  name=resultSet.getInt("restaid");
				String address=resultSet.getString("itemname");
				String descrption=resultSet.getString("descrption");
				float price=resultSet.getFloat("price");
				Boolean isavailable=resultSet.getBoolean("isavailable");
				float rating=resultSet.getFloat("rating");
				String imagapath=resultSet.getString("imagepath");
//				Timestamp created=resultSet.getTimestamp("i");
				String menucol=resultSet.getString("menucol");
				
			     r=new menu(menuid,name,address,descrption,price,isavailable,rating,imagapath,menucol);
				
								
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r ;
	}

	@Override
	public void addmenu(menu m) {
		try {
		     Class.forName("com.mysql.cj.jdbc.Driver");
		     Connection Connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodapp","root","root");
		     PreparedStatement ps=Connection.prepareStatement(sql);
	            ps.setInt(1, m.getRestaid());
	            ps.setString(2, m.getItemname());
	            ps.setString(3, m.getDescrption());
	            ps.setDouble(4, m.getPrice());
	            ps.setBoolean(5, m.isIsavailable());
	            ps.setFloat(6, m.getRating());
	            ps.setString(7, m.getImagepath());
	            ps.setString(8, m.getMenucol());
	            int i=ps.executeUpdate();
	            System.out.println(i);
	        }catch(ClassNotFoundException e) {
				e.printStackTrace();
			    
	        }catch(SQLException e) {
	        	e.printStackTrace();
	    }

		
	}

	@Override
	public void updatemenu(menu m) {
		try (Connection connection = dbconnection.getConnection();
			     PreparedStatement preparestatement = connection.prepareStatement(UPDATE)) {

			    preparestatement.setInt(1, m.getRestaid());
			    preparestatement.setString(2, m.getItemname());
			    preparestatement.setString(3, m.getDescrption());
			    preparestatement.setDouble(4, m.getPrice());
			    preparestatement.setBoolean(5, m.isIsavailable());
			    preparestatement.setFloat(6, m.getRating());
			    preparestatement.setString(7, m.getImagepath());
			    preparestatement.setString(8, m.getMenucol());
			    preparestatement.setInt(9, m.getMenuid());

			    int i = preparestatement.executeUpdate();
			    System.out.println(i);

			} catch (SQLException e) {
			    e.printStackTrace();
			}
	}

	@Override
	public void deletermenu(int menuid) {
		// TODO Auto-generated method stub
		try(Connection connection=dbconnection.getConnection();
				PreparedStatement preparestatement=connection.prepareStatement(delete);){
			 preparestatement.setInt(1,menuid);
		    
		    
		     
		     
		     int i=preparestatement.executeUpdate();
		     System.out.println(i);
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<menu> getMenuByRestaid(int restaid) {
		List<menu> list = new ArrayList<>();

		try(Connection connection=dbconnection.getConnection();
				PreparedStatement ps=connection.prepareStatement(sql2);){
			 ps.setInt(1, restaid);
		        ResultSet rs = ps.executeQuery();
		        while (rs.next()) {
		            menu m = new menu(
		                rs.getInt("menuid"),
		                rs.getInt("restaid"),
		                rs.getString("itemname"),
		                rs.getString("descrption"),
		                rs.getDouble("price"),
		                rs.getBoolean("isavailable"),
		                rs.getFloat("rating"),
		                rs.getString("imagepath"),
		                rs.getString("menucol")
		            );
		            list.add(m);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return list;

		}
		
	

	

}
