package com.vedant.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class resetPasswordIndividual
 */
@WebServlet("/resetPasswordIndividual")
public class resetPasswordIndividual extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pass = request.getParameter("password");
		
		RequestDispatcher rd = request.getRequestDispatcher("resetPasswordIndividualLaunch");
		request.setAttribute("pass", pass);
		rd.forward(request, response);
	}

}
