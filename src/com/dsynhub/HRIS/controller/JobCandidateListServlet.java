package com.dsynhub.HRIS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dsynhub.HRIS.bean.JobCandidateBean;
import com.dsynhub.HRIS.dao.JobCandidateDAO;

/**
 * Servlet implementation class JobCandidateListServlet
 */
@WebServlet("/JobCandidateListServlet")
public class JobCandidateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		List <JobCandidateBean> listofCandidates= new JobCandidateDAO().list();
		
		if(listofCandidates!=null)
		{
			request.setAttribute("listofCandidates", listofCandidates);
			request.getRequestDispatcher("jobCandidateList.jsp").forward(request, response);
			
		}
		
		else
			System.out.println("List is Empty");
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			doGet(request, response);
	}
}
