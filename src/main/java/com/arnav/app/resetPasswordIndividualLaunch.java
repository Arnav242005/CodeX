package com.arnav.app;

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
import org.hibernate.query.MutationQuery;
import org.mindrot.jbcrypt.BCrypt;

import com.vedant.model.Signup_individualmodel;

/**
 * Servlet implementation class resetPasswordIndividualLaunch
 */
@WebServlet("/resetPasswordIndividualLaunch")
public class resetPasswordIndividualLaunch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resetPasswordIndividualLaunch() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessionObj = request.getSession(false); 

		if (sessionObj == null || sessionObj.getAttribute("emailcheck") == null) {
		    response.sendRedirect("forgotindividual.jsp");
		    return;
		}

		String email = (String) sessionObj.getAttribute("emailcheck");
		String pass = request.getAttribute("pass").toString();
		
		Configuration config = new Configuration();
		
		config.configure();
		
		config.addAnnotatedClass(Signup_individualmodel.class);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = null;
		
		Transaction transaction = null;
		
		boolean flag = false;
		
		String password = BCrypt.hashpw(pass, BCrypt.gensalt(12));
		
		try {
			
			session = factory.openSession();
			
			transaction = session.beginTransaction();
			
			String hql = "UPDATE Signup_individualmodel s SET s.password = :newPassword WHERE s.email = :email";
			
			MutationQuery query = session.createMutationQuery(hql);
			
			query.setParameter("newPassword", password); // Make sure it's hashed!
		    query.setParameter("email", email);

		    int rowsUpdated = query.executeUpdate();
		    System.out.println("Rows updated: " + rowsUpdated);
			
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
				response.sendRedirect("loginindividual.jsp?success=password");
			}else {
				
				transaction.rollback();
				session.close();
				factory.close();
				response.sendRedirect("error.jsp");
				
			}
			
		}
	}

}
