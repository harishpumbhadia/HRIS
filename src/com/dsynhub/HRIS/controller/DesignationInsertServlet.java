package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.DesignationBean;
import com.dsynhub.HRIS.dao.DesignationDAO;


/**
 * Servlet implementation class DesignationInsertServlet
 */
@WebServlet("/DesignationInsertServlet")
public class DesignationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	String designationName ;
	int designationId , departmentId ;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		departmentId = Integer.parseInt(request.getParameter("departmentId"));
		designationName=request.getParameter("designationName");
		
		System.out.println("Desig Name " + designationName);
		
		DesignationBean designationBean = new DesignationBean() ;
		
		
	
		designationBean.setDepartmentId(departmentId);
		designationBean.setDesignationName(designationName);
		
		if(new DesignationDAO().insert(designationBean)){
		
			response.sendRedirect("DesignationListServlet");
		}
		
		else
			System.out.println("Error ");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
	}

}
