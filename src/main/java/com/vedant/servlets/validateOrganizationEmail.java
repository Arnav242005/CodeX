package com.vedant.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class validateOrganizationEmail
 */
@WebServlet("/validateOrganizationEmail")
public class validateOrganizationEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validateOrganizationEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String companyemail = request.getParameter("companyemail");
		
		RequestDispatcher rd = request.getRequestDispatcher("validateOrganizationEmailLaunch");
		request.setAttribute("companyemail", companyemail);
		rd.forward(request, response);
	}

}
