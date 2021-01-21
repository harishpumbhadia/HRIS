package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.OrganizationDetailsBean;
import com.dsynhub.HRIS.dao.OrganizationDetailsDAO;

/**
 * Servlet implementation class OrganizationDetailsEditServlet
 */
@WebServlet("/OrganizationDetailsEditServlet")
public class OrganizationDetailsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int organizationId =Integer.parseInt(request.getParameter("organizationId"));

		
		OrganizationDetailsBean organizationDetails= new OrganizationDetailsDAO().getByPK(organizationId);
	
		if(organizationDetails!=null){
			request.setAttribute("organizationDetails", organizationDetails);
			request.getRequestDispatcher("organizationDetailsEdit.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
