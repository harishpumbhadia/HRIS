package com.dsynhub.HRIS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.JobCandidateBean;
import com.dsynhub.HRIS.dao.JobCandidateDAO;

/**
 * Servlet implementation class JobCandidateInsertServlet
 */
@WebServlet("/JobCandidateInsertServlet")
public class JobCandidateInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String candidateFirstName ;
	String candidateMiddleName ;
	String candidateLastName ;
	String email ;
	String mobileNumber ;
	String candidateQualification ;
	int departmentId ;
	String departentName ;
	int designationId ;
	String designationName ;
	String dateOfApplication ;
	int isActive ;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
		candidateFirstName = request.getParameter("candidateFirstName");
		candidateMiddleName = request.getParameter("candidateMiddleName");
		candidateLastName = request.getParameter("candidateLastName");
		email= request.getParameter("email");
		mobileNumber = request.getParameter("mobileNumber");
		candidateQualification= request.getParameter("candidateQualification");
		departmentId=Integer.parseInt(request.getParameter("departmentId"));
		designationId=Integer.parseInt(request.getParameter("designationId"));
		dateOfApplication= request.getParameter("dateOfApplication");
		isActive=Integer.parseInt(request.getParameter("isActive"));
		
		
		
		JobCandidateBean jobCandidateBean= new JobCandidateBean() ;
		
		jobCandidateBean.setCandidateFirstName(candidateFirstName);
		jobCandidateBean.setCandidateMiddleName(candidateMiddleName);
		jobCandidateBean.setCandidateLastName(candidateLastName);
		jobCandidateBean.setEmail(email);
		jobCandidateBean.setMobileNumber(mobileNumber);
		jobCandidateBean.setCandidateQualification(candidateQualification);
		jobCandidateBean.setDepartmentId(departmentId);
		jobCandidateBean.setDesignationId(designationId);
		jobCandidateBean.setDateOfApplication(dateOfApplication);
		jobCandidateBean.setIsActive(isActive);
	
		
		if(new JobCandidateDAO().insert(jobCandidateBean)){
		
			response.sendRedirect("JobCandidateListServlet");
		}
		
		else
			System.out.println("Error ");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
	}


}
