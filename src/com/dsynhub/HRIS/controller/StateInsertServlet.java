package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.StateBean;
import com.dsynhub.HRIS.dao.StateDAO;

/**
 * Servlet implementation class StateInsertServlet
 */
@WebServlet("/StateInsertServlet")
public class StateInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String stateName;
	int countryId,stateId;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		countryId = Integer.parseInt(request.getParameter("countryId"));
		stateName = request.getParameter("stateName");

		System.out.println("State Name " + stateName);
		
		StateBean stateBean = new StateBean();
		stateBean.setCountryId(countryId);
		stateBean.setStateName(stateName);

		if (new StateDAO().insert(stateBean)) {
			System.out.println("Inserted");
			response.sendRedirect("StateListServlet");
		} 

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
