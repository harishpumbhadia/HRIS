package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.SecurityQuestionsBean;
import com.dsynhub.HRIS.dao.SecurityQuestionsDAO;

/**
 * Servlet implementation class SecurityQuestionsEditServlet
 */
@WebServlet("/SecurityQuestionsEditServlet")
public class SecurityQuestionsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int securityQuestionId=Integer.parseInt(request.getParameter("securityQuestionId"));
		SecurityQuestionsBean questionBean=new SecurityQuestionsBean();
		questionBean=new SecurityQuestionsDAO().getBySecurityQuestionId(securityQuestionId);
		if(questionBean!=null)
		{
			request.setAttribute("questionBean",questionBean);
			request.getRequestDispatcher("securityQuestionsEdit.jsp").forward(request, response);
		}
		
		
		
	}
	

}
