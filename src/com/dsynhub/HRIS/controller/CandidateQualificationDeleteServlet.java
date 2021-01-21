package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.dao.CandidateQualificationDAO;


/**
 * Servlet implementation class CandidateQualificationDeleteServlet
 */
@WebServlet("/CandidateQualificationDeleteServlet")
public class CandidateQualificationDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int candidateQualificationId = Integer.parseInt(request
				.getParameter("candidateQualificationId"));

		if (new CandidateQualificationDAO().delete(candidateQualificationId)) {
			response.sendRedirect("CandidateQualificationListServlet");

		} else {
			response.sendRedirect("CandidateQualificationListServlet");

		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
