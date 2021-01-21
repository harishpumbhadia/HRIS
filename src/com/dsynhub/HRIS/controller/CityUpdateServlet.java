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
 * Servlet implementation class CityUpdateServlet
 */
@WebServlet("/CityUpdateServlet")
public class CityUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String cityName = request.getParameter("cityName");
		int cityId = Integer.parseInt(request.getParameter("cityId"));
		int stateId = Integer.parseInt(request.getParameter("stateId"));
		
		CityBean cityBean = new CityBean() ;
		
		cityBean.setCityName(cityName);
		cityBean.setStateId(stateId);
		cityBean.setCityId(cityId);
		
		

		if (new CityDAO().update(cityBean)) {
			response.sendRedirect("CityListServlet");
			System.out.println("Updated");
			
		} else {
			response.sendRedirect("cityList.jsp");
			System.out.println("Not Updated");
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
