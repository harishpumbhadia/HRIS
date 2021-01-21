package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.CandidateQualificationBean;
import com.dsynhub.HRIS.dao.CandidateQualificationDAO;

/**
 * Servlet implementation class CandidateQualificationInsertServlet
 */
@WebServlet("/CandidateQualificationInsertServlet")
public class CandidateQualificationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	String candidateQualificationName ;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	
		candidateQualificationName=request.getParameter("candidateQualificationName");
		
		
		
		CandidateQualificationBean candidateQualificationBean= new CandidateQualificationBean() ;
		
		
	
		candidateQualificationBean.setCandidateQualificationName(candidateQualificationName);
	
		
		if(new CandidateQualificationDAO().insert(candidateQualificationBean)){
		
			response.sendRedirect("CandidateQualificationListServlet");
		}
		
		else
			System.out.println("Error ");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
	}
}
