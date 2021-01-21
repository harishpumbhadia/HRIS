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
 * Servlet implementation class EmployeeEmergencyContactUpdateServlet
 */
@WebServlet("/EmployeeEmergencyContactUpdateServlet")
public class EmployeeEmergencyContactUpdateServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int emergencyId ;
	String contactName ;
	String relation ;
	String contactNumberOne ;
	String contactNumberTwo ;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		emergencyId = Integer.parseInt(request.getParameter("emergencyId"));
		contactName = request.getParameter("contactName");
		relation= request.getParameter("relation");
		contactNumberOne = request.getParameter("contactNumberOne");
		contactNumberTwo = request.getParameter("contactNumberTwo");
		
EmployeeEmergencyContactBean employeeEmergencyContactBean = new EmployeeEmergencyContactBean();
		
		employeeEmergencyContactBean.setEmergencyId(emergencyId);
		employeeEmergencyContactBean.setContactName(contactName);
		employeeEmergencyContactBean.setRelation(relation);
		employeeEmergencyContactBean.setContactNumberOne(contactNumberOne);
		employeeEmergencyContactBean.setContactNumberTwo(contactNumberTwo);
		
		if(new EmployeeEmerencyContactDAO().update(employeeEmergencyContactBean)){
			
			response.sendRedirect("EmployeeEmergencyContactListServlet");
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
