package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.dao.LeaveCategoriesDAO;

/**
 * Servlet implementation class LeaveCategoriesDeleteServlet
 */
@WebServlet("/LeaveCategoriesDeleteServlet")
public class LeaveCategoriesDeleteServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int leaveId= Integer.parseInt( request.getParameter("lid"));
		
		if(new LeaveCategoriesDAO().delete(leaveId))
		{
			response.sendRedirect("LeaveCategoriesListServlet");
		}
		else
		{
			response.sendRedirect("LeaveCategoriesListServlet");
			
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
