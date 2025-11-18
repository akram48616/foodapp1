<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.menu.menu, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>FoodFinder Menu</title>
  <link rel="stylesheet" href="menu.css" />
</head>
<body>

 <nav class="navbar">
    <div class="logo">FoodFinder</div>
    <ul class="nav-links">
      <li><a href="callinghomeservlet">Home</a></li>
      <% if (session.getAttribute("restaid") != null) { %>
        <li><a href="callingmenuservlet?restaid=<%= session.getAttribute("restaid") %>">Menu</a></li>
      <% } %>
     
    </ul>
  </nav>
  <section class="hero">
    <h1>Top Rated Restaurants in the USA 🇺🇸</h1>
    <p>Discover the most loved places to eat — from coast to coast!</p>
  </section>
  

 

  <section class="restaurant-grid">
    <%
      List<menu> menuList = (List<menu>) request.getAttribute("allmenu");
      if (menuList != null) {
        for (menu m : menuList) {
    %>
    <div class="card">
      <img src="<%= m.getImagepath() %>" alt="<%= m.getItemname() %>">
      <div class="card-content">
        <h3><%= m.getItemname() %></h3>
        <p><%= m.getDescrption() %></p>
        <div class="info">
          <span style="color:#18b767;">💲<%= m.getPrice() %></span>
          

          <!-- ✅ Add to Cart Form -->
          <form action="cart" method="post">
            <input type="hidden" name="itemid" value="<%= m.getMenuid() %>">
            <input type="hidden" name="name" value="<%= m.getItemname() %>">
            <input type="hidden" name="price" value="<%= m.getPrice() %>">
            <input type="hidden" name="quantity" value="1">
            <input type="hidden" name="restaid" value="<%= m.getRestaid() %>">
            <input type="hidden" name="userid" value="101"> 
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Add to Cart" class="add-btn">
          </form>
        </div>
      </div>
    </div>
    <%
        }
      }
    %>
  </section>

</body>
</html>