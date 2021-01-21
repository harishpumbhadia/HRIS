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
 * Servlet implementation class OrganizationDetailsInsertServlet
 */
@WebServlet("/OrganizationDetailsInsertServlet")
public class OrganizationDetailsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
	String organizationName = request.getParameter("organizationName");
	String	organizationAddress = request.getParameter("organizationAddress");
	int	cityId = Integer.parseInt(request.getParameter("cityId"));
	int	stateId = Integer.parseInt(request.getParameter("stateId"));
	int	countryId = Integer.parseInt(request.getParameter("countryId"));
	String	contactNo = request.getParameter("contactNo");
	String	emailId = request.getParameter("emailId");
	String	website = request.getParameter("website");
		
		OrganizationDetailsBean organizationDetails= new OrganizationDetailsBean() ;
		
		organizationDetails.setOrganizationName(organizationName);
		organizationDetails.setOrganizationAddress(organizationAddress);
		organizationDetails.setCityId(cityId);
		organizationDetails.setStateId(stateId);
		organizationDetails.setCountryId(countryId);
		organizationDetails.setContactNo(contactNo);
		organizationDetails.setEmailId(emailId);
		organizationDetails.setWebsite(website);
		

		if(new OrganizationDetailsDAO().insert(organizationDetails)){
		
			response.sendRedirect("OrganizationDetailsListServlet");
		}
		
		else
			System.out.println("Error ");
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	

}
