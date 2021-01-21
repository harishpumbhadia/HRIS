package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.dao.DesignationDAO;


/**
 * Servlet implementation class DesignationDeleteServlet
 */
@WebServlet("/DesignationDeleteServlet")
public class DesignationDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int designationId = Integer.parseInt(request.getParameter("designationId"));
		
		if(new DesignationDAO().delete(designationId)){
			response.sendRedirect("DesignationListServlet");
			
		}else{
			response.sendRedirect("DesignationListServlet");
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
