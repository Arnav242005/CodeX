package com.arnav.app;


import jakarta.servlet.RequestDispatcher;
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
import org.mindrot.jbcrypt.BCrypt;

import com.vedant.model.Signup_individualmodel;



/**
 * Servlet implementation class loginindividualLaunch
 */
@WebServlet("/loginindividualLaunch")
public class loginindividualLaunch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginindividualLaunch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String)request.getAttribute("email");
		String pass = (String)request.getAttribute("pass");
		
		System.out.println(email);
        System.out.println(pass);
        System.out.println("Got value from front end");

        // Load Hibernate configuration
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Signup_individualmodel.class);
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        Signup_individualmodel user = session.createQuery(
        	    "FROM Signup_individualmodel WHERE email = :email", 
        	    Signup_individualmodel.class
        	).setParameter("email", email).uniqueResult();
        session.close();
        factory.close();

        if (user == null) {
            System.out.println("User not found");
            response.sendRedirect("loginindividual.jsp"); // Redirect back to login if user not found
            return;
        }

        String storedHashedPassword = user.getPassword().trim(); // Get hashed password from DB

        System.out.println("Stored Hashed Password: " + storedHashedPassword);

        if (BCrypt.checkpw(pass, storedHashedPassword)) {  // Compare passwords
            System.out.println("Login successful");
            
            HttpSession sessionhandling = request.getSession();
            sessionhandling.setAttribute("email", email);
            sessionhandling.setMaxInactiveInterval(30 * 60);

            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.forward(request, response);
        } else {
            System.out.println("Invalid password");
            response.sendRedirect("error.jsp"); // Redirect back to login
        }
		
		
	}

}
