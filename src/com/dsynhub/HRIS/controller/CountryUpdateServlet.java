package com.dsynhub.HRIS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.HRIS.bean.CountryBean;
import com.dsynhub.HRIS.dao.CountryDAO;

/**
 * Servlet implementation class CountryUpdateServlet
 */
@WebServlet("/CountryUpdateServlet")
public class CountryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String countryName = request.getParameter("countryName");
		int countryId = Integer.parseInt(request.getParameter("cid"));

		CountryBean countryBean = new CountryBean();

		countryBean.setCountryName(countryName);
		countryBean.setCountryId(countryId);

		countryBean.setCountryName(countryName);

		if (new CountryDAO().update(countryBean)) {
			response.sendRedirect("CountryListServlet");
			System.out.println("Updated");

		} else {
			response.sendRedirect("countryList.jsp");
			System.out.println("Not Updated");

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
