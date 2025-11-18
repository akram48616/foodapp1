package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.rest.food.app.rest;
import com.restdaoimpl.foodapp.restdaoimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/callinghomeservlet")
public class homeservlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    
	        restdaoimpl daoimpl = new restdaoimpl();
	        List<rest> allresa = daoimpl.getresta(); // Ensure this method throws SQLException
	        for(rest r:allresa) {
	        	System.out.println(r);
	        }
	        req.setAttribute("allresa" , allresa);
	        RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
	        rd.forward(req, resp);
	   
	}

    }
