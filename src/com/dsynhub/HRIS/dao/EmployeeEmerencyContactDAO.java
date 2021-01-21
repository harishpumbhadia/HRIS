package com.dsynhub.HRIS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.HRIS.bean.EmployeeEmergencyContactBean;
import com.dsynhub.HRIS.util.DBConnection;

public class EmployeeEmerencyContactDAO {

	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	boolean result = false;

	public boolean insert(EmployeeEmergencyContactBean employeeEmergencyContactBean) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String insertSQL = "INSERT INTO EmployeeEmergencyContact(employeeId, contactName , relation, contactNumberOne, contactNumberTwo) VALUES(?,?,?,?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setInt(1, employeeEmergencyContactBean.getEmployeeId());
				pstmt.setString(2, employeeEmergencyContactBean.getContactName());
				pstmt.setString(3, employeeEmergencyContactBean.getRelation());
				pstmt.setString(4, employeeEmergencyContactBean.getContactNumberOne());
				pstmt.setString(5, employeeEmergencyContactBean.getContactNumberTwo());
			
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

	public List<EmployeeEmergencyContactBean> list() {
		List<EmployeeEmergencyContactBean> listofEmployeeEmergencyContact= new ArrayList<EmployeeEmergencyContactBean>();

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String selectSQL = "select ee.EmergencyId , ee.employeeId ,e.employeeFirstName , e.employeeLastName , ee.contactName , ee.relation , ee.contactNumberOne , ee.contactNumberTwo , e.departmentId , e.designationId , dept.departmentName , e.designationId , desig.designationName from employee e ,employeeEmergencyContact ee , Department dept , designation desig where  e.departmentId = dept.departmentId and e.designationId = desig.designationId  and ee.employeeId = e.employeeId";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				EmployeeEmergencyContactBean employeeEmergencyContactBean = null;

				while (rs.next()) {
					employeeEmergencyContactBean = new EmployeeEmergencyContactBean();

					employeeEmergencyContactBean.setEmergencyId(rs.getInt("emergencyId"));
					employeeEmergencyContactBean.setEmployeeId(rs.getInt("employeeId"));
					employeeEmergencyContactBean.setContactName(rs.getString("contactName"));
					employeeEmergencyContactBean.setRelation(rs.getString("Relation"));
					employeeEmergencyContactBean.setEmployeeFirstName(rs.getString("employeeFirstName"));
					employeeEmergencyContactBean.setEmployeeLastName(rs.getString("employeeLastName"));
					employeeEmergencyContactBean.setContactNumberOne(rs.getString("contactNumberOne"));
					employeeEmergencyContactBean.setContactNumberTwo(rs.getString("contactNumberTwo"));
					employeeEmergencyContactBean.setDepartmentName(rs.getString("departmentName"));
					employeeEmergencyContactBean.setDesignationId(rs.getInt("designationId"));
					employeeEmergencyContactBean.setDepartmentId(rs.getInt("departmentid"));
					employeeEmergencyContactBean.setDesignationName(rs.getString("designationName"));
				
					listofEmployeeEmergencyContact.add(employeeEmergencyContactBean);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		}
		return listofEmployeeEmergencyContact;
	}

	public boolean delete(int emergencyId) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String deleteSQL = "DELETE FROM EmployeeEmergencyContact WHERE emergencyId= ?";

			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setInt(1, emergencyId);

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

	public EmployeeEmergencyContactBean getByPK(int emergencyId) {

		conn = DBConnection.getDBConnection();

		EmployeeEmergencyContactBean employeeEmergencyContactBean = new EmployeeEmergencyContactBean();
		if (conn != null) {
			String selectSQL = "SELECT * FROM EmployeeEmergencyContact WHERE emergencyId = ? ";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setInt(1, emergencyId);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					
					employeeEmergencyContactBean.setEmergencyId(rs.getInt("emergencyId"));
					employeeEmergencyContactBean.setEmployeeId(rs.getInt("employeeId"));
					employeeEmergencyContactBean.setContactName(rs.getString("contactName"));
					employeeEmergencyContactBean.setRelation(rs.getString("Relation"));
					employeeEmergencyContactBean.setContactNumberOne(rs.getString("contactNumberOne"));
					employeeEmergencyContactBean.setContactNumberTwo(rs.getString("contactNumberTwo"));				
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return employeeEmergencyContactBean;
	}

	public boolean update(EmployeeEmergencyContactBean employeeEmergencyContactBean) {

		conn = DBConnection.getDBConnection();

		// DesignationBean designationBean = new DesignationBean();

		if (conn != null) {
			String updateSQL = "UPDATE EmployeeEmergencyContact set contactName=?,relation=? ,contactNumberOne=? , contactNumberOne= ? WHERE emergencyId=?";

			try {
				pstmt = conn.prepareStatement(updateSQL);

				pstmt.setString(1, employeeEmergencyContactBean.getContactName());
				pstmt.setString(2, employeeEmergencyContactBean.getRelation());
				pstmt.setString(3, employeeEmergencyContactBean.getContactNumberOne());
				pstmt.setString(4, employeeEmergencyContactBean.getContactNumberTwo());
				pstmt.setInt(5, employeeEmergencyContactBean.getEmergencyId());
			
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
