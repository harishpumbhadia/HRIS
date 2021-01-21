package com.dsynhub.HRIS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.HRIS.bean.JobCandidateBean;
import com.dsynhub.HRIS.util.DBConnection;

public class JobCandidateDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	boolean result = false;

	public boolean insert(JobCandidateBean jobCandidateBean) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String insertSQL = "INSERT INTO JobCandidate(candidateFirstName , candidateMiddleName , candidateLastName, email , mobileNumber , candidateQualification , departmentId , designationId , dateOfApplication , isActive ) VALUES(?,?,?,?,?,?,?,?,?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setString(1, jobCandidateBean.getCandidateFirstName());
				pstmt.setString(2, jobCandidateBean.getCandidateMiddleName());
				pstmt.setString(3, jobCandidateBean.getCandidateLastName());
				pstmt.setString(4, jobCandidateBean.getEmail());
				pstmt.setString(5, jobCandidateBean.getMobileNumber());
				pstmt.setString(6, jobCandidateBean.getCandidateQualification());
				pstmt.setInt(7, jobCandidateBean.getDepartmentId());
				pstmt.setInt(8, jobCandidateBean.getDesignationId());
				pstmt.setString(9, jobCandidateBean.getDateOfApplication());
				pstmt.setInt(10, jobCandidateBean.getIsActive());

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

	public List<JobCandidateBean> list() {
		List<JobCandidateBean> listofJobCandidate= new ArrayList<JobCandidateBean>();

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String selectSQL = "select c.candidateId , c.candidateFirstName , c.candidateMiddleName , c.candidateLastName , c.email , c.mobileNumber ,c.candidateQualification , c.departmentId , dept.departmentName , c.designationId , desig.designationName , c.dateOfApplication , c.isActive  from JobCandidate c , Department dept , designation desig where  c.departmentId = dept.departmentId and c.designationId = desig.designationId ";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				JobCandidateBean jobCandidateBean = null;

				while (rs.next()) {
					jobCandidateBean = new JobCandidateBean();

					jobCandidateBean.setCadidateId(rs.getInt("candidateId"));
					jobCandidateBean.setCandidateFirstName(rs.getString("candidateFirstName"));
					jobCandidateBean.setCandidateMiddleName(rs.getString("candidateMiddleName"));
					jobCandidateBean.setCandidateLastName(rs.getString("candidateLastName"));
					jobCandidateBean.setEmail(rs.getString("email"));
					jobCandidateBean.setMobileNumber(rs.getString("mobileNumber"));
					jobCandidateBean.setCandidateQualification(rs.getString("candidateQualification"));
					jobCandidateBean.setDesignationId(rs.getInt("designationId"));
					jobCandidateBean.setDepartmentId(rs.getInt("departmentid"));
					jobCandidateBean.setDesignationName(rs.getString("designationName"));
					jobCandidateBean.setDepartentName(rs.getString("departmentName"));
					jobCandidateBean.setDateOfApplication(rs.getString("dateOfApplication"));
					jobCandidateBean.setIsActive(rs.getInt("isActive"));

					listofJobCandidate.add(jobCandidateBean);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		}
		return listofJobCandidate;
	}

	public boolean delete(int jobCandidateId) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String deleteSQL = "DELETE FROM JobCandidate WHERE candidateId= ?";

			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setInt(1, jobCandidateId);

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

	public JobCandidateBean getByPK(int jobCandidateId) {

		conn = DBConnection.getDBConnection();

		JobCandidateBean jobCandidateBean = new JobCandidateBean();
		if (conn != null) {
			String selectSQL = "SELECT * FROM JobCandidate WHERE candidateId = ? ";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setInt(1, jobCandidateId);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					jobCandidateBean.setCadidateId(rs.getInt("candidateId"));
					jobCandidateBean.setCandidateFirstName(rs.getString("candidateFirstName"));
					jobCandidateBean.setCandidateMiddleName(rs.getString("candidateMiddleName"));
					jobCandidateBean.setCandidateLastName(rs.getString("candidateLastName"));
					jobCandidateBean.setEmail(rs.getString("email"));
					jobCandidateBean.setMobileNumber(rs.getString("mobileNumber"));
					jobCandidateBean.setCandidateQualification(rs.getString("candidateQualification"));
					jobCandidateBean.setDesignationId(rs.getInt("designationId"));
					jobCandidateBean.setDepartmentId(rs.getInt("departmentid"));
					jobCandidateBean.setDateOfApplication(rs.getString("dateOfApplication"));
					jobCandidateBean.setIsActive(rs.getInt("isActive"));
					

				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return jobCandidateBean;
	}

	public boolean update(JobCandidateBean jobCandidateBean) {

		conn = DBConnection.getDBConnection();

		// DesignationBean designationBean = new DesignationBean();

		if (conn != null) {
			String updateSQL = "UPDATE JobCandidate set candidateFirstName=?,candidateMiddleName=? ,candidateLastName=? , email = ? , mobileNumber = ? ,  candidateQualification = ? , departmentId = ? , designationId = ? , dateOfApplication = ? ,isActive = ?  WHERE CandidateId=?";

			try {
				pstmt = conn.prepareStatement(updateSQL);

				pstmt.setString(1, jobCandidateBean.getCandidateFirstName());
				pstmt.setString(2, jobCandidateBean.getCandidateMiddleName());
				pstmt.setString(3, jobCandidateBean.getCandidateLastName());
				pstmt.setString(4, jobCandidateBean.getEmail());
				pstmt.setString(5, jobCandidateBean.getMobileNumber());
				pstmt.setString(6, jobCandidateBean.getCandidateQualification());
				pstmt.setInt(7, jobCandidateBean.getDepartmentId());
				pstmt.setInt(8, jobCandidateBean.getDesignationId());
				pstmt.setString(9, jobCandidateBean.getDateOfApplication());
				pstmt.setInt(10, jobCandidateBean.getIsActive());
				pstmt.setInt(11, jobCandidateBean.getCadidateId());
				

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
