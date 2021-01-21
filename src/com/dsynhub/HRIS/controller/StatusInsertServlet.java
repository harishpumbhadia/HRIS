package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.StatusBean;
import com.dsynhub.HRIS.dao.StatusDAO;

/**
 * Servlet implementation class StatusInsertServlet
 */
@WebServlet("/StatusInsertServlet")
public class StatusInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		StatusBean b1 = new StatusBean();

		String status = request.getParameter("status");

		b1.setStatusName(status);

		StatusDAO statusInsert = new StatusDAO();

	

		b1.setStatusName(status);

		boolean temp = statusInsert.insert(b1);

		if (temp == true) {

			System.out.println("Check DataBase");
			request.getRequestDispatcher("StatusListServlet").forward(request,
					response);
		}

		else {
			request.getRequestDispatcher("status.jsp").forward(request,
					response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
