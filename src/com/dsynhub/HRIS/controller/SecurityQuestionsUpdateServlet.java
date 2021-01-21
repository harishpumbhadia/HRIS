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
 * Servlet implementation class SecurityQuestionsUpdateServlet
 */
@WebServlet("/SecurityQuestionsUpdateServlet")
public class SecurityQuestionsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int questionId = Integer.parseInt(request
				.getParameter("securityQuestionId"));
		String question = request.getParameter("securityQuestion");
		SecurityQuestionsBean questionsBean = new SecurityQuestionsBean();
	
		questionsBean.setQuestionId(questionId);
		questionsBean.setQuestion(question);

		if (new SecurityQuestionsDAO().update(questionsBean)) {
			System.out.println("Record Updated");
		} else {
			System.out.println("Record Not Not Updated");

		}
		request.getRequestDispatcher("SecurityQuestionsListServlet").forward(
				request, response);
	}

}
