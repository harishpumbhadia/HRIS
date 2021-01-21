package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.dao.CountryDAO;

/**
 * Servlet implementation class CountryDeleteServlet
 */
@WebServlet("/CountryDeleteServlet")
public class CountryDeleteServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int countryId= Integer.parseInt( request.getParameter("cid"));
		
		if(new CountryDAO().delete(countryId))
		{
			response.sendRedirect("CountryListServlet");
		}
		else
		{
			response.sendRedirect("CountryListServlet");
			
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
