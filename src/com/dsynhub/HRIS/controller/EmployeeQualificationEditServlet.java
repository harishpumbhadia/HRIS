package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.EmployeeQualificationBean;
import com.dsynhub.HRIS.dao.EmployeeQualificationDAO;

/**
 * Servlet implementation class EmployeeQualificationEditServlet
 */
@WebServlet("/EmployeeQualificationEditServlet")
public class EmployeeQualificationEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int employeeQualificationId =Integer.parseInt(request.getParameter("employeeQualificationId"));

		
		EmployeeQualificationBean employeeQualificationBean= new EmployeeQualificationDAO().getByPK(employeeQualificationId);
	
		if(employeeQualificationBean!=null){
			request.setAttribute("employeeQualificationBean", employeeQualificationBean);
			request.getRequestDispatcher("employeeQualificationEdit.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
