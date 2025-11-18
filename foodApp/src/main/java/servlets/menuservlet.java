package servlets;

import java.io.IOException;
import java.util.List;

import com.menu.menu;
import com.menudaoimpl.menudaoimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/callingmenuservlet")
public class menuservlet extends HttpServlet {

  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();

    // ✅ Step 1: Set or retrieve userid
    Integer userId = null;
    String userIdParam = req.getParameter("userid");

    if (userIdParam != null && !userIdParam.isEmpty()) {
      try {
        userId = Integer.parseInt(userIdParam);
        session.setAttribute("userid", userId);
      } catch (NumberFormatException e) {
        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid userid format");
        return;
      }
    } else if (session.getAttribute("userid") != null) {
      userId = (Integer) session.getAttribute("userid");
    } else {
      // ✅ TEMP fallback for testing without login
      userId = 101;
      session.setAttribute("userid", userId);
    }

    // ✅ Step 2: Set or retrieve restaid
    Integer restaid = null;
    String restaidParam = req.getParameter("restaid");

    if (restaidParam != null && !restaidParam.isEmpty()) {
      try {
        restaid = Integer.parseInt(restaidParam);
        session.setAttribute("restaid", restaid);
      } catch (NumberFormatException e) {
        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid restaid format");
        return;
      }
    } else if (session.getAttribute("restaid") != null) {
      restaid = (Integer) session.getAttribute("restaid");
    } else {
      resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing restaid parameter");
      return;
    }

    // ✅ Step 3: Load menu and forward
    menudaoimpl daoimpl = new menudaoimpl();
    List<menu> menuList = daoimpl.getMenuByRestaid(restaid);

    req.setAttribute("allmenu", menuList);
    req.setAttribute("restaid", restaid);

    RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
    rd.forward(req, resp);
  }
}