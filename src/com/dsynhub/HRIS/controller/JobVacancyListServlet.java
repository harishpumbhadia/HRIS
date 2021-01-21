package com.dsynhub.HRIS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.JobVacancyBean;
import com.dsynhub.HRIS.dao.JobVacancyDAO;

/**
 * Servlet implementation class JobVacancyListServlet
 */
@WebServlet("/JobVacancyListServlet")
public class JobVacancyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<JobVacancyBean> listOfJobVacancy= new JobVacancyDAO().list();
		
		if(listOfJobVacancy!=null){
			request.setAttribute("listOfJobVacancy",listOfJobVacancy);
			request.getRequestDispatcher("jobVacancyList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
