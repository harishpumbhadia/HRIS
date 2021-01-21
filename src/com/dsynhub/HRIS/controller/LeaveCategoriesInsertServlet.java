package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.LeaveCategoriesBean;
import com.dsynhub.HRIS.dao.LeaveCategoriesDAO;

/**
 * Servlet implementation class LeaveCategoriesInsertServlet
 */
@WebServlet("/LeaveCategoriesInsertServlet")
public class LeaveCategoriesInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String category;
	int leavesPerYear;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		category = request.getParameter("category");
		leavesPerYear = Integer.parseInt(request.getParameter("leavesPerYear"));
		LeaveCategoriesBean leaveCategories = new LeaveCategoriesBean();

		leaveCategories.setCategory(category);
		leaveCategories.setLeavesPerYear(leavesPerYear);
		

		request.setAttribute("leaveCategories", leaveCategories);

		if (new LeaveCategoriesDAO().insert(leaveCategories)) {
			System.out.println("Inserted");
			response.sendRedirect("LeaveCategoriesListServlet");
		} 

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
