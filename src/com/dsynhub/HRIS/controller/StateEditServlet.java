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
 * Servlet implementation class StateEditServlet
 */
@WebServlet("/StateEditServlet")
public class StateEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		int stateId =Integer.parseInt(request.getParameter("sid"));

		StateBean state = new StateDAO().getByPK(stateId);
	
		if(state!=null){
			request.setAttribute("stateBean", state);
			request.getRequestDispatcher("stateEdit.jsp").forward(request, response);
		}else{
			
			
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
