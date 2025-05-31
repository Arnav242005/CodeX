package com.vedant.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class signupMentorServlet
 */
@WebServlet("/signupMentorServlet")
public class signupMentorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupMentorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String expertise = request.getParameter("expertise");
		String city = request.getParameter("city");
		String gitlink = request.getParameter("gitlink");
		String phone = request.getParameter("phone");
		String availability = request.getParameter("availability");
		
		RequestDispatcher rd = request.getRequestDispatcher("signupMentorLaunch");
		request.setAttribute("name", name);
		request.setAttribute("email", email);
		request.setAttribute("expertise", expertise);
		request.setAttribute("city", city);
		request.setAttribute("gitlink", gitlink);
		request.setAttribute("phone", phone);
		request.setAttribute("availability", availability);
		rd.forward(request, response);
		
	}

}
