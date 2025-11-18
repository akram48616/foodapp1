<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="cart.cart, cart.cartitem" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Your Cart</title>
  <link rel="stylesheet" href="cart.css" />
</head>
<body>

  <h1>Your Cart 🛒</h1>
  <div class="cart-container">
    <%
      cart cart = (cart) session.getAttribute("cart");
      Integer restaid = (Integer) session.getAttribute("restaid");

      // Debug output to server console
      System.out.println("Cart size: " + (cart != null && cart.getItems() != null ? cart.getItems().size() : 0));

      if (cart != null && cart.getItems() != null && !cart.getItems().isEmpty()) {
        double grandTotal = 0;
        for (cartitem item : cart.getItems().values()) {
          double itemTotal = item.getPrice() * item.getQuantity();
          grandTotal += itemTotal;
    %>
    <div class="cart-item">
      <div class="cart-item-details">
        <h3><%= item.getName() %></h3>
        <p>Price: ₹<%= item.getPrice() %></p>
        <p>Quantity: <%= item.getQuantity() %></p>
        <p>Total: ₹<%= itemTotal %></p>

        <div class="quantity-controls">
          <!-- Increase Quantity -->
          <form action="cart" method="post" style="display:inline;">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="itemid" value="<%= item.getItemid() %>">
            <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
            <input type="hidden" name="restaid" value="<%= restaid %>">
            <button type="submit">➕</button>
          </form>

          <!-- Decrease Quantity -->
          <form action="cart" method="post" style="display:inline;">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="itemid" value="<%= item.getItemid() %>">
            <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
            <input type="hidden" name="restaid" value="<%= restaid %>">
            <button type="submit">➖</button>
          </form>

          <!-- Remove Item -->
          <form action="cart" method="post" style="display:inline;">
            <input type="hidden" name="action" value="delete">
            <input type="hidden" name="itemid" value="<%= item.getItemid() %>">
            <input type="hidden" name="restaid" value="<%= session.getAttribute("restaid") %>">
            
            <button class="remove-btn">🗑️ Remove</button>
            </form>
            
          
        </div>
      </div>
    </div>
    <%
        } // end for loop
    %>
     <div class="cart-summary">
      <h2>Grand Total: ₹<%= grandTotal %></h2>
      <div class="cart-actions">
      
    
        <!-- Home Button -->
        <form action="callinghomeservlet" method="get" style="display:inline;">
          <button type="submit" class="nav-btn">🏠 Home</button>
        </form>

        <!-- Menu Button -->
        <form action="callingmenuservlet" method="get" style="display:inline;">
          <input type="hidden" name="restaid" value="<%= restaid %>">
          <button type="submit" class="nav-btn">📋 Menu</button>
        </form>

        <!-- Proceed to Checkout Button -->
       <form action="checkout.jsp" method="post" style="display:inline;">
          <input type="hidden" name="action" value="checkout">
         <button type="submit" class="checkout-btn">✅ Proceed to Checkout</button>
         </form>
        
      </div>
    </div>
    <%
      } else {
    %>
   <div class="cart-actions">
  <form action="callinghomeservlet" method="get" style="display:inline;">
    <button type="submit" class="nav-btn">🏠 Home</button>
  </form>
</div>
<p>Your cart is empty.</p>
    <%
      } // end if-else
    %>
  </div>
    

</body>
</html>