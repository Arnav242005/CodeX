package com.arnav.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.vedant.model.Signup_individualmodel;

/**
 * Servlet implementation class deleteIndividualLaunch
 */
@WebServlet("/deleteIndividualLaunch")
public class deleteIndividualLaunch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteIndividualLaunch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getAttribute("email").toString();
		String password = request.getAttribute("password").toString();
		
		Configuration config = new Configuration();
		
		config.configure("hibernate.cfg.xml");
		
		config.addAnnotatedClass(Signup_individualmodel.class);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = null;;
		
		Transaction transaction = null;
		
		boolean flag = false;
		
		try {
			
		session = factory.openSession();
		
		transaction = session.beginTransaction();
			
		MutationQuery query = session.createMutationQuery("DELETE FROM Signup_individualmodel WHERE email = :email");

		query.setParameter("email", email);

		flag = true;
		
		int result = query.executeUpdate();

		if(result > 0) {
			response.sendRedirect("index.html");
		}else {
			response.sendRedirect("error.jsp");
		}
		
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(flag == true) {
				
				transaction.commit();
				session.close();
				factory.close();
				
			}else {
				
				transaction.rollback();
				session.close();
				factory.close();
			}
			
		}
		
	}

}
