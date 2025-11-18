<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="cart.cart, cart.cartitem" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Checkout Summary</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="checkout.css" />
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background-color: #f7f7f7;
      margin: 0;
      padding: 0;
    }
    h1 {
      text-align: center;
      color: #32a852;
      margin-top: 40px;
      font-weight: 700;
    }
    .checkout-container {
      background: #fff;
      border-radius: 10px;
      box-shadow: 0 0 16px rgba(0,0,0,0.09);
      max-width: 600px;
      margin: 40px auto 60px;
      padding: 32px 32px 32px 32px;
    }
    table {
      width: 100%;
      border-collapse: collapse;
      margin-bottom: 24px;
    }
    table thead tr {
      border-bottom: 2px solid #32a852;
    }
    table thead th {
      text-align: left;
      padding: 8px 0;
      color: #32a852;
      font-weight: 700;
    }
    table tbody td {
      padding: 10px 0;
      border-bottom: 1px solid #eee;
      font-size: 1rem;
      color: #333;
    }
    h2 {
      color: #32a852;
      margin: 20px 0 12px 0;
      font-weight: 700;
    }
    .checkout-form {
      display: flex;
      flex-direction: column;
      gap: 16px;
    }
    .checkout-form input[type="text"],
    .checkout-form textarea,
    .checkout-form select {
      border: 1.5px solid #d0d0d0;
      border-radius: 6px;
      padding: 10px 10px;
      font-size: 1rem;
      background: #f9fafb;
      transition: border-color 0.2s;
      font-weight: 500;
    }
    .checkout-form input:focus,
    .checkout-form textarea:focus,
    .checkout-form select:focus {
      border: 1.5px solid #32a852;
      outline: none;
      background: #eefaf3;
    }
    .checkout-btn {
      margin-top: 18px;
      background: #32a852;
      color: #fff;
      font-weight: 700;
      padding: 14px 0;
      border: none;
      border-radius: 6px;
      font-size: 1.2rem;
      cursor: pointer;
      transition: background 0.2s;
    }
    .checkout-btn:hover {
      background: #23893b;
    }
    .payment-section label {
      font-weight: 600;
      margin-bottom: 6px;
      color: #333;
    }
    .payment-section {
      margin-top: 6px;
      display: flex;
      flex-direction: column;
      gap: 8px;
    }
    .nav-btn {
      background: #2a80d2;
      color: #fff;
      font-weight: 700;
      padding: 12px 28px;
      border-radius: 6px;
      border: none;
      font-size: 1.1rem;
      margin-right: 10px;
      margin-top: 18px;
      cursor: pointer;
      transition: background 0.2s;
    }
    .nav-btn:hover {
      background:#195a99;
    }
    p {
      font-size: 1.1rem;
      color: #ff4c4c;
      font-weight: 600;
      text-align: center;
      margin-top: 20px;
    }
  </style>
</head>
<body>

  <h1>Checkout Summary 🧾</h1>
  <div class="checkout-container">
    <%
      cart cart = (cart) session.getAttribute("cart");
      Integer restaid = (Integer) session.getAttribute("restaid");
      Integer userid = (Integer) session.getAttribute("userid");

      if (cart != null && cart.getItems() != null && !cart.getItems().isEmpty()) {
        double grandTotal = 0;
    %>

    <!-- Cart Summary -->
    <table>
      <thead>
        <tr>
          <th>Item</th><th>Price</th><th>Quantity</th><th>Total</th>
        </tr>
      </thead>
      <tbody>
      <%
        for (cartitem item : cart.getItems().values()) {
          double itemTotal = item.getPrice() * item.getQuantity();
          grandTotal += itemTotal;
      %>
        <tr>
          <td><%= item.getName() %></td>
          <td>₹<%= item.getPrice() %></td>
          <td><%= item.getQuantity() %></td>
          <td>₹<%= String.format("%.2f", itemTotal) %></td>
        </tr>
      <% } %>
      </tbody>
    </table>
    <h2>Grand Total: ₹<%= String.format("%.2f", grandTotal) %></h2>

    <!-- Navigation Buttons -->
    <div class="checkout-actions" style="margin: 20px 0;">
      <form action="callingmenuservlet" method="get" style="display:inline;">
        <input type="hidden" name="restaid" value="<%= restaid != null ? restaid : "" %>">
        <button type="submit" class="nav-btn">➕ Add More Items</button>
      </form>
    </div>

    <!-- Delivery Address + Payment -->
    <% if (userid != null && restaid != null) { %>
    <form action="callingCheckoutservlet" method="post" class="checkout-form" autocomplete="off">
      <h2>📦 Delivery Address</h2>
      <input type="text" name="name" placeholder="Full Name" required>
      <textarea name="address" placeholder="Address" rows="3" required></textarea>
      <input type="text" name="city" placeholder="City" required>
      <input type="text" name="pincode" placeholder="Pincode" required pattern="\d{6}" title="Enter a 6-digit pincode">

      <div class="payment-section">
        <label for="paymentmethod">Payment Method:</label>
        <select id="paymentmethod" name="paymentmethod" required>
          <option value="">-- Select Payment Method --</option>
          <option value="Cash on Delivery">Cash on Delivery</option>
          <option value="Paytm">Paytm</option>
          <option value="Credit/Debit Card">Credit/Debit Card</option>
        </select>
      </div>

      <!-- Hidden fields for backend -->
      <input type="hidden" name="userid" value="<%= userid %>">
      <input type="hidden" name="restaid" value="<%= restaid %>">
      <input type="hidden" name="totalamount" value="<%= String.format("%.2f", grandTotal) %>">

      <button type="submit" class="checkout-btn">Place Order</button>
    </form>
    <% } else { %>
      <p>Session expired or missing user info. Please log in again.</p>
      <form action="login.jsp" method="get">
        <button type="submit" class="nav-btn">🔐 Go to Login</button>
      </form>
    <% } %>

    <% } else { %>
    <p>Your cart is empty.</p>
    <form action="callinghomeservlet" method="get">
      <button type="submit" class="nav-btn">🏠 Return Home</button>
    </form>
    <% } %>
  </div>

</body>
</html>
