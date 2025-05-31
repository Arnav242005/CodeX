package com.vedant.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class paymentServlet
 */
@WebServlet("/paymentServlet")
public class paymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public paymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessionObj = request.getSession(false); // Don't create a new session if none exists

		if (sessionObj == null || sessionObj.getAttribute("email") == null) {
		    response.sendRedirect("login.jsp"); // Redirect to login page if session is null or email is missing
		    return;
		}
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String referralCode = request.getParameter("referralCode");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String nameOnCard = request.getParameter("nameOnCard");
		String cardNumber = request.getParameter("cardNumber");
		String expiryMonth = request.getParameter("expiryMonth");
		String expiryYear = request.getParameter("expiryYear");
		String CVV = request.getParameter("CVV");
		
		RequestDispatcher rd = request.getRequestDispatcher("paymentLaunch");
		request.setAttribute("name", name);
		request.setAttribute("email", email);
		request.setAttribute("referralCode", referralCode);
		request.setAttribute("address", address);
		request.setAttribute("city", city);
		request.setAttribute("state", state);
		request.setAttribute("zip", zip);
		request.setAttribute("nameOnCard", nameOnCard);
		request.setAttribute("cardNumber", cardNumber);
		request.setAttribute("expiryMonth", expiryMonth);
		request.setAttribute("expiryYear", expiryYear);
		request.setAttribute("CVV", CVV);
		rd.forward(request, response);
		
	}

}
