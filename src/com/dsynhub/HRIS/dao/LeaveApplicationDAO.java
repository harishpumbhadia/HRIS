package com.dsynhub.HRIS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.dsynhub.HRIS.bean.LeaveApplicationBean;
import com.dsynhub.HRIS.util.DBConnection;

public class LeaveApplicationDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	boolean result = false;
	ResultSet rs = null;

	public boolean insert(LeaveApplicationBean leaveApplicationBean) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String insertSQL = "INSERT INTO leaveApplication(employeeId,leaveId,leaveStartDate,leaveDays,discription,isActive,dateOfApplication,dateOfLastUpdate) VALUES(?,?,?,?,?,?,?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setInt(1, leaveApplicationBean.getEmployeeId());
				pstmt.setInt(2, leaveApplicationBean.getLeaveId());
				pstmt.setString(3, leaveApplicationBean.getLeaveStartDate());
				pstmt.setInt(4, leaveApplicationBean.getLeaveDays());
				pstmt.setString(5, leaveApplicationBean.getDiscription());
				pstmt.setInt(6, leaveApplicationBean.getIsActive());
				pstmt.setString(7, leaveApplicationBean.getDateOfApplication());
				pstmt.setString(8, leaveApplicationBean.getDateOfLastUpdate());

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

	public List<LeaveApplicationBean> list() {
		List<LeaveApplicationBean> listofleaveApplication = new ArrayList<LeaveApplicationBean>();

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String selectSQL = "SELECT  l.leaveApplicationId , l.employeeId , l.leaveId, l.leaveStartDate , l.leaveDays , l.description , l.isActive , l.dateOfApplication , l.dateOfLastUpdate , e.employeeFirstName , lc.category  FROM leaveApplication l , employeeFirstName e , category lc  WHERE l.employeeId = e.employeeId and l.leaveId = lc.leaveId";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				LeaveApplicationBean leaveApplication = null;

				while (rs.next()) {
					leaveApplication = new LeaveApplicationBean();
					
					leaveApplication.setLeaveApplicationId(rs.getInt("leaveApplicationId"));
					
					leaveApplication.setEmployeeId(rs.getInt("employeeId"));
					leaveApplication.setLeaveId(rs.getInt("leaveId"));
					leaveApplication.setLeaveStartDate(rs.getString("leaveStartDate"));
					leaveApplication.setLeaveDays(rs.getInt("leaveDays"));
					leaveApplication.setDiscription(rs.getString("discription"));
					leaveApplication.setIsActive(rs.getInt("isActive"));
					leaveApplication.setDateOfApplication(rs.getString("dateOfApplication"));
					leaveApplication.setDateOfLastUpdate(rs.getString("dateOfLastUpdate"));
				
					listofleaveApplication.add(leaveApplication);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return listofleaveApplication;
	}

/*	public boolean delete(int organizationId) {

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

	}*/

}
