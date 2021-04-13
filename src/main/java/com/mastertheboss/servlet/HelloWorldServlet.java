package com.mastertheboss.servlet;

import com.mastertheboss.servlet.util.GenericSendEmail;
import com.mastertheboss.servlet.util.Ldap;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8080/helloworld/email
@WebServlet(name = "email", urlPatterns = { "/email" })
public class HelloWorldServlet extends HttpServlet {

	public HelloWorldServlet() {
		super();

	}
	
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

		String fileName = System.getProperty("propertiesTestFile");
		System.out.println("&&&&&&&&&&& PROPERTY FILE NAME: " + fileName);

		Random rand = new Random(); //instance of random class
		int upperbound = 250000;
		int int_random = rand.nextInt(upperbound);

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Random#: " + int_random + "</h1>");
		writer.println("<h3>System Property Read test: </h3> <p style=" + "\"color:green;\">" + fileName + "</p>");

		String pass = new Ldap().getPassword();
		writer.println("<h3>Ldap test: </h3> <p style=" + "\"color:green;\">" + pass + "</p>");

		writer.close();

    }
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void sendEmail() {
		Random rand = new Random(); //instance of random class
		int upperbound = 250000;
		int int_random = rand.nextInt(upperbound);
		try {
			GenericSendEmail email = new GenericSendEmail();
			email.sendConfirmationEmail("saeed.dadashi@teranet.ca", "saeeddadashi82@gmail.com", "Hello " + Integer.toString(int_random), "test", null, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
