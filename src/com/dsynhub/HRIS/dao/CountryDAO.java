package com.dsynhub.HRIS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.HRIS.bean.CountryBean;
import com.dsynhub.HRIS.util.DBConnection;

public class CountryDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	boolean result = false;
	ResultSet rs = null;

	public boolean insert(CountryBean countrybean) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String insertSQL = "INSERT INTO COUNTRY(COUNTRYNAME) VALUES(?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setString(1, countrybean.getCountryName());

				int rowAffected = pstmt.executeUpdate();

				if (rowAffected == 0) {
					
					System.out.println("Not Inserted");
				}

				else {
					result=true;
					System.out.println("Inserted");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("Check Connection");
		}

		return result;

	}

	public List<CountryBean> list() {
		List<CountryBean> listofCountry = new ArrayList<CountryBean>();

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String selectSQL = "SELECT * FROM COUNTRY";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				CountryBean country = null;

				while (rs.next()) {
					country = new CountryBean();
					country.setCountryId(rs.getInt(1));
					country.setCountryName(rs.getString(2));

					listofCountry.add(country);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return listofCountry;
	}

	public boolean delete(int countryId) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String deleteSQL = "DELETE  FROM COUNTRY WHERE COUNTRYID= ?";

			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setInt(1, countryId);

				int rowAffected = pstmt.executeUpdate();

				if (rowAffected > 0)
					result = true;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("Network Error");
		}
		return result;
	}

	public CountryBean getByPK(int countryId) {

		conn = DBConnection.getDBConnection();
		System.out.println("Getbypk" + countryId);
		CountryBean country = new CountryBean();
		if (conn != null) {
			String selectSQL = "SELECT * FROM COUNTRY WHERE COUNTRYID = ? ";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setInt(1, countryId);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					country.setCountryId(countryId);
					country.setCountryName(rs.getString(2));
					System.out.println("countryId    " + countryId);

				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return country;
	}

	public boolean update(CountryBean countryBean) {

		conn = DBConnection.getDBConnection();

		System.out.println("update" + countryBean.getCountryId());

		if (conn != null) {
			String updateSQL = "UPDATE COUNTRY set COUNTRYNAME=? WHERE COUNTRYID=?";

			try {
				pstmt = conn.prepareStatement(updateSQL);

				pstmt.setString(1, countryBean.getCountryName());
				pstmt.setInt(2, countryBean.getCountryId());

				System.out.println(updateSQL);
				System.out.println(countryBean.getCountryId());
				System.out.println(countryBean.getCountryName());

				int rowsAffected = pstmt.executeUpdate();

				if (rowsAffected > 0) {

					System.out.println(rowsAffected + " Row(s) Updated......");
					result = true;
				} else {
					System.out.println("No Row(s) Updated......");
					result = false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;

	}

}
