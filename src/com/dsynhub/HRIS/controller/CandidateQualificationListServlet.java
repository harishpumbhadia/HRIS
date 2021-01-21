package com.dsynhub.HRIS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.CandidateQualificationBean;
import com.dsynhub.HRIS.dao.CandidateQualificationDAO;

/**
 * Servlet implementation class CandidateQualificationListServlet
 */
@WebServlet("/CandidateQualificationListServlet")
public class CandidateQualificationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<CandidateQualificationBean> listOfCandidateQualification= new CandidateQualificationDAO().list();
		
		if(listOfCandidateQualification!=null){
			request.setAttribute("listOfCandidateQualification",listOfCandidateQualification);
			request.getRequestDispatcher("candidateQualificationList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
