package com.sanushi.javaweb.basics;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setName("Sanushi");
		user.setEmail("san@gmail.com");
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		request.setAttribute("user", user);
		dispatcher.forward(request, response);
	}

	 
}