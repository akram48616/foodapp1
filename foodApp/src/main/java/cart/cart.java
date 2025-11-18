package cart;

import java.util.HashMap;
import java.util.Map;

public class cart {
	private Map<Integer,cartitem> items;
	public cart() {
		this.items=new HashMap<>();
		}
	
	public void additem(cartitem item) {
		int itemid=item.getItemid();
		if(items.containsKey(itemid)) {
		    cartitem existingitem=items.get(itemid);
		    existingitem.setQuantity(existingitem.getQuantity()+item.getQuantity());
		}else {
			items.put(itemid, item);
		}
		
	}
	public void updateItem(int itemid, int quantity) {
	    if (items.containsKey(itemid)) {
	        cartitem existingitem = items.get(itemid);
	        existingitem.setQuantity(quantity);
	    }
	}

	public void removeitem(int itemid) {
		
		items.remove(itemid);
	}
	 public Map<Integer, cartitem> getItems() {
	        return items;
	    }


}
