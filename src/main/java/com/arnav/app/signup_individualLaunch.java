package com.arnav.app;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.mindrot.jbcrypt.BCrypt;

import com.vedant.model.Signup_individualmodel;

/**
 * Servlet implementation class signup_individualLaunch
 */
@WebServlet("/signup_individualLaunch")
public class signup_individualLaunch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup_individualLaunch() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = (String)request.getAttribute("firstName");
		String lastname = (String)request.getAttribute("lastName");
		String email = (String)request.getAttribute("email");
		String pass = (String)request.getAttribute("password");
		
		System.out.println(pass);
		System.out.println(firstname);
		Configuration config = new Configuration();
		
		config.configure("hibernate.cfg.xml");
		
		config.addAnnotatedClass(Signup_individualmodel.class);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = null;
		
		Transaction transaction = null;
		
		boolean flag = false;
		
		String password = BCrypt.hashpw(pass, BCrypt.gensalt(12));
		
		Signup_individualmodel signup = new Signup_individualmodel();
		signup.setFirst_name(firstname);
		signup.setLast_name(lastname);
		signup.setEmail(email);
		signup.setPassword(password);
		
		try {
			
			session= factory.openSession();
			
			transaction = session.beginTransaction();
		
			session.persist(signup);
			
			flag = true;
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(flag == true) {
				
				transaction.commit();
				session.close();
				factory.close();
				RequestDispatcher rd = request.getRequestDispatcher("loginindividual.jsp");
				rd.forward(request, response);
				
			}else {
				
				transaction.rollback();
				session.close();
				factory.close();
				response.sendRedirect("error.jsp");
				
			}
			
		}
	}

}
