package com.dsynhub.HRIS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.StatusBean;
import com.dsynhub.HRIS.dao.StatusDAO;

/**
 * Servlet implementation class StatusListServlet
 */
@WebServlet("/StatusListServlet")
public class StatusListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<StatusBean> listofStatus = new StatusDAO().list();
		
		if(listofStatus!=null){
			request.setAttribute("listofStatus",listofStatus);
			request.getRequestDispatcher("statusList.jsp").forward(request, response);
		}
		
		else{
		
			System.out.println("NULL TABLE FOUND");
		}
	

	}
		

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}


}
