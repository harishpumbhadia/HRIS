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
 * Servlet implementation class DepartmentInsertServlet
 */
@WebServlet("/DepartmentInsertServlet")
public class DepartmentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String deptName;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		deptName = request.getParameter("deptName");

		DepartmentBean departmentBean = new DepartmentBean();

		departmentBean.setDeptName(deptName);

		request.setAttribute("departmentBean", departmentBean);

		if (new DepartmentDAO().insert(departmentBean)) {
			System.out.println("Inserted");
			response.sendRedirect("DepartmentListServlet");
		} 

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
