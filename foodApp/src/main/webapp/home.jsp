<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.rest.food.app.rest, java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>FoodFinder - Top Indian Restaurants</title>
  <link rel="stylesheet" href="restaurant.css" />
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
      List<rest> restList = (List<rest>) request.getAttribute("allresa");
      if (restList != null) {
        for (rest r : restList) {
    %>

    <div class="card">
      <img src="<%=r.getImage() %>" 
           alt="<%=r.getName() %>">
      <div class="card-content">
        <h3><%=r.getName() %></h3>
        <p><%=r.getCusine_type() %></p>
        <div class="info">
          <span><%=r.getRating() %></span>
          <span>ETA: <%=r.getDeliverytime() %></span>
          <div>
           <a href="callingmenuservlet?restaid=<%= r.getRestaid() %>" class="menu-link">View Menu</a>
          
          </div>
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
