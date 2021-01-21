package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.DepartmentBean;
import com.dsynhub.HRIS.dao.DepartmentDAO;

/**
 * Servlet implementation class DepartmentUpdateServlet
 */
@WebServlet("/DepartmentUpdateServlet")
public class DepartmentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String deptName = request.getParameter("deptName");
		int deptId = Integer.parseInt(request.getParameter("did"));

		DepartmentBean departmentBean = new DepartmentBean();

		departmentBean.setDeptName(deptName);
		departmentBean.setDeptId(deptId);

		departmentBean.setDeptName(deptName);

		if (new DepartmentDAO().update(departmentBean)) {
			response.sendRedirect("DepartmentListServlet");
			System.out.println("Updated");

		} else {
			response.sendRedirect("departmentList.jsp");
			System.out.println("Not Updated");

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
