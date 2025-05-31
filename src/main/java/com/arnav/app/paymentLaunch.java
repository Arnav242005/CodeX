package com.arnav.app;

import jakarta.servlet.RequestDispatcher;
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
import org.mindrot.jbcrypt.BCrypt;

import com.vedant.model.paymentModel;

/**
 * Servlet implementation class paymentLaunch
 */
@WebServlet("/paymentLaunch")
public class paymentLaunch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public paymentLaunch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getAttribute("name").toString();
		String email = request.getAttribute("email").toString();
		String referralCode = request.getAttribute("referralCode").toString();
		String address = request.getAttribute("address").toString();
		String city = request.getAttribute("city").toString();
		String state = request.getAttribute("state").toString();
		String zip = request.getAttribute("zip").toString();
		String nameOnCard = request.getAttribute("nameOnCard").toString();
		String cardNumber = request.getAttribute("cardNumber").toString();
		String expiryMonth = request.getAttribute("expiryMonth").toString();
		String expiryYear = request.getAttribute("expiryYear").toString();
		String CVV = request.getAttribute("CVV").toString();
		
		Configuration config = new Configuration();
		
		config.configure("hibernate.cfg.xml");
		
		config.addAnnotatedClass(paymentModel.class);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = null;
		
		Transaction transaction = null;
		
		boolean flag = false;
		
		String hashedzip = BCrypt.hashpw(zip, BCrypt.gensalt(12));
		String hashednameOnCard = BCrypt.hashpw(nameOnCard, BCrypt.gensalt(12));
		String hashedcardNumber = BCrypt.hashpw(cardNumber, BCrypt.gensalt(12));
		String hashedexpiryMonth = BCrypt.hashpw(expiryMonth, BCrypt.gensalt(12));
		String hashedexpiryYear = BCrypt.hashpw(expiryYear, BCrypt.gensalt(12));
		String hashedCVV = BCrypt.hashpw(CVV, BCrypt.gensalt(12));
		
		paymentModel pm = new paymentModel();
		pm.setName(name);
		pm.setEmail(email);
		pm.setCity(city);
		pm.setState(state);
		pm.setAddress(address);
		pm.setReferralCode(referralCode);
		pm.setHashedzip(hashedzip);
		pm.setHashednameOnCard(hashednameOnCard);
		pm.setHashedcardNumber(hashedcardNumber);
		pm.setHashedexpiryMonth(hashedexpiryMonth);
		pm.setHashedexpiryYear(hashedexpiryYear);
		pm.setHashedCVV(hashedCVV);
		
		try {
			session = factory.openSession();
			
			transaction = session.beginTransaction();
			
			session.persist(pm);
			
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
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.forward(request, response);
				
			}else {
				
				transaction.commit();
				session.close();
				factory.close();
				response.sendRedirect("paymentfailed.jsp");
				
			}
			
		}
	}

}
