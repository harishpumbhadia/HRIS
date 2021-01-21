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
 * Servlet implementation class StateUpdateServlet
 */
@WebServlet("/StateUpdateServlet")
public class StateUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String stateName = request.getParameter("stateName");
		int stateId = Integer.parseInt(request.getParameter("stateId"));
		int countryId = Integer.parseInt(request.getParameter("countryId"));
		
		StateBean stateBean = new StateBean() ;
		
		stateBean.setStateName(stateName);
		stateBean.setStateId(stateId);
		stateBean.setCountryId(countryId);
		
		

		if (new StateDAO().update(stateBean)) {
			response.sendRedirect("StateListServlet");
			System.out.println("Updated");
			
		} else {
			response.sendRedirect("stateList.jsp");
			System.out.println("Not Updated");
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
