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
 * Servlet implementation class JobCandidateEditServlet
 */
@WebServlet("/JobCandidateEditServlet")
public class JobCandidateEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int jobCandidateId =Integer.parseInt(request.getParameter("jobCandidateId"));

		
		JobCandidateBean jobCandidateBean= new JobCandidateDAO().getByPK(jobCandidateId);
	
		if(jobCandidateBean!=null){
			request.setAttribute("jobCandidateBean", jobCandidateBean);
			request.getRequestDispatcher("jobCandidateEdit.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
