package com.dsynhub.HRIS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.HRIS.bean.EmployeeQualificationBean;
import com.dsynhub.HRIS.util.DBConnection;

public class EmployeeQualificationDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	boolean result = false;

	public boolean insert(EmployeeQualificationBean employeeQualificationBean) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String insertSQL = "INSERT INTO EmployeeQualification(employeeId, qualificationName, institute, dateOfCompletion) VALUES(?,?,?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setInt(1, employeeQualificationBean.getEmployeeId());
				pstmt.setString(2, employeeQualificationBean.getQualificaionName());
				pstmt.setString(3, employeeQualificationBean.getInstitute());
				pstmt.setString(4, employeeQualificationBean.getDateOfCompletion());
			
				int rowAffected = pstmt.executeUpdate();

				if (rowAffected == 0) {

					System.out.println("Not Inserted");
				}

				else {
					result = true;
					System.out.println("Inserted");
				}

			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		} else {
			System.out.println("Check Connection");
		}

		return result;

	}

	public List<EmployeeQualificationBean> list() {
		List<EmployeeQualificationBean> listofEmployeeQuaification= new ArrayList<EmployeeQualificationBean>();

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String selectSQL = "select eq.employeeQualificationId, e.employeeID, e.employeeFirstName , e.employeeLastName , e.departmentId ,dept.departmentName , e.designationID , desig.designationName ,eq.qualificationName , eq.institute , eq.dateofCompletion from employeeQualification eq , Department dept , designation desig , employee e where  e.departmentId = dept.departmentId and e.designationId = desig.designationId  and eq.employeeId = e.employeeId";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				EmployeeQualificationBean employeeQualificationBean = null;

				while (rs.next()) {
					employeeQualificationBean = new EmployeeQualificationBean();

					employeeQualificationBean.setEmployeeQualificationId(rs.getInt("employeeQualificationId"));
					employeeQualificationBean.setEmployeeId(rs.getInt("employeeId"));
					employeeQualificationBean.setEmployeeFirstName(rs.getString("employeeFirstName"));
					employeeQualificationBean.setEmployeeLastName(rs.getString("employeeLastName"));
					employeeQualificationBean.setDepartmentId(rs.getInt("departmentId"));
					employeeQualificationBean.setDepartmentName(rs.getString("departmentName"));
					employeeQualificationBean.setDesignationId(rs.getInt("designationId"));
					employeeQualificationBean.setDesignationName(rs.getString("designationName"));	
					employeeQualificationBean.setQualificaionName(rs.getString("qualificationName"));
					employeeQualificationBean.setInstitute(rs.getString("institute"));
					employeeQualificationBean.setDateOfCompletion(rs.getString("dateOfCompletion"));
					
					listofEmployeeQuaification.add(employeeQualificationBean);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		}
		return listofEmployeeQuaification;
	}

	public boolean delete(int employeeQualificationId) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String deleteSQL = "DELETE FROM EMPLOYEEQUALIFICATION WHERE employeeQualificationId= ?";

			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setInt(1, employeeQualificationId);

				int rowAffected = pstmt.executeUpdate();

				if (rowAffected > 0)
					result = true;

			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		} else {
			System.out.println("Network Error");
		}
		return result;
	}

	public EmployeeQualificationBean getByPK(int employeeQualificationId) {

		conn = DBConnection.getDBConnection();

		EmployeeQualificationBean employeeQualificationBean = new EmployeeQualificationBean();
		if (conn != null) {
			String selectSQL = "SELECT * FROM EmployeeQualification WHERE employeeQualificationId = ? ";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setInt(1, employeeQualificationId);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					employeeQualificationBean.setEmployeeQualificationId(rs.getInt("employeeQualificationId"));
					employeeQualificationBean.setEmployeeId(rs.getInt("employeeId"));
					employeeQualificationBean.setQualificaionName(rs.getString("qualificationName"));
					employeeQualificationBean.setInstitute(rs.getString("institute"));
					employeeQualificationBean.setDateOfCompletion(rs.getString("dateOfCompletion"));
					
					

				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return employeeQualificationBean;
	}

	public boolean update(EmployeeQualificationBean employeeQualificationBean) {

		conn = DBConnection.getDBConnection();

		// DesignationBean designationBean = new DesignationBean();

		if (conn != null) {
			String updateSQL = "UPDATE EMPLOYEEQUALIFICATION set qualificationName=?,institute=? ,dateOfCompletion=?   WHERE employeeQualificationId=?";

			try {
				pstmt = conn.prepareStatement(updateSQL);

				pstmt.setString(1, employeeQualificationBean.getQualificaionName());
				pstmt.setString(2, employeeQualificationBean.getInstitute());
				pstmt.setString(3, employeeQualificationBean.getDateOfCompletion());
				pstmt.setInt(4, employeeQualificationBean.getEmployeeQualificationId());
				
				int rowsAffected = pstmt.executeUpdate();

				if (rowsAffected > 0) {

					System.out.println(rowsAffected + " Row(s) Updated......");
					result = true;
				} else {
					System.out.println(rowsAffected + " Row(s) Updated......");
					result = false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;

	}

}
