package com.dsynhub.HRIS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.CountryBean;
import com.dsynhub.HRIS.dao.CountryDAO;

/**
 * Servlet implementation class CountryListServlet
 */
@WebServlet("/CountryListServlet")
public class CountryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		List <CountryBean> listofCountry= new CountryDAO().list();
		
		if(listofCountry!=null)
		{
			request.setAttribute("listofCountry", listofCountry);
			request.getRequestDispatcher("countryList.jsp").forward(request, response);
			
		}
		
		else
			System.out.println("List is Empty");
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			doGet(request, response);
	}

}
