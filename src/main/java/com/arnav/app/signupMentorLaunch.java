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

import com.vedant.model.signupMentorModel;

/**
 * Servlet implementation class signupMentorLaunch
 */
@WebServlet("/signupMentorLaunch")
public class signupMentorLaunch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupMentorLaunch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getAttribute("name").toString();
		String email = request.getAttribute("email").toString();
		String expertise = request.getAttribute("expertise").toString();
		String city = request.getAttribute("city").toString();
		String gitlink = request.getAttribute("gitlink").toString();
		String phone = request.getAttribute("phone").toString();
		String availability = request.getAttribute("availability").toString();
		
		Configuration config = new Configuration();
		
		config.configure("hibernate.cfg.xml");
		
		config.addAnnotatedClass(signupMentorModel.class);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = null;
		
		Transaction transaction = null;
		
		boolean flag = false;
		
		signupMentorModel smm = new signupMentorModel();
		smm.setName(name);
		smm.setEmail(email);
		smm.setCity(city);
		smm.setExperise(expertise);
		smm.setAvailability(availability);
		smm.setGitlink(gitlink);
		smm.setPhone(phone);
		
		try {
			
			session = factory.openSession();
			
			transaction = session.beginTransaction();
			
			session.persist(smm);
			
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
				response.sendRedirect("index.html");
				
			}else {
				
				transaction.rollback();
				session.close();
				factory.close();
				response.sendRedirect("error.jsp");
				
			}
			
		}
	}

}
