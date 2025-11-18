package servlets;

import java.io.IOException;
import com.food.model.user;
import com.tap.daoimp.userdaoimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

  // ✅ Handles GET requests (e.g., direct browser access)
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.sendRedirect("register.html");
  }

  // ✅ Handles POST requests from the registration form
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");

    String name = req.getParameter("name");
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    String email = req.getParameter("email");
    String phonenumber = req.getParameter("phonenumber");
    String address = req.getParameter("address");
    String role = req.getParameter("role");

    user u = new user(name, username, password, email, phonenumber, address, role);
    userdaoimpl udao = new userdaoimpl();
    boolean success = udao.addUser(u);

    if (success) {
      resp.sendRedirect("login.jsp?msg=Registration+successful");
    } else {
      resp.sendRedirect("register.jsp?error=Registration+failed");
    }
  }
}