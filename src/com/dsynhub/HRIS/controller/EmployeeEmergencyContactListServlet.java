package com.dsynhub.HRIS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.EmployeeEmergencyContactBean;
import com.dsynhub.HRIS.dao.EmployeeEmerencyContactDAO;


/**
 * Servlet implementation class EmployeeEmergencyContactListServlet
 */
@WebServlet("/EmployeeEmergencyContactListServlet")
public class EmployeeEmergencyContactListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		List <EmployeeEmergencyContactBean> listofEmployeeEmergencyContact= new EmployeeEmerencyContactDAO().list();
		
		if(listofEmployeeEmergencyContact!=null)
		{
			request.setAttribute("listofEmployeeEmergencyContact", listofEmployeeEmergencyContact);
			request.getRequestDispatcher("employeeEmergencyContactList.jsp").forward(request, response);
			
		}
		
		else
			System.out.println("List is Empty");
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			doGet(request, response);
	}

}
