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
 * Servlet implementation class EmployeeQualificationInsertServlet
 */
@WebServlet("/EmployeeQualificationInsertServlet")
public class EmployeeQualificationInsertServlet extends HttpServlet {
	
	int employeeId ;
	String qualificationName;
	String institute;
	String dateOfCompletion ;
	
	private static final long serialVersionUID = 1L;
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		employeeId = Integer.parseInt(request.getParameter("employeeId"));
		qualificationName = request.getParameter("qualificationName");
		institute = request.getParameter("institute");
		dateOfCompletion = request.getParameter("dateOfCompletion");
		
		EmployeeQualificationBean employeeQualificationBean = new EmployeeQualificationBean();
		
		employeeQualificationBean.setEmployeeId(employeeId);
		employeeQualificationBean.setQualificaionName(qualificationName);
		employeeQualificationBean.setInstitute(institute);
		employeeQualificationBean.setDateOfCompletion(dateOfCompletion);
		
		if(new EmployeeQualificationDAO().insert(employeeQualificationBean)){
			
			response.sendRedirect("EmployeeQualificationListServlet");
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
