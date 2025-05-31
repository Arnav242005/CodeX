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
import com.vedant.model.signup_organizationmodel;

/**
 * Servlet implementation class loginorganizationLaunch
 */
@WebServlet("/loginorganizationLaunch")
public class loginorganizationLaunch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginorganizationLaunch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String companyemail = (String)request.getAttribute("companyemail");
		String password = (String)request.getAttribute("password");
		
		System.out.println(password);
		
		Configuration config = new Configuration();
		
		config.configure("hibernate.cfg.xml");
		
		config.addAnnotatedClass(signup_organizationmodel.class);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = factory.openSession();
		
		signup_organizationmodel user = session.createQuery(
        	    "FROM signup_organizationmodel WHERE companyemail = :companyemail", 
        	    signup_organizationmodel.class
        	).setParameter("companyemail", companyemail).uniqueResult();
        session.close();
        factory.close();

        if (user == null) {
            System.out.println("User not found");
            response.sendRedirect("loginorganization.jsp");
            return;
        }

        String storedHashedPassword = user.getPassword().trim(); 

        System.out.println("Stored Hashed Password: " + storedHashedPassword);
        
        System.out.println(user);

        if (BCrypt.checkpw(password, storedHashedPassword)) {
            System.out.println("Login successful");
            
            HttpSession sessionhandling = request.getSession();
            sessionhandling.setAttribute("email", companyemail);
            sessionhandling.setMaxInactiveInterval(30 * 60);

            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.forward(request, response);
        } else {
            System.out.println("Invalid password");
            response.sendRedirect("error.jsp"); // Redirect back to login
        }
	}

}
