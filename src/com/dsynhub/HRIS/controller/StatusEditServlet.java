package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.StatusBean;
import com.dsynhub.HRIS.dao.StatusDAO;

/**
 * Servlet implementation class StatusEditServlet
 */
@WebServlet("/StatusEditServlet")
public class StatusEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		int statusId=Integer.parseInt(request.getParameter("statusId"));
		
		StatusBean b1=new StatusBean();
		
		
		
		b1=new StatusDAO().getByPK(statusId);
		
		if(b1!=null){
			
			request.setAttribute("b1",b1);
			request.getRequestDispatcher("statusEdit.jsp").forward(request, response);
			
		}
		
		else {
			// TODO
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


}
