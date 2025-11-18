<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Error</title>
  <link rel="stylesheet" href="checkout.css">
</head>
<body>
  <div class="checkout-container">
    <h1 style="color: red;">❌ Something went wrong</h1>
    <p>We couldn't place your order due to a technical issue.</p>
    <p>Please try again or contact support if the problem persists.</p>
    <p style="color:red;">
  <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "Something went wrong." %>
</p>

    <div style="margin-top: 30px;">
      <form action="checkout.jsp" method="get">
        <button type="submit" class="nav-btn">🔁 Try Again</button>
      </form>
    </div>
  </div>
</body>
</html>