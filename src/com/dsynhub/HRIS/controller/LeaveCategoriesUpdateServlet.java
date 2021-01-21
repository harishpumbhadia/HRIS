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
 * Servlet implementation class LeaveCategoriesUpdateServlet
 */
@WebServlet("/LeaveCategoriesUpdateServlet")
public class LeaveCategoriesUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String category = request.getParameter("category");
		int leaveId = Integer.parseInt(request.getParameter("lid"));
		int leavesPerYear = Integer.parseInt(request.getParameter("leavesPerYear"));
		
		LeaveCategoriesBean leaveCategories = new LeaveCategoriesBean();

		leaveCategories.setCategory(category);
		leaveCategories.setLeaveId(leaveId);
		leaveCategories.setLeavesPerYear(leavesPerYear);

		leaveCategories.setCategory(category);

		if (new LeaveCategoriesDAO().update(leaveCategories)) {
			response.sendRedirect("LeaveCategoriesListServlet");
			System.out.println("Updated");

		} else {
			response.sendRedirect("leaveCategoriesList.jsp");
			System.out.println("Not Updated");

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
