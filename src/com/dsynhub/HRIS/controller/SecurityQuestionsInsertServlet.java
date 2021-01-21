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
 * Servlet implementation class SecurityQuestionsInsertServlet
 */
@WebServlet("/SecurityQuestionsInsertServlet")
public class SecurityQuestionsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String question=request.getParameter("question");
		

		
			SecurityQuestionsBean questionsBean=new SecurityQuestionsBean();
			questionsBean.setQuestion(question);
			if(new SecurityQuestionsDAO().add(questionsBean))
			{
				System.out.println("Record inserted");
			}
			else
			{
				System.out.println("Record Not inserted");
				
			}
			request.getRequestDispatcher("SecurityQuestionsListServlet").forward(request, response);
		}
		
		



}
