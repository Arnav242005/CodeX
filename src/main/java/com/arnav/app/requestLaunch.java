package com.arnav.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.vedant.model.SalesModel;
import com.vedant.model.requestModel;

/**
 * Servlet implementation class requestLaunch
 */
@WebServlet("/requestLaunch")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024,  // 1MB before saving to disk
	    maxFileSize = 1024 * 1024 * 10,   // 10MB max per file
	    maxRequestSize = 1024 * 1024 * 20 // 20MB max for the whole request
	)
public class requestLaunch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public requestLaunch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String projectType = request.getParameter("projectType");
		Part filePart = request.getPart("textfile");
		String filename = filePart.getSubmittedFileName();
		
		@SuppressWarnings("resource")
		String filecontent = new BufferedReader(new InputStreamReader(filePart.getInputStream())).lines().collect(Collectors.joining("\n"));
		
		Configuration config = new Configuration();
		
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(requestModel.class);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = null;
		
		Transaction transaction = null;
		
		boolean flag = false;
		
		requestModel rm = new requestModel();
		rm.setFirstName(firstName);
		rm.setLastName(lastName);
		rm.setEmail(email);
		rm.setFilename(filename);
		rm.setContent(filecontent);
		rm.setProjectType(projectType);
		
		try {
			
			session = factory.openSession();
			
			transaction = session.beginTransaction();
			
			session.persist(rm);
			
			response.sendRedirect("index.html");
			
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
				
			}else {
				
				transaction.rollback();
				session.close();
				factory.close();
				response.sendRedirect("error.jsp");
				
			}
			
		}
		
	}

}
