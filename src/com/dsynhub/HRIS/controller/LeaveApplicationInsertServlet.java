package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dsynhub.HRIS.bean.LeaveApplicationBean;
import com.dsynhub.HRIS.dao.LeaveApplicationDAO;

/**
 * Servlet implementation class JobVacancyInsertServlet
 */
@WebServlet("/JobVacancyInsertServlet")
public class LeaveApplicationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	 int leaveApplicationId;
	 int employeeId;
	 String employeeFirstName;
	 String leaveName;
	 int leaveId;
	 String leaveStartDate;
	 int leaveDays;
	 String discription;
	 int isActive;
	 String dateOfApplication;
	 String dateOfLastUpdate;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	
		leaveApplicationId=Integer.parseInt(request.getParameter("leaveApplicationId"));
		employeeId=Integer.parseInt(request.getParameter("employeeId"));
		leaveId=Integer.parseInt(request.getParameter("leaveId"));
		leaveStartDate=(request.getParameter("leaveStartDate"));
		leaveDays=Integer.parseInt(request.getParameter("leaveDays"));
		discription = request.getParameter("discription");
		isActive=Integer.parseInt(request.getParameter("isActive"));
		dateOfApplication= request.getParameter("dateOfApplication");
		dateOfLastUpdate= request.getParameter("dateOfLastUpdate");
	
		
		LeaveApplicationBean leaveApplicationBean= new LeaveApplicationBean() ;
		
		leaveApplicationBean.setEmployeeFirstName(employeeFirstName);
		leaveApplicationBean.setLeaveName(leaveName);
		leaveApplicationBean.setLeaveStartDate(leaveStartDate);
		leaveApplicationBean.setLeaveDays(leaveDays);
		leaveApplicationBean.setDiscription(discription);
		leaveApplicationBean.setIsActive(isActive);
		leaveApplicationBean.setDateOfApplication(dateOfApplication);
		leaveApplicationBean.setDateOfLastUpdate(dateOfLastUpdate);
			
	
		
		if(new LeaveApplicationDAO().insert(leaveApplicationBean)){
		
			response.sendRedirect("LeaveApplicationListServlet");
		}
		
		else
			System.out.println("Error ");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
	}
}
