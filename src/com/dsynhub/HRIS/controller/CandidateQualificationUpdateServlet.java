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
 * Servlet implementation class CandidateQualificationUpdateServlet
 */
@WebServlet("/CandidateQualificationUpdateServlet")
public class CandidateQualificationUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String candidateQualificationName = request.getParameter("candidateQualificationName");
		int candidateQualificationId = Integer.parseInt(request.getParameter("candidateQualificationId"));
		
		
		CandidateQualificationBean candidateQualificationBean = new CandidateQualificationBean() ;
		
		candidateQualificationBean.setCandidateQualificationId(candidateQualificationId);
		candidateQualificationBean.setCandidateQualificationName(candidateQualificationName);
	

		if (new CandidateQualificationDAO().update(candidateQualificationBean)) {
			response.sendRedirect("CandidateQualificationListServlet");
			System.out.println("Updated");
			
		} else {
			response.sendRedirect("candidateQualificationList.jsp");
			System.out.println("Not Updated");
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
