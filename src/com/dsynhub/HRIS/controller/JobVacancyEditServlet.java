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
 * Servlet implementation class JobVacancyEditServlet
 */
@WebServlet("/JobVacancyEditServlet")
public class JobVacancyEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int jobVacancyId =Integer.parseInt(request.getParameter("jobVacancyId"));

		
		JobVacancyBean jobVacancyBean= new JobVacancyDAO().getByPK(jobVacancyId);
	
		if(jobVacancyBean!=null){
			request.setAttribute("jobVacancyBean", jobVacancyBean);
			request.getRequestDispatcher("jobVacancyEdit.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
