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
 * Servlet implementation class JobVacancyInsertServlet
 */
@WebServlet("/JobVacancyInsertServlet")
public class JobVacancyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	int candidateQualificationId ;
	int departmentId ;
	int designationId ;
	int isActive ;
	String vacancyName ;
	String description ;
	int noOfPositions ;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	
		candidateQualificationId=Integer.parseInt(request.getParameter("candidateQualificationId"));
		departmentId=Integer.parseInt(request.getParameter("departmentId"));
		designationId=Integer.parseInt(request.getParameter("designationId"));
		noOfPositions=Integer.parseInt(request.getParameter("noOfPositions"));
		isActive=Integer.parseInt(request.getParameter("isActive"));
		vacancyName = request.getParameter("vacancyName");
		description= request.getParameter("description");
	
		
		JobVacancyBean jobVacancyBean= new JobVacancyBean() ;
		
		jobVacancyBean.setCandidateQualificationId(candidateQualificationId);
		jobVacancyBean.setDepartmentId(departmentId);
		jobVacancyBean.setDesignationId(designationId);
		jobVacancyBean.setIsActive(isActive);
		jobVacancyBean.setVacancyName(vacancyName);
		jobVacancyBean.setDescription(description);
		jobVacancyBean.setNoOfPositions(noOfPositions);
			
	
		
		if(new JobVacancyDAO().insert(jobVacancyBean)){
		
			response.sendRedirect("JobVacancyListServlet");
		}
		
		else
			System.out.println("Error ");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
	}
}
