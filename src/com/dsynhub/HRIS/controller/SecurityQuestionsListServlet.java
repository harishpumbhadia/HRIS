package com.dsynhub.HRIS.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.SecurityQuestionsBean;
import com.dsynhub.HRIS.dao.SecurityQuestionsDAO;

/**
 * Servlet implementation class SecurityQuestionsListServlet
 */
@WebServlet("/SecurityQuestionsListServlet")
public class SecurityQuestionsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			List<SecurityQuestionsBean> questionList=new ArrayList<SecurityQuestionsBean>();
			questionList=new SecurityQuestionsDAO().getSecurityQuestionsList();
			if(questionList!=null)
			{
				request.setAttribute("questionList",questionList);
			}
			request.getRequestDispatcher("securityQuestionsList.jsp").forward(request, response);
	}
}
