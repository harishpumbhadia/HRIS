package com.dsynhub.HRIS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.HRIS.bean.LeaveCategoriesBean;
import com.dsynhub.HRIS.util.DBConnection;

public class LeaveCategoriesDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	boolean result = false;
	ResultSet rs = null;

	public boolean insert(LeaveCategoriesBean leavesCategoriesBean) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String insertSQL = "INSERT INTO LEAVECATEGORIES( CATEGORY ,LEAVESPERYEAR ) VALUES(?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setString(1, leavesCategoriesBean.getCategory());
				pstmt.setInt(2, leavesCategoriesBean.getLeavesPerYear());

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

	public List<LeaveCategoriesBean> list() {
		List<LeaveCategoriesBean> listofLeaveCategories = new ArrayList<LeaveCategoriesBean>();

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String selectSQL = "SELECT * FROM LEAVECATEGORIES";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				LeaveCategoriesBean leaveCategories = null;

				while (rs.next()) {
					leaveCategories = new LeaveCategoriesBean();
					leaveCategories.setLeaveId(rs.getInt(1));
					leaveCategories.setCategory(rs.getString(2));
					leaveCategories.setLeavesPerYear(rs.getInt(3));

					listofLeaveCategories.add(leaveCategories);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return listofLeaveCategories;
	}

	public boolean delete(int leaveId) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String deleteSQL = "DELETE  FROM LEAVECATEGORIES WHERE LEAVEID= ?";

			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setInt(1, leaveId);

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

	public LeaveCategoriesBean getByPK(int leaveId) {

		conn = DBConnection.getDBConnection();
		System.out.println("Getbypk" + leaveId);
		LeaveCategoriesBean leaveCategories = new LeaveCategoriesBean();
		if (conn != null) {
			String selectSQL = "SELECT * FROM LEAVECATEGORIES WHERE LEAVEID = ? ";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setInt(1, leaveId);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					leaveCategories.setLeaveId(rs.getInt(1));
					leaveCategories.setCategory(rs.getString(2));
					leaveCategories.setLeavesPerYear(rs.getInt(3));
					System.out.println("leaveId    " + leaveId);

				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return leaveCategories;
	}

	public boolean update(LeaveCategoriesBean leaveCategories) {

		conn = DBConnection.getDBConnection();

		System.out.println("update" + leaveCategories.getLeaveId());

		if (conn != null) {
			String updateSQL = "UPDATE LEAVECATEGORIES set CATEGORY=? , LEAVESPERYEAR=? WHERE LEAVEID=?";

			try {
				pstmt = conn.prepareStatement(updateSQL);

				pstmt.setString(1, leaveCategories.getCategory());
				pstmt.setInt(2, leaveCategories.getLeavesPerYear());
				pstmt.setInt(3, leaveCategories.getLeaveId());

				System.out.println(updateSQL);
				System.out.println(leaveCategories.getLeaveId());
				System.out.println(leaveCategories.getCategory());
				System.out.println(leaveCategories.getLeavesPerYear());
				

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
