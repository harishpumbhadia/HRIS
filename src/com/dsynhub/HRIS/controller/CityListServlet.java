package com.dsynhub.HRIS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.CityBean;
import com.dsynhub.HRIS.dao.CityDAO;

@WebServlet("/CityListServlet")
public class CityListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		List<CityBean> listOfCity = new CityDAO().list();
		
		if(listOfCity!=null){
			request.setAttribute("listofCity",listOfCity);
			request.getRequestDispatcher("cityList.jsp").forward(request, response);
		}else{
		
			
		}
	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
