package cart;

public class cartitem {
	private int itemid;
	private int restaid;
	private String name;
	private int quantity;
	private double price;
	public cartitem(int itemid, int restaid, String name, int quantity, double price) {
		super();
		this.itemid = itemid;
		this.restaid = restaid;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "cartitem [itemid=" + itemid + ", restaid=" + restaid + ", name=" + name + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    cartitem other = (cartitem) obj;
	    return itemid == other.itemid;
	}

	@Override
	public int hashCode() {
	    return Integer.hashCode(itemid);
	}
	

}
