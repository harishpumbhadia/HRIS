package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.LeaveCategoriesBean;
import com.dsynhub.HRIS.dao.LeaveCategoriesDAO;

/**
 * Servlet implementation class LeaveCategoriesEditServlet
 */
@WebServlet("/LeaveCategoriesEditServlet")
public class LeaveCategoriesEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int leaveId = Integer.parseInt(request.getParameter("lid"));
		
		LeaveCategoriesBean leaveCategories = new LeaveCategoriesDAO().getByPK(leaveId);
		
		if(leaveCategories!=null)
		{
			request.setAttribute("leaveCategories", leaveCategories);
			
			request.getRequestDispatcher("leaveCategoriesEdit.jsp").forward(request, response);
			
		}
		else
		{
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
