package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.dao.StateDAO;

/**
 * Servlet implementation class StateDeleteServlet
 */
@WebServlet("/StateDeleteServlet")
public class StateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		int stateId = Integer.parseInt(request.getParameter("sid"));
		
		if(new StateDAO().delete(stateId)){
			response.sendRedirect("StateListServlet");
			
		}else{
			response.sendRedirect("StateListServlet");
			
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
