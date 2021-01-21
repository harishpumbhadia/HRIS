package com.dsynhub.HRIS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.DesignationBean;
import com.dsynhub.HRIS.dao.DesignationDAO;



@WebServlet("/DesignationListServlet")
public class DesignationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<DesignationBean> listOfDesignation = new DesignationDAO().list();
		
		if(listOfDesignation!=null){
			request.setAttribute("listOfDesignation",listOfDesignation);
			request.getRequestDispatcher("designationList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
