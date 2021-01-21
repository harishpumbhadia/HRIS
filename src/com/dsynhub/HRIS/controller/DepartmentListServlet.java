package com.dsynhub.HRIS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.DepartmentBean;
import com.dsynhub.HRIS.dao.DepartmentDAO;

/**
 * Servlet implementation class DepartmentListServlet
 */
@WebServlet("/DepartmentListServlet")
public class DepartmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		List <DepartmentBean> listofDepartments= new DepartmentDAO().list();
		
		if(listofDepartments!=null)
		{
			request.setAttribute("listofDepartments", listofDepartments);
			request.getRequestDispatcher("departmentList.jsp").forward(request, response);
			
		}
		
		else
			System.out.println("List is Empty");
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			doGet(request, response);
	}

}
