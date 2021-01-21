package com.dsynhub.HRIS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.HRIS.bean.OrganizationDetailsBean;
import com.dsynhub.HRIS.util.DBConnection;

public class OrganizationDetailsDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	boolean result = false;
	ResultSet rs = null;

	public boolean insert(OrganizationDetailsBean organizationDetailsBean) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String insertSQL = "INSERT INTO ORGANIZATIONDETAILS(ORGANIZATIONNAME,organizationAddress,CITYID,STATEID,COUNTRYID,CONTACTNO,EMAILID,WEBSITE) VALUES(?,?,?,?,?,?,?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setString(1, organizationDetailsBean.getOrganizationName());
				pstmt.setString(2, organizationDetailsBean.getOrganizationAddress());
				pstmt.setInt(3, organizationDetailsBean.getCityId());
				pstmt.setInt(4, organizationDetailsBean.getStateId());
				pstmt.setInt(5, organizationDetailsBean.getCountryId());
				pstmt.setString(6, organizationDetailsBean.getContactNo());
				pstmt.setString(7, organizationDetailsBean.getEmailId());
				pstmt.setString(8, organizationDetailsBean.getWebsite());

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

	public List<OrganizationDetailsBean> list() {
		List<OrganizationDetailsBean> listofOrganizationDetails = new ArrayList<OrganizationDetailsBean>();

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String selectSQL = "SELECT  o.organizationId , o.organizationName , o.organizationAddress , o.cityId , o.stateId , o.countryId , o.contactNo , o.emailId , o.website , ci.cityName , s.stateName , co.countryName FROM organizationDetails o , city ci , state s , country co WHERE o.cityId = ci.cityId and o.stateId = s.stateId and o.countryId = co.countryId ";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				OrganizationDetailsBean organizationDetails = null;

				while (rs.next()) {
					organizationDetails = new OrganizationDetailsBean();
					
					organizationDetails.setOrganizationId(rs.getInt("organizationId"));
					
					organizationDetails.setOrganizationName(rs.getString("organizationName"));
					organizationDetails.setOrganizationAddress(rs.getString("organizationAddress"));
					organizationDetails.setCityId(rs.getInt("cityId"));
					organizationDetails.setCityName(rs.getString("cityName"));
					organizationDetails.setStateId(rs.getInt("stateId"));
					organizationDetails.setStateName(rs.getString("stateName"));
					organizationDetails.setCountryId(rs.getInt("countryId"));
					organizationDetails.setCountryName(rs.getString("countryName"));
					organizationDetails.setContactNo(rs.getString("contactNo"));
					organizationDetails.setEmailId(rs.getString("emailId"));
					organizationDetails.setWebsite(rs.getString("website"));

					listofOrganizationDetails.add(organizationDetails);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return listofOrganizationDetails;
	}

	public boolean delete(int organizationId) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String deleteSQL = "DELETE  FROM organizationDetails WHERE organizationId= ?";

			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setInt(1, organizationId);

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

	public OrganizationDetailsBean getByPK(int organizationId) {

		conn = DBConnection.getDBConnection();
		System.out.println("Getbypk" + organizationId);
		OrganizationDetailsBean organizationDetails = new OrganizationDetailsBean();
		if (conn != null) {
			String selectSQL = "SELECT * FROM organizationDetails WHERE OrganizationId = ? ";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setInt(1, organizationId);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					organizationDetails.setOrganizationId(rs.getInt("organizationId"));
					organizationDetails.setOrganizationName(rs.getString("organizationName"));
					organizationDetails.setOrganizationAddress(rs.getString("organizationAddress"));
					organizationDetails.setCityId(rs.getInt("cityId"));
					
					organizationDetails.setStateId(rs.getInt("stateId"));
					
					organizationDetails.setCountryId(rs.getInt("countryId"));
					
					organizationDetails.setContactNo(rs.getString("contactNo"));
					organizationDetails.setEmailId(rs.getString("emailId"));
					organizationDetails.setWebsite(rs.getString("website"));

					System.out.println("organizationId    " + organizationId);

				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return organizationDetails;
	}

	public boolean update(OrganizationDetailsBean organizationDetails) {

		conn = DBConnection.getDBConnection();

		System.out.println("update" + organizationDetails.getOrganizationId());

		if (conn != null) {
			String updateSQL = "UPDATE organizationDetails set organizationName=?,organizationAddress=?,cityId=?,stateId=?,countryId=?,contactNo=?,emailId=?,website=? WHERE organizationId=?";

			try {
				pstmt = conn.prepareStatement(updateSQL);

				
				pstmt.setString(1, organizationDetails.getOrganizationName());
				pstmt.setString(2, organizationDetails.getOrganizationAddress());
				pstmt.setInt(3, organizationDetails.getCityId());
				pstmt.setInt(4, organizationDetails.getStateId());
				pstmt.setInt(5, organizationDetails.getCountryId());
				pstmt.setString(6, organizationDetails.getContactNo());
				pstmt.setString(7, organizationDetails.getEmailId());
				pstmt.setString(8, organizationDetails.getWebsite());
				pstmt.setInt(9, organizationDetails.getOrganizationId());
				
				
				System.out.println(updateSQL);
				
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
