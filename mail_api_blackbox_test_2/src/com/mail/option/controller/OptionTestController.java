package com.mail.option.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mail.blackbox.util.ConstanceValue;

/**
 * Servlet implementation class OptionTestController
 */
@WebServlet(ConstanceValue.OPTION_TEST_CONTROLLER)
public class OptionTestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public OptionTestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
