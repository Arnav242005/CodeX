package com.arnav.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.vedant.model.AffiliateModel;
import com.vedant.model.Contactmodel;
import com.vedant.model.SalesModel;
import com.vedant.model.Signup_individualmodel;
import com.vedant.model.paymentModel;
import com.vedant.model.signupMentorModel;

/**
 * Servlet implementation class adminDashboardLaunch
 */
@WebServlet("/adminDashboardLaunch")
public class adminDashboardLaunch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminDashboardLaunch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Configuration config = new Configuration();
		
		config.configure("hibernate.cfg.xml");
		
		config.addAnnotatedClass(Signup_individualmodel.class);
		
		config.addAnnotatedClass(paymentModel.class);
		
		config.addAnnotatedClass(signupMentorModel.class);
		
		config.addAnnotatedClass(SalesModel.class);
		
		config.addAnnotatedClass(AffiliateModel.class);
		
		config.addAnnotatedClass(Contactmodel.class);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = factory.openSession();
		
		try {
			Query<Long> query = session.createQuery("SELECT COUNT(u) FROM Signup_individualmodel u", Long.class);
			Long userCount = query.getSingleResult();

			Query<Long> query1 = session.createQuery("SELECT COUNT(u) FROM signupMentorModel u", Long.class);
			Long mentorCount = query1.getSingleResult();
			
			Query<Long> query2 = session.createQuery("SELECT COUNT(u) FROM SalesModel u", Long.class);
			Long projectCount = query2.getSingleResult();
			
			Query<Long> query3 = session.createQuery("SELECT COUNT(u) FROM paymentModel u", Long.class);
			Long purchasedCount = query3.getSingleResult();
			
			Query<Long> query4 = session.createQuery("SELECT COUNT(u) FROM Contactmodel u", Long.class);
			Long messageCount = query4.getSingleResult();
			
			Query<Long> query5 = session.createQuery("SELECT COUNT(u) FROM AffiliateModel u", Long.class);
			Long affiliateCount = query5.getSingleResult();
			

            request.setAttribute("userCount", userCount);
            request.setAttribute("mentorCount", mentorCount);
            request.setAttribute("projectCount", projectCount);
            request.setAttribute("purchasedCount", purchasedCount);
            request.setAttribute("messageCount", messageCount);
            request.setAttribute("affiliateCount", affiliateCount);

            request.getRequestDispatcher("adminControl.jsp").forward(request, response);

        }catch(Exception e) {
        	e.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }
	}

}
