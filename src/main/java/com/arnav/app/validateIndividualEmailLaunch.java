package com.arnav.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vedant.model.Signup_individualmodel;

/**
 * Servlet implementation class validateIndividualEmailLaunch
 */
@WebServlet("/validateIndividualEmailLaunch")
public class validateIndividualEmailLaunch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validateIndividualEmailLaunch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getAttribute("email").toString();
		
		Configuration config = new Configuration();
		
		config.configure("hibernate.cfg.xml");
		
		config.addAnnotatedClass(Signup_individualmodel.class);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Signup_individualmodel user = session.createQuery("FROM Signup_individualmodel WHERE email = :email", 
        	    Signup_individualmodel.class
        	).setParameter("email", email).uniqueResult();
		
		
			
		try {
			System.out.println(user.getEmail());
			System.out.println(email);
			if(user.getEmail().equals(email)) {
				response.sendRedirect("forgotenterPasswordIndividual.jsp");
			}
			
			HttpSession sessionhandling = request.getSession();
			sessionhandling.setAttribute("emailcheck", user.getEmail());
		}catch(Exception e) {
			
			response.sendRedirect("forgotindividual.jsp?error=email");
			
		}finally {
			
			session.close();
			factory.close();
			
		}
	}

}
