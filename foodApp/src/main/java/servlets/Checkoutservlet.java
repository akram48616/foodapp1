package servlets;

import java.io.IOException;
import java.sql.Connection;

import com.tap.checkout.order;
import com.tap.checkoutimpl.OrderImpl;
import com.checkoutimpl.OrderDao;
import com.food.app.dbconnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/callingCheckoutservlet")
public class Checkoutservlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            // 1. Validate and parse parameters
            String userIdStr = req.getParameter("userid");
            String restIdStr = req.getParameter("restaid");
            String totalAmountStr = req.getParameter("totalamount");
            System.out.println("userid: " + userIdStr);
            System.out.println("restaid: " + restIdStr);
            System.out.println("totalamount: " + totalAmountStr);


            if (userIdStr == null || restIdStr == null || totalAmountStr == null ||
                userIdStr.isEmpty() || restIdStr.isEmpty() || totalAmountStr.isEmpty()) {
            	req.setAttribute("errorMessage", "Missing required form data. Please check your session or try again.");
            	RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
            	rd.forward(req, resp);
            	return;

            }

            int userId = Integer.parseInt(userIdStr);
            int restId = Integer.parseInt(restIdStr);
            double totalAmount = Double.parseDouble(totalAmountStr);
            String paymentMethod = req.getParameter("paymentmethod");
            String status = "Placed";

            // Optional delivery info
            String name = req.getParameter("name");
            String address = req.getParameter("address");
            String city = req.getParameter("city");
            String pincode = req.getParameter("pincode");

            // 2. Create order object
            order order = new order();
            order.setUserId(userId);
            order.setRestId(restId);
            order.setTotalAmount(totalAmount);
            order.setPaymentMethod(paymentMethod);
            order.setStatus(status);

            // 3. Insert into DB
            try (Connection conn = dbconnection.getConnection()) {
                OrderDao dao = new OrderImpl(conn);
                boolean success = dao.insertOrder(order);

                if (success) {
                    req.setAttribute("orderId", order.getOrderId());
                    RequestDispatcher rd = req.getRequestDispatcher("confirmation.jsp");
                    rd.forward(req, resp);
                } else {
                    RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
                    rd.forward(req, resp);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("checkout.jsp");
        rd.forward(req, resp);
    }
}