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
import com.vedant.model.signup_organizationmodel;

/**
 * Servlet implementation class resetPasswordOrganizationLaunch
 */
@WebServlet("/resetPasswordOrganizationLaunch")
public class resetPasswordOrganizationLaunch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resetPasswordOrganizationLaunch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pass = request.getAttribute("pass").toString();
		
		String password = BCrypt.hashpw(pass, BCrypt.gensalt(12));
		
		HttpSession sessionObj = request.getSession(false); 

		if (sessionObj == null || sessionObj.getAttribute("emailorganizationcheck") == null) {
		    response.sendRedirect("forgotorganization.jsp");
		    return;
		}

		String companyemail = (String) sessionObj.getAttribute("emailorganizationcheck");
		
		Configuration config = new Configuration();
		
		config.configure();
		
		config.addAnnotatedClass(signup_organizationmodel.class);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = null;
		
		Transaction transaction = null;
		
		boolean flag = false;
		
		try {
			
			session = factory.openSession();
			
			transaction = session.beginTransaction();
			
			String hql = "UPDATE signup_organizationmodel s SET s.password = :newPassword WHERE s.companyemail = :companyemail";
			
			MutationQuery query = session.createMutationQuery(hql);
			
			query.setParameter("newPassword", password); 
		    query.setParameter("companyemail", companyemail);

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
				response.sendRedirect("loginorganization.jsp?success=password");
			}else {
				
				transaction.rollback();
				session.close();
				factory.close();
				response.sendRedirect("error.jsp");
				
			}
			
		}
		
	}

}
