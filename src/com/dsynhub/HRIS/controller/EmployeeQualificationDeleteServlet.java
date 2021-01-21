package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dsynhub.HRIS.dao.EmployeeQualificationDAO;

/**
 * Servlet implementation class EmployeeQualificationDeleteServlet
 */
@WebServlet("/EmployeeQualificationDeleteServlet")
public class EmployeeQualificationDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	
		int employeeQualificationId = Integer.parseInt(request
				.getParameter("employeeQualificationId"));
		System.out.println("Employee Delete " + employeeQualificationId);
		
		if (new EmployeeQualificationDAO().delete(employeeQualificationId)) {
			response.sendRedirect("EmployeeQualificationListServlet");

		} else {
			response.sendRedirect("EmployeeQualificationListServlet");

		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
