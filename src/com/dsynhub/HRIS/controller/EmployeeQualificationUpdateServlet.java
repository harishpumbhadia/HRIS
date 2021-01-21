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
 * Servlet implementation class EmployeeQualificationUpdateServlet
 */
@WebServlet("/EmployeeQualificationUpdateServlet")
public class EmployeeQualificationUpdateServlet extends HttpServlet {
	
	int employeeId ;
	int employeeQualificationId ;
	String qualificationName;
	String institute;
	String dateOfCompletion ;
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		employeeQualificationId = Integer.parseInt(request.getParameter("employeeQualificationId"));
		qualificationName = request.getParameter("qualificationName");
		institute = request.getParameter("institute");
		dateOfCompletion = request.getParameter("dateOfCompletion");
		
		EmployeeQualificationBean employeeQualificationBean = new EmployeeQualificationBean();
		
	
		employeeQualificationBean.setEmployeeQualificationId(employeeQualificationId);
		employeeQualificationBean.setQualificaionName(qualificationName);
		employeeQualificationBean.setInstitute(institute);
		employeeQualificationBean.setDateOfCompletion(dateOfCompletion);
		
		if(new EmployeeQualificationDAO().update(employeeQualificationBean)){
			
			response.sendRedirect("EmployeeQualificationListServlet");
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
