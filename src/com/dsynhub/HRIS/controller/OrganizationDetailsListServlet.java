package com.dsynhub.HRIS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.OrganizationDetailsBean;
import com.dsynhub.HRIS.dao.OrganizationDetailsDAO;


/**
 * Servlet implementation class OrganizationDetailsListServlet
 */
@WebServlet("/OrganizationDetailsListServlet")
public class OrganizationDetailsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		List <OrganizationDetailsBean> listofOrganizationDetails= new OrganizationDetailsDAO().list();
		
		if(listofOrganizationDetails!=null)
		{
			request.setAttribute("listofOrganizationDetails", listofOrganizationDetails);
			request.getRequestDispatcher("organizationDetailsList.jsp").forward(request, response);
			
		}
		
		else
			System.out.println("List is Empty");
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			doGet(request, response);
	}

}
