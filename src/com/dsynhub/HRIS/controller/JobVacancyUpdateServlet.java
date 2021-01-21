package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dsynhub.HRIS.bean.JobVacancyBean;
import com.dsynhub.HRIS.dao.JobVacancyDAO;

/**
 * Servlet implementation class JobVacancyUpdateServlet
 */
@WebServlet("/JobVacancyUpdateServlet")
public class JobVacancyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	int candidateQualificationId ;
	int departmentId ;
	int designationId ;
	int isActive ;
	String vacancyName ;
	String description ;
	int noOfPositions ;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		int jobVacancyId = Integer.parseInt(request.getParameter("jobVacancyId"));
		candidateQualificationId=Integer.parseInt(request.getParameter("candidateQualificationId"));
		departmentId=Integer.parseInt(request.getParameter("departmentId"));
		designationId=Integer.parseInt(request.getParameter("designationId"));
		noOfPositions=Integer.parseInt(request.getParameter("noOfPositions"));
		isActive=Integer.parseInt(request.getParameter("isActive"));
		vacancyName = request.getParameter("vancancyName");
		description= request.getParameter("description");
		
		JobVacancyBean jobVacancyBean = new JobVacancyBean() ;
		
		jobVacancyBean.setCandidateQualificationId(candidateQualificationId);
		jobVacancyBean.setDepartmentId(departmentId);
		jobVacancyBean.setDesignationId(designationId);
		jobVacancyBean.setIsActive(isActive);
		jobVacancyBean.setVacancyName(vacancyName);
		jobVacancyBean.setDescription(description);
		jobVacancyBean.setNoOfPositions(noOfPositions);
		jobVacancyBean.setVacancyId(jobVacancyId);

		if (new JobVacancyDAO().update(jobVacancyBean)) {
			response.sendRedirect("JobVacancyListServlet");
			System.out.println("Updated");
			
		} else {
			response.sendRedirect("jobVacancyList.jsp");
			System.out.println("Not Updated");
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
