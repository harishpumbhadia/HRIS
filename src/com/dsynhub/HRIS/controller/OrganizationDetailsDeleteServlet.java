package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.dao.OrganizationDetailsDAO;


/**
 * Servlet implementation class OrganizationDetailsDeleteServlet
 */
@WebServlet("/OrganizationDetailsDeleteServlet")
public class OrganizationDetailsDeleteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		int organizationId = Integer.parseInt(request
				.getParameter("organizationId"));

		
		if (new OrganizationDetailsDAO().delete(organizationId)) {
			response.sendRedirect("OrganizationDetailsListServlet");

		} else {
			response.sendRedirect("OrganizationDetailsListServlet");

		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
