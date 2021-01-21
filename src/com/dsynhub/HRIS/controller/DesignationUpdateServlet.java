package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.DesignationBean;
import com.dsynhub.HRIS.dao.DesignationDAO;


/**
 * Servlet implementation class DesignationUpdateServlet
 */
@WebServlet("/DesignationUpdateServlet")
public class DesignationUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String designationName = request.getParameter("designationName");
		int designationId = Integer.parseInt(request.getParameter("designationId"));
		int departmentId = Integer.parseInt(request.getParameter("departmentId"));
		
		DesignationBean designationBean = new DesignationBean() ;
		
		designationBean.setDesignationName(designationName);
		designationBean.setDepartmentId(departmentId);
		designationBean.setDesignationId(designationId);
		
		

		if (new DesignationDAO().update(designationBean)) {
			response.sendRedirect("DesignationListServlet");
			System.out.println("Updated");
			
		} else {
			response.sendRedirect("designationList.jsp");
			System.out.println("Not Updated");
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
