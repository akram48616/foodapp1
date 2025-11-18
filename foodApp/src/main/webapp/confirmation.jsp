<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Order Confirmation</title>
  <link rel="stylesheet" href="checkout.css">
</head>
<body>
  <div class="checkout-container">
    <h1 style="color: green;">✅ Order Placed Successfully!</h1>
    <p>Thank you for your order.</p>
    <h2>Your Order ID: <span style="color: blue;"><%= request.getAttribute("orderId") %></span></h2>

    <div style="margin-top: 30px;">
      <form action="callinghomeservlet" method="get">
        <button type="submit" class="nav-btn">🏠 Return to Home</button>
      </form>
    </div>
  </div>
</body>
</html>