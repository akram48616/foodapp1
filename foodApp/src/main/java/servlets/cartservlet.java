package servlets;

import java.io.IOException;
import cart.cart;
import cart.cartitem;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class cartservlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  HttpSession session = req.getSession();

	  // Get or create cart
	  cart cartObj = (cart) session.getAttribute("cart");
	  if (cartObj == null) {
	    cartObj = new cart();
	    session.setAttribute("cart", cartObj);
	  }

	  String action = req.getParameter("action");

	  // Parse restaid safely
	  String restaidParam = req.getParameter("restaid");
	  int newRestaurantId = 0;
	  if (restaidParam != null && !restaidParam.isEmpty()) {
	    newRestaurantId = Integer.parseInt(restaidParam);
	  }

	  if ("add".equals(action)) {
	    Integer oldRestaurantId = (Integer) session.getAttribute("restaid");

	    if (oldRestaurantId == null || oldRestaurantId != newRestaurantId) {
	      cartObj = new cart(); // reset cart
	      session.setAttribute("cart", cartObj);
	      System.out.println("Cart reset for new restaurant: " + newRestaurantId);
	    }

	    session.setAttribute("restaid", newRestaurantId); // always update restaid
	    addItemToCart(req, cartObj);

	  } else if ("update".equals(action)) {
	    updateCart(req, cartObj);

	  } else if ("delete".equals(action)) {
	    deleteFromCart(req, cartObj);
	  }else if("checkout".equals(action)) {
		  RequestDispatcher rd = req.getRequestDispatcher("checkout.jsp");
          rd.forward(req, resp);
          return;

		  
	  }

	  resp.sendRedirect("cart.jsp");
	}
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.sendRedirect("cart.jsp"); // fallback for accidental GET requests
  }

  private void addItemToCart(HttpServletRequest req, cart cartObj) {
    try {
      int itemid = Integer.parseInt(req.getParameter("itemid"));
      int restaid = Integer.parseInt(req.getParameter("restaid"));
      String name = req.getParameter("name");
      int quantity = Integer.parseInt(req.getParameter("quantity"));
      double price = Double.parseDouble(req.getParameter("price"));

      cartitem item = new cartitem(itemid, restaid, name, quantity, price);
      cartObj.additem(item);
      System.out.println("Added item: " + item);
    } catch (Exception e) {
      System.out.println("Error adding item to cart: " + e.getMessage());
    }
  }

  private void updateCart(HttpServletRequest req, cart cartObj) {
    try {
      int itemid = Integer.parseInt(req.getParameter("itemid"));
      int quantity = Integer.parseInt(req.getParameter("quantity"));

      if (quantity <= 0) {
        cartObj.removeitem(itemid);
        System.out.println("Removed item due to zero quantity: " + itemid);
      } else {
        cartObj.updateItem(itemid, quantity);
        System.out.println("Updated item: " + itemid + " to quantity " + quantity);
      }
    } catch (Exception e) {
      System.out.println("Error updating cart: " + e.getMessage());
    }
  }

  private void deleteFromCart(HttpServletRequest req, cart cartObj) {
    try {
      int itemid = Integer.parseInt(req.getParameter("itemid"));
      cartObj.removeitem(itemid);
      System.out.println("Deleted item: " + itemid);
    } catch (Exception e) {
      System.out.println("Error deleting item from cart: " + e.getMessage());
    }
  }
}