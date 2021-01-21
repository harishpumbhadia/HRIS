package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.dao.JobCandidateDAO;

/**
 * Servlet implementation class JobCandidateDeleteServlet
 */
@WebServlet("/JobCandidateDeleteServlet")
public class JobCandidateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		int candidateId = Integer.parseInt(request
				.getParameter("jobCandidateId"));

		
		if (new JobCandidateDAO().delete(candidateId)) {
			response.sendRedirect("JobCandidateListServlet");

		} else {
			response.sendRedirect("JobCandidateListServlet");

		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
