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

import com.vedant.model.signup_organizationmodel;

/**
 * Servlet implementation class deleteOrganizationLaunch
 */
@WebServlet("/deleteOrganizationLaunch")
public class deleteOrganizationLaunch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteOrganizationLaunch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String companyemail = request.getAttribute("email").toString();
		String password = request.getAttribute("password").toString();
		
Configuration config = new Configuration();
		
		config.configure("hibernate.cfg.xml");
		
		config.addAnnotatedClass(signup_organizationmodel.class);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = null;
		
		Transaction transaction = null;
		
		boolean flag = false;
		
		try {
			
		session = factory.openSession();
		
		transaction = session.beginTransaction();
			
		MutationQuery query = session.createMutationQuery("DELETE FROM signup_organizationmodel WHERE companyemail = :companyemail");

		query.setParameter("companyemail", companyemail);

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
