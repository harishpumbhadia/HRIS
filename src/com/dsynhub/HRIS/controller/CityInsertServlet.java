package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.CityBean;
import com.dsynhub.HRIS.dao.CityDAO;


/**
 * Servlet implementation class CityInsertServlet
 */
@WebServlet("/CityInsertServlet")
public class CityInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	String cityName ;
	int cityId , stateId ;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		stateId = Integer.parseInt(request.getParameter("stateId"));
		cityName=request.getParameter("cityName");
		
		System.out.println("City Name " + cityName);
		
		CityBean cityBean = new CityBean() ;
		
		
	
		cityBean.setStateId(stateId);
		cityBean.setCityName(cityName);
		
		if(new CityDAO().insert(cityBean)){
		
			response.sendRedirect("CityListServlet");
		}
		
		else
			System.out.println("Error ");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
	}

}
