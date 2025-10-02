package com.edutrack.contoller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.edutrack.dao.UserDao;
import com.edutrack.model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		if(name==null || name.trim().isEmpty() ||
		   email==null || email.trim().isEmpty() ||
		   password==null || role==null || role.trim().isEmpty()) {
			
			HttpSession hs = request.getSession();
			hs.setAttribute("error", "All fields must be required");
			response.sendRedirect("register.jsp");
			return;
		}
		
		User u = new User();
		u.setName(name);
		u.setEmail(email);
		u.setPassword(password);
		u.setRole(role);
		
		UserDao udao = new UserDao();
		
		try {
			int insert = udao.insertUser(u);
			
			if(insert>0) {
				HttpSession hs = request.getSession();
				hs.setAttribute("success", "Registration Successfull");
				response.sendRedirect("login.jsp");
			}
			else if(insert == -1) {
				HttpSession hs = request.getSession();
				hs.setAttribute("duplicate", "Email Already Registered");
				response.sendRedirect("register.jsp");
			}
			else {
				HttpSession hs = request.getSession();
				hs.setAttribute("error1", "Something Went Wrong. Please try again.");
				response.sendRedirect("register.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			HttpSession hs = request.getSession();
			hs.setAttribute("unexpected", "Database issue. Try again later");
			response.sendRedirect("register.jsp");
		}
	}

}
