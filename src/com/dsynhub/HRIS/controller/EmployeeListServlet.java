package com.dsynhub.HRIS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.EmployeeBean;
import com.dsynhub.HRIS.dao.EmployeeDAO;


/**
 * Servlet implementation class EmployeeListServlet
 */
@WebServlet("/EmployeeListServlet")
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		List <EmployeeBean> listofEmployee= new EmployeeDAO().list();
		
		if(listofEmployee!=null)
		{
			request.setAttribute("listofEmployee", listofEmployee);
			request.getRequestDispatcher("employeeList.jsp").forward(request, response);
			
		}
		
		else
			System.out.println("List is Empty");
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			doGet(request, response);
	}

}
