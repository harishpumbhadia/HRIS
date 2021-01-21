package com.dsynhub.HRIS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.LeaveCategoriesBean;
import com.dsynhub.HRIS.dao.LeaveCategoriesDAO;

/**
 * Servlet implementation class LeaveCategoriesListServlet
 */
@WebServlet("/LeaveCategoriesListServlet")
public class LeaveCategoriesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		List <LeaveCategoriesBean> listofleaveCategories= new LeaveCategoriesDAO().list();
		
		if(listofleaveCategories!=null)
		{
			request.setAttribute("listofleaveCategories", listofleaveCategories);
			request.getRequestDispatcher("leaveCategoriesList.jsp").forward(request, response);
			
		}
		
		else
			System.out.println("List is Empty");
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			doGet(request, response);
	}

}
