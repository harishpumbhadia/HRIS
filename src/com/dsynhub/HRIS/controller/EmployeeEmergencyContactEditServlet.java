package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.EmployeeEmergencyContactBean;
import com.dsynhub.HRIS.dao.EmployeeEmerencyContactDAO;


/**
 * Servlet implementation class EmployeeEmergencyContactEditServlet
 */
@WebServlet("/EmployeeEmergencyContactEditServlet")
public class EmployeeEmergencyContactEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int emergencyId =Integer.parseInt(request.getParameter("emergencyId"));

		
		EmployeeEmergencyContactBean employeeEmergencyContactBean= new EmployeeEmerencyContactDAO().getByPK(emergencyId);
	
		if(employeeEmergencyContactBean!=null){
			request.setAttribute("employeeEmergencyContactBean", employeeEmergencyContactBean);
			request.getRequestDispatcher("employeeEmergencyContactEdit.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
