package com.sanushi.javaweb.basics;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author - S Salgado 
 * Date   - 29/11/2020
 */
@WebServlet(urlPatterns = { "/home", "*.abc" }, name="SimpleServlet", initParams = {
		@WebInitParam(name = "AppName", value = "Demo Servlet"),
		@WebInitParam(name = "Author", value = "Abc")})
public class SimpleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	String appName;
	String author;

	@Override
	public void init() {
		appName = getInitParameter("AppName");
		author = getServletContext().getInitParameter("Author");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		if (name != null) {
			response.setContentType("text/xml");
			response.getWriter().printf("<application><greeting>Hello %s</greeting><app>%s</app><author>%s</author></application>", name,
					appName, author);
		} else
			//response.getWriter().append("Hello World!");
			throw new ServletException("Name cannot be null! Please enter a name.");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		if (name != null && !name.isEmpty())
			response.getWriter().printf("Hello %s", name);
		else
			response.sendRedirect("index.jsp");
	}

}
