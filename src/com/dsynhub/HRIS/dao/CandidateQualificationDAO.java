package com.dsynhub.HRIS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.HRIS.bean.CandidateQualificationBean;
import com.dsynhub.HRIS.util.DBConnection;

public class CandidateQualificationDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	boolean result = false;

	public boolean insert(CandidateQualificationBean candidateQualificationBean) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String insertSQL = "INSERT INTO CandidateQualification( candidateQualificationName) VALUES(?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);

			
				pstmt.setString(1, candidateQualificationBean.getCandidateQualificationName());

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

	public List<CandidateQualificationBean> list() {
		List<CandidateQualificationBean> listofCandidateQualification= new ArrayList<CandidateQualificationBean>();

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String selectSQL = "select * from candidateQualification";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				CandidateQualificationBean candidateQualificationBean = null;

				while (rs.next()) {
					candidateQualificationBean = new CandidateQualificationBean();

					candidateQualificationBean
							.setCandidateQualificationId(rs.getInt("candidateQualificationId"));
					candidateQualificationBean.setCandidateQualificationName(rs.getString("candidateQualificationName"));
					
					listofCandidateQualification.add(candidateQualificationBean);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		}
		return listofCandidateQualification;
	}

	public boolean delete(int candidateQualificationId) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String deleteSQL = "DELETE FROM candidateQualification WHERE candidateQualificationId= ?";

			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setInt(1, candidateQualificationId);

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

	public CandidateQualificationBean getByPK(int candidateQualificationId) {

		conn = DBConnection.getDBConnection();

		CandidateQualificationBean candidateQualificationBean = new CandidateQualificationBean() ;
		
		if (conn != null) {
			String selectSQL = "SELECT * FROM CandidateQualification WHERE candidateQualificationId = ? ";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setInt(1, candidateQualificationId);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					candidateQualificationBean.setCandidateQualificationId(rs.getInt("candidateQualificationId"));
					candidateQualificationBean.setCandidateQualificationName(rs.getString("candidateQualificationName"));
				
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return candidateQualificationBean;
	}

	public boolean update(CandidateQualificationBean candidateQualificationBean) {
		
		
		conn = DBConnection.getDBConnection();
		
	//	DesignationBean designationBean = new DesignationBean();
		
		 if(conn!=null){
			 String updateSQL = "UPDATE CandidateQualification set CandidateQualificationName=? WHERE CandidateQualificationId=?";
			 
			 try {
				pstmt = conn.prepareStatement(updateSQL);
				
				pstmt.setString(1,candidateQualificationBean.getCandidateQualificationName());
				pstmt.setInt(2,candidateQualificationBean.getCandidateQualificationId());
				
			
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
