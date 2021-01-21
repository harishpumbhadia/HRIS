package com.dsynhub.HRIS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.HRIS.bean.DesignationBean;
import com.dsynhub.HRIS.util.DBConnection;



public class DesignationDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	boolean result = false;

	public boolean insert(DesignationBean designationBean) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String insertSQL = "INSERT INTO DESIGNATION(departmentId , designationName) VALUES(?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setInt(1, designationBean.getDepartmentId());
				pstmt.setString(2, designationBean.getDesignationName());

				int rowAffected = pstmt.executeUpdate();

				if (rowAffected == 0) {

					System.out.println("Not Inserted");
				}

				else {
					result = true;
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

	public List<DesignationBean> list() {
		List<DesignationBean> listofDesignation = new ArrayList<DesignationBean>();

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String selectSQL = "select desig.designationId, desig.designationName,dept.departmentId, dept.departmentName from Designation desig , Department dept where desig.departmentId = dept.departmentId";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				DesignationBean designationBean = null;

				while (rs.next()) {
					designationBean = new DesignationBean();

					designationBean
							.setDesignationId(rs.getInt("designationId"));
					designationBean.setDepartmentId(rs.getInt("departmentid"));
					designationBean.setDesignationName(rs
							.getString("designationName"));
					designationBean.setDepartmentName(rs
							.getString("departmentName"));

					listofDesignation.add(designationBean);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return listofDesignation;
	}

	public boolean delete(int designationId) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String deleteSQL = "DELETE FROM Designation WHERE designationId= ?";

			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setInt(1, designationId);

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

	public DesignationBean getByPK(int designationId) {

		conn = DBConnection.getDBConnection();

		DesignationBean designationBean = new DesignationBean();
		if (conn != null) {
			String selectSQL = "SELECT * FROM Designation WHERE designationId = ? ";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setInt(1, designationId);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					designationBean
							.setDesignationId(rs.getInt("designationId"));
					designationBean.setDepartmentId(rs.getInt("departmentid"));
					designationBean.setDesignationName(rs
							.getString("designationName"));
				

				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return designationBean;
	}

	public boolean update(DesignationBean designationBean) {
		
		
		conn = DBConnection.getDBConnection();
		
	//	DesignationBean designationBean = new DesignationBean();
		
		 if(conn!=null){
			 String updateSQL = "UPDATE Designation set designationName=?,departmentId=? WHERE designationId=?";
			 
			 try {
				pstmt = conn.prepareStatement(updateSQL);
				
				pstmt.setString(1,designationBean.getDesignationName());
				pstmt.setInt(2,designationBean.getDepartmentId());
				pstmt.setInt(3,designationBean.getDesignationId());
				
				
				 System.out.println(updateSQL);
				 System.out.println(designationBean.getDesignationName());
				 System.out.println(designationBean.getDesignationId());
				 System.out.println(designationBean.getDepartmentId());
				 
				 
					
				int rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					
					System.out.println(rowsAffected + " Row(s) Updated......");
					result=true;
				} else {
					System.out.println(rowsAffected + " Row(s) Updated......");
					result = false ;
				}
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 }
		 return result;

	}



}
