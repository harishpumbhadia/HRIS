package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.dao.DepartmentDAO;

/**
 * Servlet implementation class DepartmentDeleteServlet
 */
@WebServlet("/DepartmentDeleteServlet")
public class DepartmentDeleteServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int deptId= Integer.parseInt( request.getParameter("did"));
		
		if(new DepartmentDAO().delete(deptId))
		{
			response.sendRedirect("DepartmentListServlet");
		}
		else
		{
			response.sendRedirect("DepartmentListServlet");
			
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
