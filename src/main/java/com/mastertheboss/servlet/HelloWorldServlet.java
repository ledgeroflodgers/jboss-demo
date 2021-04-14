package com.mastertheboss.servlet;

import com.mastertheboss.servlet.util.GenericSendEmail;
import com.mastertheboss.servlet.util.Ldap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "email", urlPatterns = {"/call"})
public class HelloWorldServlet extends HttpServlet {

    public HelloWorldServlet() {
        super();

    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String fileName = System.getProperty("propertiesTestFile");
        System.out.println("&&&&&&&&&&& TEST PROPERTY FILE: " + fileName);

        Random rand = new Random(); //instance of random class
        int upperbound = 250000;
        int int_random = rand.nextInt(upperbound);

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        writer.println("<h2 style=" + "\"color:red;\">" + "Run#: " + int_random + "</h2>");
        writer.println("<h3>Test 1) Read form JAVA_OPTS: </h3> <p style=" + "\"color:green;\">" + fileName + "</p>");

        String pass = new Ldap().getPassword();
        writer.println("<h3>Test 2) Ldap: </h3> <p style=" + "\"color:green;\">" + pass + "</p>");

        writer.println("<h3>Test 3) Version: </h3> <p style=" + "\"color:green;\">" + System.getenv("JBOSS_VERSION") + "</p>");

        writer.close();

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
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
