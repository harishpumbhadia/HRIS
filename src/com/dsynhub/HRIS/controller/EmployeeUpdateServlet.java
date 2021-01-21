package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.EmployeeBean;
import com.dsynhub.HRIS.dao.EmployeeDAO;

/**
 * Servlet implementation class EmployeeUpdateServlet
 */
@WebServlet("/EmployeeUpdateServlet")
public class EmployeeUpdateServlet extends HttpServlet {
	
	int employeeId ;
	String employeeFirstName ;
	String employeeMiddleName ;
	String employeeLastName ;
	String dateOfBirth ;
	String gender;
	String maratialStatus ;
	String currentAddress ;
	int cityId ;
	String cityName ;
	int stateId ;
	String stateName ;
	int countryId ;
	String countryName ;
	String mobileNumber ;
	String postalCode ;
	String email ;
	int departmentId ;
	String departmentName ;
	int designationId ;
	String designationName ;
	int employmentStatusId ;
	String statusName ;
	String joiningDate ;
	int securityQuestionId ;
	String securityQuestion ;
	String securityAnswer ;


	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
	
		employeeFirstName = request.getParameter("employeeFirstName");
		employeeMiddleName = request.getParameter("employeeMiddleName");
		employeeLastName = request.getParameter("employeeLastName");
		dateOfBirth = request.getParameter("dateOfBirth");
		gender = request.getParameter("gender");
		maratialStatus = request.getParameter("maratialStatus");
		currentAddress = request.getParameter("currentAddress");
		cityId = Integer.parseInt(request.getParameter("cityId"));
		stateId = Integer.parseInt(request.getParameter("stateId"));
		countryId = Integer.parseInt(request.getParameter("countryId"));
		mobileNumber = request.getParameter("mobileNumber");
		postalCode = request.getParameter("postalCode");
		email = request.getParameter("email");
		departmentId = Integer.parseInt(request.getParameter("departmentId"));
		designationId = Integer.parseInt(request.getParameter("designationId"));
		employmentStatusId = Integer.parseInt(request.getParameter("employmentStatusId"));
		joiningDate = request.getParameter("joiningDate");
		
		EmployeeBean employeeBean= new EmployeeBean() ;
		
		employeeBean.setEmployeeFirstName(employeeFirstName);
		employeeBean.setEmployeeMiddleName(employeeMiddleName);
		employeeBean.setEmployeeLastName(employeeLastName);
		employeeBean.setDateOfBirth(dateOfBirth);
		employeeBean.setGender(gender);
		employeeBean.setMaratialStatus(maratialStatus);
		employeeBean.setCurrentAddress(currentAddress);
		employeeBean.setCityId(cityId);
		employeeBean.setStateId(stateId);
		employeeBean.setCountryId(countryId);
		employeeBean.setMobileNumber(mobileNumber);
		employeeBean.setPostalCode(postalCode);
		employeeBean.setEmail(email);
		employeeBean.setDepartmentId(departmentId);
		employeeBean.setDesignationId(designationId);
		employeeBean.setEmploymentStatusId(employmentStatusId);
		employeeBean.setJoiningDate(joiningDate);
		employeeBean.setEmployeeId(employeeId);		

		if(new EmployeeDAO().update(employeeBean)){
		
			response.sendRedirect("EmployeeListServlet");
		}
		
		else
			System.out.println("Error ");
		
	}


		
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
	}
}
