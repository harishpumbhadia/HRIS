package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.EmployeeBean;
import com.dsynhub.HRIS.dao.EmployeeDAO;

/**
 * Servlet implementation class EmployeeEditServlet
 */
@WebServlet("/EmployeeEditServlet")
public class EmployeeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int employeeId =Integer.parseInt(request.getParameter("employeeId"));

		
		EmployeeBean employeeBean= new EmployeeDAO().getByPK(employeeId);
	
		if(employeeBean!=null){
			request.setAttribute("employeeBean", employeeBean);
			request.getRequestDispatcher("employeeEdit.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
