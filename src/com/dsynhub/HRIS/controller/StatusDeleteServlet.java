package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.dao.StatusDAO;

/**
 * Servlet implementation class StatusDeleteServlet
 */
@WebServlet("/StatusDeleteServlet")
public class StatusDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		 
		int statusId=Integer.parseInt(request.getParameter("statusId"));
		
		if(new StatusDAO().delete(statusId))
		{

			response.sendRedirect("StatusListServlet");
		}
		
		else
		{
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
