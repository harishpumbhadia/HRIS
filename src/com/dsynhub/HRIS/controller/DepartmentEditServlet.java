package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.DepartmentBean;
import com.dsynhub.HRIS.dao.DepartmentDAO;

/**
 * Servlet implementation class DepartmentEditServlet
 */
@WebServlet("/DepartmentEditServlet")
public class DepartmentEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int deptId = Integer.parseInt(request.getParameter("did"));
		
		DepartmentBean department = new DepartmentDAO().getByPK(deptId);
		
		if(department!=null)
		{
			request.setAttribute("department", department);
			
			request.getRequestDispatcher("departmentEdit.jsp").forward(request, response);
			
		}
		else
		{
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
