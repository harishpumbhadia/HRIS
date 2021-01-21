package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.dao.EmployeeEmerencyContactDAO;


/**
 * Servlet implementation class EmployeeEmergencyContactDeleteServlet
 */
@WebServlet("/EmployeeEmergencyContactDeleteServlet")
public class EmployeeEmergencyContactDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	
		int emergencyId = Integer.parseInt(request
				.getParameter("emergencyId"));
	
		
		if (new EmployeeEmerencyContactDAO().delete(emergencyId)) {
			response.sendRedirect("EmployeeEmergencyContactListServlet");

		} else {
			response.sendRedirect("EmployeeEmergencyContactListServlet");

		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
