package com.mail.blackbox.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mail.blackbox.factory.TestActionFactory;
import com.mail.blackbox.util.ConstanceValue;
import com.sun.corba.se.spi.orb.OperationFactory;

/**
 * Servlet implementation class BlackboxTestController
 */
@WebServlet(ConstanceValue.TEST_CONTROLLER)
public class BlackboxTestController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BlackboxTestController() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
	System.out.println(ConstanceValue.TEST_CONTROLLER);
	TestActionFactory.getOptionTestAction().execute(request, response);
	
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doGet(request, response);
    }

}
