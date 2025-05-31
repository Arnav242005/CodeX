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
import com.vedant.model.signup_organizationmodel;

/**
 * Servlet implementation class validateOrganizationEmailLaunch
 */
@WebServlet("/validateOrganizationEmailLaunch")
public class validateOrganizationEmailLaunch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validateOrganizationEmailLaunch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String companyemail = request.getAttribute("companyemail").toString();
		
		Configuration config = new Configuration();
		
		config.configure("hibernate.cfg.xml");
		
		config.addAnnotatedClass(signup_organizationmodel.class);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = factory.openSession();
		
		signup_organizationmodel user = session.createQuery("FROM signup_organizationmodel WHERE companyemail = :companyemail", 
        	    signup_organizationmodel.class
        	).setParameter("companyemail", companyemail).uniqueResult();
		
		
			
		try {
			System.out.println(user.getCompanyemail());
			System.out.println(companyemail);
			if(user.getCompanyemail().equals(companyemail)) {
				response.sendRedirect("forgotenterPasswordOrganization.jsp");
			}
			
			HttpSession sessionhandling = request.getSession();
			sessionhandling.setAttribute("emailorganizationcheck", user.getCompanyemail());
		}catch(Exception e) {
			
			response.sendRedirect("forgotorganization.jsp?error=companyemail");
			
		}finally {
			
			session.close();
			factory.close();
			
		}
	}

}
