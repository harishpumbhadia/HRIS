package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.CountryBean;
import com.dsynhub.HRIS.dao.CountryDAO;

/**
 * Servlet implementation class CountryEditServlet
 */
@WebServlet("/CountryEditServlet")
public class CountryEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int countryId = Integer.parseInt(request.getParameter("cid"));
		
		CountryBean country = new CountryDAO().getByPK(countryId);
		
		if(country!=null)
		{
			request.setAttribute("country", country);
			
			request.getRequestDispatcher("countryEdit.jsp").forward(request, response);
			
		}
		else
		{
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
