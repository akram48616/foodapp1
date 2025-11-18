package com.rest.food.app;

public class rest {
	int restaid;
	String name;
	String address;
	String phonenumber;
	String cusine_type;
	String deliverytime;
	String rating;
	String isactive;
	String image;
	String adminuserid;
	public rest() {
		
	}
	
	public rest(String name, String address, String phonenumber, String cusine_type, String deliverytime,
			String rating, String isactive, String image, String adminuserid) {
		super();
		this.name = name;
		this.address = address;
		this.phonenumber = phonenumber;
		this.cusine_type = cusine_type;
		this.deliverytime = deliverytime;
		this.rating = rating;
		this.isactive = isactive;
		this.image = image;
		this.adminuserid = adminuserid;
	}

	public rest(int restaid, String name, String address, String phonenumber, String cusine_type, String deliverytime,
			String rating, String isactive, String image, String adminuserid) {
		super();
		this.restaid = restaid;
		this.name = name;
		this.address = address;
		this.phonenumber = phonenumber;
		this.cusine_type = cusine_type;
		this.deliverytime = deliverytime;
		this.rating = rating;
		this.isactive = isactive;
		this.image = image;
		this.adminuserid = adminuserid;
	}
	public int getRestaid() {
		return restaid;
	}
	public void setRestaid(int restaid) {
		this.restaid = restaid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getCusine_type() {
		return cusine_type;
	}
	public void setCusine_type(String cuisine_type) {
		this.cusine_type = cuisine_type;
	}
	public String getDeliverytime() {
		return deliverytime;
	}
	public void setDeliverytime(String deliverytime) {
		this.deliverytime = deliverytime;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAdminuserid() {
		return adminuserid;
	}
	public void setAdminuserid(String adminuserid) {
		this.adminuserid = adminuserid;
	}

	@Override
	public String toString() {
		return "rest [name=" + name + ", cusine_type=" + cusine_type + ", deliverytime=" + deliverytime + ", rating="
				+ rating + ", image=" + image + "]";
	}
	
}