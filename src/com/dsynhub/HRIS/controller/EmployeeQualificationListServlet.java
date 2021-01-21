package com.dsynhub.HRIS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.EmployeeQualificationBean;
import com.dsynhub.HRIS.dao.EmployeeQualificationDAO;

/**
 * Servlet implementation class EmployeeQualificationListServlet
 */
@WebServlet("/EmployeeQualificationListServlet")
public class EmployeeQualificationListServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		List <EmployeeQualificationBean> listofEmployeeQualification= new EmployeeQualificationDAO().list();
		
		if(listofEmployeeQualification!=null)
		{
			request.setAttribute("listOfEmployeeQualification", listofEmployeeQualification);
			request.getRequestDispatcher("employeeQualificationList.jsp").forward(request, response);
			
		}
		
		else
			System.out.println("List is Empty");
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			doGet(request, response);
	}

}
