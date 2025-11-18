package com.menu;

public class menu {
    private int menuid;
    private int restaid;
    private String itemname;
    private String descrption;
    private double price;
    private boolean isavailable;
    private float rating;
    private String imagepath;
    private String menucol;
    public menu() {
    	
    }
	public menu(int restaid, String itemname, String descrption, double price, boolean isavailable, float rating,
			String imagepath, String menucol) {
		super();
		this.restaid = restaid;
		this.itemname = itemname;
		this.descrption = descrption;
		this.price = price;
		this.isavailable = isavailable;
		this.rating = rating;
		this.imagepath = imagepath;
		this.menucol = menucol;
	}
	public menu(int menuid, int restaid, String itemname, String descrption, double price, boolean isavailable,
			float rating, String imagepath, String menucol) {
		super();
		this.menuid = menuid;
		this.restaid = restaid;
		this.itemname = itemname;
		this.descrption = descrption;
		this.price = price;
		this.isavailable = isavailable;
		this.rating = rating;
		this.imagepath = imagepath;
		this.menucol = menucol;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public int getRestaid() {
		return restaid;
	}
	public void setRestaid(int restaid) {
		this.restaid = restaid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isIsavailable() {
		return isavailable;
	}
	public void setIsavailable(boolean isavailable) {
		this.isavailable = isavailable;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public String getMenucol() {
		return menucol;
	}
	public void setMenucol(String menucol) {
		this.menucol = menucol;
	}
	@Override
	public String toString() {
		return "menu [menuid=" + menuid + ", restaid=" + restaid + ", itemname=" + itemname + ", descrption="
				+ descrption + ", price=" + price + ", isavailable=" + isavailable + "]";
	}
    
}
