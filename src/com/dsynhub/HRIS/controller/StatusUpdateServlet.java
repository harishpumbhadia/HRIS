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
 * Servlet implementation class StatusUpdateServlet
 */
@WebServlet("/StatusUpdateServlet")
public class StatusUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String status = request.getParameter("status");

		StatusBean b1 = new StatusBean();

		int statusId = Integer.parseInt(request.getParameter("statusId"));

		b1.setStatusName(status);

		b1.setStatusId(statusId);
		b1.setStatusName(status);

		StatusDAO updateStatus = new StatusDAO();

		boolean temp = updateStatus.update(b1);

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

	}

}
