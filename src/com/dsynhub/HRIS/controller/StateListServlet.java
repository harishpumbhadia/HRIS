package com.dsynhub.HRIS.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.StateBean;
import com.dsynhub.HRIS.dao.StateDAO;

/**
 * Servlet implementation class StateListServlet
 */
@WebServlet("/StateListServlet")
public class StateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		List<StateBean> listofStates = new StateDAO().list();
		
		if(listofStates!=null){
			request.setAttribute("listofStates",listofStates);
			request.getRequestDispatcher("stateList.jsp").forward(request, response);
		}else{
		
			System.out.println("List is Empty");
		}
	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
