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
 * Servlet implementation class OrganizationDetailsUpdateServlet
 */
@WebServlet("/OrganizationDetailsUpdateServlet")
public class OrganizationDetailsUpdateServlet extends HttpServlet {
	
	int organizationId ;
	String organizationName ;
	String organizationAddress ;
	int cityId ;
	String cityName ;
	int stateId ;
	String stateName ;
	int countryId ;
	String countryName ;
	String contactNo ;
	String emailId ;
	String website ;


	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		organizationId = Integer.parseInt(request.getParameter("organizationId"));
		organizationName = request.getParameter("organizationName");
		organizationAddress = request.getParameter("organizationAddress");
		cityId = Integer.parseInt(request.getParameter("cityId"));
		stateId = Integer.parseInt(request.getParameter("stateId"));
		countryId = Integer.parseInt(request.getParameter("countryId"));
		contactNo = request.getParameter("contactNo");
		emailId = request.getParameter("emailId");
		website = request.getParameter("website");
		
		
		OrganizationDetailsBean organizationDetails= new OrganizationDetailsBean() ;
		
		organizationDetails.setOrganizationId(organizationId);
		organizationDetails.setOrganizationName(organizationName);
		organizationDetails.setOrganizationAddress(organizationAddress);
		organizationDetails.setCityId(cityId);
		organizationDetails.setStateId(stateId);
		organizationDetails.setCountryId(countryId);
		organizationDetails.setContactNo(contactNo);
		organizationDetails.setEmailId(emailId);
		organizationDetails.setWebsite(website);

		if(new OrganizationDetailsDAO().update(organizationDetails)){
		
			response.sendRedirect("OrganizationDetailsListServlet");
		}
		
		else
			System.out.println("Error ");
		
	}


		
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
	}
}
