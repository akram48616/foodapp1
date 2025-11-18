package com.food.model;
import java.sql.Timestamp;
public class user {
	
	
	int userid;
	String name;
	String username;
	String password;
	String email;
	String phonenumber;
	String address;
	String role;
	Timestamp created_date;
	Timestamp lastlogin_date;
	public user() {
		
	}
	
	
	
	



	
	public user(String name, String username, String password, String email, String phonenumber, String address,
			String role) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
		this.role = role;
	}








	public user(int userid, String name, String username, String password, String email, String phonenumber,
			String address, String role, Timestamp created_date, Timestamp lastlogin_date) {
		super();
		this.userid = userid;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
		this.role = role;
		this.created_date = created_date;
		this.lastlogin_date = lastlogin_date;
	}








	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Timestamp getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}
	public Timestamp getLastlogin_date() {
		return lastlogin_date;
	}
	public void setLastlogin_date(Timestamp lastlogin_date) {
		this.lastlogin_date = lastlogin_date;
	}
	@Override
	public String toString() {
		return "user: ["+name+" "+username+" "+password+" "+email+"] ";
	}
	
	

}
