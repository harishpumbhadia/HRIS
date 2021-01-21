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
 * Servlet implementation class DesignationEditServlet
 */
@WebServlet("/DesignationEditServlet")
public class DesignationEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int designationId =Integer.parseInt(request.getParameter("designationId"));

		
		DesignationBean designationBean= new DesignationDAO().getByPK(designationId);
	
		if(designationBean!=null){
			request.setAttribute("designationBean", designationBean);
			request.getRequestDispatcher("designationEdit.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
