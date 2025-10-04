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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao udao = new UserDao();
	
		try {
			User u = udao.getIdRoleByEmail(email);
			
			Integer userId = u.getUserId();
			String role = u.getRole();
			
			boolean isPresent = udao.checkUser(email, password);
			
			if(isPresent) {
				
				HttpSession hs = request.getSession();
				hs.setAttribute("userId", userId);
				hs.setAttribute("role", role);
				
				if(role.equals("STUDENT")) {
					response.sendRedirect("student.jsp");
				}
				else {
					response.sendRedirect("admin.jsp");
				}
			}
			else {
				response.getWriter().println("Invalid Email/Password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
