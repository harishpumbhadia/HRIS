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
 * Servlet implementation class CandidateQualificationEditServlet
 */
@WebServlet("/CandidateQualificationEditServlet")
public class CandidateQualificationEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int candidateQualificationId =Integer.parseInt(request.getParameter("candidateQualificationId"));

		
		CandidateQualificationBean candidateQualificationBean= new CandidateQualificationDAO().getByPK(candidateQualificationId);
	
		if(candidateQualificationBean!=null){
			request.setAttribute("candidateQualificationBean", candidateQualificationBean);
			request.getRequestDispatcher("candidateQualificationEdit.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
