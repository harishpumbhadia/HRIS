package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.dao.JobVacancyDAO;

/**
 * Servlet implementation class JobVacancyDeleteServlet
 */
@WebServlet("/JobVacancyDeleteServlet")
public class JobVacancyDeleteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int jobVacancyId = Integer.parseInt(request
				.getParameter("jobVacancyId"));

		if (new JobVacancyDAO().delete(jobVacancyId)) {
			response.sendRedirect("JobVacancyListServlet");

		} else {
			response.sendRedirect("JobVacancyListServlet");

		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
